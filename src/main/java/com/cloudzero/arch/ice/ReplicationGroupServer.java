package com.cloudzero.arch.ice;

import Ice.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.Exception;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/**
 * Replication group server
 * Created by lishiwu on 2016/10/9.
 */
public class ReplicationGroupServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReplicationGroupServer.class);
    private static Communicator communicator;

    /**
     * 启动ice server
     */
    public static void init() throws InterruptedException {
        if (communicator == null) {
            CountDownLatch startLatch = new CountDownLatch(1);
            new Thread(() -> {
                LOGGER.info("***********************ngLabel:{} ngVersion:{} starting******************************", ServerCfgHelper.NG_NAME, ServerCfgHelper.NG_VERSION);
                Properties properties = ServerCfgHelper.customWithDefault();
                properties.setProperty("CommObjectAdapter.AdapterId", UUID.randomUUID().toString());
                properties.setProperty("CommObjectAdapter.ReplicaGroupId", IceUtil.ngToRGI(ServerCfgHelper.NG_NAME, ServerCfgHelper.NG_VERSION));
                InitializationData initializationData = new InitializationData();
                initializationData.properties = properties;
                initializationData.logger = new Slf4jIceLogger();
                communicator = Util.initialize(initializationData);
                try {
                    ObjectAdapter objectAdapter = null;
                    do {
                        String endPoints = ServerCfgHelper.generateEndPoints(properties);
                        LOGGER.info("Try to init ice server with end points:{}", endPoints);
                        try {
                            objectAdapter = communicator.createObjectAdapterWithEndpoints("CommObjectAdapter", endPoints);
                        } catch (SocketException e) {
                            LOGGER.warn(e.getMessage());
                        }
                    } while (objectAdapter == null);
                    objectAdapter.add(new DIceCallerI(), communicator.stringToIdentity(DIceCallerI.ice_staticId()));
                    objectAdapter.activate();
                    LOGGER.info("Published end points:{}", Arrays.toString(objectAdapter.getPublishedEndpoints()));
                    startLatch.countDown();
                    communicator.waitForShutdown();
                    LOGGER.info("Server shutdown...");
                } catch (Exception e) {
                    LOGGER.error("Oops , something wrong with server, system will exit", e);
                    communicator.destroy();
                    System.exit(-1);
                }
            }).start();
            startLatch.await();
        } else {
            LOGGER.warn("Ice server has been initialized");
        }
    }
}

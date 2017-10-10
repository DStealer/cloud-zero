package com.cloudzero.arch.ice;

import Ice.*;
import com.cloudzero.arch.ice.generate.Callback_DIceCaller_call;
import com.cloudzero.arch.ice.generate.DIceCallerPrx;
import com.cloudzero.arch.ice.generate.DIceCallerPrxHelper;
import com.cloudzero.arch.pb.CloudRequest;
import com.cloudzero.arch.pb.CloudResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.InvalidParameterException;

/**
 * Replication group client
 * Created by lishiwu on 2016/10/9.
 */
public class ClientConnector {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientConnector.class);
    private DIceCallerPrx callerPrx;

    /**
     * 初始化连接
     *
     * @param ngLabel
     * @param ngVersion
     * @throws java.lang.Exception
     */
    public synchronized void init(String ngLabel, String ngVersion) throws java.lang.Exception {
        LOGGER.info("Try to establish connection to ngLabel:{},ngVersion:{}", ngLabel, ngVersion);
        if (StringUtils.isEmpty(ngLabel) || StringUtils.isEmpty(ngVersion)) {
            throw new InvalidParameterException("ngLabel or ngVersion is empty");
        }
        Properties properties = ClientCfgHelper.customWithDefault(ngLabel, ngVersion);
        InitializationData initializationData = new InitializationData();
        initializationData.properties = properties;
        initializationData.logger = new Slf4jIceLogger();
        Ice.Communicator communicator = Util.initialize(initializationData);
        ObjectPrx objectPrx = communicator.stringToProxy(IceUtil.stringToRGIProxy(DIceCallerI.ice_staticId(), ngLabel, ngVersion))
                .ice_connectionCached(false);
        if (objectPrx != null) {
            callerPrx = DIceCallerPrxHelper.checkedCast(objectPrx);
            LOGGER.info("Establish connection to ngLabel:{},ngVersion:{} success", ngLabel, ngVersion);
        } else {
            LOGGER.warn("Establish connection to ngLabel:{},ngVersion:{} failed", ngLabel, ngVersion);
        }
    }

    /**
     * 发送请求
     *
     * @param request
     * @return
     * @throws java.lang.Exception
     */
    public CloudResponse invoke(CloudRequest request) throws java.lang.Exception {
        return callerPrx.invoke(request);
    }

    /**
     * 异步发送请求
     *
     * @param request
     * @return
     * @throws java.lang.Exception
     */
    public CloudResponse asyncInvoke(CloudRequest request) throws java.lang.Exception {
        Ice.AsyncResult asyncResult = callerPrx.begin_invoke(request);
        return callerPrx.end_invoke(asyncResult);
    }

    /**
     * 发送请求
     *
     * @param request
     * @return
     * @throws java.lang.Exception
     */
    public void call(CloudRequest request) throws java.lang.Exception {
        callerPrx.call(request);
    }

    /**
     * 异步发送请求
     *
     * @param request
     * @return
     * @throws java.lang.Exception
     */
    public void asyncCall(CloudRequest request) throws java.lang.Exception {
        callerPrx.begin_call(request, new Callback_DIceCaller_call() {
            @Override
            public void response() {
                LOGGER.info("Call back from:{}|{}", request.getNgLabel(), request.getNgVersion());
            }

            @Override
            public void exception(LocalException ex) {
                LOGGER.info("Exception in call:{}|{}", request.getNgLabel(), request.getNgVersion());
            }
        });
    }

    /**
     * 销毁客户端
     *
     * @throws java.lang.Exception
     */
    public void destroy() throws java.lang.Exception {
        if (callerPrx != null) {
            callerPrx.ice_getCommunicator().shutdown();
        }
    }
}

package com.cloudzero.arch.startup;

import com.cloudzero.arch.config.ConfigHelper;
import com.cloudzero.arch.ice.ReplicationGroupServer;
import com.cloudzero.arch.ice.ServerCfgHelper;
import com.cloudzero.arch.xwork.Dispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by lishiwu on 2016/10/8.
 */
public class BootMain implements BootStep {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BootMain.class);
    private static final AtomicBoolean RUNFLAG = new AtomicBoolean(false);

    /**
     * 程序启动入口
     *
     * @param args
     * @throws Exception
     */
    public final void run(String[] args) throws Exception {
        if (RUNFLAG.compareAndSet(false, true)) {
            LOGGER.info("********************Server starting......***************************");
            this.beforeLoadConfig(args);
            this.loadConfig(args);
            this.afterLoadConfig(args);
            this.beforeInitXwork(args);
            this.initXwork(args);
            this.afterInitXwork(args);
            this.beforeInitServer(args);
            this.initServer(args);
            this.afterInitServer(args);
            LOGGER.info("***********************Server started......*************************");
        } else {
            LOGGER.warn("Hi,application has started!");
        }
    }

    @Override
    public void beforeLoadConfig(String[] args) throws Exception {

    }

    @Override
    public final void loadConfig(String[] args) throws Exception {
        ConfigHelper.initNodeConfig();
    }

    @Override
    public void afterLoadConfig(String[] args) throws Exception {

    }

    @Override
    public void beforeInitXwork(String[] args) throws Exception {

    }

    @Override
    public final void initXwork(String[] args) throws Exception {
        Dispatcher.init(ServerCfgHelper.XWORK_CFG_FILE_PATH);
    }

    @Override
    public void afterInitXwork(String[] args) throws Exception {

    }

    @Override
    public void beforeInitServer(String[] args) throws Exception {

    }

    @Override
    public final void initServer(String[] args) throws Exception {
        ReplicationGroupServer.init();
    }

    @Override
    public void afterInitServer(String[] args) throws Exception {

    }
}

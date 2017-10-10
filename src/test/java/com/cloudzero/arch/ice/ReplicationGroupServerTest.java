package com.cloudzero.arch.ice;

import com.cloudzero.arch.xwork.Dispatcher;
import org.testng.annotations.Test;

/**
 * Created by lishiwu on 2016/10/11.
 */
public class ReplicationGroupServerTest {
    @Test
    public void testStartIceServer() throws Exception {
        ServerCfgHelper.NG_NAME = "MockNg";
        ServerCfgHelper.NG_VERSION = "0.0.1";
        Dispatcher.init("xwork-test.xml");
        ReplicationGroupServer.init();
        System.out.println("success...");
        Thread.currentThread().join();
    }

}
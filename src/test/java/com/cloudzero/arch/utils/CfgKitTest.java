package com.cloudzero.arch.utils;

import com.cloudzero.arch.config.ConfigKit;
import org.testng.annotations.Test;

/**
 * Created by LiShiwu on 06/20/2017.
 */
public class CfgKitTest {
    @Test
    public void tt1() throws Exception {
        System.out.println(ConfigKit.use("node-test.xml").getString("localNode.label"));
        System.out.println(ConfigKit.use("node-test.xml").getString("localNode.version"));
        System.out.println(ConfigKit.use("node-test.xml").immutableSubset("localNode").getString("label"));
    }

    @Test
    public void test2() throws Exception {
        ConfigKit.local("node-test.xml");
        System.out.println(ConfigKit.subset("localNode").getString("label"));
        ConfigKit.evict();
    }
}
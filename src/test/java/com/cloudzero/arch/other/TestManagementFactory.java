package com.cloudzero.arch.other;

import org.testng.annotations.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

/**
 * Created by lishiwu on 2016/10/14.
 */
public class TestManagementFactory {
    @Test
    public void testManagementFactory() throws Exception{
        MemoryMXBean mmBean = ManagementFactory.getMemoryMXBean();
        mmBean.getHeapMemoryUsage().getUsed();
        mmBean.getNonHeapMemoryUsage().getUsed();

    }
}

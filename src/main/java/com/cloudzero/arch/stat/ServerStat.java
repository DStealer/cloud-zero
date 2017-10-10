package com.cloudzero.arch.stat;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lishiwu on 2016/10/14.
 */
public class ServerStat {
    private AtomicInteger runningThreadCount = new AtomicInteger(0);
    private AtomicInteger threadCountMax = new AtomicInteger(0);
    private AtomicInteger threadCountMin = new AtomicInteger(0);
    private AtomicLong currentHeapMemoryUsage = new AtomicLong(0);
    private AtomicLong currentNonHeapMemoryUsage = new AtomicLong(0);
    private AtomicLong memoryMax = new AtomicLong(0);
}

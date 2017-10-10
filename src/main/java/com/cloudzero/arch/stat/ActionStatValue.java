package com.cloudzero.arch.stat;

/**
 * Created by lishiwu on 2016/10/14.
 */
public class ActionStatValue {
    int runningCount;
    int concurrentMax;
    long requestCount;
    long requestTimeNano;
    long errorCount;

    long lastAccessTimeMillis;

    int histogram_0_1;
    int histogram_1_10;
    int histogram_10_100;
    int histogram_100_1000;
    int histogram_1000_10000;
    int histogram_10000_100000;
    int histogram_100000_1000000;
    int histogram_1000000_10000000;
    int histogram_10000000_more;
}

package com.cloudzero.arch.stat;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lishiwu on 2016/10/14.
 */
public class NgStat {
    private final String ip;
    private final AtomicLong requestCount = new AtomicLong(0);
    private final AtomicLong validRequestCount = new AtomicLong(0);
    private final AtomicLong statBeginMillis = new AtomicLong(0);
    private final AtomicLong statEndMillis = new AtomicLong(0);

    public NgStat(String ip) {
        this.ip = ip;
        statBeginMillis.set(System.currentTimeMillis());
    }
}

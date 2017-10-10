package com.cloudzero.arch.stat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


/**
 * Action 状况监控统计类
 * Created by lishiwu on 2016/10/14.
 */
public class ActionStat {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActionStat.class);
    private final static ThreadLocal<ActionStat> currentLocal = new ThreadLocal<>();
    private final String actionName;
    private final String actionVersion;
    private final AtomicInteger runningCount = new AtomicInteger(0);
    private final AtomicInteger concurrentMax = new AtomicInteger(0);
    private final AtomicLong requestCount = new AtomicLong(0);
    private final AtomicLong requestTimeNano = new AtomicLong(0);
    private final AtomicLong errorCount = new AtomicLong(0);

    private final AtomicLong lastAccessTimeMillis = new AtomicLong(0);

    private AtomicInteger histogram_0_1 = new AtomicInteger(0);
    private AtomicInteger histogram_1_10 = new AtomicInteger(0);
    private AtomicInteger histogram_10_100 = new AtomicInteger(0);
    private AtomicInteger histogram_100_1000 = new AtomicInteger(0);
    private AtomicInteger histogram_1000_10000 = new AtomicInteger(0);
    private AtomicInteger histogram_10000_100000 = new AtomicInteger(0);
    private AtomicInteger histogram_100000_1000000 = new AtomicInteger(0);
    private AtomicInteger histogram_1000000_10000000 = new AtomicInteger(0);
    private AtomicInteger histogram_10000000_more = new AtomicInteger(0);


    public ActionStat(String actionName, String actionVersion) {
        this.actionName = actionName;
        this.actionVersion = actionVersion;
    }

    public static ActionStat current() {
        return currentLocal.get();
    }

    public void beforeInvoke() {
        currentLocal.set(this);

        int running = runningCount.incrementAndGet();

        for (; ; ) {
            int max = concurrentMax.get();
            if (running > max) {
                if (concurrentMax.compareAndSet(max, running)) {
                    break;
                }
            } else {
                break;
            }
        }
        requestCount.incrementAndGet();
    }

    public void afterInvoke(Throwable error, long nanos) {

        runningCount.decrementAndGet();
        requestTimeNano.addAndGet(nanos);

        histogramRecord(nanos);

        if (error != null) {
            errorCount.incrementAndGet();
        }
        currentLocal.set(null);
    }

    private void histogramRecord(long nanos) {
        final long millis = nanos / 1000 / 1000;

        if (millis < 1) {
            histogram_0_1.incrementAndGet();
        } else if (millis < 10) {
            histogram_1_10.incrementAndGet();
        } else if (millis < 100) {
            histogram_10_100.incrementAndGet();
        } else if (millis < 1000) {
            histogram_100_1000.incrementAndGet();
        } else if (millis < 10000) {
            histogram_1000_10000.incrementAndGet();
        } else if (millis < 100000) {
            histogram_10000_100000.incrementAndGet();
        } else if (millis < 1000000) {
            histogram_100000_1000000.incrementAndGet();
        } else if (millis < 10000000) {
            histogram_1000000_10000000.incrementAndGet();
        } else {
            histogram_10000000_more.incrementAndGet();
        }
    }

    public long[] getHistogramValues() {
        return new long[]{
                histogram_0_1.get(),
                histogram_1_10.get(),
                histogram_10_100.get(),
                histogram_100_1000.get(),
                histogram_1000_10000.get(),
                histogram_10000_100000.get(),
                histogram_100000_1000000.get(),
                histogram_1000000_10000000.get(),
                histogram_10000000_more.incrementAndGet()
        };
    }

    public ActionStatValue getValue(boolean reset) {
        ActionStatValue val = new ActionStatValue();

        val.runningCount = StatUtil.get(runningCount, reset);
        val.concurrentMax = StatUtil.get(concurrentMax, reset);
        val.requestCount = StatUtil.get(requestCount, reset);
        val.requestTimeNano = StatUtil.get(requestTimeNano, reset);
        val.errorCount = StatUtil.get(errorCount, reset);

        val.lastAccessTimeMillis = StatUtil.get(lastAccessTimeMillis, reset);

        val.histogram_0_1 = StatUtil.get(histogram_0_1, reset);
        val.histogram_1_10 = StatUtil.get(histogram_1_10, reset);
        val.histogram_10_100 = StatUtil.get(histogram_10_100, reset);
        val.histogram_100_1000 = StatUtil.get(histogram_100_1000, reset);
        val.histogram_1000_10000 = StatUtil.get(histogram_1000_10000, reset);
        val.histogram_10000_100000 = StatUtil.get(histogram_10000_100000, reset);
        val.histogram_100000_1000000 = StatUtil.get(histogram_100000_1000000, reset);
        val.histogram_1000000_10000000 = StatUtil.get(histogram_1000000_10000000, reset);
        val.histogram_10000000_more = StatUtil.get(histogram_10000000_more, reset);

        return val;
    }
}

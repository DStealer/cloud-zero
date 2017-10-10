package com.cloudzero.arch.stat;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lishiwu on 2016/10/14.
 */
public class StatUtil {
    public static int get(AtomicInteger value, boolean reset) {
        if (reset) {
            return value.getAndSet(0);
        } else {
            return value.get();
        }
    }

    public static long get(AtomicLong value, boolean reset) {
        if (reset) {
            return value.getAndSet(0);
        } else {
            return value.get();
        }
    }
}

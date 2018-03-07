package com.facebook.messaging.model.threads;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: updated_time_precise */
public class ActionIdHelper {
    public static AtomicLong f2230a = new AtomicLong(0);

    public static long m3513a(long j) {
        return (1000000 * j) + f2230a.incrementAndGet();
    }

    public static long m3514b(long j) {
        return 1000000 * j;
    }

    public static long m3515c(long j) {
        return j / 1000000;
    }
}

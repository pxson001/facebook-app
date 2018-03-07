package com.facebook.analytics2.logger;

import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: tab_id */
public class BatchSession {
    private final String f3372a;
    public final String f3373b;
    private AtomicInteger f3374c = new AtomicInteger(-1);

    public BatchSession(String str, String str2) {
        this.f3372a = str2;
        this.f3373b = str;
    }

    public final String m5583a() {
        return this.f3372a;
    }

    public final String m5584b() {
        return this.f3373b;
    }

    public final synchronized int m5585c() {
        return this.f3374c.incrementAndGet();
    }
}

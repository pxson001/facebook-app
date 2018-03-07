package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class zzod implements ThreadFactory {
    private final String f19117a;
    private final int f19118b;
    private final AtomicInteger f19119c;
    private final ThreadFactory f19120d;

    public zzod(String str) {
        this(str, 0);
    }

    private zzod(String str, int i) {
        this.f19119c = new AtomicInteger();
        this.f19120d = Executors.defaultThreadFactory();
        this.f19117a = (String) zzx.m105a((Object) str, (Object) "Name must not be null");
        this.f19118b = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f19120d.newThread(new zzoe(runnable, this.f19118b));
        newThread.setName(this.f19117a + "[" + this.f19119c.getAndIncrement() + "]");
        return newThread;
    }
}

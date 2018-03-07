package com.facebook.imagepipeline.core;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: TRANSPORTATION_CHECKIN */
public class DefaultExecutorSupplier implements ExecutorSupplier {
    private final Executor f13683a = Executors.newFixedThreadPool(2);
    private final Executor f13684b;
    private final Executor f13685c;
    private final Executor f13686d;

    public DefaultExecutorSupplier(int i) {
        ThreadFactory priorityThreadFactory = new PriorityThreadFactory(10);
        this.f13684b = Executors.newFixedThreadPool(i, priorityThreadFactory);
        this.f13685c = Executors.newFixedThreadPool(i, priorityThreadFactory);
        this.f13686d = Executors.newFixedThreadPool(1, priorityThreadFactory);
    }

    public final Executor m23012a() {
        return this.f13683a;
    }

    public final Executor m23013b() {
        return this.f13683a;
    }

    public final Executor m23014c() {
        return this.f13684b;
    }

    public final Executor m23015d() {
        return this.f13685c;
    }

    public final Executor m23016e() {
        return this.f13686d;
    }
}

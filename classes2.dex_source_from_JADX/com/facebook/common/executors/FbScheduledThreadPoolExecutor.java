package com.facebook.common.executors;

import android.annotation.TargetApi;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: viewer_has_voted */
public class FbScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
    private final BackgroundWorkLogger f1033a;

    public FbScheduledThreadPoolExecutor(int i, ThreadFactory threadFactory, BackgroundWorkLogger backgroundWorkLogger) {
        super(i, threadFactory);
        this.f1033a = backgroundWorkLogger;
    }

    @TargetApi(9)
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return super.newTaskFor(m2107a(runnable), t);
    }

    @TargetApi(9)
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return super.newTaskFor(m2108a((Callable) callable));
    }

    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return super.schedule(m2107a(runnable), j, timeUnit);
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        return super.schedule(m2108a((Callable) callable), j, timeUnit);
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return super.scheduleAtFixedRate(m2107a(runnable), j, j2, timeUnit);
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return super.scheduleWithFixedDelay(m2107a(runnable), j, j2, timeUnit);
    }

    private Runnable m2107a(Runnable runnable) {
        return LoggingRunnable.m12548a(runnable, this.f1033a, "FbScheduledThreadPoolExecutor");
    }

    private <E> Callable<E> m2108a(Callable<E> callable) {
        return LoggingCallable.m20280a(callable, this.f1033a, "FbScheduledThreadPoolExecutor");
    }
}

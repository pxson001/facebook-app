package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

/* compiled from: video/x-apng */
public class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {
    private final ExecutionList f1253a = new ExecutionList();

    public static <V> ListenableFutureTask<V> m2437a(Callable<V> callable) {
        return new ListenableFutureTask(callable);
    }

    public static <V> ListenableFutureTask<V> m2436a(Runnable runnable, @Nullable V v) {
        return new ListenableFutureTask(runnable, v);
    }

    private ListenableFutureTask(Callable<V> callable) {
        super(callable);
    }

    private ListenableFutureTask(Runnable runnable, @Nullable V v) {
        super(runnable, v);
    }

    public final void mo223a(Runnable runnable, Executor executor) {
        this.f1253a.m1746a(runnable, executor);
    }

    protected void done() {
        this.f1253a.m1745a();
    }
}

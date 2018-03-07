package com.facebook.common.executors;

import android.os.Handler;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: squareLargeImage */
public class ScheduledFutureImpl<V> implements RunnableFuture<V>, ScheduledFuture<V> {
    private final Handler f2583a;
    private final FutureTask<V> f2584b;

    public ScheduledFutureImpl(Handler handler, Callable<V> callable) {
        this.f2583a = handler;
        this.f2584b = new FutureTask(callable);
    }

    public ScheduledFutureImpl(Handler handler, Runnable runnable, @Nullable V v) {
        this.f2583a = handler;
        this.f2584b = new FutureTask(runnable, v);
    }

    public long getDelay(TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public int compareTo(Object obj) {
        throw new UnsupportedOperationException();
    }

    public void run() {
        this.f2584b.run();
    }

    public boolean cancel(boolean z) {
        return this.f2584b.cancel(z);
    }

    public boolean isCancelled() {
        return this.f2584b.isCancelled();
    }

    public boolean isDone() {
        return this.f2584b.isDone();
    }

    public V get() {
        return FutureDetour.a(this.f2584b, 407534880);
    }

    public V get(long j, TimeUnit timeUnit) {
        return FutureDetour.a(this.f2584b, j, timeUnit, 690709267);
    }
}

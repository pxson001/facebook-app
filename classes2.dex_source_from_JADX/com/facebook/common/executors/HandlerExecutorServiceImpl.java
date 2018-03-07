package com.facebook.common.executors;

import android.os.Handler;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: memory_savings_stories_to_keep */
public class HandlerExecutorServiceImpl extends AbstractExecutorService implements HandlerExecutorService {
    public final Handler f14396a;

    protected /* synthetic */ RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return m20772a(runnable, obj);
    }

    protected /* synthetic */ RunnableFuture newTaskFor(Callable callable) {
        return m20773a(callable);
    }

    public /* synthetic */ Future submit(Runnable runnable, @Nullable Object obj) {
        return m20774b(runnable, obj);
    }

    public HandlerExecutorServiceImpl(Handler handler) {
        this.f14396a = handler;
    }

    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public void execute(Runnable runnable) {
        HandlerDetour.a(this.f14396a, runnable, 1217376857);
    }

    private <T> ScheduledFutureImpl<T> m20772a(Runnable runnable, T t) {
        return new ScheduledFutureImpl(this.f14396a, runnable, t);
    }

    private <T> ScheduledFutureImpl<T> m20773a(Callable<T> callable) {
        return new ScheduledFutureImpl(this.f14396a, callable);
    }

    public Future submit(Runnable runnable) {
        return m20774b(runnable, null);
    }

    private <T> ScheduledFuture<T> m20774b(Runnable runnable, @Nullable T t) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        ScheduledFutureImpl a = m20772a(runnable, t);
        ExecutorDetour.a(this, a, 445125091);
        return a;
    }

    public Future submit(Callable callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        ScheduledFutureImpl a = m20773a(callable);
        ExecutorDetour.a(this, a, -119848472);
        return a;
    }

    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledFutureImpl a = m20772a(runnable, null);
        HandlerDetour.b(this.f14396a, a, timeUnit.toMillis(j), -1850758711);
        return a;
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        ScheduledFutureImpl a = m20773a(callable);
        HandlerDetour.b(this.f14396a, a, timeUnit.toMillis(j), -343507236);
        return a;
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }
}

package com.facebook.common.executors;

import android.os.Handler;
import com.facebook.debug.log.BLog;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: voip_adaptive_isac */
public class HandlerListeningExecutorServiceImpl extends AbstractExecutorService implements HandlerListeningExecutorService {
    public final Handler f966a;

    public final /* synthetic */ ListenableFuture mo269a(Runnable runnable) {
        return m1955b(runnable);
    }

    public final /* synthetic */ ListenableFuture mo270a(Runnable runnable, @Nullable Object obj) {
        return m1956c(runnable, obj);
    }

    public final /* synthetic */ ListenableFuture mo271a(Callable callable) {
        return m1957c(callable);
    }

    public /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return mo310a(runnable, j, timeUnit);
    }

    public /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        return mo311a(callable, j, timeUnit);
    }

    public /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return mo309a(runnable, j, j2, timeUnit);
    }

    public /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return mo313b(runnable, j, j2, timeUnit);
    }

    public /* synthetic */ Future submit(Runnable runnable) {
        return m1955b(runnable);
    }

    public /* synthetic */ Future submit(Runnable runnable, @Nullable Object obj) {
        return m1956c(runnable, obj);
    }

    public /* synthetic */ Future submit(Callable callable) {
        return m1957c(callable);
    }

    public HandlerListeningExecutorServiceImpl(Handler handler) {
        this.f966a = handler;
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new ListenableScheduledRunnableFuture(this.f966a, runnable, t);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new ListenableScheduledRunnableFuture(this.f966a, callable);
    }

    private <T> ListenableScheduledFutureImpl<T> m1953b(Runnable runnable, @Nullable T t) {
        return new ListenableScheduledFutureImpl(this.f966a, runnable, t);
    }

    private <T> ListenableScheduledFutureImpl<T> m1954b(Callable<T> callable) {
        return new ListenableScheduledFutureImpl(this.f966a, callable);
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
        if ((runnable instanceof Future) && !(runnable instanceof HandlerDeadlockAwareForwardingFuture)) {
            BLog.a(getClass(), "%s submitted as runnable to %s. Potential deadlocks on get().", new Object[]{runnable.getClass(), getClass()});
        }
        HandlerDetour.a(this.f966a, runnable, 547196587);
    }

    private ListenableScheduledFuture<?> m1955b(Runnable runnable) {
        return m1956c(runnable, null);
    }

    private <T> ListenableScheduledFuture<T> m1956c(Runnable runnable, @Nullable T t) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        Object b = m1953b(runnable, t);
        ExecutorDetour.a(this, b, -944956636);
        return b;
    }

    private <T> ListenableScheduledFuture<T> m1957c(Callable<T> callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        Object b = m1954b((Callable) callable);
        ExecutorDetour.a(this, b, -162035655);
        return b;
    }

    public final ListenableScheduledFuture<?> mo310a(Runnable runnable, long j, TimeUnit timeUnit) {
        Object b = m1953b(runnable, null);
        HandlerDetour.b(this.f966a, b, timeUnit.toMillis(j), -193045406);
        return b;
    }

    public final <V> ListenableScheduledFuture<V> mo311a(Callable<V> callable, long j, TimeUnit timeUnit) {
        Object b = m1954b((Callable) callable);
        HandlerDetour.b(this.f966a, b, timeUnit.toMillis(j), 225367384);
        return b;
    }

    public final ListenableScheduledFuture<?> mo309a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final ListenableScheduledFuture<?> mo313b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final void mo312a() {
        this.f966a.getLooper().quit();
    }

    public final boolean mo314b() {
        return Thread.currentThread() == this.f966a.getLooper().getThread();
    }
}

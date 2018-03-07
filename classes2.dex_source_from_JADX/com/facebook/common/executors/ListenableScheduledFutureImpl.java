package com.facebook.common.executors;

import android.os.Handler;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: profile_qr?source=%s */
public class ListenableScheduledFutureImpl<V> extends HandlerDeadlockAwareForwardingFuture<V> implements ListenableScheduledFuture<V>, Runnable {
    public final ListenableFutureTask<V> f8824a;

    public ListenableScheduledFutureImpl(Handler handler, Callable<V> callable) {
        super(handler);
        this.f8824a = ListenableFutureTask.m2437a(callable);
    }

    public ListenableScheduledFutureImpl(Handler handler, Runnable runnable, @Nullable V v) {
        super(handler);
        this.f8824a = ListenableFutureTask.m2436a(runnable, (Object) v);
    }

    protected final /* synthetic */ Future mo1830a() {
        return this.f8824a;
    }

    public final void mo223a(Runnable runnable, Executor executor) {
        this.f8824a.mo223a(runnable, executor);
    }

    protected final /* synthetic */ Object mo105e() {
        return this.f8824a;
    }

    public void run() {
        this.f8824a.run();
    }

    public long getDelay(TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public int compareTo(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean cancel(boolean z) {
        return super.cancel(false);
    }
}

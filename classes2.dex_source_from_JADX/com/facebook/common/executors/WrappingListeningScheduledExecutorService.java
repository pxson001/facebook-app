package com.facebook.common.executors;

import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: vnd.android.cursor.item/vnd.facebook.katana.keyvalue */
public abstract class WrappingListeningScheduledExecutorService extends WrappingListeningExecutorService implements ListeningScheduledExecutorService {
    private final ListeningScheduledExecutorService f968a;

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

    public WrappingListeningScheduledExecutorService(ListeningScheduledExecutorService listeningScheduledExecutorService) {
        super(listeningScheduledExecutorService);
        this.f968a = listeningScheduledExecutorService;
    }

    public final ListenableScheduledFuture<?> mo310a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f968a.mo310a(runnable, j, timeUnit);
    }

    public final <V> ListenableScheduledFuture<V> mo311a(Callable<V> callable, long j, TimeUnit timeUnit) {
        return this.f968a.mo311a((Callable) callable, j, timeUnit);
    }

    public final ListenableScheduledFuture<?> mo309a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.f968a.mo309a(runnable, j, j2, timeUnit);
    }

    public final ListenableScheduledFuture<?> mo313b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.f968a.mo313b(runnable, j, j2, timeUnit);
    }
}

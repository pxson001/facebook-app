package com.facebook.common.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: viewer_has_pending_invite */
public abstract class WrappingScheduledExecutorService extends WrappingExecutorService implements ScheduledExecutorService {
    private final ScheduledExecutorService f1035a;

    public WrappingScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.f1035a = scheduledExecutorService;
    }

    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f1035a.schedule(runnable, j, timeUnit);
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        return this.f1035a.schedule(callable, j, timeUnit);
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.f1035a.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.f1035a.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }
}

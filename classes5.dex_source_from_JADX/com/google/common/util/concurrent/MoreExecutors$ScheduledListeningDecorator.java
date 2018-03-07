package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.ForwardingListenableFuture.SimpleForwardingListenableFuture;
import com.google.common.util.concurrent.MoreExecutors.ListeningDecorator;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@GwtIncompatible("TODO")
/* compiled from: bug_creation_ttime */
final class MoreExecutors$ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {
    final ScheduledExecutorService f7672a;

    /* compiled from: bug_creation_ttime */
    final class ListenableScheduledTask<V> extends SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {
        private final ScheduledFuture<?> f7670a;

        public final int compareTo(Object obj) {
            return this.f7670a.compareTo((Delayed) obj);
        }

        public ListenableScheduledTask(ListenableFuture<V> listenableFuture, ScheduledFuture<?> scheduledFuture) {
            super(listenableFuture);
            this.f7670a = scheduledFuture;
        }

        public final boolean cancel(boolean z) {
            boolean cancel = super.cancel(z);
            if (cancel) {
                this.f7670a.cancel(z);
            }
            return cancel;
        }

        public final long getDelay(TimeUnit timeUnit) {
            return this.f7670a.getDelay(timeUnit);
        }
    }

    @GwtIncompatible("TODO")
    /* compiled from: bug_creation_ttime */
    final class NeverSuccessfulListenableFutureTask extends AbstractFuture<Void> implements Runnable {
        private final Runnable f7671a;

        public NeverSuccessfulListenableFutureTask(Runnable runnable) {
            this.f7671a = (Runnable) Preconditions.checkNotNull(runnable);
        }

        public final void run() {
            try {
                this.f7671a.run();
            } catch (Throwable th) {
                a(th);
                RuntimeException propagate = Throwables.propagate(th);
            }
        }
    }

    public final /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return m13843a(runnable, j, timeUnit);
    }

    public final /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        return m13844a(callable, j, timeUnit);
    }

    public final /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return m13842a(runnable, j, j2, timeUnit);
    }

    public final /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return m13845b(runnable, j, j2, timeUnit);
    }

    MoreExecutors$ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.f7672a = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
    }

    public final ListenableScheduledFuture<?> m13843a(Runnable runnable, long j, TimeUnit timeUnit) {
        TrustedListenableFutureTask a = TrustedListenableFutureTask.a(runnable, null);
        return new ListenableScheduledTask(a, this.f7672a.schedule(a, j, timeUnit));
    }

    public final <V> ListenableScheduledFuture<V> m13844a(Callable<V> callable, long j, TimeUnit timeUnit) {
        TrustedListenableFutureTask a = TrustedListenableFutureTask.a(callable);
        return new ListenableScheduledTask(a, this.f7672a.schedule(a, j, timeUnit));
    }

    public final ListenableScheduledFuture<?> m13842a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Runnable neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
        return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.f7672a.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
    }

    public final ListenableScheduledFuture<?> m13845b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Runnable neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
        return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.f7672a.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
    }
}

package com.google.common.util.concurrent;

import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

@GwtCompatible
/* compiled from: warm */
public final class MoreExecutors {

    @GwtIncompatible("TODO")
    /* compiled from: warm */
    final class DirectExecutorService extends AbstractListeningExecutorService {
        private final Object f911a = new Object();
        @GuardedBy("lock")
        private int f912b = 0;
        @GuardedBy("lock")
        private boolean f913c = false;

        public final void execute(Runnable runnable) {
            m1817a();
            try {
                runnable.run();
            } finally {
                m1818b();
            }
        }

        public final boolean isShutdown() {
            boolean z;
            synchronized (this.f911a) {
                z = this.f913c;
            }
            return z;
        }

        public final void shutdown() {
            synchronized (this.f911a) {
                this.f913c = true;
                if (this.f912b == 0) {
                    ObjectDetour.c(this.f911a, -281569255);
                }
            }
        }

        public final List<Runnable> shutdownNow() {
            shutdown();
            return Collections.emptyList();
        }

        public final boolean isTerminated() {
            boolean z;
            synchronized (this.f911a) {
                z = this.f913c && this.f912b == 0;
            }
            return z;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean awaitTermination(long r10, java.util.concurrent.TimeUnit r12) {
            /*
            r9 = this;
            r0 = r12.toNanos(r10);
            r2 = r9.f911a;
            monitor-enter(r2);
        L_0x0007:
            r3 = r9.f913c;	 Catch:{ all -> 0x001b }
            if (r3 == 0) goto L_0x0012;
        L_0x000b:
            r3 = r9.f912b;	 Catch:{ all -> 0x001b }
            if (r3 != 0) goto L_0x0012;
        L_0x000f:
            r0 = 1;
            monitor-exit(r2);	 Catch:{ all -> 0x001b }
        L_0x0011:
            return r0;
        L_0x0012:
            r4 = 0;
            r3 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r3 > 0) goto L_0x001e;
        L_0x0018:
            r0 = 0;
            monitor-exit(r2);	 Catch:{ all -> 0x001b }
            goto L_0x0011;
        L_0x001b:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x001b }
            throw r0;
        L_0x001e:
            r4 = java.lang.System.nanoTime();	 Catch:{  }
            r3 = java.util.concurrent.TimeUnit.NANOSECONDS;	 Catch:{  }
            r6 = r9.f911a;	 Catch:{  }
            r3.timedWait(r6, r0);	 Catch:{  }
            r6 = java.lang.System.nanoTime();	 Catch:{  }
            r4 = r6 - r4;
            r0 = r0 - r4;
            goto L_0x0007;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.MoreExecutors.DirectExecutorService.awaitTermination(long, java.util.concurrent.TimeUnit):boolean");
        }

        private void m1817a() {
            synchronized (this.f911a) {
                if (this.f913c) {
                    throw new RejectedExecutionException("Executor already shutdown");
                }
                this.f912b++;
            }
        }

        private void m1818b() {
            synchronized (this.f911a) {
                int i = this.f912b - 1;
                this.f912b = i;
                if (i == 0) {
                    ObjectDetour.c(this.f911a, 93988759);
                }
            }
        }
    }

    /* compiled from: warm */
    public enum DirectExecutor implements Executor {
        INSTANCE;

        public final void execute(Runnable runnable) {
            runnable.run();
        }

        public final String toString() {
            return "MoreExecutors.directExecutor()";
        }
    }

    @GwtIncompatible("TODO")
    /* compiled from: warm */
    class ListeningDecorator extends AbstractListeningExecutorService {
        private final ExecutorService f9074a;

        ListeningDecorator(ExecutorService executorService) {
            this.f9074a = (ExecutorService) Preconditions.checkNotNull(executorService);
        }

        public final boolean awaitTermination(long j, TimeUnit timeUnit) {
            return this.f9074a.awaitTermination(j, timeUnit);
        }

        public final boolean isShutdown() {
            return this.f9074a.isShutdown();
        }

        public final boolean isTerminated() {
            return this.f9074a.isTerminated();
        }

        public final void shutdown() {
            this.f9074a.shutdown();
        }

        public final List<Runnable> shutdownNow() {
            return this.f9074a.shutdownNow();
        }

        public final void execute(Runnable runnable) {
            ExecutorDetour.a(this.f9074a, runnable, -1403047339);
        }
    }

    private MoreExecutors() {
    }

    @GwtIncompatible("TODO")
    @Deprecated
    public static ListeningExecutorService m1813a() {
        return new DirectExecutorService();
    }

    @GwtIncompatible("TODO")
    public static ListeningExecutorService m1815b() {
        return new DirectExecutorService();
    }

    public static Executor m1816c() {
        return DirectExecutor.INSTANCE;
    }

    @GwtIncompatible("TODO")
    public static ListeningExecutorService m1814a(ExecutorService executorService) {
        if (executorService instanceof ListeningExecutorService) {
            return (ListeningExecutorService) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new ScheduledListeningDecorator((ScheduledExecutorService) executorService) : new ListeningDecorator(executorService);
    }
}

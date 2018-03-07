package com.facebook.common.executors;

import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: menuHelper */
public class ConstrainedExecutorService extends AbstractExecutorService {
    private static final Class<?> f14385a = ConstrainedExecutorService.class;
    private final String f14386b;
    private final Executor f14387c;
    private volatile int f14388d;
    public final BlockingQueue<Runnable> f14389e;
    private final Worker f14390f;
    public final AtomicInteger f14391g;
    private final AtomicInteger f14392h;

    /* compiled from: menuHelper */
    class Worker implements Runnable {
        final /* synthetic */ ConstrainedExecutorService f14393a;

        public Worker(ConstrainedExecutorService constrainedExecutorService) {
            this.f14393a = constrainedExecutorService;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r3 = this;
            r0 = r3.f14393a;	 Catch:{ all -> 0x002b }
            r0 = r0.f14389e;	 Catch:{ all -> 0x002b }
            r0 = r0.poll();	 Catch:{ all -> 0x002b }
            r0 = (java.lang.Runnable) r0;	 Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x000f;
        L_0x000c:
            r0.run();	 Catch:{ all -> 0x002b }
        L_0x000f:
            r0 = r3.f14393a;
            r0 = r0.f14391g;
            r0 = r0.decrementAndGet();
            r1 = r3.f14393a;
            r1 = r1.f14389e;
            r1 = r1.isEmpty();
            if (r1 != 0) goto L_0x0027;
        L_0x0021:
            r0 = r3.f14393a;
            com.facebook.common.executors.ConstrainedExecutorService.m20766a(r0);
        L_0x0026:
            return;
        L_0x0027:
            java.lang.Integer.valueOf(r0);
            goto L_0x0026;
        L_0x002b:
            r0 = move-exception;
            r1 = r3.f14393a;
            r1 = r1.f14391g;
            r1 = r1.decrementAndGet();
            r2 = r3.f14393a;
            r2 = r2.f14389e;
            r2 = r2.isEmpty();
            if (r2 != 0) goto L_0x0044;
        L_0x003e:
            r1 = r3.f14393a;
            com.facebook.common.executors.ConstrainedExecutorService.m20766a(r1);
        L_0x0043:
            throw r0;
        L_0x0044:
            java.lang.Integer.valueOf(r1);
            goto L_0x0043;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.executors.ConstrainedExecutorService.Worker.run():void");
        }
    }

    public ConstrainedExecutorService(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.f14386b = str;
        this.f14387c = executor;
        this.f14388d = i;
        this.f14389e = blockingQueue;
        this.f14390f = new Worker(this);
        this.f14391g = new AtomicInteger(0);
        this.f14392h = new AtomicInteger(0);
    }

    public static ConstrainedExecutorService m20765a(String str, int i, int i2, Executor executor) {
        return new ConstrainedExecutorService(str, i, executor, new LinkedBlockingQueue(i2));
    }

    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        } else if (this.f14389e.offer(runnable)) {
            int size = this.f14389e.size();
            int i = this.f14392h.get();
            if (size > i && this.f14392h.compareAndSet(i, size)) {
                Integer.valueOf(size);
            }
            m20766a(this);
        } else {
            throw new RejectedExecutionException(this.f14386b + " queue is full, size=" + this.f14389e.size());
        }
    }

    public static void m20766a(ConstrainedExecutorService constrainedExecutorService) {
        int i = constrainedExecutorService.f14391g.get();
        while (i < constrainedExecutorService.f14388d) {
            int i2 = i + 1;
            if (constrainedExecutorService.f14391g.compareAndSet(i, i2)) {
                Integer.valueOf(i2);
                Integer.valueOf(constrainedExecutorService.f14388d);
                ExecutorDetour.a(constrainedExecutorService.f14387c, constrainedExecutorService.f14390f, -173853661);
                return;
            }
            i = constrainedExecutorService.f14391g.get();
        }
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
}

package com.google.common.util.concurrent;

import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: wear_connected_nodes */
public final class ExecutionList {
    @VisibleForTesting
    static final Logger f889a = Logger.getLogger(ExecutionList.class.getName());
    @GuardedBy("this")
    private RunnableExecutorPair f890b;
    @GuardedBy("this")
    private boolean f891c;

    /* compiled from: wear_connected_nodes */
    final class RunnableExecutorPair {
        final Runnable f1264a;
        final Executor f1265b;
        @Nullable
        RunnableExecutorPair f1266c;

        RunnableExecutorPair(Runnable runnable, Executor executor, RunnableExecutorPair runnableExecutorPair) {
            this.f1264a = runnable;
            this.f1265b = executor;
            this.f1266c = runnableExecutorPair;
        }
    }

    public final void m1746a(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        synchronized (this) {
            if (this.f891c) {
                m1744b(runnable, executor);
                return;
            }
            this.f890b = new RunnableExecutorPair(runnable, executor, this.f890b);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1745a() {
        /*
        r4 = this;
        r1 = 0;
        monitor-enter(r4);
        r0 = r4.f891c;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r4);	 Catch:{ all -> 0x001d }
    L_0x0007:
        return;
    L_0x0008:
        r0 = 1;
        r4.f891c = r0;	 Catch:{ all -> 0x001d }
        r0 = r4.f890b;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r4.f890b = r2;	 Catch:{ all -> 0x001d }
        monitor-exit(r4);	 Catch:{ all -> 0x001d }
        r3 = r0;
        r0 = r1;
        r1 = r3;
    L_0x0014:
        if (r1 == 0) goto L_0x0020;
    L_0x0016:
        r2 = r1.f1266c;
        r1.f1266c = r0;
        r0 = r1;
        r1 = r2;
        goto L_0x0014;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{  }
        throw r0;
    L_0x0020:
        if (r0 == 0) goto L_0x0007;
    L_0x0022:
        r1 = r0.f1264a;
        r2 = r0.f1265b;
        m1744b(r1, r2);
        r0 = r0.f1266c;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ExecutionList.a():void");
    }

    private static void m1744b(Runnable runnable, Executor executor) {
        try {
            ExecutorDetour.a(executor, runnable, -1933206678);
        } catch (Throwable e) {
            f889a.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e);
        }
    }
}

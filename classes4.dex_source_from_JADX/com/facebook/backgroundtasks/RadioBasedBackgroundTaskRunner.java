package com.facebook.backgroundtasks;

import android.net.NetworkInfo;
import com.facebook.common.executors.C0398xee77ff78;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.powermanagement.listener.RadioPowerStateChange;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.PriorityQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: i2o_delay_ms */
public class RadioBasedBackgroundTaskRunner implements RadioPowerStateChange {
    private static volatile RadioBasedBackgroundTaskRunner f10570f;
    private final ScheduledExecutorService f10571a;
    private final Clock f10572b;
    private final FbNetworkManager f10573c;
    @GuardedBy("this")
    private final PriorityQueue<RunnableNode> f10574d = new PriorityQueue();
    private ScheduledFuture f10575e;

    public static com.facebook.backgroundtasks.RadioBasedBackgroundTaskRunner m11103a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10570f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backgroundtasks.RadioBasedBackgroundTaskRunner.class;
        monitor-enter(r1);
        r0 = f10570f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m11106b(r0);	 Catch:{ all -> 0x0035 }
        f10570f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10570f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backgroundtasks.RadioBasedBackgroundTaskRunner.a(com.facebook.inject.InjectorLike):com.facebook.backgroundtasks.RadioBasedBackgroundTaskRunner");
    }

    private static RadioBasedBackgroundTaskRunner m11106b(InjectorLike injectorLike) {
        return new RadioBasedBackgroundTaskRunner((ScheduledExecutorService) C0398xee77ff78.m8506a(injectorLike), FbNetworkManager.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RadioBasedBackgroundTaskRunner(ScheduledExecutorService scheduledExecutorService, FbNetworkManager fbNetworkManager, Clock clock) {
        this.f10571a = scheduledExecutorService;
        this.f10573c = fbNetworkManager;
        this.f10572b = clock;
    }

    public final synchronized void m11113a(Runnable runnable, long j) {
        m11105a(runnable, Optional.of(Long.valueOf(j)));
    }

    public final synchronized void m11112a(Runnable runnable) {
        m11105a(runnable, Absent.withType());
    }

    public final synchronized void mo691a() {
        if (!this.f10574d.isEmpty()) {
            m11108c();
            m11110e();
        }
    }

    public final synchronized void mo692b() {
    }

    private synchronized void m11105a(Runnable runnable, Optional<Long> optional) {
        Preconditions.checkNotNull(runnable);
        NetworkInfo i = this.f10573c.i();
        if (i != null && i.isConnected() && i.getType() == 1) {
            m11107b(runnable);
        } else {
            long a = this.f10572b.a();
            if (this.f10574d.isEmpty()) {
                if (optional.isPresent()) {
                    m11104a(((Long) optional.get()).longValue());
                }
            } else if (optional.isPresent()) {
                long longValue = ((Long) optional.get()).longValue();
                Optional optional2 = ((RunnableNode) this.f10574d.peek()).b;
                if (!optional2.isPresent() || longValue + a < ((Long) optional2.get()).longValue()) {
                    m11108c();
                    m11104a(longValue);
                }
            }
            PriorityQueue priorityQueue = this.f10574d;
            if (optional.isPresent()) {
                optional = Optional.of(Long.valueOf(a + ((Long) optional.get()).longValue()));
            }
            priorityQueue.add(new RunnableNode(this, runnable, optional));
        }
    }

    private void m11104a(long j) {
        Preconditions.checkArgument(this.f10575e == null);
        this.f10575e = this.f10571a.schedule(new 1(this), j, TimeUnit.MILLISECONDS);
    }

    private void m11108c() {
        if (this.f10575e != null) {
            this.f10575e.cancel(false);
        }
        this.f10575e = null;
    }

    private void m11107b(Runnable runnable) {
        ExecutorDetour.a(this.f10571a, runnable, -1035838470);
    }

    public static synchronized void m11109d(RadioBasedBackgroundTaskRunner radioBasedBackgroundTaskRunner) {
        synchronized (radioBasedBackgroundTaskRunner) {
            Preconditions.checkNotNull(radioBasedBackgroundTaskRunner.f10575e);
            radioBasedBackgroundTaskRunner.f10575e = null;
            radioBasedBackgroundTaskRunner.m11110e();
        }
    }

    private synchronized void m11110e() {
        while (!this.f10574d.isEmpty()) {
            ExecutorDetour.a(this.f10571a, ((RunnableNode) this.f10574d.poll()).a, -2002665673);
        }
    }
}

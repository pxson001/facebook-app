package com.facebook.powermanagement;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.executors.ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider;
import com.facebook.common.hardware.NetworkActivityBroadcastManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.powermanagement.listener.RadioPowerStateChange;
import com.facebook.powermanagement.listener.STATICDI_MULTIBIND_PROVIDER$RadioPowerStateChange;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: thread_presence_remote_duration_instance */
public class RadioPowerManager {
    private static volatile RadioPowerManager f11174i;
    private final Class<?> f11175a = RadioPowerManager.class;
    private final MonotonicClock f11176b;
    private final Set<RadioPowerStateChange> f11177c;
    private final ScheduledExecutorService f11178d;
    public ActionReceiver f11179e;
    @GuardedBy("this")
    private final Map<Integer, ScheduledFuture> f11180f = Maps.c();
    private boolean f11181g = false;
    private long f11182h = -1;

    /* compiled from: thread_presence_remote_duration_instance */
    class TimeoutPidRunnable implements Runnable {
        final /* synthetic */ RadioPowerManager f1113a;
        private final int f1114b;

        public TimeoutPidRunnable(RadioPowerManager radioPowerManager, int i) {
            this.f1113a = radioPowerManager;
            this.f1114b = i;
        }

        public void run() {
            this.f1113a.m11616b(this.f1114b);
        }
    }

    /* compiled from: thread_presence_remote_duration_instance */
    public class NetworkActivityActionReceiver implements ActionReceiver {
        final /* synthetic */ RadioPowerManager f11184a;

        public NetworkActivityActionReceiver(RadioPowerManager radioPowerManager) {
            this.f11184a = radioPowerManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1482442363);
            int intExtra = intent.getIntExtra("pid", -1);
            if (intExtra == -1) {
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1561313521, a);
                return;
            }
            if (NetworkActivityBroadcastManager.a.equals(intent.getAction())) {
                this.f11184a.m11615a(intExtra);
            } else if (NetworkActivityBroadcastManager.b.equals(intent.getAction())) {
                this.f11184a.m11616b(intExtra);
            }
            LogUtils.e(-1693967483, a);
        }
    }

    public static com.facebook.powermanagement.RadioPowerManager m11611a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11174i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.powermanagement.RadioPowerManager.class;
        monitor-enter(r1);
        r0 = f11174i;	 Catch:{ all -> 0x003a }
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
        r0 = m11612b(r0);	 Catch:{ all -> 0x0035 }
        f11174i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11174i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.powermanagement.RadioPowerManager.a(com.facebook.inject.InjectorLike):com.facebook.powermanagement.RadioPowerManager");
    }

    private static RadioPowerManager m11612b(InjectorLike injectorLike) {
        return new RadioPowerManager((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$RadioPowerStateChange(injectorLike)), ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public RadioPowerManager(MonotonicClock monotonicClock, Set<RadioPowerStateChange> set, ScheduledExecutorService scheduledExecutorService) {
        this.f11176b = monotonicClock;
        this.f11177c = set;
        this.f11178d = scheduledExecutorService;
    }

    final synchronized void m11615a(int i) {
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.f11180f.remove(Integer.valueOf(i));
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        m11614c();
        this.f11180f.put(Integer.valueOf(i), this.f11178d.schedule(new TimeoutPidRunnable(this, i), 120000, TimeUnit.MILLISECONDS));
    }

    final synchronized void m11616b(int i) {
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.f11180f.remove(Integer.valueOf(i));
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            if (this.f11180f.isEmpty()) {
                m11613b();
            }
        }
    }

    private synchronized void m11613b() {
        Preconditions.checkState(this.f11181g);
        this.f11181g = false;
        this.f11182h = this.f11176b.now();
        for (RadioPowerStateChange radioPowerStateChange : this.f11177c) {
            if (radioPowerStateChange != null) {
                radioPowerStateChange.mo692b();
            }
        }
    }

    private synchronized void m11614c() {
        if (!this.f11181g) {
            this.f11181g = true;
            for (RadioPowerStateChange radioPowerStateChange : this.f11177c) {
                if (radioPowerStateChange != null) {
                    radioPowerStateChange.mo691a();
                }
            }
        }
    }
}

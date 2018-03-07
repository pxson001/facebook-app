package com.facebook.common.appstate;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.C0336x1fe4bb6b;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.http.common.RequestProcessorSnapshotLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: receiver_mqtt_client */
public class PeriodicForegroundScheduler {
    private static volatile PeriodicForegroundScheduler f7900k;
    public final Object f7901a = new Object();
    private final AppStateManager f7902b;
    public final ScheduledExecutorService f7903c;
    private final BaseFbBroadcastManager f7904d;
    private final ActionReceiver f7905e;
    private final ActionReceiver f7906f;
    @GuardedBy("mLock")
    public ScheduledFuture f7907g;
    @GuardedBy("mLock")
    public int f7908h;
    @GuardedBy("itself")
    public final ArrayList<ForegroundPeriodicTask> f7909i;
    public final Runnable f7910j = new C03371(this);

    /* compiled from: receiver_mqtt_client */
    class C03371 implements Runnable {
        final /* synthetic */ PeriodicForegroundScheduler f7912a;

        C03371(PeriodicForegroundScheduler periodicForegroundScheduler) {
            this.f7912a = periodicForegroundScheduler;
        }

        public void run() {
            synchronized (this.f7912a.f7909i) {
                for (int i = 0; i < this.f7912a.f7909i.size(); i++) {
                    if (Math.random() < ((ForegroundPeriodicTask) this.f7912a.f7909i.get(i)).m12498a()) {
                        ((ForegroundPeriodicTask) this.f7912a.f7909i.get(i)).m12499b().m12486a();
                    }
                }
                Integer.valueOf(this.f7912a.f7909i.size());
            }
        }
    }

    /* compiled from: receiver_mqtt_client */
    class C03382 implements ActionReceiver {
        final /* synthetic */ PeriodicForegroundScheduler f7913a;

        C03382(PeriodicForegroundScheduler periodicForegroundScheduler) {
            this.f7913a = periodicForegroundScheduler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 452576621);
            synchronized (this.f7913a.f7901a) {
                try {
                    if (this.f7913a.f7908h == 0) {
                        this.f7913a.f7907g = this.f7913a.f7903c.scheduleAtFixedRate(this.f7913a.f7910j, 5000, 5000, TimeUnit.MILLISECONDS);
                    }
                    this.f7913a.f7908h = this.f7913a.f7908h + 1;
                } finally {
                    LogUtils.e(-856287908, a);
                }
            }
        }
    }

    /* compiled from: receiver_mqtt_client */
    class C03393 implements ActionReceiver {
        final /* synthetic */ PeriodicForegroundScheduler f7914a;

        C03393(PeriodicForegroundScheduler periodicForegroundScheduler) {
            this.f7914a = periodicForegroundScheduler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 342150729);
            synchronized (this.f7914a.f7901a) {
                try {
                    if (this.f7914a.f7908h == 1 && this.f7914a.f7907g != null) {
                        this.f7914a.f7907g.cancel(true);
                        this.f7914a.f7907g = null;
                    }
                    this.f7914a.f7908h = this.f7914a.f7908h - 1;
                } finally {
                    LogUtils.e(-1879354943, a);
                }
            }
        }
    }

    public static com.facebook.common.appstate.PeriodicForegroundScheduler m12490a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7900k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.appstate.PeriodicForegroundScheduler.class;
        monitor-enter(r1);
        r0 = f7900k;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m12492b(r0);	 Catch:{ all -> 0x0035 }
        f7900k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7900k;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.appstate.PeriodicForegroundScheduler.a(com.facebook.inject.InjectorLike):com.facebook.common.appstate.PeriodicForegroundScheduler");
    }

    private static PeriodicForegroundScheduler m12492b(InjectorLike injectorLike) {
        return new PeriodicForegroundScheduler(LocalFbBroadcastManager.m2946a(injectorLike), AppStateManager.m2245a(injectorLike), C0336x1fe4bb6b.m12496a(injectorLike));
    }

    @Inject
    public PeriodicForegroundScheduler(BaseFbBroadcastManager baseFbBroadcastManager, AppStateManager appStateManager, ScheduledExecutorService scheduledExecutorService) {
        this.f7904d = baseFbBroadcastManager;
        this.f7902b = appStateManager;
        this.f7903c = scheduledExecutorService;
        this.f7907g = null;
        this.f7908h = 0;
        this.f7909i = new ArrayList();
        this.f7905e = new C03382(this);
        this.f7906f = new C03393(this);
        this.f7904d.m2951a().mo506a(AppStateManager.f1110b, this.f7905e).mo503a().m3296b();
        this.f7904d.m2951a().mo506a(AppStateManager.f1111c, this.f7906f).mo503a().m3296b();
    }

    public final void m12495a(RequestProcessorSnapshotLogger requestProcessorSnapshotLogger, double d) {
        synchronized (this.f7909i) {
            this.f7909i.add(new ForegroundPeriodicTask(requestProcessorSnapshotLogger, d));
        }
    }
}

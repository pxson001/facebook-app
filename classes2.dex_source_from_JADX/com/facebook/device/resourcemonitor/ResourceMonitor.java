package com.facebook.device.resourcemonitor;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.C0109x696ccb0c;
import com.facebook.common.hardware.ScreenPowerState;
import com.facebook.common.hardware.ScreenPowerState.PowerChangeListener;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: setOrientation call must be passed from the LayoutManager */
public class ResourceMonitor {
    public static final Class<?> f5341a = ResourceMonitor.class;
    private static volatile ResourceMonitor f5342q;
    public ResourceManager f5343b;
    private final Runnable f5344c = new C02491(this);
    private final Runnable f5345d = new C02502(this);
    private ScheduledFuture<?> f5346e;
    private ScheduledFuture<?> f5347f;
    public boolean f5348g;
    public boolean f5349h;
    private final ScheduledExecutorService f5350i;
    public final ScreenPowerState f5351j;
    public final AppStateManager f5352k;
    public final PowerChangeListener f5353l = new C02513(this);
    private final BaseFbBroadcastManager f5354m;
    public final SelfRegistrableReceiverImpl f5355n;
    private final ActionReceiver f5356o = new C02524(this);
    private final ActionReceiver f5357p = new C02535(this);

    /* compiled from: setOrientation call must be passed from the LayoutManager */
    class C02491 implements Runnable {
        final /* synthetic */ ResourceMonitor f5358a;

        C02491(ResourceMonitor resourceMonitor) {
            this.f5358a = resourceMonitor;
        }

        public void run() {
            try {
                this.f5358a.f5343b.m9216e();
            } catch (Throwable e) {
                BLog.b(ResourceMonitor.f5341a, "updateMemoryUsage throws", e);
            }
        }
    }

    /* compiled from: setOrientation call must be passed from the LayoutManager */
    class C02502 implements Runnable {
        final /* synthetic */ ResourceMonitor f5359a;

        C02502(ResourceMonitor resourceMonitor) {
            this.f5359a = resourceMonitor;
        }

        public void run() {
            try {
                this.f5359a.f5343b.m9217f();
            } catch (Throwable e) {
                BLog.b(ResourceMonitor.f5341a, "updateDiskUsage throws", e);
            }
        }
    }

    /* compiled from: setOrientation call must be passed from the LayoutManager */
    class C02513 implements PowerChangeListener {
        final /* synthetic */ ResourceMonitor f5360a;

        C02513(ResourceMonitor resourceMonitor) {
            this.f5360a = resourceMonitor;
        }

        public final void mo1326a(boolean z) {
            this.f5360a.f5348g = z;
            if (z) {
                ResourceMonitor.m9221b(this.f5360a);
            } else {
                ResourceMonitor.m9222c(this.f5360a);
            }
        }
    }

    /* compiled from: setOrientation call must be passed from the LayoutManager */
    class C02524 implements ActionReceiver {
        final /* synthetic */ ResourceMonitor f5361a;

        C02524(ResourceMonitor resourceMonitor) {
            this.f5361a = resourceMonitor;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1522775650);
            this.f5361a.f5349h = true;
            ResourceMonitor.m9221b(this.f5361a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1127969443, a);
        }
    }

    /* compiled from: setOrientation call must be passed from the LayoutManager */
    class C02535 implements ActionReceiver {
        final /* synthetic */ ResourceMonitor f5362a;

        C02535(ResourceMonitor resourceMonitor) {
            this.f5362a = resourceMonitor;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -2056753910);
            this.f5362a.f5349h = false;
            ResourceMonitor.m9222c(this.f5362a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1484017191, a);
        }
    }

    public static com.facebook.device.resourcemonitor.ResourceMonitor m9219a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5342q;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.device.resourcemonitor.ResourceMonitor.class;
        monitor-enter(r1);
        r0 = f5342q;	 Catch:{ all -> 0x003a }
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
        r0 = m9220b(r0);	 Catch:{ all -> 0x0035 }
        f5342q = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5342q;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.resourcemonitor.ResourceMonitor.a(com.facebook.inject.InjectorLike):com.facebook.device.resourcemonitor.ResourceMonitor");
    }

    private static ResourceMonitor m9220b(InjectorLike injectorLike) {
        return new ResourceMonitor(ScreenPowerState.m8540a(injectorLike), AppStateManager.m2245a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), C0109x696ccb0c.m2944a(injectorLike), Handler_BackgroundBroadcastThreadMethodAutoProvider.m4110a(injectorLike));
    }

    @Inject
    public ResourceMonitor(ScreenPowerState screenPowerState, AppStateManager appStateManager, BaseFbBroadcastManager baseFbBroadcastManager, ScheduledExecutorService scheduledExecutorService, Handler handler) {
        this.f5351j = screenPowerState;
        this.f5352k = appStateManager;
        this.f5354m = baseFbBroadcastManager;
        this.f5350i = scheduledExecutorService;
        this.f5355n = this.f5354m.m2951a().mo506a(AppStateManager.f1110b, this.f5356o).mo506a(AppStateManager.f1111c, this.f5357p).mo505a(handler).mo503a();
    }

    public static synchronized void m9221b(ResourceMonitor resourceMonitor) {
        synchronized (resourceMonitor) {
            if (resourceMonitor.f5348g && resourceMonitor.f5349h && resourceMonitor.f5346e == null) {
                if (resourceMonitor.f5346e == null) {
                    resourceMonitor.f5346e = resourceMonitor.f5350i.scheduleAtFixedRate(resourceMonitor.f5344c, 0, 3000, TimeUnit.MILLISECONDS);
                }
                if (resourceMonitor.f5347f == null) {
                    resourceMonitor.f5347f = resourceMonitor.f5350i.scheduleAtFixedRate(resourceMonitor.f5345d, 0, 60000, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public static synchronized void m9222c(ResourceMonitor resourceMonitor) {
        synchronized (resourceMonitor) {
            if (!(resourceMonitor.f5346e == null && resourceMonitor.f5347f == null)) {
                if (resourceMonitor.f5346e != null) {
                    resourceMonitor.f5346e.cancel(false);
                    resourceMonitor.f5346e = null;
                }
                if (resourceMonitor.f5347f != null) {
                    resourceMonitor.f5347f.cancel(false);
                    resourceMonitor.f5347f = null;
                }
            }
        }
    }
}

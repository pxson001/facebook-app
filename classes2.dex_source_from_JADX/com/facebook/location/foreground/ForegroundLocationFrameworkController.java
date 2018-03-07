package com.facebook.location.foreground;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.GlobalFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.location.C0664xc4defe1d;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusMonitor;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.Handler_ForLocationNonUiThreadMethodAutoProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mapped_uri */
public class ForegroundLocationFrameworkController {
    public static final String f15153a = ForegroundLocationFrameworkController.class.getSimpleName();
    private static volatile ForegroundLocationFrameworkController f15154w;
    private final QeAccessor f15155b;
    private final Handler f15156c;
    public final AppStateManager f15157d;
    private final BaseFbBroadcastManager f15158e;
    private final BaseFbBroadcastManager f15159f;
    private final MonotonicClock f15160g;
    public final FbLocationStatusUtil f15161h;
    private final Lazy<ForegroundLocationFrameworkConfig> f15162i;
    private final Lazy<ForegroundLocationFrameworkSignalReader> f15163j;
    public final ForegroundLocationFrameworkAnalyticsLogger f15164k;
    public final Lazy<ForegroundLocationStatusBroadcaster> f15165l;
    private final ListeningScheduledExecutorService f15166m;
    public final Lazy<FbErrorReporter> f15167n;
    private boolean f15168o;
    private SelfRegistrableReceiverImpl f15169p;
    private SelfRegistrableReceiverImpl f15170q;
    private long f15171r;
    private ListenableFuture<?> f15172s;
    private final Runnable f15173t = new C06651(this);
    private final Runnable f15174u = new C06662(this);
    private final Runnable f15175v = new C06673(this);

    /* compiled from: mapped_uri */
    class C06651 implements Runnable {
        final /* synthetic */ ForegroundLocationFrameworkController f15218a;

        C06651(ForegroundLocationFrameworkController foregroundLocationFrameworkController) {
            this.f15218a = foregroundLocationFrameworkController;
        }

        public void run() {
            ForegroundLocationFrameworkController.m21669d(this.f15218a);
        }
    }

    /* compiled from: mapped_uri */
    class C06662 implements Runnable {
        final /* synthetic */ ForegroundLocationFrameworkController f15219a;

        C06662(ForegroundLocationFrameworkController foregroundLocationFrameworkController) {
            this.f15219a = foregroundLocationFrameworkController;
        }

        public void run() {
            ForegroundLocationFrameworkController.m21670e(this.f15219a);
        }
    }

    /* compiled from: mapped_uri */
    class C06673 implements Runnable {
        final /* synthetic */ ForegroundLocationFrameworkController f15220a;
        private int f15221b;

        C06673(ForegroundLocationFrameworkController foregroundLocationFrameworkController) {
            this.f15220a = foregroundLocationFrameworkController;
        }

        public void run() {
            try {
                if (!this.f15220a.f15157d.m2264l()) {
                    ((ForegroundLocationStatusBroadcaster) this.f15220a.f15165l.get()).m23331c();
                } else if (this.f15220a.f15161h.m8257a() != State.OKAY) {
                    ((ForegroundLocationStatusBroadcaster) this.f15220a.f15165l.get()).m23331c();
                    int i = this.f15221b + 1;
                    this.f15221b = i;
                    ForegroundLocationFrameworkController.m21667a(this.f15220a, ForegroundLocationFrameworkController.m21679n(this.f15220a) << Math.min(i, 4));
                } else {
                    this.f15221b = 0;
                    ForegroundLocationFrameworkController.m21667a(this.f15220a, ForegroundLocationFrameworkController.m21679n(this.f15220a));
                    ForegroundLocationFrameworkController.m21673h(this.f15220a);
                }
            } catch (Throwable e) {
                Throwable th = e;
                this.f15220a.f15164k.m21735b();
                ((AbstractFbErrorReporter) this.f15220a.f15167n.get()).m2343a(ForegroundLocationFrameworkController.f15153a, "Something is wrong when requesting location", th);
            }
        }
    }

    /* compiled from: mapped_uri */
    class C06964 extends ForegroundOnlyActionReceiver {
        final /* synthetic */ ForegroundLocationFrameworkController f16112a;

        C06964(ForegroundLocationFrameworkController foregroundLocationFrameworkController) {
            this.f16112a = foregroundLocationFrameworkController;
            super(foregroundLocationFrameworkController);
        }

        public final void mo2918a(Intent intent) {
            ForegroundLocationFrameworkController.m21671f(this.f16112a);
        }
    }

    /* compiled from: mapped_uri */
    abstract class ForegroundOnlyActionReceiver implements ActionReceiver {
        final /* synthetic */ ForegroundLocationFrameworkController f16113b;

        public abstract void mo2918a(Intent intent);

        public ForegroundOnlyActionReceiver(ForegroundLocationFrameworkController foregroundLocationFrameworkController) {
            this.f16113b = foregroundLocationFrameworkController;
        }

        public final void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 957929538);
            if (this.f16113b.f15157d.m2264l() && !broadcastReceiverLike.isInitialStickyBroadcast()) {
                mo2918a(intent);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1349164083, a);
        }
    }

    /* compiled from: mapped_uri */
    class C06985 extends ForegroundOnlyActionReceiver {
        final /* synthetic */ ForegroundLocationFrameworkController f16118a;

        C06985(ForegroundLocationFrameworkController foregroundLocationFrameworkController) {
            this.f16118a = foregroundLocationFrameworkController;
            super(foregroundLocationFrameworkController);
        }

        public final void mo2918a(Intent intent) {
            int intExtra = intent.getIntExtra("previous_wifi_state", -1);
            int intExtra2 = intent.getIntExtra("wifi_state", -1);
            if (intExtra2 == 3 && intExtra != -1 && intExtra2 != intExtra) {
                ForegroundLocationFrameworkController.m21672g(this.f16118a);
            }
        }
    }

    public static com.facebook.location.foreground.ForegroundLocationFrameworkController m21666a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15154w;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.location.foreground.ForegroundLocationFrameworkController.class;
        monitor-enter(r1);
        r0 = f15154w;	 Catch:{ all -> 0x003a }
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
        r0 = m21668b(r0);	 Catch:{ all -> 0x0035 }
        f15154w = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15154w;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.location.foreground.ForegroundLocationFrameworkController.a(com.facebook.inject.InjectorLike):com.facebook.location.foreground.ForegroundLocationFrameworkController");
    }

    private static ForegroundLocationFrameworkController m21668b(InjectorLike injectorLike) {
        return new ForegroundLocationFrameworkController(QeInternalImplMethodAutoProvider.m3744a(injectorLike), Handler_ForLocationNonUiThreadMethodAutoProvider.m21682a(injectorLike), C0664xc4defe1d.m21716a(injectorLike), AppStateManager.m2245a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), GlobalFbBroadcastManager.m4507a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), FbLocationStatusUtil.m8253a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2495), IdBasedLazy.m1808a(injectorLike, 2498), ForegroundLocationFrameworkAnalyticsLogger.m21719a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2500));
    }

    @Inject
    public ForegroundLocationFrameworkController(QeAccessor qeAccessor, Handler handler, ListeningScheduledExecutorService listeningScheduledExecutorService, AppStateManager appStateManager, FbBroadcastManager fbBroadcastManager, FbBroadcastManager fbBroadcastManager2, MonotonicClock monotonicClock, FbLocationStatusUtil fbLocationStatusUtil, Lazy<ForegroundLocationFrameworkConfig> lazy, Lazy<ForegroundLocationFrameworkSignalReader> lazy2, ForegroundLocationFrameworkAnalyticsLogger foregroundLocationFrameworkAnalyticsLogger, Lazy<FbErrorReporter> lazy3, Lazy<ForegroundLocationStatusBroadcaster> lazy4) {
        this.f15155b = qeAccessor;
        this.f15156c = handler;
        this.f15157d = appStateManager;
        this.f15158e = fbBroadcastManager;
        this.f15159f = fbBroadcastManager2;
        this.f15160g = monotonicClock;
        this.f15161h = fbLocationStatusUtil;
        this.f15162i = lazy;
        this.f15163j = lazy2;
        this.f15164k = foregroundLocationFrameworkAnalyticsLogger;
        this.f15165l = lazy4;
        this.f15167n = lazy3;
        this.f15166m = listeningScheduledExecutorService;
    }

    public final void m21680a() {
        if (m21676k()) {
            HandlerDetour.a(this.f15156c, this.f15173t, 985895651);
        }
    }

    public final void m21681b() {
        if (m21676k()) {
            HandlerDetour.a(this.f15156c, this.f15174u, 124868490);
        }
    }

    public static synchronized void m21669d(ForegroundLocationFrameworkController foregroundLocationFrameworkController) {
        synchronized (foregroundLocationFrameworkController) {
            if (!foregroundLocationFrameworkController.f15168o) {
                foregroundLocationFrameworkController.f15168o = true;
                long max = Math.max(0, foregroundLocationFrameworkController.m21677l());
                foregroundLocationFrameworkController.f15164k.m21731a(max);
                m21667a(foregroundLocationFrameworkController, max);
                if (max > 0) {
                    ((ForegroundLocationStatusBroadcaster) foregroundLocationFrameworkController.f15165l.get()).m23330b();
                }
                if (foregroundLocationFrameworkController.f15169p == null) {
                    foregroundLocationFrameworkController.f15169p = foregroundLocationFrameworkController.f15158e.m2951a().mo505a(foregroundLocationFrameworkController.f15156c).mo506a(FbLocationStatusMonitor.f16098b, new C06964(foregroundLocationFrameworkController)).mo503a();
                    foregroundLocationFrameworkController.f15169p.m3296b();
                }
                foregroundLocationFrameworkController.f15170q = foregroundLocationFrameworkController.f15159f.m2951a().mo506a("android.net.wifi.WIFI_STATE_CHANGED", new C06985(foregroundLocationFrameworkController)).mo503a();
                foregroundLocationFrameworkController.f15170q.m3296b();
            }
        }
    }

    public static synchronized void m21670e(ForegroundLocationFrameworkController foregroundLocationFrameworkController) {
        synchronized (foregroundLocationFrameworkController) {
            if (foregroundLocationFrameworkController.f15168o) {
                foregroundLocationFrameworkController.f15168o = false;
                if (foregroundLocationFrameworkController.f15170q != null) {
                    if (foregroundLocationFrameworkController.f15170q.m3295a()) {
                        foregroundLocationFrameworkController.f15170q.m3297c();
                    }
                    foregroundLocationFrameworkController.f15170q = null;
                }
                foregroundLocationFrameworkController.m21675j();
                ((ForegroundLocationFrameworkSignalReader) foregroundLocationFrameworkController.f15163j.get()).m23064b();
                foregroundLocationFrameworkController.f15164k.m21739f();
            }
        }
    }

    public static synchronized void m21671f(ForegroundLocationFrameworkController foregroundLocationFrameworkController) {
        synchronized (foregroundLocationFrameworkController) {
            if (foregroundLocationFrameworkController.m21678m()) {
                foregroundLocationFrameworkController.m21674i();
            } else {
                foregroundLocationFrameworkController.m21675j();
                ((ForegroundLocationFrameworkSignalReader) foregroundLocationFrameworkController.f15163j.get()).m23064b();
            }
        }
    }

    public static synchronized void m21672g(ForegroundLocationFrameworkController foregroundLocationFrameworkController) {
        synchronized (foregroundLocationFrameworkController) {
            foregroundLocationFrameworkController.m21674i();
        }
    }

    public static synchronized void m21673h(ForegroundLocationFrameworkController foregroundLocationFrameworkController) {
        synchronized (foregroundLocationFrameworkController) {
            foregroundLocationFrameworkController.f15171r = foregroundLocationFrameworkController.f15160g.now();
            ((ForegroundLocationFrameworkSignalReader) foregroundLocationFrameworkController.f15163j.get()).m23063a();
        }
    }

    public static synchronized void m21667a(ForegroundLocationFrameworkController foregroundLocationFrameworkController, long j) {
        synchronized (foregroundLocationFrameworkController) {
            foregroundLocationFrameworkController.f15172s = foregroundLocationFrameworkController.f15166m.mo310a(foregroundLocationFrameworkController.f15175v, j, TimeUnit.MILLISECONDS);
        }
    }

    private synchronized void m21674i() {
        m21675j();
        if (m21678m()) {
            m21667a(this, 0);
        }
    }

    private synchronized void m21675j() {
        if (this.f15172s != null) {
            this.f15172s.cancel(false);
            this.f15172s = null;
        }
    }

    private synchronized boolean m21676k() {
        return this.f15155b.mo596a(ExperimentsForForegroundLocationModule.f15224c, false);
    }

    private synchronized long m21677l() {
        return Math.max((this.f15171r + m21679n(this)) - this.f15160g.now(), 0);
    }

    private synchronized boolean m21678m() {
        boolean z;
        z = this.f15157d.m2264l() && this.f15161h.m8257a() == State.OKAY;
        return z;
    }

    public static synchronized long m21679n(ForegroundLocationFrameworkController foregroundLocationFrameworkController) {
        long d;
        synchronized (foregroundLocationFrameworkController) {
            d = ((ForegroundLocationFrameworkConfig) foregroundLocationFrameworkController.f15162i.get()).m22176d();
        }
        return d;
    }
}

package com.facebook.location.foreground;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.init.INeedInit;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationCache;
import com.facebook.location.FbLocationManagerParams.Priority;
import com.facebook.location.FbLocationOperation;
import com.facebook.location.FbLocationOperationParams;
import com.facebook.location.FbLocationOperationParams.Builder;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.foreground.GeoPixelController.1;
import com.facebook.location.foreground.GeoPixelController.2;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@VisibleForTesting
/* compiled from: is_rich_notif_collapsed */
public class ForegroundLocationController implements INeedInit {
    private static final Class<?> f9874a = ForegroundLocationController.class;
    public static final CallerContext f9875b = CallerContext.b(ForegroundLocationController.class, "foreground_location");
    public static final FbLocationOperationParams f9876c;
    private static volatile ForegroundLocationController f9877q;
    private final QeAccessor f9878d;
    private final AppStateManager f9879e;
    private final BaseFbBroadcastManager f9880f;
    private final Clock f9881g;
    public final TasksManager<Task> f9882h;
    private final FbSharedPreferences f9883i;
    public final FbLocationCache f9884j;
    public final Provider<FbLocationOperation> f9885k;
    public final DefaultBlueServiceOperationFactory f9886l;
    public final ForegroundLocationAnalyticsLogger f9887m;
    public final ForegroundLocationStatusBroadcaster f9888n;
    private final FbLocationStatusUtil f9889o;
    private final GeoPixelController f9890p;

    /* compiled from: is_rich_notif_collapsed */
    class C04481 implements ActionReceiver {
        final /* synthetic */ ForegroundLocationController f9919a;

        C04481(ForegroundLocationController foregroundLocationController) {
            this.f9919a = foregroundLocationController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 805859070);
            ForegroundLocationController.m10280c(this.f9919a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1441353878, a);
        }
    }

    @VisibleForTesting
    /* compiled from: is_rich_notif_collapsed */
    public enum Task {
        REQUEST_LOCATION,
        SEND_LOCATION
    }

    /* compiled from: is_rich_notif_collapsed */
    public class C04492 implements Callable<ListenableFuture<ImmutableLocation>> {
        final /* synthetic */ ForegroundLocationController f9922a;

        public C04492(ForegroundLocationController foregroundLocationController) {
            this.f9922a = foregroundLocationController;
        }

        public Object call() {
            FbLocationOperation fbLocationOperation = (FbLocationOperation) this.f9922a.f9885k.get();
            fbLocationOperation.a(ForegroundLocationController.f9876c, ForegroundLocationController.f9875b);
            return fbLocationOperation;
        }
    }

    /* compiled from: is_rich_notif_collapsed */
    public class C04503 extends AbstractDisposableFutureCallback<ImmutableLocation> {
        final /* synthetic */ ForegroundLocationController f9923a;

        public C04503(ForegroundLocationController foregroundLocationController) {
            this.f9923a = foregroundLocationController;
        }

        protected final void m10309a(Object obj) {
            ImmutableLocation immutableLocation = (ImmutableLocation) obj;
            ForegroundLocationController foregroundLocationController = this.f9923a;
            foregroundLocationController.f9882h.a(Task.SEND_LOCATION, new 4(foregroundLocationController, immutableLocation), new 5(foregroundLocationController));
            this.f9923a.f9888n.a();
            this.f9923a.f9887m.m10287b(immutableLocation);
        }

        protected final void m10310a(Throwable th) {
            this.f9923a.f9888n.c();
            this.f9923a.f9887m.m10286a(th);
        }
    }

    public static com.facebook.location.foreground.ForegroundLocationController m10278a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9877q;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.location.foreground.ForegroundLocationController.class;
        monitor-enter(r1);
        r0 = f9877q;	 Catch:{ all -> 0x003a }
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
        r0 = m10279b(r0);	 Catch:{ all -> 0x0035 }
        f9877q = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9877q;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.location.foreground.ForegroundLocationController.a(com.facebook.inject.InjectorLike):com.facebook.location.foreground.ForegroundLocationController");
    }

    private static ForegroundLocationController m10279b(InjectorLike injectorLike) {
        return new ForegroundLocationController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), AppStateManager.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), FbLocationCache.b(injectorLike), IdBasedProvider.a(injectorLike, 2481), DefaultBlueServiceOperationFactory.b(injectorLike), ForegroundLocationAnalyticsLogger.m10283a(injectorLike), ForegroundLocationStatusBroadcaster.a(injectorLike), FbLocationStatusUtil.a(injectorLike), GeoPixelController.m10288a(injectorLike));
    }

    static {
        Builder a = FbLocationOperationParams.a(Priority.BALANCED_POWER_AND_ACCURACY);
        a.b = 60000;
        f9876c = a.a();
    }

    @Inject
    public ForegroundLocationController(QeAccessor qeAccessor, AppStateManager appStateManager, FbBroadcastManager fbBroadcastManager, Clock clock, TasksManager tasksManager, FbSharedPreferences fbSharedPreferences, FbLocationCache fbLocationCache, Provider<FbLocationOperation> provider, BlueServiceOperationFactory blueServiceOperationFactory, ForegroundLocationAnalyticsLogger foregroundLocationAnalyticsLogger, ForegroundLocationStatusBroadcaster foregroundLocationStatusBroadcaster, FbLocationStatusUtil fbLocationStatusUtil, GeoPixelController geoPixelController) {
        this.f9878d = qeAccessor;
        this.f9879e = appStateManager;
        this.f9880f = fbBroadcastManager;
        this.f9881g = clock;
        this.f9882h = tasksManager;
        this.f9883i = fbSharedPreferences;
        this.f9884j = fbLocationCache;
        this.f9885k = provider;
        this.f9886l = blueServiceOperationFactory;
        this.f9887m = foregroundLocationAnalyticsLogger;
        this.f9888n = foregroundLocationStatusBroadcaster;
        this.f9889o = fbLocationStatusUtil;
        this.f9890p = geoPixelController;
    }

    public void init() {
        if (!this.f9878d.a(ExperimentsForForegroundLocationModule.c, false)) {
            this.f9880f.a().a(AppStateManager.b, new C04481(this)).a().b();
            if (this.f9879e.l()) {
                m10280c(this);
            }
        }
    }

    public static void m10280c(ForegroundLocationController foregroundLocationController) {
        if (foregroundLocationController.f9889o.b().a != State.OKAY) {
            foregroundLocationController.f9888n.c();
            return;
        }
        long a = foregroundLocationController.f9883i.a(ForegroundLocationPrefKeys.f9921b, 0);
        long a2 = foregroundLocationController.f9881g.a();
        if (a + 60000 <= a2) {
            ImmutableLocation a3 = foregroundLocationController.f9884j.a();
            if (a3 != null) {
                foregroundLocationController.f9887m.m10285a(a3);
            }
            foregroundLocationController.f9882h.a(Task.REQUEST_LOCATION, new C04492(foregroundLocationController), new C04503(foregroundLocationController));
            GeoPixelController geoPixelController = foregroundLocationController.f9890p;
            if (geoPixelController.f9903i.a(ExperimentsForForegroundLocationModule.n, false) && geoPixelController.f9901g.a("geopixel_rtt", false) && geoPixelController.f9907m.a() == State.OKAY && !((FbNetworkManager) geoPixelController.f9905k.get()).v()) {
                Futures.a(geoPixelController.f9908n.a(new 1(geoPixelController)), new 2(geoPixelController), geoPixelController.f9908n);
            }
            foregroundLocationController.f9883i.edit().a(ForegroundLocationPrefKeys.f9921b, a2).commit();
            return;
        }
        foregroundLocationController.f9888n.b();
    }
}

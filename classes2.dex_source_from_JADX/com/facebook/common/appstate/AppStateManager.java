package com.facebook.common.appstate;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossFbProcessBroadcast;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.common.activitylistener.AbstractFbActivityListener;
import com.facebook.common.appstate.configs.FloatingWindowTimeoutXConfig;
import com.facebook.common.appstate.dispatcher.AppStateChangeEventDispatcher;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.init.AppInitLock;
import com.facebook.common.init.AppInitLock.Listener;
import com.facebook.common.init.C0067xab9c254b;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.multiprocess.peer.PeerInfo;
import com.facebook.multiprocess.peer.PeerProcessManager;
import com.facebook.multiprocess.peer.PeerProcessManagerFactory;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.schema.Locators;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: video_logging_level */
public class AppStateManager implements INeedInit {
    public static final String f1109a = (AppStateManager.class.getCanonicalName() + ".USER_MAYBE_BECAME_ACTIVE_OR_INACTIVE_IN_APP");
    private static volatile AppStateManager ab;
    public static final String f1110b = (AppStateManager.class.getCanonicalName() + ".USER_ENTERED_APP");
    public static final String f1111c = (AppStateManager.class.getCanonicalName() + ".USER_LEFT_APP");
    public static final PrefKey f1112d;
    public static final PrefKey f1113e;
    public final IdleHandler f1114A = new C00703(this);
    public final IdleHandler f1115B = new C00714(this);
    public final IdleHandler f1116C = new C00725(this);
    private final Runnable f1117D = new C00736(this);
    private final Runnable f1118E = new C00747(this);
    private final Runnable f1119F = new C00758(this);
    @Nullable
    private PeerProcessManager f1120G;
    public ScheduledFuture f1121H;
    public ScheduledFuture f1122I;
    public volatile long f1123J;
    public volatile long f1124K;
    public volatile long f1125L;
    public volatile long f1126M;
    public volatile long f1127N;
    public volatile long f1128O;
    public volatile long f1129P;
    private volatile long f1130Q;
    private volatile long f1131R;
    public volatile boolean f1132S;
    public volatile boolean f1133T;
    public volatile boolean f1134U = false;
    public volatile boolean f1135V = false;
    public volatile long f1136W = Long.MIN_VALUE;
    @GuardedBy("this")
    public Map<PeerInfo, AppStateInfo> f1137X = Maps.m838c();
    @GuardedBy("this")
    private int f1138Y = 0;
    @GuardedBy("this")
    public int f1139Z = 0;
    public volatile AppStateInfo aa = new AppStateInfo();
    private final AppInitLock f1140f;
    private final FbSharedPreferences f1141g;
    private final Context f1142h;
    public final Provider<XConfigReader> f1143i;
    private final Provider<Set<INeedInit>> f1144j;
    @Inject
    public GatekeeperStoreImpl f1145k;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<AppStateChangeEventDispatcher> f1146l = UltralightRuntime.f368b;
    @Inject
    @Lazy
    @LocalBroadcast
    public com.facebook.inject.Lazy<FbBroadcastManager> f1147m = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AndroidThreadUtil> f1148n = UltralightRuntime.f368b;
    @Inject
    @Lazy
    @ForUiThread
    public com.facebook.inject.Lazy<ScheduledExecutorService> f1149o = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PeerProcessManagerFactory> f1150p = UltralightRuntime.f368b;
    @Inject
    @CrossFbProcessBroadcast
    @Lazy
    private com.facebook.inject.Lazy<FbBroadcastManager> f1151q = UltralightRuntime.f368b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<KeyguardManager> f1152r = UltralightRuntime.f368b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MonotonicClock> f1153s = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<PackageManager> f1154t = UltralightRuntime.f368b;
    @DefaultExecutorService
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ExecutorService> f1155u = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<QeAccessor> f1156v = UltralightRuntime.f368b;
    public final MyActivityListener f1157w = new MyActivityListener(this);
    public final FloatingWindowListener f1158x = new FloatingWindowListener(this);
    private final Runnable f1159y = new C00681(this);
    public final Runnable f1160z = new C00692(this);

    /* compiled from: video_logging_level */
    class C00681 implements Runnable {
        final /* synthetic */ AppStateManager f1166a;

        C00681(AppStateManager appStateManager) {
            this.f1166a = appStateManager;
        }

        public void run() {
            this.f1166a.f1121H = null;
            if (!this.f1166a.f1133T) {
                AppStateManager.m2238I(this.f1166a);
            }
        }
    }

    /* compiled from: video_logging_level */
    class C00692 implements Runnable {
        final /* synthetic */ AppStateManager f1167a;

        C00692(AppStateManager appStateManager) {
            this.f1167a = appStateManager;
        }

        public void run() {
            this.f1167a.f1122I = null;
            synchronized (this.f1167a) {
                if (this.f1167a.f1139Z > 0) {
                    this.f1167a.f1139Z = this.f1167a.f1139Z - 1;
                    Integer.valueOf(this.f1167a.f1139Z);
                }
                this.f1167a.f1133T = false;
                AppStateManager.m2253w(this.f1167a);
            }
            if (!this.f1167a.f1132S && this.f1167a.f1121H == null) {
                AppStateManager.m2238I(this.f1167a);
            }
        }
    }

    /* compiled from: video_logging_level */
    class C00703 implements IdleHandler {
        final /* synthetic */ AppStateManager f1168a;

        C00703(AppStateManager appStateManager) {
            this.f1168a = appStateManager;
        }

        public boolean queueIdle() {
            if (this.f1168a.f1145k.m2189a(9, true)) {
                ((BaseFbBroadcastManager) this.f1168a.f1147m.get()).m2955a(AppStateManager.f1110b);
            }
            ((AppStateChangeEventDispatcher) this.f1168a.f1146l.get()).mo2844a();
            return false;
        }
    }

    /* compiled from: video_logging_level */
    class C00714 implements IdleHandler {
        final /* synthetic */ AppStateManager f1169a;

        C00714(AppStateManager appStateManager) {
            this.f1169a = appStateManager;
        }

        public boolean queueIdle() {
            ((AppStateChangeEventDispatcher) this.f1169a.f1146l.get()).mo2845b();
            return false;
        }
    }

    /* compiled from: video_logging_level */
    class C00725 implements IdleHandler {
        final /* synthetic */ AppStateManager f1170a;

        C00725(AppStateManager appStateManager) {
            this.f1170a = appStateManager;
        }

        public boolean queueIdle() {
            this.f1170a.f1146l.get();
            return false;
        }
    }

    /* compiled from: video_logging_level */
    class C00736 implements Runnable {
        final /* synthetic */ AppStateManager f1171a;

        C00736(AppStateManager appStateManager) {
            this.f1171a = appStateManager;
        }

        public void run() {
            Looper.myQueue().addIdleHandler(this.f1171a.f1114A);
        }
    }

    /* compiled from: video_logging_level */
    class C00747 implements Runnable {
        final /* synthetic */ AppStateManager f1172a;

        C00747(AppStateManager appStateManager) {
            this.f1172a = appStateManager;
        }

        public void run() {
            Looper.myQueue().addIdleHandler(this.f1172a.f1115B);
        }
    }

    /* compiled from: video_logging_level */
    class C00758 implements Runnable {
        final /* synthetic */ AppStateManager f1173a;

        C00758(AppStateManager appStateManager) {
            this.f1173a = appStateManager;
        }

        public void run() {
            Looper.myQueue().addIdleHandler(this.f1173a.f1116C);
        }
    }

    /* compiled from: video_logging_level */
    public class AppStateInfo implements Parcelable {
        public static final Creator<AppStateInfo> CREATOR = new C00761();
        public boolean f1174a;
        public boolean f1175b;

        /* compiled from: video_logging_level */
        final class C00761 implements Creator<AppStateInfo> {
            C00761() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new AppStateInfo(parcel);
            }

            public final Object[] newArray(int i) {
                return new AppStateInfo[i];
            }
        }

        public AppStateInfo(AppStateInfo appStateInfo) {
            this.f1174a = appStateInfo.f1174a;
            this.f1175b = appStateInfo.f1175b;
        }

        public static void m2279a(AppStateInfo appStateInfo, AppStateInfo appStateInfo2) {
            appStateInfo.f1174a = appStateInfo2.f1174a;
            appStateInfo.f1175b = appStateInfo2.f1175b;
        }

        AppStateInfo(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            if (parcel.readByte() == (byte) 1) {
                z = true;
            } else {
                z = false;
            }
            this.f1174a = z;
            if (parcel.readByte() != (byte) 1) {
                z2 = false;
            }
            this.f1175b = z2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            if (this.f1174a) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
            if (!this.f1175b) {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
        }
    }

    /* compiled from: video_logging_level */
    public class MyActivityListener extends AbstractFbActivityListener {
        final /* synthetic */ AppStateManager f1176a;

        public MyActivityListener(AppStateManager appStateManager) {
            this.f1176a = appStateManager;
        }

        private static boolean m2280j(Activity activity) {
            return !(activity instanceof ManualUserInteractionTrackingActivity);
        }

        private static boolean m2281k(Activity activity) {
            if (activity instanceof ManualUserInteractionTrackingActivity) {
                return ((ManualUserInteractionTrackingActivity) activity).m13106a();
            }
            return true;
        }

        public final void mo263c(Activity activity) {
            if (m2280j(activity)) {
                AppStateManager.m2242M(this.f1176a);
                this.f1176a.f1132S = true;
                this.f1176a.f1127N = ((MonotonicClock) this.f1176a.f1153s.get()).now();
                AppStateManager.m2253w(this.f1176a);
            }
        }

        public final void mo242d(Activity activity) {
            if (m2280j(activity)) {
                AppStateManager.m2243N(this.f1176a);
                this.f1176a.f1126M = ((MonotonicClock) this.f1176a.f1153s.get()).now();
                this.f1176a.f1132S = false;
                AppStateManager.m2253w(this.f1176a);
            }
        }

        public final void mo259h(Activity activity) {
            if (m2281k(activity)) {
                AppStateManager.m2236G(this.f1176a);
            }
        }

        public final void mo249a(Activity activity, @Nullable Bundle bundle) {
            if (this.f1176a.f1125L == 0) {
                this.f1176a.f1125L = ((MonotonicClock) this.f1176a.f1153s.get()).now();
            }
        }
    }

    /* compiled from: video_logging_level */
    public class FloatingWindowListener {
        public final /* synthetic */ AppStateManager f1177a;

        public FloatingWindowListener(AppStateManager appStateManager) {
            this.f1177a = appStateManager;
        }
    }

    /* compiled from: video_logging_level */
    class C00779 implements Runnable {
        final /* synthetic */ AppStateManager f1178a;

        C00779(AppStateManager appStateManager) {
            this.f1178a = appStateManager;
        }

        public void run() {
            AppStateManager.m2231A(this.f1178a);
        }
    }

    public static com.facebook.common.appstate.AppStateManager m2245a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = ab;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.appstate.AppStateManager.class;
        monitor-enter(r1);
        r0 = ab;	 Catch:{ all -> 0x003a }
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
        r0 = m2249b(r0);	 Catch:{ all -> 0x0035 }
        ab = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = ab;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.appstate.AppStateManager.a(com.facebook.inject.InjectorLike):com.facebook.common.appstate.AppStateManager");
    }

    private static AppStateManager m2249b(InjectorLike injectorLike) {
        AppStateManager appStateManager = new AppStateManager(AppInitLock.m2271a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), (Context) injectorLike.getInstance(Context.class), new C0067xab9c254b(injectorLike.getScopeAwareInjector()), IdBasedSingletonScopeProvider.m1809a(injectorLike, 3749));
        appStateManager.m2247a(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), IdBasedLazy.m1808a(injectorLike, 479), IdBasedLazy.m1808a(injectorLike, 401), IdBasedLazy.m1808a(injectorLike, 517), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3863), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2767), IdBasedLazy.m1808a(injectorLike, 393), IdBasedLazy.m1808a(injectorLike, 5), IdBasedSingletonScopeProvider.m1810b(injectorLike, 601), IdBasedSingletonScopeProvider.m1810b(injectorLike, 28), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3834), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3219));
        return appStateManager;
    }

    private void m2247a(GatekeeperStore gatekeeperStore, com.facebook.inject.Lazy<AppStateChangeEventDispatcher> lazy, com.facebook.inject.Lazy<FbBroadcastManager> lazy2, com.facebook.inject.Lazy<AndroidThreadUtil> lazy3, com.facebook.inject.Lazy<ScheduledExecutorService> lazy4, com.facebook.inject.Lazy<PeerProcessManagerFactory> lazy5, com.facebook.inject.Lazy<FbBroadcastManager> lazy6, com.facebook.inject.Lazy<KeyguardManager> lazy7, com.facebook.inject.Lazy<MonotonicClock> lazy8, com.facebook.inject.Lazy<PackageManager> lazy9, com.facebook.inject.Lazy<ExecutorService> lazy10, com.facebook.inject.Lazy<QeAccessor> lazy11) {
        this.f1145k = gatekeeperStore;
        this.f1146l = lazy;
        this.f1147m = lazy2;
        this.f1148n = lazy3;
        this.f1149o = lazy4;
        this.f1150p = lazy5;
        this.f1151q = lazy6;
        this.f1152r = lazy7;
        this.f1153s = lazy8;
        this.f1154t = lazy9;
        this.f1155u = lazy10;
        this.f1156v = lazy11;
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f989c.m2011a("app_state/");
        f1112d = prefKey;
        f1113e = (PrefKey) prefKey.m2011a("last_first_run_time");
    }

    @Inject
    public AppStateManager(AppInitLock appInitLock, FbSharedPreferences fbSharedPreferences, Context context, Provider<Set<INeedInit>> provider, Provider<XConfigReader> provider2) {
        this.f1140f = appInitLock;
        this.f1141g = fbSharedPreferences;
        this.f1142h = context;
        this.f1144j = provider;
        this.f1143i = provider2;
    }

    public static PeerProcessManager m2252v(AppStateManager appStateManager) {
        if (appStateManager.f1120G == null) {
            synchronized (appStateManager) {
                if (appStateManager.f1120G == null) {
                    appStateManager.f1120G = ((PeerProcessManagerFactory) appStateManager.f1150p.get()).m4836a("com.facebook.common.appstate.peers", (BaseFbBroadcastManager) appStateManager.f1151q.get(), false);
                }
            }
        }
        return appStateManager.f1120G;
    }

    public final void m2255a(long j) {
        TracerDetour.a("AppStateManager.notifyApplicationOnCreateComplete", -1344909247);
        try {
            this.f1123J = j;
            this.f1141g.mo280a(new C00779(this));
            this.f1140f.m2276a(new Listener(this) {
                final /* synthetic */ AppStateManager f1179a;

                {
                    this.f1179a = r1;
                }

                public final void mo334a() {
                    this.f1179a.f1124K = ((MonotonicClock) this.f1179a.f1153s.get()).now();
                }
            });
        } finally {
            TracerDetour.a(-1459104595);
        }
    }

    public void init() {
        INeedInit v = m2252v(this);
        v.mo686a(new AppStatePeerProcessStatusListener(this));
        v.mo683a(10000, new AppStatePeerProcessMessageListener(this));
        v.init();
        m2253w(this);
    }

    public static Message m2254x(AppStateManager appStateManager) {
        Message obtain = Message.obtain(null, 10000);
        Bundle bundle = new Bundle();
        bundle.putParcelable("app_state_info", new AppStateInfo(appStateManager.aa));
        obtain.setData(bundle);
        return obtain;
    }

    public static void m2253w(AppStateManager appStateManager) {
        appStateManager.aa.f1174a = appStateManager.f1132S;
        appStateManager.aa.f1175b = appStateManager.f1133T;
        m2252v(appStateManager).mo684a(m2254x(appStateManager));
    }

    @TargetApi(9)
    public static void m2231A(AppStateManager appStateManager) {
        long a = appStateManager.f1141g.mo277a(f1113e, 0);
        try {
            PackageInfo packageInfo = ((PackageManager) appStateManager.f1154t.get()).getPackageInfo(appStateManager.f1142h.getPackageName(), 0);
            long max = Math.max(packageInfo.firstInstallTime, packageInfo.lastUpdateTime);
            appStateManager.f1136W = Math.max(max, a);
            if (max > a) {
                boolean z;
                appStateManager.f1134U = max == packageInfo.firstInstallTime;
                if (max == packageInfo.lastUpdateTime) {
                    z = true;
                } else {
                    z = false;
                }
                appStateManager.f1135V = z;
                appStateManager.f1141g.edit().mo1275a(f1113e, max).commit();
                if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                    appStateManager.m2244O();
                }
            }
        } catch (Throwable e) {
            BLog.a("AppStateManager", e, "Can't find our own package name : %s", new Object[]{r3});
        } catch (Throwable e2) {
            if (e2.getCause() instanceof DeadObjectException) {
                BLog.a("AppStateManager", e2, "PackageManager connection lost", new Object[0]);
                return;
            }
            throw e2;
        }
    }

    public final long m2257c() {
        return ((MonotonicClock) this.f1153s.get()).now() - this.f1123J;
    }

    public final long m2258d() {
        return ((MonotonicClock) this.f1153s.get()).now() - this.f1124K;
    }

    public final long m2259e() {
        return ((MonotonicClock) this.f1153s.get()).now() - this.f1131R;
    }

    public final boolean m2260h() {
        return this.f1124K > 0;
    }

    public final boolean m2261i() {
        if (((QeAccessor) this.f1156v.get()).mo596a(ExperimentsForAppStateModule.f7628b, false)) {
            return !m2266o();
        } else {
            if (((QeAccessor) this.f1156v.get()).mo596a(ExperimentsForAppStateModule.f7627a, false)) {
                return !m2266o() && m2268q() > 5000;
            } else {
                return m2262j();
            }
        }
    }

    public final boolean m2262j() {
        return !m2266o() && m2257c() > Locators.qU && m2268q() > 5000;
    }

    public final TriState m2263k() {
        if (this.f1124K == 0) {
            return TriState.UNSET;
        }
        if (this.f1125L != 0) {
            return this.f1125L - this.f1124K > Locators.qU ? TriState.YES : TriState.NO;
        } else {
            if (m2258d() > Locators.qU) {
                return TriState.YES;
            }
            return TriState.UNSET;
        }
    }

    public final boolean m2264l() {
        return (m2266o() && !((KeyguardManager) this.f1152r.get()).inKeyguardRestrictedInputMode()) || (!m2266o() && m2257c() < Locators.qU);
    }

    public final boolean m2256b(long j) {
        if (m2257c() >= Locators.qU && m2267p() > j) {
            return false;
        }
        return true;
    }

    public final boolean m2265m() {
        return this.f1127N > 0 || this.f1128O > 0;
    }

    public final synchronized boolean m2266o() {
        boolean z;
        z = this.f1139Z > 0 || this.f1138Y > 0;
        return z;
    }

    public final long m2267p() {
        return ((MonotonicClock) this.f1153s.get()).now() - this.f1130Q;
    }

    public final long m2268q() {
        return Math.min(((MonotonicClock) this.f1153s.get()).now() - this.f1126M, ((MonotonicClock) this.f1153s.get()).now() - this.f1129P);
    }

    private void m2232C() {
        this.f1121H = ((ScheduledExecutorService) this.f1149o.get()).schedule(this.f1159y, 5000, TimeUnit.MILLISECONDS);
        m2239J();
    }

    private void m2233D() {
        if (this.f1121H == null && !m2266o()) {
            m2237H();
            this.f1131R = ((MonotonicClock) this.f1153s.get()).now();
        } else if (this.f1121H != null) {
            this.f1121H.cancel(false);
            this.f1121H = null;
        }
        m2239J();
    }

    private void m2234E() {
        if (this.f1121H == null && !m2266o()) {
            m2237H();
            this.f1131R = ((MonotonicClock) this.f1153s.get()).now();
        } else if (this.f1121H != null) {
            this.f1121H.cancel(false);
            this.f1121H = null;
        }
        if (this.f1122I != null) {
            this.f1122I.cancel(false);
            this.f1122I = null;
        }
        if (!((XConfigReader) this.f1143i.get()).m2686a(FloatingWindowTimeoutXConfig.e, false)) {
            this.f1122I = ((ScheduledExecutorService) this.f1149o.get()).schedule(this.f1160z, ((XConfigReader) this.f1143i.get()).m2684a(FloatingWindowTimeoutXConfig.d, 300), TimeUnit.SECONDS);
        }
        m2239J();
    }

    private void m2235F() {
        if (this.f1122I != null) {
            this.f1122I.cancel(false);
            this.f1122I = null;
        }
        if (!this.f1132S && this.f1133T) {
            this.f1121H = ((ScheduledExecutorService) this.f1149o.get()).schedule(this.f1159y, 5000, TimeUnit.MILLISECONDS);
        }
        m2239J();
    }

    public static void m2236G(AppStateManager appStateManager) {
        ((DefaultAndroidThreadUtil) appStateManager.f1148n.get()).m1649a();
        appStateManager.f1130Q = ((MonotonicClock) appStateManager.f1153s.get()).now();
        appStateManager.m2239J();
    }

    private void m2237H() {
        if (!this.f1145k.m2189a(9, true)) {
            ((BaseFbBroadcastManager) this.f1147m.get()).m2955a(f1110b);
        }
        ((DefaultAndroidThreadUtil) this.f1148n.get()).m1652a(this.f1117D);
    }

    public static void m2238I(AppStateManager appStateManager) {
        ((BaseFbBroadcastManager) appStateManager.f1147m.get()).m2955a(f1111c);
        ((DefaultAndroidThreadUtil) appStateManager.f1148n.get()).m1652a(appStateManager.f1118E);
    }

    private void m2239J() {
        ((BaseFbBroadcastManager) this.f1147m.get()).m2955a(f1109a);
        ((DefaultAndroidThreadUtil) this.f1148n.get()).m1652a(this.f1119F);
    }

    public static synchronized void m2240K(AppStateManager appStateManager) {
        synchronized (appStateManager) {
            appStateManager.m2234E();
            appStateManager.f1139Z++;
            Integer.valueOf(appStateManager.f1139Z);
            Integer.valueOf(appStateManager.f1138Y);
        }
    }

    public static synchronized void m2241L(AppStateManager appStateManager) {
        synchronized (appStateManager) {
            appStateManager.m2235F();
            if (appStateManager.f1139Z > 0) {
                appStateManager.f1139Z--;
                Integer.valueOf(appStateManager.f1139Z);
                Integer.valueOf(appStateManager.f1138Y);
            }
        }
    }

    public static synchronized void m2242M(AppStateManager appStateManager) {
        synchronized (appStateManager) {
            appStateManager.m2233D();
            appStateManager.f1138Y++;
            Integer.valueOf(appStateManager.f1139Z);
            Integer.valueOf(appStateManager.f1138Y);
        }
    }

    public static synchronized void m2243N(AppStateManager appStateManager) {
        synchronized (appStateManager) {
            appStateManager.m2232C();
            if (appStateManager.f1138Y > 0) {
                appStateManager.f1138Y--;
                Integer.valueOf(appStateManager.f1139Z);
                Integer.valueOf(appStateManager.f1138Y);
            }
        }
    }

    public static synchronized void m2246a(AppStateManager appStateManager, AppStateInfo appStateInfo, AppStateInfo appStateInfo2) {
        synchronized (appStateManager) {
            if (appStateInfo.f1174a != appStateInfo2.f1174a) {
                if (appStateInfo.f1174a) {
                    m2242M(appStateManager);
                } else {
                    m2243N(appStateManager);
                }
            }
            if (appStateInfo.f1175b != appStateInfo2.f1175b) {
                if (appStateInfo.f1175b) {
                    m2240K(appStateManager);
                } else {
                    m2241L(appStateManager);
                }
            }
            AppStateInfo.m2279a(appStateInfo2, appStateInfo);
        }
    }

    private void m2244O() {
        if (this.f1144j != null) {
            Set<INeedInit> set = (Set) this.f1144j.get();
            if (set != null) {
                for (INeedInit 11 : set) {
                    ExecutorDetour.a((ExecutorService) this.f1155u.get(), new 11(this, 11), -1166179803);
                }
            }
        }
    }

    public final synchronized int m2269t() {
        return this.f1139Z;
    }

    public final synchronized int m2270u() {
        return this.f1138Y;
    }
}

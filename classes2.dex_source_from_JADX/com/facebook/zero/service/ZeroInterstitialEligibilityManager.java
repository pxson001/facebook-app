package com.facebook.zero.service;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.common.time.Clock;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.dialtone.common.AbstractDialtoneStateChangedListener;
import com.facebook.dialtone.common.IsDialtoneEnabled;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.iorg.common.zero.interfaces.ZeroFeatureVisibilityHelper;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.annotations.IsInZeroInterstitialGatekeeper;
import com.facebook.zero.common.constants.DialtonePrefKeys;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.protocol.graphql.ZeroOptinGraphQL.FetchZeroOptinQueryString;
import com.facebook.zero.protocol.graphql.ZeroOptinGraphQLModels.FetchZeroOptinQueryModel;
import com.facebook.zero.protocol.graphql.ZeroOptinGraphQLModels.ZeroDefaultOptinFieldsModel;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.sdk.request.FetchZeroInterstitialEligibilityParams;
import com.facebook.zero.sdk.request.FetchZeroInterstitialEligibilityResult;
import com.facebook.zero.sdk.request.ZeroRequestHandler;
import com.facebook.zero.sdk.util.CarrierAndSimMccMnc;
import com.facebook.zero.sdk.util.StringListDataSerializer;
import com.facebook.zero.sdk.util.ZeroNetworkAndTelephonyHelper;
import com.facebook.zero.util.ZeroDefaultOptinStore;
import com.facebook.zero.util.ZeroDefaultOptinStore.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_bytes_received_foreground */
public class ZeroInterstitialEligibilityManager extends AbstractDialtoneStateChangedListener implements IHavePrivacyCriticalKeysToClear {
    private static final Class<?> f15587a = ZeroInterstitialEligibilityManager.class;
    private static volatile ZeroInterstitialEligibilityManager f15588u;
    private final Lazy<Clock> f15589b;
    private final Lazy<FbErrorReporter> f15590c;
    private final Lazy<ZeroNetworkAndTelephonyHelper> f15591d;
    @IsInZeroInterstitialGatekeeper
    public final Provider<Boolean> f15592e;
    private final Lazy<AppStateManager> f15593f;
    private final FbSharedPreferences f15594g;
    private final Lazy<ZeroRequestHandler> f15595h;
    public final FbZeroFeatureVisibilityHelper f15596i;
    @IsDialtoneEnabled
    public final Provider<Boolean> f15597j;
    private final GraphQLQueryExecutor f15598k;
    private final Lazy<ExecutorService> f15599l;
    private final Resources f15600m;
    private final GatekeeperStoreImpl f15601n;
    private final StringListDataSerializer f15602o;
    private final UriIntentMapper f15603p;
    private final SecureContextHelper f15604q;
    private final Context f15605r;
    private ListenableFuture<GraphQLResult<FetchZeroOptinQueryModel>> f15606s;
    private ListenableFuture<?> f15607t;

    @Singleton
    /* compiled from: total_bytes_received_foreground */
    public class LocalZeroInterstitialEligibilityManagerReceiverRegistration extends INeedInitForBroadcastReceiverRegistration<ZeroInterstitialEligibilityManager> {
        private static volatile LocalZeroInterstitialEligibilityManagerReceiverRegistration f2380a;

        public static com.facebook.zero.service.ZeroInterstitialEligibilityManager.LocalZeroInterstitialEligibilityManagerReceiverRegistration m4546a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f2380a;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.zero.service.ZeroInterstitialEligibilityManager.LocalZeroInterstitialEligibilityManagerReceiverRegistration.class;
            monitor-enter(r1);
            r0 = f2380a;	 Catch:{ all -> 0x003a }
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
            r0 = m4547b(r0);	 Catch:{ all -> 0x0035 }
            f2380a = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2380a;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.service.ZeroInterstitialEligibilityManager.LocalZeroInterstitialEligibilityManagerReceiverRegistration.a(com.facebook.inject.InjectorLike):com.facebook.zero.service.ZeroInterstitialEligibilityManager$LocalZeroInterstitialEligibilityManagerReceiverRegistration");
        }

        private static LocalZeroInterstitialEligibilityManagerReceiverRegistration m4547b(InjectorLike injectorLike) {
            return new LocalZeroInterstitialEligibilityManagerReceiverRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3816), Handler_BackgroundBroadcastThreadMethodAutoProvider.m4110a(injectorLike));
        }

        protected void onReceive(Context context, Intent intent, Object obj) {
            ZeroInterstitialEligibilityManager zeroInterstitialEligibilityManager = (ZeroInterstitialEligibilityManager) obj;
            String action = intent.getAction();
            if ("com.facebook.zero.ZERO_HEADER_REFRESH_COMPLETED".equals(action) || "com.facebook.zero.ACTION_ZERO_INTERSTITIAL_REFRESH".equals(action) || AppStateManager.f1110b.equals(action) || "com.facebook.growth.constants.nux_completed".equals(action) || "com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE".equals(action)) {
                zeroInterstitialEligibilityManager.m22227c();
            }
        }

        @Inject
        public LocalZeroInterstitialEligibilityManagerReceiverRegistration(Lazy<ZeroInterstitialEligibilityManager> lazy, Handler handler) {
            super(FbBroadcastManagerType.LOCAL, (Lazy) lazy, handler, AppStateManager.f1110b, "com.facebook.zero.ZERO_HEADER_REFRESH_COMPLETED", "com.facebook.zero.ACTION_ZERO_INTERSTITIAL_REFRESH", "com.facebook.growth.constants.nux_completed", "com.facebook.orca.login.AuthStateMachineMonitor.LOGIN_COMPLETE");
        }
    }

    public static com.facebook.zero.service.ZeroInterstitialEligibilityManager m22219a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15588u;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.service.ZeroInterstitialEligibilityManager.class;
        monitor-enter(r1);
        r0 = f15588u;	 Catch:{ all -> 0x003a }
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
        r0 = m22221b(r0);	 Catch:{ all -> 0x0035 }
        f15588u = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15588u;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.service.ZeroInterstitialEligibilityManager.a(com.facebook.inject.InjectorLike):com.facebook.zero.service.ZeroInterstitialEligibilityManager");
    }

    private static ZeroInterstitialEligibilityManager m22221b(InjectorLike injectorLike) {
        return new ZeroInterstitialEligibilityManager(IdBasedSingletonScopeProvider.m1810b(injectorLike, 609), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), IdBasedLazy.m1808a(injectorLike, 3799), IdBasedProvider.m1811a(injectorLike, 4387), IdBasedSingletonScopeProvider.m1810b(injectorLike, 476), FbSharedPreferencesImpl.m1826a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3804), FbZeroFeatureVisibilityHelper.m7916a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3954), GraphQLQueryExecutor.m10435a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3863), ResourcesMethodAutoProvider.m6510a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), StringListDataSerializer.m8057a(injectorLike), (Context) injectorLike.getInstance(Context.class), Fb4aUriIntentMapper.m8640a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike));
    }

    @Inject
    public ZeroInterstitialEligibilityManager(Lazy<Clock> lazy, Lazy<FbErrorReporter> lazy2, Lazy<ZeroNetworkAndTelephonyHelper> lazy3, Provider<Boolean> provider, Lazy<AppStateManager> lazy4, FbSharedPreferences fbSharedPreferences, Lazy<ZeroRequestHandler> lazy5, ZeroFeatureVisibilityHelper zeroFeatureVisibilityHelper, Provider<Boolean> provider2, GraphQLQueryExecutor graphQLQueryExecutor, Lazy<ExecutorService> lazy6, Resources resources, GatekeeperStore gatekeeperStore, StringListDataSerializer stringListDataSerializer, Context context, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper) {
        this.f15589b = lazy;
        this.f15590c = lazy2;
        this.f15591d = lazy3;
        this.f15592e = provider;
        this.f15593f = lazy4;
        this.f15594g = fbSharedPreferences;
        this.f15595h = lazy5;
        this.f15596i = zeroFeatureVisibilityHelper;
        this.f15597j = provider2;
        this.f15598k = graphQLQueryExecutor;
        this.f15599l = lazy6;
        this.f15600m = resources;
        this.f15601n = gatekeeperStore;
        this.f15602o = stringListDataSerializer;
        this.f15605r = context;
        this.f15603p = uriIntentMapper;
        this.f15604q = secureContextHelper;
    }

    final void m22227c() {
        boolean booleanValue = !((Boolean) this.f15592e.get()).booleanValue() ? false : this.f15596i.m7924a(ZeroFeatureKey.DIALTONE_OPTIN) ? ((Boolean) this.f15597j.get()).booleanValue() : this.f15596i.m7924a(ZeroFeatureKey.OPTIN_GROUP_INTERSTITIAL) || this.f15596i.m7924a(ZeroFeatureKey.ZERO_RATED_INTERSTITIAL);
        if (booleanValue) {
            if (this.f15594g.mo286a(DialtonePrefKeys.f2495r, false)) {
                this.f15594g.edit().putBoolean(DialtonePrefKeys.f2495r, false).commit();
            }
            m22223f();
            if (this.f15601n.m2185a(510) == TriState.YES) {
                CarrierAndSimMccMnc a = ((ZeroNetworkAndTelephonyHelper) this.f15591d.get()).m22188a();
                this.f15606s = this.f15598k.m10446a(GraphQLRequest.m11587a((FetchZeroOptinQueryString) new FetchZeroOptinQueryString().m11315a("screen_scale", SizeUtil.m19194a(this.f15600m)).m11315a("carrier_mcc", a.f23518b.f23520a).m11315a("carrier_mnc", a.f23518b.f23521b).m11315a("sim_mcc", a.f23519c.f23520a).m11315a("sim_mnc", a.f23519c.f23521b).m11315a("interface", ((ZeroNetworkAndTelephonyHelper) this.f15591d.get()).m22189b())));
                Futures.m2458a(this.f15606s, new 1(this), (Executor) this.f15599l.get());
                return;
            }
            this.f15607t = ((ZeroRequestHandler) this.f15595h.get()).mo3442a(new FetchZeroInterstitialEligibilityParams(((ZeroNetworkAndTelephonyHelper) this.f15591d.get()).m22188a(), ((ZeroNetworkAndTelephonyHelper) this.f15591d.get()).m22189b()), new 2(this));
        }
    }

    public final void m22225a(FetchZeroInterstitialEligibilityResult fetchZeroInterstitialEligibilityResult) {
        this.f15594g.edit().mo1276a(ZeroPrefKeys.f2650y, fetchZeroInterstitialEligibilityResult.a()).mo1274a(ZeroPrefKeys.f2651z, fetchZeroInterstitialEligibilityResult.b()).mo1274a(ZeroPrefKeys.f2600A, fetchZeroInterstitialEligibilityResult.c()).commit();
        m22222e();
    }

    public final void m22224a(GraphQLResult<FetchZeroOptinQueryModel> graphQLResult) {
        ZeroDefaultOptinFieldsModel a = ((FetchZeroOptinQueryModel) graphQLResult.f6203e).a();
        if (a == null) {
            ZeroDefaultOptinStore.a(this.f15594g);
            return;
        }
        Builder builder = new Builder(this.f15594g, this.f15602o);
        builder.a = a.a();
        builder = builder;
        builder.b = a.r();
        builder = builder;
        builder.c = a.F();
        builder = builder;
        builder.d = a.m();
        builder = builder;
        builder.e = a.E();
        builder = builder;
        builder.f = a.C();
        builder = builder;
        builder.g = a.n();
        builder = builder;
        builder.h = a.q();
        builder = builder;
        builder.i = a.B();
        builder = builder;
        builder.j = a.p();
        builder = builder;
        builder.k = a.o();
        builder = builder;
        builder.l = a.D();
        builder = builder;
        builder.m = a.k();
        builder = builder;
        builder.n = a.l();
        builder = builder;
        builder.o = a.v();
        builder = builder;
        builder.p = a.t();
        builder = builder;
        builder.q = a.u();
        builder = builder;
        builder.r = a.s();
        builder = builder;
        builder.s = a.A();
        builder = builder;
        builder.t = a.x();
        builder = builder;
        builder.u = a.z();
        builder = builder;
        builder.v = a.w();
        builder = builder;
        builder.w = a.y();
        builder = builder;
        builder.x = a.j();
        builder.a().a();
        m22222e();
    }

    public static void m22220a(ZeroInterstitialEligibilityManager zeroInterstitialEligibilityManager, Throwable th) {
        th.getMessage();
        ((AbstractFbErrorReporter) zeroInterstitialEligibilityManager.f15590c.get()).m2343a("zero_rating", "Error fetching zero interstitial request", th);
    }

    private void m22222e() {
        String a = this.f15594g.mo278a(ZeroPrefKeys.f2650y, "");
        long a2 = this.f15594g.mo277a(ZeroPrefKeys.f2621V, 0);
        int a3 = this.f15594g.mo276a(ZeroPrefKeys.f2600A, 0);
        if (!StringUtil.m3599c((CharSequence) a) && ((AppStateManager) this.f15593f.get()).m2264l() && !((ZeroNetworkAndTelephonyHelper) this.f15591d.get()).m22189b().equals("none") && a2 + ((long) a3) < ((Clock) this.f15589b.get()).mo211a()) {
            this.f15594g.edit().mo1275a(ZeroPrefKeys.f2621V, ((Clock) this.f15589b.get()).mo211a()).commit();
            Intent a4 = this.f15603p.mo1267a(this.f15605r, a);
            if (a4 != null) {
                this.f15604q.mo662a(a4, this.f15605r);
            }
        }
    }

    private void m22223f() {
        if (this.f15606s != null) {
            this.f15606s.cancel(true);
        }
        if (this.f15607t != null) {
            this.f15607t.cancel(true);
        }
    }

    public final ImmutableSet<PrefKey> mo671b() {
        m22223f();
        return RegularImmutableSet.f688a;
    }

    public final void b_(boolean z) {
        m22227c();
    }
}

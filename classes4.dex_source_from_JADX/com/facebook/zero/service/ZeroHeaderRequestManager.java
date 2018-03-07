package com.facebook.zero.service;

import android.os.Bundle;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.zero.sdk.annotations.IsZeroHeaderRequestFeatureEnabled;
import com.facebook.zero.sdk.util.ZeroNetworkAndTelephonyHelper;
import com.facebook.zero.server.FetchZeroHeaderRequestParams;
import com.facebook.zero.server.FetchZeroHeaderRequestResult;
import com.facebook.zero.server.SendZeroHeaderRequestParams;
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
/* compiled from: sms_internal_force_nux */
public class ZeroHeaderRequestManager implements IHavePrivacyCriticalKeysToClear {
    public static final Class<?> f2094a = ZeroHeaderRequestManager.class;
    private static final CallerContext f2095b = CallerContext.a(ZeroHeaderRequestManager.class);
    private static volatile ZeroHeaderRequestManager f2096k;
    private final Lazy<BlueServiceOperationFactory> f2097c;
    public final Lazy<AnalyticsLogger> f2098d;
    private final Lazy<ZeroNetworkAndTelephonyHelper> f2099e;
    @IsZeroHeaderRequestFeatureEnabled
    private final Provider<TriState> f2100f;
    @LocalBroadcast
    public final Lazy<FbBroadcastManager> f2101g;
    @DefaultExecutorService
    private final Lazy<ExecutorService> f2102h;
    public final FbSharedPreferences f2103i;
    private ListenableFuture<OperationResult> f2104j;

    public static com.facebook.zero.service.ZeroHeaderRequestManager m2190a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2096k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.service.ZeroHeaderRequestManager.class;
        monitor-enter(r1);
        r0 = f2096k;	 Catch:{ all -> 0x003a }
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
        r0 = m2191b(r0);	 Catch:{ all -> 0x0035 }
        f2096k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2096k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.service.ZeroHeaderRequestManager.a(com.facebook.inject.InjectorLike):com.facebook.zero.service.ZeroHeaderRequestManager");
    }

    private static ZeroHeaderRequestManager m2191b(InjectorLike injectorLike) {
        return new ZeroHeaderRequestManager(IdBasedLazy.a(injectorLike, 1144), IdBasedSingletonScopeProvider.b(injectorLike, 175), IdBasedLazy.a(injectorLike, 3799), IdBasedProvider.a(injectorLike, 817), IdBasedLazy.a(injectorLike, 401), IdBasedSingletonScopeProvider.b(injectorLike, 3834), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public ZeroHeaderRequestManager(Lazy<BlueServiceOperationFactory> lazy, Lazy<AnalyticsLogger> lazy2, Lazy<ZeroNetworkAndTelephonyHelper> lazy3, Provider<TriState> provider, Lazy<FbBroadcastManager> lazy4, Lazy<ExecutorService> lazy5, FbSharedPreferences fbSharedPreferences) {
        this.f2097c = lazy;
        this.f2098d = lazy2;
        this.f2099e = lazy3;
        this.f2100f = provider;
        this.f2101g = lazy4;
        this.f2102h = lazy5;
        this.f2103i = fbSharedPreferences;
    }

    public final ListenableFuture<OperationResult> m2196a(boolean z) {
        if (!((TriState) this.f2100f.get()).asBoolean(false)) {
            return Futures.a(OperationResult.a(ErrorCode.OTHER, "Zero header request not sent because header request feature is not enabled"));
        }
        m2195c();
        this.f2104j = m2193b(z);
        Futures.a(this.f2104j, new 1(this), (Executor) this.f2102h.get());
        return Futures.b(this.f2104j, new 2(this), (Executor) this.f2102h.get());
    }

    public static ListenableFuture m2192b(ZeroHeaderRequestManager zeroHeaderRequestManager, FetchZeroHeaderRequestResult fetchZeroHeaderRequestResult) {
        ListenableFuture c = zeroHeaderRequestManager.m2194c(fetchZeroHeaderRequestResult);
        Futures.a(c, new 3(zeroHeaderRequestManager), (Executor) zeroHeaderRequestManager.f2102h.get());
        return c;
    }

    private ListenableFuture<OperationResult> m2193b(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchZeroHeaderRequestParams", new FetchZeroHeaderRequestParams(((ZeroNetworkAndTelephonyHelper) this.f2099e.get()).a(), ((ZeroNetworkAndTelephonyHelper) this.f2099e.get()).b(), this.f2103i.a(AuthPrefKeys.f, ""), z));
        return m2189a("fetch_zero_header_request", bundle);
    }

    private ListenableFuture<OperationResult> m2194c(FetchZeroHeaderRequestResult fetchZeroHeaderRequestResult) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("sendZeroHeaderRequestParams", new SendZeroHeaderRequestParams(fetchZeroHeaderRequestResult.m2303b(), fetchZeroHeaderRequestResult.m2304c(), fetchZeroHeaderRequestResult.m2305d(), fetchZeroHeaderRequestResult.m2306e()));
        return m2189a("send_zero_header_request", bundle);
    }

    private OperationFuture m2189a(String str, Bundle bundle) {
        OperationFuture a = BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f2097c.get(), str, bundle, ErrorPropagation.BY_EXCEPTION, f2095b, 919205220).a();
        a.a(RequestPriority.NON_INTERACTIVE);
        return a;
    }

    private void m2195c() {
        if (this.f2104j != null) {
            this.f2104j.cancel(true);
        }
    }

    public final ImmutableSet<PrefKey> m2197b() {
        m2195c();
        return RegularImmutableSet.a;
    }
}

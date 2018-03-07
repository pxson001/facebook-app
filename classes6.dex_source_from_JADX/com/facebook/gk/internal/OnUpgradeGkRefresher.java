package com.facebook.gk.internal;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.config.background.impl.ConfigPrefKeys;
import com.facebook.debug.log.BLog;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.BatchComponentRunner;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: mSrcUrlSmall */
public class OnUpgradeGkRefresher implements INeedInit {
    private static final Class f10881f = OnUpgradeGkRefresher.class;
    private static volatile OnUpgradeGkRefresher f10882g;
    private final Provider<String> f10883a;
    private final Lazy<FbSharedPreferences> f10884b;
    private final Lazy<Clock> f10885c;
    private final Lazy<BatchComponentRunner> f10886d;
    private final Lazy<GkConfigurationComponent> f10887e;

    public static com.facebook.gk.internal.OnUpgradeGkRefresher m17443a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10882g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.gk.internal.OnUpgradeGkRefresher.class;
        monitor-enter(r1);
        r0 = f10882g;	 Catch:{ all -> 0x003a }
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
        r0 = m17445b(r0);	 Catch:{ all -> 0x0035 }
        f10882g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10882g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gk.internal.OnUpgradeGkRefresher.a(com.facebook.inject.InjectorLike):com.facebook.gk.internal.OnUpgradeGkRefresher");
    }

    private static OnUpgradeGkRefresher m17445b(InjectorLike injectorLike) {
        return new OnUpgradeGkRefresher(IdBasedProvider.a(injectorLike, 4442), IdBasedSingletonScopeProvider.b(injectorLike, 3078), IdBasedSingletonScopeProvider.b(injectorLike, 609), IdBasedSingletonScopeProvider.b(injectorLike, 2283), IdBasedSingletonScopeProvider.b(injectorLike, 2112));
    }

    @Inject
    public OnUpgradeGkRefresher(Provider<String> provider, Lazy<FbSharedPreferences> lazy, Lazy<Clock> lazy2, Lazy<BatchComponentRunner> lazy3, Lazy<GkConfigurationComponent> lazy4) {
        this.f10883a = provider;
        this.f10884b = lazy;
        this.f10885c = lazy2;
        this.f10886d = lazy3;
        this.f10887e = lazy4;
    }

    public void init() {
        if (!StringUtil.c((CharSequence) this.f10883a.get())) {
            ((FbSharedPreferences) this.f10884b.get()).edit().a((PrefKey) ConfigPrefKeys.c.a(GkConfigurationComponent.class.getName()), ((Clock) this.f10885c.get()).a()).commit();
            try {
                ((BatchComponentRunner) this.f10886d.get()).a("onUpgradeGkRefresh", CallerContext.a(OnUpgradeGkRefresher.class), ImmutableList.of(((GkConfigurationComponent) this.f10887e.get()).c()), m17444a());
            } catch (Throwable e) {
                BLog.a(f10881f, "Failed to refresh Gks on app upgrade.", e);
            }
        }
    }

    private static ApiMethodRunnerParams m17444a() {
        ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
        apiMethodRunnerParams.f = RequestPriority.CAN_WAIT;
        return apiMethodRunnerParams;
    }
}

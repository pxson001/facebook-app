package com.facebook.zero.sdk.ui;

import com.facebook.common.idleexecutor.IdleExecutor;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.zero.sdk.constants.ZeroTokenType;
import com.facebook.zero.sdk.request.ZeroRequestHandler;
import com.facebook.zero.sdk.util.UiFeatureDataSerializer;
import com.facebook.zero.sdk.util.ZeroNetworkAndTelephonyHelper;
import com.facebook.zero.sdk.util.ZeroSharedPreferences;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.android.internal.os.BatteryStatsImpl$Uid$Proc */
public class ZeroIndicatorManagerBase {
    private static final Class<?> f5920a = ZeroIndicatorManagerBase.class;
    private static volatile ZeroIndicatorManagerBase f5921j;
    private final ZeroIndicator f5922b;
    private final Lazy<ZeroSharedPreferences> f5923c;
    private final Lazy<IdleExecutor> f5924d;
    private final Lazy<UiFeatureDataSerializer> f5925e;
    private final Provider<ZeroTokenType> f5926f;
    private final Provider<Boolean> f5927g;
    private final Lazy<ZeroRequestHandler> f5928h;
    private final Lazy<ZeroNetworkAndTelephonyHelper> f5929i;

    public static com.facebook.zero.sdk.ui.ZeroIndicatorManagerBase m10710a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5921j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.sdk.ui.ZeroIndicatorManagerBase.class;
        monitor-enter(r1);
        r0 = f5921j;	 Catch:{ all -> 0x003a }
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
        r0 = m10711b(r0);	 Catch:{ all -> 0x0035 }
        f5921j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5921j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.sdk.ui.ZeroIndicatorManagerBase.a(com.facebook.inject.InjectorLike):com.facebook.zero.sdk.ui.ZeroIndicatorManagerBase");
    }

    private static ZeroIndicatorManagerBase m10711b(InjectorLike injectorLike) {
        return new ZeroIndicatorManagerBase((ZeroIndicator) ZeroIndicatorBase.m10705a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3826), IdBasedSingletonScopeProvider.b(injectorLike, 557), IdBasedLazy.a(injectorLike, 3798), IdBasedProvider.a(injectorLike, 3786), IdBasedProvider.a(injectorLike, 4397), IdBasedLazy.a(injectorLike, 3804), IdBasedLazy.a(injectorLike, 3799));
    }

    @Inject
    public ZeroIndicatorManagerBase(ZeroIndicator zeroIndicator, Lazy<ZeroSharedPreferences> lazy, Lazy<IdleExecutor> lazy2, Lazy<UiFeatureDataSerializer> lazy3, Provider<ZeroTokenType> provider, Provider<Boolean> provider2, Lazy<ZeroRequestHandler> lazy4, Lazy<ZeroNetworkAndTelephonyHelper> lazy5) {
        this.f5922b = zeroIndicator;
        this.f5923c = lazy;
        this.f5924d = lazy2;
        this.f5925e = lazy3;
        this.f5926f = provider;
        this.f5927g = provider2;
        this.f5928h = lazy4;
        this.f5929i = lazy5;
    }
}

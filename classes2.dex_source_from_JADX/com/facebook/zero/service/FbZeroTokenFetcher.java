package com.facebook.zero.service;

import com.facebook.common.time.Clock;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.sdk.constants.ZeroTokenType;
import com.facebook.zero.sdk.request.ZeroRequestHandler;
import com.facebook.zero.sdk.token.ZeroToken;
import com.facebook.zero.sdk.token.ZeroTokenFetcher;
import com.facebook.zero.sdk.util.ZeroNetworkAndTelephonyHelper;
import com.facebook.zero.sdk.util.ZeroSharedPreferences;
import com.facebook.zero.util.FbZeroSharedPreferences;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: sort_name_key */
public class FbZeroTokenFetcher extends ZeroTokenFetcher {
    private static volatile FbZeroTokenFetcher f4318d;
    private Set<ZeroTokenType> f4319a = new HashSet();
    private final Provider<Boolean> f4320b;
    private final Provider<Boolean> f4321c;

    public static com.facebook.zero.service.FbZeroTokenFetcher m7986a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4318d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.service.FbZeroTokenFetcher.class;
        monitor-enter(r1);
        r0 = f4318d;	 Catch:{ all -> 0x003a }
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
        r0 = m7987b(r0);	 Catch:{ all -> 0x0035 }
        f4318d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4318d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.service.FbZeroTokenFetcher.a(com.facebook.inject.InjectorLike):com.facebook.zero.service.FbZeroTokenFetcher");
    }

    private static FbZeroTokenFetcher m7987b(InjectorLike injectorLike) {
        return new FbZeroTokenFetcher(IdBasedSingletonScopeProvider.m1810b(injectorLike, 609), IdBasedLazy.m1808a(injectorLike, 3799), IdBasedLazy.m1808a(injectorLike, 3804), IdBasedProvider.m1811a(injectorLike, 814), FbZeroSharedPreferences.m7971a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4384), IdBasedProvider.m1811a(injectorLike, 4383));
    }

    @Inject
    public FbZeroTokenFetcher(Lazy<Clock> lazy, Lazy<ZeroNetworkAndTelephonyHelper> lazy2, Lazy<ZeroRequestHandler> lazy3, Provider<TriState> provider, ZeroSharedPreferences zeroSharedPreferences, Provider<Boolean> provider2, Provider<Boolean> provider3) {
        super(lazy, lazy2, lazy3, provider, zeroSharedPreferences);
        this.f4320b = provider2;
        this.f4321c = provider3;
    }

    protected final void mo1200a(Throwable th, ZeroTokenType zeroTokenType) {
        super.mo1200a(th, zeroTokenType);
        if (!((Boolean) this.f4320b.get()).booleanValue() || !((Boolean) this.f4321c.get()).booleanValue()) {
            return;
        }
        if (this.f4319a.add(zeroTokenType)) {
            m7991a(zeroTokenType, TokenRequestReason.TOKEN_FETCH_FAILED_RETRY);
        } else {
            this.f4319a.remove(zeroTokenType);
        }
    }

    protected final void mo1199a(ZeroToken zeroToken, ZeroTokenType zeroTokenType) {
        super.mo1199a(zeroToken, zeroTokenType);
        if (((Boolean) this.f4320b.get()).booleanValue()) {
            this.f4319a.remove(zeroTokenType);
        }
    }
}

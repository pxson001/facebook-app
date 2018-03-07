package com.facebook.zero.service;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.iorg.common.zero.annotations.IsZeroRatingCampaignEnabled;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.zero.common.constants.FbZeroTokenType;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.sdk.request.ZeroIndicatorData;
import com.facebook.zero.sdk.request.ZeroRequestHandler;
import com.facebook.zero.sdk.util.UiFeatureDataSerializer;
import com.facebook.zero.sdk.util.ZeroNetworkAndTelephonyHelper;
import com.facebook.zero.ui.ZeroIndicatorDataSerialization;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_bytes_sent_foreground */
public class FbZeroIndicatorManager implements IHavePrivacyCriticalKeysToClear {
    private static final Class<?> f4616a = FbZeroIndicatorManager.class;
    private static volatile FbZeroIndicatorManager f4617l;
    @LocalBroadcast
    private final BaseFbBroadcastManager f4618b;
    public final Lazy<FbSharedPreferences> f4619c;
    private final Lazy<IdleExecutor> f4620d;
    private final Lazy<ZeroIndicatorDataSerialization> f4621e;
    public final Lazy<UiFeatureDataSerializer> f4622f;
    public final Provider<FbZeroTokenType> f4623g;
    @IsZeroRatingCampaignEnabled
    private final Provider<Boolean> f4624h;
    public final Lazy<ZeroRequestHandler> f4625i;
    public final Lazy<ZeroNetworkAndTelephonyHelper> f4626j;
    @Nullable
    private volatile ZeroIndicatorData f4627k;

    @Singleton
    /* compiled from: total_bytes_sent_foreground */
    public class CrossFbAppZeroIndicatorManagerReceiverRegistration extends INeedInitForBroadcastReceiverRegistration<FbZeroIndicatorManager> {
        private static volatile CrossFbAppZeroIndicatorManagerReceiverRegistration f2374a;

        public static com.facebook.zero.service.FbZeroIndicatorManager.CrossFbAppZeroIndicatorManagerReceiverRegistration m4534a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
            r0 = f2374a;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.zero.service.FbZeroIndicatorManager.CrossFbAppZeroIndicatorManagerReceiverRegistration.class;
            monitor-enter(r1);
            r0 = f2374a;	 Catch:{ all -> 0x003a }
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
            r0 = m4535b(r0);	 Catch:{ all -> 0x0035 }
            f2374a = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2374a;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.service.FbZeroIndicatorManager.CrossFbAppZeroIndicatorManagerReceiverRegistration.a(com.facebook.inject.InjectorLike):com.facebook.zero.service.FbZeroIndicatorManager$CrossFbAppZeroIndicatorManagerReceiverRegistration");
        }

        private static CrossFbAppZeroIndicatorManagerReceiverRegistration m4535b(InjectorLike injectorLike) {
            return new CrossFbAppZeroIndicatorManagerReceiverRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3803));
        }

        protected void onReceive(Context context, Intent intent, Object obj) {
            FbZeroIndicatorManager fbZeroIndicatorManager = (FbZeroIndicatorManager) obj;
            if ("android.intent.action.LOCALE_CHANGED".equals(intent.getAction())) {
                fbZeroIndicatorManager.m8375a();
            }
        }

        @Inject
        public CrossFbAppZeroIndicatorManagerReceiverRegistration(Lazy<FbZeroIndicatorManager> lazy) {
            super(FbBroadcastManagerType.CROSS_APP, (Lazy) lazy, "android.intent.action.LOCALE_CHANGED");
        }
    }

    @Singleton
    /* compiled from: total_bytes_sent_foreground */
    public class LocalZeroIndicatorManagerReceiverRegistration extends INeedInitForBroadcastReceiverRegistration<FbZeroIndicatorManager> {
        private static volatile LocalZeroIndicatorManagerReceiverRegistration f2375a;

        public static com.facebook.zero.service.FbZeroIndicatorManager.LocalZeroIndicatorManagerReceiverRegistration m4536a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
            r0 = f2375a;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.zero.service.FbZeroIndicatorManager.LocalZeroIndicatorManagerReceiverRegistration.class;
            monitor-enter(r1);
            r0 = f2375a;	 Catch:{ all -> 0x003a }
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
            r0 = m4537b(r0);	 Catch:{ all -> 0x0035 }
            f2375a = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2375a;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.service.FbZeroIndicatorManager.LocalZeroIndicatorManagerReceiverRegistration.a(com.facebook.inject.InjectorLike):com.facebook.zero.service.FbZeroIndicatorManager$LocalZeroIndicatorManagerReceiverRegistration");
        }

        private static LocalZeroIndicatorManagerReceiverRegistration m4537b(InjectorLike injectorLike) {
            return new LocalZeroIndicatorManagerReceiverRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3803));
        }

        protected void onReceive(Context context, Intent intent, Object obj) {
            FbZeroIndicatorManager fbZeroIndicatorManager = (FbZeroIndicatorManager) obj;
            if ("com.facebook.zero.ZERO_RATING_STATE_CHANGED".equals(intent.getAction())) {
                fbZeroIndicatorManager.m8375a();
            }
        }

        @Inject
        public LocalZeroIndicatorManagerReceiverRegistration(Lazy<FbZeroIndicatorManager> lazy) {
            super(FbBroadcastManagerType.LOCAL, (Lazy) lazy, "com.facebook.zero.ZERO_RATING_STATE_CHANGED");
        }
    }

    public static com.facebook.zero.service.FbZeroIndicatorManager m8371a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4617l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.service.FbZeroIndicatorManager.class;
        monitor-enter(r1);
        r0 = f4617l;	 Catch:{ all -> 0x003a }
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
        r0 = m8373b(r0);	 Catch:{ all -> 0x0035 }
        f4617l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4617l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.service.FbZeroIndicatorManager.a(com.facebook.inject.InjectorLike):com.facebook.zero.service.FbZeroIndicatorManager");
    }

    private static FbZeroIndicatorManager m8373b(InjectorLike injectorLike) {
        return new FbZeroIndicatorManager(LocalFbBroadcastManager.m2946a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3078), IdBasedSingletonScopeProvider.m1810b(injectorLike, 557), IdBasedLazy.m1808a(injectorLike, 3825), IdBasedLazy.m1808a(injectorLike, 3798), IdBasedProvider.m1811a(injectorLike, 3759), IdBasedProvider.m1811a(injectorLike, 4034), IdBasedLazy.m1808a(injectorLike, 3804), IdBasedLazy.m1808a(injectorLike, 3799));
    }

    @Inject
    public FbZeroIndicatorManager(FbBroadcastManager fbBroadcastManager, Lazy<FbSharedPreferences> lazy, Lazy<IdleExecutor> lazy2, Lazy<ZeroIndicatorDataSerialization> lazy3, Lazy<UiFeatureDataSerializer> lazy4, Provider<FbZeroTokenType> provider, Provider<Boolean> provider2, Lazy<ZeroRequestHandler> lazy5, Lazy<ZeroNetworkAndTelephonyHelper> lazy6) {
        this.f4618b = fbBroadcastManager;
        this.f4619c = lazy;
        this.f4620d = lazy2;
        this.f4621e = lazy3;
        this.f4622f = lazy4;
        this.f4623g = provider;
        this.f4624h = provider2;
        this.f4625i = lazy5;
        this.f4626j = lazy6;
    }

    public final void m8375a() {
        if (((Boolean) this.f4624h.get()).booleanValue()) {
            ImmutableSet a = ((UiFeatureDataSerializer) this.f4622f.get()).m8055a(((FbZeroTokenType) this.f4623g.get()).getBaseToken().getUIFeaturesKey());
            if (a == null || !(a.contains(ZeroFeatureKey.FB4A_INDICATOR) || a.contains(ZeroFeatureKey.ZERO_INDICATOR))) {
                m8374b(null);
                return;
            } else {
                ExecutorDetour.a((DefaultProcessIdleExecutor) this.f4620d.get(), new 1(this), -661076421);
                return;
            }
        }
        m8374b(null);
    }

    public static void m8372a(FbZeroIndicatorManager fbZeroIndicatorManager, ZeroIndicatorData zeroIndicatorData) {
        if (!Objects.equal(fbZeroIndicatorManager.f4627k, zeroIndicatorData)) {
            fbZeroIndicatorManager.m8374b(zeroIndicatorData);
        }
    }

    private void m8374b(@Nullable ZeroIndicatorData zeroIndicatorData) {
        this.f4627k = zeroIndicatorData;
        ((FbSharedPreferences) this.f4619c.get()).edit().putBoolean(ZeroPrefKeys.m4712a(ZeroFeatureKey.ZERO_INDICATOR), zeroIndicatorData != null).commit();
        this.f4618b.m2955a("com.facebook.zero.ZERO_RATING_INDICATOR_DATA_CHANGED");
    }

    @Nullable
    public final ZeroIndicatorData m8377c() {
        if (this.f4627k == null) {
            synchronized (this) {
                if (this.f4627k == null) {
                    try {
                        String a = ((FbSharedPreferences) this.f4619c.get()).mo278a(ZeroPrefKeys.ac, "");
                        if (!StringUtil.m3589a((CharSequence) a)) {
                            this.f4627k = ((ZeroIndicatorDataSerialization) this.f4621e.get()).m32146a(a);
                        }
                    } catch (IOException e) {
                        BLog.b(f4616a, "Error deserializing indicator data %s: ", new Object[]{e.getMessage(), e});
                    }
                }
            }
        }
        return this.f4627k;
    }

    public final ImmutableSet<PrefKey> mo671b() {
        return ImmutableSet.of(ZeroPrefKeys.ac);
    }
}

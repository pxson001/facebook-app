package com.facebook.zero.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.base.broadcast.Handler_BackgroundBroadcastThreadMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.common.time.Clock;
import com.facebook.common.util.TriState;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.init.INeedInitForGatekeepersListenerRegistration;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.xconfig.core.XConfigReader;
import com.facebook.zero.common.constants.FbZeroTokenType;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.preview.PreviewPrefKeys;
import com.facebook.zero.rewrite.FbZeroRewriteRulesManager;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.sdk.constants.ZeroTokenType;
import com.facebook.zero.sdk.logging.ZeroLogger;
import com.facebook.zero.sdk.rewrite.ZeroRewriteRulesManager;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriteRuleSerialization;
import com.facebook.zero.sdk.token.ZeroToken;
import com.facebook.zero.sdk.token.ZeroTokenFetcher;
import com.facebook.zero.sdk.token.ZeroTokenManagerBase;
import com.facebook.zero.sdk.util.UiFeatureDataSerializer;
import com.facebook.zero.sdk.util.ZeroNetworkAndTelephonyHelper;
import com.facebook.zero.sdk.util.ZeroSharedPreferences;
import com.facebook.zero.token.ZeroTokenXConfig;
import com.facebook.zero.token.request.ZeroTokenHttpRequestHandler;
import com.facebook.zero.token.response.ZeroTokenHeaderResponseManager;
import com.facebook.zero.util.FbZeroSharedPreferences;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_bytes_sent_background */
public class FbZeroTokenManager extends ZeroTokenManagerBase implements DialtoneStateChangedListener, IHavePrivacyCriticalKeysToClear {
    private static volatile FbZeroTokenManager f4285A;
    private static final Class<?> f4286q = FbZeroTokenManager.class;
    @VisibleForTesting
    int f4287p = 0;
    private final Lazy<LoggedInUserAuthDataStore> f4288r;
    private final Provider<Boolean> f4289s;
    private final Provider<Boolean> f4290t;
    public final GatekeeperStoreImpl f4291u;
    public final ZeroTokenHttpRequestHandler f4292v;
    private final ZeroTokenHeaderResponseManager f4293w;
    private final FunnelLoggerImpl f4294x;
    private final XConfigReader f4295y;
    private int f4296z = 3;

    @Singleton
    /* compiled from: total_bytes_sent_background */
    public class CrossProcessZeroTokenManagerReceiverRegistration extends INeedInitForBroadcastReceiverRegistration<FbZeroTokenManager> {
        private static volatile CrossProcessZeroTokenManagerReceiverRegistration f2376a;

        public static com.facebook.zero.service.FbZeroTokenManager.CrossProcessZeroTokenManagerReceiverRegistration m4538a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
            r0 = f2376a;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.zero.service.FbZeroTokenManager.CrossProcessZeroTokenManagerReceiverRegistration.class;
            monitor-enter(r1);
            r0 = f2376a;	 Catch:{ all -> 0x003a }
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
            r0 = m4539b(r0);	 Catch:{ all -> 0x0035 }
            f2376a = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2376a;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.service.FbZeroTokenManager.CrossProcessZeroTokenManagerReceiverRegistration.a(com.facebook.inject.InjectorLike):com.facebook.zero.service.FbZeroTokenManager$CrossProcessZeroTokenManagerReceiverRegistration");
        }

        private static CrossProcessZeroTokenManagerReceiverRegistration m4539b(InjectorLike injectorLike) {
            return new CrossProcessZeroTokenManagerReceiverRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3809));
        }

        protected void onReceive(Context context, Intent intent, Object obj) {
            FbZeroTokenManager fbZeroTokenManager = (FbZeroTokenManager) obj;
            String action = intent.getAction();
            if ("com.facebook.zero.ZERO_RATING_CLEAR_SETTINGS".equals(action)) {
                fbZeroTokenManager.mo1188j();
            } else if ("com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN".equals(action)) {
                TokenRequestReason tokenRequestReason = (TokenRequestReason) intent.getSerializableExtra("zero_token_request_reason");
                if (tokenRequestReason == null) {
                    tokenRequestReason = TokenRequestReason.UNKNOWN_REASON;
                }
                fbZeroTokenManager.m7945a(tokenRequestReason);
            }
        }

        @Inject
        public CrossProcessZeroTokenManagerReceiverRegistration(Lazy<FbZeroTokenManager> lazy) {
            super(FbBroadcastManagerType.CROSS_PROCESS, (Lazy) lazy, "com.facebook.zero.ZERO_RATING_CLEAR_SETTINGS", "com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN");
        }
    }

    @Singleton
    /* compiled from: total_bytes_sent_background */
    public class LocalZeroTokenManagerReceiverRegistration extends INeedInitForBroadcastReceiverRegistration<FbZeroTokenManager> {
        private static volatile LocalZeroTokenManagerReceiverRegistration f2377a;

        public static com.facebook.zero.service.FbZeroTokenManager.LocalZeroTokenManagerReceiverRegistration m4540a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
            r0 = f2377a;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.zero.service.FbZeroTokenManager.LocalZeroTokenManagerReceiverRegistration.class;
            monitor-enter(r1);
            r0 = f2377a;	 Catch:{ all -> 0x003a }
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
            r0 = m4541b(r0);	 Catch:{ all -> 0x0035 }
            f2377a = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2377a;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.service.FbZeroTokenManager.LocalZeroTokenManagerReceiverRegistration.a(com.facebook.inject.InjectorLike):com.facebook.zero.service.FbZeroTokenManager$LocalZeroTokenManagerReceiverRegistration");
        }

        private static LocalZeroTokenManagerReceiverRegistration m4541b(InjectorLike injectorLike) {
            return new LocalZeroTokenManagerReceiverRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3809), Handler_BackgroundBroadcastThreadMethodAutoProvider.m4110a(injectorLike));
        }

        protected void onReceive(Context context, Intent intent, Object obj) {
            FbZeroTokenManager fbZeroTokenManager = (FbZeroTokenManager) obj;
            String action = intent.getAction();
            if ("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED".equals(action)) {
                fbZeroTokenManager.m7958l();
                fbZeroTokenManager.f4292v.m8013a(Boolean.valueOf(true));
                fbZeroTokenManager.mo1192h();
            } else if (AppStateManager.f1110b.equals(action)) {
                fbZeroTokenManager.mo1192h();
            } else if ("com.facebook.zero.ZERO_HEADER_REFRESH_COMPLETED".equals(action)) {
                fbZeroTokenManager.m7945a(TokenRequestReason.HEADERS_REFRESH);
            }
        }

        @Inject
        public LocalZeroTokenManagerReceiverRegistration(Lazy<FbZeroTokenManager> lazy, Handler handler) {
            super(FbBroadcastManagerType.LOCAL, (Lazy) lazy, handler, "com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", AppStateManager.f1110b, "com.facebook.zero.ZERO_HEADER_REFRESH_COMPLETED");
        }
    }

    @Singleton
    /* compiled from: total_bytes_sent_background */
    public class OnInitZeroTokenManagerGatekeepersListenerRegistration extends INeedInitForGatekeepersListenerRegistration<FbZeroTokenManager> {
        private static volatile OnInitZeroTokenManagerGatekeepersListenerRegistration f2452c;
        private final FbSharedPreferences f2453b;

        public static com.facebook.zero.service.FbZeroTokenManager.OnInitZeroTokenManagerGatekeepersListenerRegistration m4663a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
            r0 = f2452c;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.zero.service.FbZeroTokenManager.OnInitZeroTokenManagerGatekeepersListenerRegistration.class;
            monitor-enter(r1);
            r0 = f2452c;	 Catch:{ all -> 0x003a }
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
            r0 = m4664b(r0);	 Catch:{ all -> 0x0035 }
            f2452c = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2452c;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.service.FbZeroTokenManager.OnInitZeroTokenManagerGatekeepersListenerRegistration.a(com.facebook.inject.InjectorLike):com.facebook.zero.service.FbZeroTokenManager$OnInitZeroTokenManagerGatekeepersListenerRegistration");
        }

        private static OnInitZeroTokenManagerGatekeepersListenerRegistration m4664b(InjectorLike injectorLike) {
            return new OnInitZeroTokenManagerGatekeepersListenerRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3809), FbSharedPreferencesImpl.m1826a(injectorLike));
        }

        protected final void mo659a(GatekeeperStoreImpl gatekeeperStoreImpl, int i, Object obj) {
            FbZeroTokenManager fbZeroTokenManager = (FbZeroTokenManager) obj;
            if (782 == i) {
                fbZeroTokenManager.mo1192h();
            } else if (1190 == i) {
                this.f2453b.edit().putBoolean(ZeroPrefKeys.f2622W, gatekeeperStoreImpl.m2189a(i, false)).commit();
            }
        }

        @Inject
        public OnInitZeroTokenManagerGatekeepersListenerRegistration(Lazy<FbZeroTokenManager> lazy, FbSharedPreferences fbSharedPreferences) {
            super((Lazy) lazy, 782, 1190);
            this.f2453b = fbSharedPreferences;
        }
    }

    /* compiled from: total_bytes_sent_background */
    class C02281 implements Provider<ZeroTokenType> {
        final /* synthetic */ Provider f4361a;

        C02281(Provider provider) {
            this.f4361a = provider;
        }

        public Object get() {
            return ((FbZeroTokenType) this.f4361a.get()).getBaseToken();
        }
    }

    /* compiled from: total_bytes_sent_background */
    public class C02302 {
        public final /* synthetic */ FbZeroTokenManager f4363a;

        C02302(FbZeroTokenManager fbZeroTokenManager) {
            this.f4363a = fbZeroTokenManager;
        }
    }

    public static com.facebook.zero.service.FbZeroTokenManager m7926b(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4285A;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.service.FbZeroTokenManager.class;
        monitor-enter(r1);
        r0 = f4285A;	 Catch:{ all -> 0x003a }
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
        r0 = m7927c(r0);	 Catch:{ all -> 0x0035 }
        f4285A = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4285A;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.service.FbZeroTokenManager.b(com.facebook.inject.InjectorLike):com.facebook.zero.service.FbZeroTokenManager");
    }

    private static FbZeroTokenManager m7927c(InjectorLike injectorLike) {
        return new FbZeroTokenManager(IdBasedSingletonScopeProvider.m1810b(injectorLike, 609), FbZeroSharedPreferences.m7971a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3799), IdBasedLazy.m1808a(injectorLike, 401), IdBasedLazy.m1808a(injectorLike, 3798), IdBasedLazy.m1808a(injectorLike, 3791), IdBasedProvider.m1811a(injectorLike, 814), IdBasedProvider.m1811a(injectorLike, 4034), IdBasedSingletonScopeProvider.m1810b(injectorLike, 339), IdBasedProvider.m1811a(injectorLike, 3954), FbZeroTokenFetcher.m7986a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3960), IdBasedProvider.m1811a(injectorLike, 4394), IdBasedProvider.m1811a(injectorLike, 4395), IdBasedProvider.m1811a(injectorLike, 3759), IdBasedLazy.m1808a(injectorLike, 3768), FbZeroRewriteRulesManager.m7998b(injectorLike), ZeroTokenHttpRequestHandler.m8011a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), ZeroTokenHeaderResponseManager.m8015a(injectorLike), FunnelLoggerImpl.m8018a(injectorLike), XConfigReader.m2681a(injectorLike));
    }

    @Inject
    public FbZeroTokenManager(Lazy<Clock> lazy, ZeroSharedPreferences zeroSharedPreferences, Lazy<ZeroNetworkAndTelephonyHelper> lazy2, Lazy<FbBroadcastManager> lazy3, Lazy<UiFeatureDataSerializer> lazy4, Lazy<ZeroUrlRewriteRuleSerialization> lazy5, Provider<TriState> provider, Provider<Boolean> provider2, Lazy<LoggedInUserAuthDataStore> lazy6, Provider<Boolean> provider3, ZeroTokenFetcher zeroTokenFetcher, Provider<Boolean> provider4, Provider<Boolean> provider5, Provider<Boolean> provider6, Provider<FbZeroTokenType> provider7, Lazy<ZeroLogger> lazy7, ZeroRewriteRulesManager zeroRewriteRulesManager, ZeroTokenHttpRequestHandler zeroTokenHttpRequestHandler, GatekeeperStore gatekeeperStore, ZeroTokenHeaderResponseManager zeroTokenHeaderResponseManager, FunnelLogger funnelLogger, XConfigReader xConfigReader) {
        super(lazy, zeroSharedPreferences, lazy2, lazy3, lazy4, lazy5, provider, provider2, zeroTokenFetcher, provider5, provider6, new C02281(provider7), lazy7, zeroRewriteRulesManager);
        this.f4288r = lazy6;
        this.f4289s = provider3;
        this.f4290t = provider4;
        this.f4291u = gatekeeperStore;
        this.f4292v = zeroTokenHttpRequestHandler;
        this.f4293w = zeroTokenHeaderResponseManager;
        m7929q();
        this.f4294x = funnelLogger;
        this.f4295y = xConfigReader;
    }

    public final void mo1188j() {
        this.f4307a.mo1195a().mo2847a(PreviewPrefKeys.b.m2012a()).mo2852a();
        this.f4304n.m7990a();
        super.mo1188j();
    }

    public final void mo1181a(ZeroTokenType zeroTokenType, TokenRequestReason tokenRequestReason) {
        if (!((ZeroNetworkAndTelephonyHelper) this.f4300j.get()).m22189b().equals("none")) {
            if (this.f4302l.get() != TriState.YES) {
                m7949a("disabled");
            } else if (((Boolean) this.f4290t.get()).booleanValue()) {
                super.mo1181a(ZeroTokenType.DIALTONE, tokenRequestReason);
                super.mo1181a(ZeroTokenType.NORMAL, tokenRequestReason);
            } else {
                super.mo1181a(zeroTokenType, tokenRequestReason);
            }
        }
    }

    protected final void mo1189m() {
        ZeroTokenType zeroTokenType = (ZeroTokenType) this.f4310d.get();
        this.f4307a.mo1196a(zeroTokenType.getRegistrationStatusKey(), "unknown");
        String a = this.f4307a.mo1196a(zeroTokenType.getStatusKey(), "unknown");
        String a2 = this.f4307a.mo1196a(zeroTokenType.getUnregisteredReasonKey(), "unavailable");
        if (((LoggedInUserSessionManager) this.f4288r.get()).m2522b() && !m7957k()) {
            if ((this.f4302l.get() != TriState.YES || !a.equals("unknown")) && !a2.equals("unavailable")) {
                Boolean.valueOf(m7957k());
                Intent intent = new Intent("com.facebook.zero.ZERO_RATING_STATE_UNREGISTERED_REASON");
                intent.putExtra("unregistered_reason", a2);
                ((BaseFbBroadcastManager) this.f4301k.get()).mo406a(intent);
            }
        }
    }

    public final Map<String, Object> mo1186i() {
        Map<String, Object> i = super.mo1186i();
        i.put("is_dialtone_enabled", this.f4289s.get());
        return i;
    }

    public final void iw_() {
    }

    public final void b_(boolean z) {
        this.f4304n.m7990a();
        m7966g();
        mo1192h();
        if (z) {
            ZeroTokenType zeroTokenType = ZeroTokenType.NORMAL;
            if (!ZeroToken.m31486a(this.f4307a.mo1196a(zeroTokenType.getCampaignIdKey(), ""))) {
                mo1181a(zeroTokenType, TokenRequestReason.PREFETCH);
            }
        }
    }

    public final ImmutableSet<PrefKey> mo671b() {
        this.f4304n.m7990a();
        Collection hashSet = new HashSet();
        for (FbZeroTokenType clearablePreferencesRoot : FbZeroTokenType.values()) {
            hashSet.add(clearablePreferencesRoot.getClearablePreferencesRoot());
        }
        return ImmutableSet.copyOf(hashSet);
    }

    protected final void mo1180a(ZeroTokenType zeroTokenType) {
        if (!this.f4291u.m2189a(1194, false)) {
            super.mo1180a(zeroTokenType);
        }
    }

    @VisibleForTesting
    public final void m7934a(Map<String, String> map) {
        this.f4294x.m8038a(FunnelRegistry.f21141G, "sent_header_response", map.toString());
        boolean z = false;
        boolean z2 = false;
        for (String str : map.keySet()) {
            boolean z3 = true;
            switch (str.hashCode()) {
                case 81624335:
                    if (str.equals("X-ZERO-FAST-HASH")) {
                        z3 = true;
                        break;
                    }
                    break;
                case 401392896:
                    if (str.equals("X-ZERO-CARRIER-ID")) {
                        z3 = false;
                        break;
                    }
                    break;
                case 1134255095:
                    if (str.equals("X-ZERO-TOKEN-REFRESH")) {
                        z3 = true;
                        break;
                    }
                    break;
            }
            switch (z3) {
                case false:
                    if (this.f4291u.m2189a(1192, false) && ((String) map.get(str)).equals("-1")) {
                        m7949a("disabled");
                        break;
                    } else if (!this.f4307a.mo1196a(((ZeroTokenType) this.f4310d.get()).getCarrierIdKey(), "").equals(map.get(str))) {
                        z2 = true;
                        break;
                    } else {
                        continue;
                    }
                    break;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    if (!this.f4307a.mo1196a(((ZeroTokenType) this.f4310d.get()).getTokenFastHashKey(), "").equals(map.get(str))) {
                        z2 = true;
                        break;
                    }
                    continue;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    z = true;
                    break;
                default:
                    continue;
            }
            if (z) {
                mo1184b(false);
                m7949a("enabled");
                return;
            }
            this.f4294x.m8043b(FunnelRegistry.f21141G, "force_token_fetch");
        }
        if (z2) {
            mo1181a((ZeroTokenType) this.f4310d.get(), TokenRequestReason.HEADER_PARAM_MISMATCH);
        }
        z = z2;
        if (z) {
            mo1184b(false);
            m7949a("enabled");
            return;
        }
        this.f4294x.m8043b(FunnelRegistry.f21141G, "force_token_fetch");
    }

    @VisibleForTesting
    public final void m7940o() {
        if (!((ZeroNetworkAndTelephonyHelper) this.f4300j.get()).m22189b().equals("none")) {
            int i = this.f4287p + 1;
            this.f4287p = i;
            if (i >= this.f4296z) {
                m7928c(true);
                this.f4294x.m8043b(FunnelRegistry.f21141G, "force_token_fetch");
                mo1181a((ZeroTokenType) this.f4310d.get(), TokenRequestReason.UNKNOWN_STATE);
            }
        }
    }

    private void m7928c(boolean z) {
        this.f4287p = 0;
        if (z) {
            this.f4296z *= this.f4295y.m2683a(ZeroTokenXConfig.c, 3);
        } else {
            this.f4296z = this.f4295y.m2683a(ZeroTokenXConfig.d, 3);
        }
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m7929q() {
        ZeroTokenHeaderResponseManager zeroTokenHeaderResponseManager = this.f4293w;
        zeroTokenHeaderResponseManager.f4343a.add(new C02302(this));
    }

    public final void mo1182a(ZeroToken zeroToken, ZeroTokenType zeroTokenType) {
        this.f4294x.m8043b(FunnelRegistry.f21141G, "token_fetch_success");
        super.mo1182a(zeroToken, zeroTokenType);
    }

    public final void mo1183a(Throwable th, ZeroTokenType zeroTokenType) {
        this.f4294x.m8043b(FunnelRegistry.f21141G, "token_fetch_failed");
        super.mo1183a(th, zeroTokenType);
    }

    protected final void mo1184b(boolean z) {
        if (this.f4291u.m2189a(1194, false)) {
            m7928c(false);
            if (z) {
                FunnelRegistry.f21141G.f21184d = false;
                this.f4294x.m8033a(FunnelRegistry.f21141G);
            }
            this.f4294x.m8043b(FunnelRegistry.f21141G, z ? "set_unknown_state_true" : "set_unknown_state_false");
            if (!z) {
                this.f4294x.m8040b(FunnelRegistry.f21141G);
            }
        }
        super.mo1184b(z);
    }
}

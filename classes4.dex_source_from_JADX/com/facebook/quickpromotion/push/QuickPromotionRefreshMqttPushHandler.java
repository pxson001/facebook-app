package com.facebook.quickpromotion.push;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.analytics.InterstitialAnalyticsLogger;
import com.facebook.interstitial.api.FetchInterstitialsMethod;
import com.facebook.interstitial.api.FetchInterstitialsParams;
import com.facebook.interstitial.manager.InterstitialControllersHolder;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.push.mqtt.external.MqttPushHandler;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetchPersistentComponents */
public class QuickPromotionRefreshMqttPushHandler implements MqttPushHandler {
    private static final Class<?> f11745a = QuickPromotionRefreshMqttPushHandler.class;
    private static volatile QuickPromotionRefreshMqttPushHandler f11746h;
    private final Lazy<InterstitialManager> f11747b;
    private final Lazy<InterstitialControllersHolder> f11748c;
    private final Lazy<FetchInterstitialsMethod> f11749d;
    private final Lazy<SingleMethodRunner> f11750e;
    private final Lazy<FbErrorReporter> f11751f;
    private final Lazy<InterstitialAnalyticsLogger> f11752g;

    public static com.facebook.quickpromotion.push.QuickPromotionRefreshMqttPushHandler m12295a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11746h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quickpromotion.push.QuickPromotionRefreshMqttPushHandler.class;
        monitor-enter(r1);
        r0 = f11746h;	 Catch:{ all -> 0x003a }
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
        r0 = m12296b(r0);	 Catch:{ all -> 0x0035 }
        f11746h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11746h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.push.QuickPromotionRefreshMqttPushHandler.a(com.facebook.inject.InjectorLike):com.facebook.quickpromotion.push.QuickPromotionRefreshMqttPushHandler");
    }

    private static QuickPromotionRefreshMqttPushHandler m12296b(InjectorLike injectorLike) {
        return new QuickPromotionRefreshMqttPushHandler(IdBasedSingletonScopeProvider.b(injectorLike, 2360), IdBasedLazy.a(injectorLike, 2358), IdBasedLazy.a(injectorLike, 2354), IdBasedSingletonScopeProvider.b(injectorLike, 2289), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.b(injectorLike, 2353));
    }

    @Inject
    public QuickPromotionRefreshMqttPushHandler(Lazy<InterstitialManager> lazy, Lazy<InterstitialControllersHolder> lazy2, Lazy<FetchInterstitialsMethod> lazy3, Lazy<SingleMethodRunner> lazy4, Lazy<FbErrorReporter> lazy5, Lazy<InterstitialAnalyticsLogger> lazy6) {
        this.f11747b = lazy;
        this.f11748c = lazy2;
        this.f11749d = lazy3;
        this.f11750e = lazy4;
        this.f11751f = lazy5;
        this.f11752g = lazy6;
    }

    public void onMessage(String str, byte[] bArr) {
        try {
            if ("/quick_promotion_refresh".equals(str)) {
                FetchInterstitialsParams fetchInterstitialsParams = new FetchInterstitialsParams(ImmutableList.copyOf(((InterstitialControllersHolder) this.f11748c.get()).a()));
                ((InterstitialAnalyticsLogger) this.f11752g.get()).b();
                ((InterstitialManager) this.f11747b.get()).a((List) ((AbstractSingleMethodRunner) this.f11750e.get()).a((ApiMethod) this.f11749d.get(), fetchInterstitialsParams, CallerContext.a(getClass())));
            }
        } catch (Throwable e) {
            ((AbstractFbErrorReporter) this.f11751f.get()).a(SoftError.m4758a(f11745a.getSimpleName(), "Failed to refresh QuickPromotions.").m4762a(e).m4765g());
        }
    }
}

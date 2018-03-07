package com.facebook.analytics2.loggermodule;

import android.content.Context;
import com.facebook.analytics.Analytics2ProcessPolicy;
import com.facebook.analytics.Analytics2SessionManager;
import com.facebook.analytics.Class_SamplingPolicyConfigClassMethodAutoProvider;
import com.facebook.analytics.EventListener_HighPriEventListenerMethodAutoProvider;
import com.facebook.analytics.EventListener_NormalPriEventListenerMethodAutoProvider;
import com.facebook.analytics.NewAnalyticsSamplingPolicy;
import com.facebook.analytics2.logger.Analytics2Logger;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: telephone_call_log/ */
public class Analytics2LoggerMethodAutoProvider extends AbstractProvider<Analytics2Logger> {
    private static volatile Analytics2Logger f3138a;

    public static com.facebook.analytics2.logger.Analytics2Logger m5285a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3138a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics2.loggermodule.Analytics2LoggerMethodAutoProvider.class;
        monitor-enter(r1);
        r0 = f3138a;	 Catch:{ all -> 0x003a }
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
        r0 = m5286b(r0);	 Catch:{ all -> 0x0035 }
        f3138a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3138a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics2.loggermodule.Analytics2LoggerMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.facebook.analytics2.logger.Analytics2Logger");
    }

    private static Analytics2Logger m5286b(InjectorLike injectorLike) {
        return Analytics2LoggerModule.m5327a((Context) injectorLike.getInstance(Context.class), EventListener_NormalPriEventListenerMethodAutoProvider.m5287a(injectorLike), EventListener_HighPriEventListenerMethodAutoProvider.m5291a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3886), IdBasedLazy.m1808a(injectorLike, 1077), Analytics2SessionManager.m5294a(injectorLike), Analytics2ProcessPolicy.m5308a(injectorLike), NewAnalyticsSamplingPolicy.m5311a(injectorLike), Class_SamplingPolicyConfigClassMethodAutoProvider.m5313a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3219), FbandroidAppInfoProvider.m5317b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 585), Class_HandlerThreadFactoryClassMethodAutoProvider.m5321a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 559));
    }

    public Object get() {
        return Analytics2LoggerModule.m5327a((Context) getInstance(Context.class), EventListener_NormalPriEventListenerMethodAutoProvider.m5287a(this), EventListener_HighPriEventListenerMethodAutoProvider.m5291a(this), IdBasedProvider.m1811a(this, 3886), IdBasedLazy.m1808a(this, 1077), Analytics2SessionManager.m5294a(this), Analytics2ProcessPolicy.m5308a(this), NewAnalyticsSamplingPolicy.m5311a(this), Class_SamplingPolicyConfigClassMethodAutoProvider.m5313a(this), IdBasedSingletonScopeProvider.m1810b(this, 3219), FbandroidAppInfoProvider.m5317b(this), IdBasedSingletonScopeProvider.m1810b(this, 585), Class_HandlerThreadFactoryClassMethodAutoProvider.m5321a(this), IdBasedSingletonScopeProvider.m1810b(this, 559));
    }
}

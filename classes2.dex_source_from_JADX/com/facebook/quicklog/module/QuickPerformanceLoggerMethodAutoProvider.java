package com.facebook.quicklog.module;

import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.C0109x696ccb0c;
import com.facebook.common.executors.ExecutorService_AnalyticsThreadExecutorMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.dalvikgc.DalvikGcInstrumentation;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.STATICDI_MULTIBIND_PROVIDER$PerformanceLoggingEventVisitor;
import com.facebook.quicklog.STATICDI_MULTIBIND_PROVIDER$QuickEventListener;

/* compiled from: userEnabledProviders */
public class QuickPerformanceLoggerMethodAutoProvider extends AbstractProvider<QuickPerformanceLogger> {
    private static volatile QuickPerformanceLogger f1472a;

    public static com.facebook.quicklog.QuickPerformanceLogger m2859a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1472a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider.class;
        monitor-enter(r1);
        r0 = f1472a;	 Catch:{ all -> 0x003a }
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
        r0 = m2860b(r0);	 Catch:{ all -> 0x0035 }
        f1472a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1472a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.facebook.quicklog.QuickPerformanceLogger");
    }

    private static QuickPerformanceLogger m2860b(InjectorLike injectorLike) {
        return QuickPerformanceLoggerModule.m2921a(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3227), HoneySamplingPolicyMethodAutoProvider.m2861a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3230), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), AppStateManager.m2245a(injectorLike), ExecutorService_AnalyticsThreadExecutorMethodAutoProvider.m2928a(injectorLike), DalvikGcInstrumentation.a(injectorLike), StandardDebugAndTestConfig.m2930a(injectorLike), C0109x696ccb0c.m2944a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), STATICDI_MULTIBIND_PROVIDER$PerformanceLoggingEventVisitor.m3056a(injectorLike), STATICDI_MULTIBIND_PROVIDER$QuickEventListener.m3057a(injectorLike));
    }

    public Object get() {
        return QuickPerformanceLoggerModule.m2921a(IdBasedSingletonScopeProvider.m1810b(this, 3227), HoneySamplingPolicyMethodAutoProvider.m2861a(this), IdBasedSingletonScopeProvider.m1810b(this, 3230), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(this), SystemClockMethodAutoProvider.m1498a(this), AppStateManager.m2245a((InjectorLike) this), ExecutorService_AnalyticsThreadExecutorMethodAutoProvider.m2928a(this), DalvikGcInstrumentation.a(this), StandardDebugAndTestConfig.m2930a(this), C0109x696ccb0c.m2944a(this), LocalFbBroadcastManager.m2946a((InjectorLike) this), STATICDI_MULTIBIND_PROVIDER$PerformanceLoggingEventVisitor.m3056a(this), STATICDI_MULTIBIND_PROVIDER$QuickEventListener.m3057a(this));
    }
}

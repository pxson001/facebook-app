package com.facebook.growth.nux.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: uiThread */
public class NUXAnalyticsLogger {
    private static volatile NUXAnalyticsLogger f639c;
    public final AnalyticsLogger f640a;
    public final FunnelLoggerImpl f641b;

    /* compiled from: uiThread */
    public enum Events {
        NUX_STEP_VIEW("account_nux_step_view"),
        LOGIN_START("login_start"),
        LOGIN_FINISH("login_finish"),
        NUX_START("nux_start"),
        NUX_FINISH("nux_finish");
        
        private final String mEventName;

        private Events(String str) {
            this.mEventName = str;
        }

        public final String getEventName() {
            return this.mEventName;
        }
    }

    public static com.facebook.growth.nux.analytics.NUXAnalyticsLogger m1005a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f639c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.growth.nux.analytics.NUXAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f639c;	 Catch:{ all -> 0x003a }
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
        r0 = m1006b(r0);	 Catch:{ all -> 0x0035 }
        f639c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f639c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.growth.nux.analytics.NUXAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.growth.nux.analytics.NUXAnalyticsLogger");
    }

    private static NUXAnalyticsLogger m1006b(InjectorLike injectorLike) {
        return new NUXAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), FunnelLoggerImpl.a(injectorLike));
    }

    @Inject
    public NUXAnalyticsLogger(AnalyticsLogger analyticsLogger, FunnelLoggerImpl funnelLoggerImpl) {
        this.f640a = analyticsLogger;
        this.f641b = funnelLoggerImpl;
    }

    public final void m1007d() {
        this.f641b.b(FunnelRegistry.f, Events.LOGIN_FINISH.getEventName());
        this.f641b.b(FunnelRegistry.g, Events.LOGIN_FINISH.getEventName());
    }
}

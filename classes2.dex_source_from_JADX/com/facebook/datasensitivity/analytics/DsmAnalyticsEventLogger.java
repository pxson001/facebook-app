package com.facebook.datasensitivity.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: signal_evdo_ecio */
public class DsmAnalyticsEventLogger {
    private static volatile DsmAnalyticsEventLogger f4777b;
    private final AnalyticsLogger f4778a;

    public static com.facebook.datasensitivity.analytics.DsmAnalyticsEventLogger m8614a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4777b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.datasensitivity.analytics.DsmAnalyticsEventLogger.class;
        monitor-enter(r1);
        r0 = f4777b;	 Catch:{ all -> 0x003a }
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
        r0 = m8616b(r0);	 Catch:{ all -> 0x0035 }
        f4777b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4777b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasensitivity.analytics.DsmAnalyticsEventLogger.a(com.facebook.inject.InjectorLike):com.facebook.datasensitivity.analytics.DsmAnalyticsEventLogger");
    }

    private static DsmAnalyticsEventLogger m8616b(InjectorLike injectorLike) {
        return new DsmAnalyticsEventLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public DsmAnalyticsEventLogger(AnalyticsLogger analyticsLogger) {
        this.f4778a = analyticsLogger;
    }

    public final void m8617a() {
        m8615a(EventType.CONFIRMATION_DIALOG_SHOWN);
    }

    public final void m8618b() {
        m8615a(EventType.CONFIRMATION_DIALOG_OK_CLICKED);
    }

    public final void m8619c() {
        m8615a(EventType.PROMOTION_NOT_NOW_CLICKED);
    }

    public final void m8620d() {
        m8615a(EventType.PROMOTION_TURN_ON_CLICKED);
    }

    public final void m8621e() {
        m8615a(EventType.CONFIRMATION_DIALOG_TO_SETTING_CLICKED);
    }

    public final void m8622f() {
        m8615a(EventType.SETTINGS_DSM_ENABLED);
    }

    public final void m8623g() {
        m8615a(EventType.SETTINGS_DSM_DISABLED);
    }

    public final void m8624h() {
        m8615a(EventType.SETTINGS_DSM_AUTO_ENABLED);
    }

    public final void m8625i() {
        m8615a(EventType.SETTINGS_DSM_AUTO_DISABLED);
    }

    private void m8615a(EventType eventType) {
        AnalyticsLogger analyticsLogger = this.f4778a;
        HoneyAnalyticsEvent b = new HoneyClientEvent("fb4a_dsm_event").m5090b("event_type", eventType.toString());
        b.f3099c = "data_sensitivity";
        analyticsLogger.mo526a(b);
    }
}

package com.facebook.composer.minutiae.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: topTouchCancel */
public class RidgeAnalyticsLogger {
    private static volatile RidgeAnalyticsLogger f1463b;
    public final AnalyticsLogger f1464a;

    /* compiled from: topTouchCancel */
    public enum RidgeView {
        ACTIVITY_PICKER,
        COMPOSER,
        RIDGE_BUTTON,
        INTERSTITIAL_NUX
    }

    public static com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger m1552a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1463b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f1463b;	 Catch:{ all -> 0x003a }
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
        r0 = m1553b(r0);	 Catch:{ all -> 0x0035 }
        f1463b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1463b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger");
    }

    private static RidgeAnalyticsLogger m1553b(InjectorLike injectorLike) {
        return new RidgeAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RidgeAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f1464a = analyticsLogger;
    }

    public static RidgeAnalyticsEventBuilder m1551a(String str, String str2) {
        return new RidgeAnalyticsEventBuilder("activity_tag_picker", str, str2);
    }

    public final void m1560j(String str) {
        m1551a("ridge_disabled", str).m1550a(this.f1464a);
    }

    public final void m1554a(String str, RidgeView ridgeView) {
        m1551a("ridge_library_load_failed", str).m1548a(ridgeView).m1550a(this.f1464a);
    }

    public final void m1555a(String str, RidgeView ridgeView, String str2) {
        m1551a("ridge_session_started", str).m1549a(str2).m1548a(ridgeView).m1550a(this.f1464a);
    }

    public final void m1557b(String str, RidgeView ridgeView, String str2) {
        m1551a("ridge_session_finished", str).m1549a(str2).m1548a(ridgeView).m1550a(this.f1464a);
    }

    public final void m1559c(String str, RidgeView ridgeView, String str2) {
        m1551a("ridge_match_found", str).m1549a(str2).m1548a(ridgeView).m1550a(this.f1464a);
    }

    public final void m1556b(String str, RidgeView ridgeView) {
        m1551a("ridge_mic_permission_denied", str).m1548a(ridgeView).m1550a(this.f1464a);
    }

    public final void m1558c(String str, RidgeView ridgeView) {
        m1551a("ridge_mic_permission_canceled", str).m1548a(ridgeView).m1550a(this.f1464a);
    }
}

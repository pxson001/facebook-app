package com.facebook.facecastdisplay.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: store_conversion_notification_tapped */
public class FacecastDisplayLogger {
    private static volatile FacecastDisplayLogger f3038c;
    private final String f3039a;
    private final AnalyticsLogger f3040b;

    public static com.facebook.facecastdisplay.analytics.FacecastDisplayLogger m3304a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3038c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.facecastdisplay.analytics.FacecastDisplayLogger.class;
        monitor-enter(r1);
        r0 = f3038c;	 Catch:{ all -> 0x003a }
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
        r0 = m3306b(r0);	 Catch:{ all -> 0x0035 }
        f3038c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3038c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecastdisplay.analytics.FacecastDisplayLogger.a(com.facebook.inject.InjectorLike):com.facebook.facecastdisplay.analytics.FacecastDisplayLogger");
    }

    private static FacecastDisplayLogger m3306b(InjectorLike injectorLike) {
        return new FacecastDisplayLogger(String_LoggedInUserIdMethodAutoProvider.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FacecastDisplayLogger(String str, AnalyticsLogger analyticsLogger) {
        this.f3039a = str;
        this.f3040b = analyticsLogger;
    }

    public final void m3307a() {
        m3305a("facecast_share_now_start");
    }

    public final void m3308b() {
        m3305a("facecast_share_now_fail");
    }

    public final void m3309c() {
        m3305a("facecast_copy_link");
    }

    public final void m3310d() {
        m3305a("facecast_schedule_pause_notif");
    }

    public final void m3311e() {
        m3305a("facecast_show_pause_notif");
    }

    public final void m3312f() {
        m3305a("facecast_reactions_toggle_off");
    }

    public final void m3313g() {
        m3305a("facecast_reactions_toggle_on");
    }

    private void m3305a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("facecast_broadcaster_update");
        honeyClientEvent.c = "facecast";
        this.f3040b.a(honeyClientEvent.b("facecast_event_name", str).j(this.f3039a));
    }
}

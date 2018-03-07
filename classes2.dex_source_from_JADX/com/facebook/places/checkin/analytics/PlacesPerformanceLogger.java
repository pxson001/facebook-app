package com.facebook.places.checkin.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: uf_android_debug_intent */
public class PlacesPerformanceLogger {
    private static volatile PlacesPerformanceLogger f2055i;
    private final String f2056a = SafeUUIDGenerator.m2795a().toString();
    public boolean f2057b;
    private boolean f2058c;
    private boolean f2059d;
    public final QuickPerformanceLogger f2060e;
    public final InteractionTTILogger f2061f;
    private final AnalyticsLogger f2062g;
    private final MonotonicClock f2063h;

    public static com.facebook.places.checkin.analytics.PlacesPerformanceLogger m4202a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2055i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.places.checkin.analytics.PlacesPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f2055i;	 Catch:{ all -> 0x003a }
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
        r0 = m4204b(r0);	 Catch:{ all -> 0x0035 }
        f2055i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2055i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.checkin.analytics.PlacesPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.places.checkin.analytics.PlacesPerformanceLogger");
    }

    private static PlacesPerformanceLogger m4204b(InjectorLike injectorLike) {
        return new PlacesPerformanceLogger(QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike), InteractionTTILogger.m4228a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    @Inject
    public PlacesPerformanceLogger(QuickPerformanceLogger quickPerformanceLogger, InteractionTTILogger interactionTTILogger, AnalyticsLogger analyticsLogger, MonotonicClock monotonicClock) {
        this.f2060e = quickPerformanceLogger;
        this.f2061f = interactionTTILogger;
        this.f2062g = analyticsLogger;
        this.f2063h = monotonicClock;
    }

    public final void m4206a() {
        this.f2060e.mo476d(1376261);
        this.f2060e.mo476d(1376262);
        this.f2060e.mo476d(1376278);
        this.f2060e.mo476d(1376279);
        this.f2060e.mo476d(1376280);
        this.f2060e.mo476d(1376281);
        this.f2061f.m4245a();
    }

    public final void m4208b() {
        this.f2061f.m4249a("LocationPin");
        this.f2060e.mo462b(1376261);
        this.f2060e.mo462b(1376278);
        m4203a(1376278, SearchType.STATUS);
    }

    public final void m4210c() {
        this.f2061f.m4249a("CheckInButton");
        this.f2060e.mo462b(1376262);
        this.f2060e.mo462b(1376278);
        m4203a(1376278, SearchType.CHECKIN);
        m4205g(this.f2057b ? "checkin_clicked_hot" : "checkin_clicked_cold");
    }

    public final void m4207a(SearchType searchType) {
        this.f2060e.mo468b(1376278, (short) 2);
        this.f2060e.mo462b(1376279);
        m4203a(1376279, searchType);
    }

    public final void m4209b(SearchType searchType) {
        this.f2060e.mo468b(1376279, (short) 2);
        this.f2060e.mo462b(1376280);
        m4203a(1376280, searchType);
    }

    public final void m4211c(SearchType searchType) {
        this.f2060e.mo468b(1376280, (short) 2);
        this.f2060e.mo462b(1376281);
        m4203a(1376281, searchType);
    }

    public final void m4212f() {
        if (!this.f2058c) {
            this.f2058c = true;
            m4205g("app_cold_start");
        }
    }

    public final void m4213g() {
        if (!this.f2059d) {
            this.f2059d = true;
            m4205g("composer_shown");
        }
    }

    public final void m4214h() {
        m4205g(this.f2057b ? "textbox_clicked_hot" : "textbox_clicked_cold");
    }

    public final void m4215i() {
        m4205g(this.f2057b ? "status_clicked_hot" : "status_clicked_cold");
    }

    public final void m4216j() {
        m4205g(this.f2057b ? "photo_clicked_hot" : "photo_clicked_cold");
    }

    public final void m4217k() {
        m4205g(this.f2057b ? "profile_pic_clicked_hot" : "profile_pic_clicked_cold");
    }

    private void m4205g(String str) {
        AnalyticsLogger analyticsLogger = this.f2062g;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f3102f = this.f2056a;
        analyticsLogger.mo526a(honeyClientEvent.m5084a("action_time", this.f2063h.now()));
    }

    private void m4203a(int i, SearchType searchType) {
        this.f2060e.mo448a(i, searchType.equals(SearchType.CHECKIN) ? "checkin_button" : "location_pin");
    }
}

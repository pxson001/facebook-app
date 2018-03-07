package com.facebook.events.dashboard;

import com.facebook.inject.InjectorLike;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.google.android.location.intent.extra.triggering_location */
public class EventsDashboardPerformanceLogger {
    private static volatile EventsDashboardPerformanceLogger f16700d;
    private final MarkerConfig f16701a;
    private final PerformanceLogger f16702b;
    private final InteractionTTILogger f16703c;

    public static com.facebook.events.dashboard.EventsDashboardPerformanceLogger m17093a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16700d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.dashboard.EventsDashboardPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f16700d;	 Catch:{ all -> 0x003a }
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
        r0 = m17094b(r0);	 Catch:{ all -> 0x0035 }
        f16700d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16700d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.dashboard.EventsDashboardPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.events.dashboard.EventsDashboardPerformanceLogger");
    }

    private static EventsDashboardPerformanceLogger m17094b(InjectorLike injectorLike) {
        return new EventsDashboardPerformanceLogger((PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), InteractionTTILogger.a(injectorLike));
    }

    @Inject
    public EventsDashboardPerformanceLogger(PerformanceLogger performanceLogger, InteractionTTILogger interactionTTILogger) {
        this.f16702b = performanceLogger;
        this.f16703c = interactionTTILogger;
        MarkerConfig a = new MarkerConfig(393234, "EventsDashboardFragment").a(new String[]{"event_dashboard"});
        a.n = true;
        this.f16701a = a;
    }

    public final void m17095a() {
        this.f16702b.c(this.f16701a);
    }

    public final void m17096a(String str) {
        if (str != null) {
            this.f16702b.a(393234, "EventsDashboardFragment", null, "load_type", str);
        } else {
            this.f16702b.b(this.f16701a);
        }
        this.f16703c.b("LoadEventsDashboard", str);
    }

    public final void m17097b() {
        this.f16702b.f(this.f16701a);
        this.f16703c.a();
    }

    public final void m17098b(String str) {
        this.f16702b.b(393230, "EventsDashboardChangeFilter", str);
    }

    public final void m17099c(String str) {
        this.f16702b.a(393230, "EventsDashboardChangeFilter", str);
    }
}

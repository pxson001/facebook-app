package com.facebook.maps;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: warn_ack */
public class StaticMapLogger {
    private static volatile StaticMapLogger f327c;
    public final AnalyticsLogger f328a;
    public final BaseAnalyticsConfig f329b;

    public static com.facebook.maps.StaticMapLogger m285a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f327c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.maps.StaticMapLogger.class;
        monitor-enter(r1);
        r0 = f327c;	 Catch:{ all -> 0x003a }
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
        r0 = m286b(r0);	 Catch:{ all -> 0x0035 }
        f327c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f327c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.maps.StaticMapLogger.a(com.facebook.inject.InjectorLike):com.facebook.maps.StaticMapLogger");
    }

    private static StaticMapLogger m286b(InjectorLike injectorLike) {
        return new StaticMapLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (BaseAnalyticsConfig) FbAnalyticsConfig.a(injectorLike));
    }

    @Inject
    public StaticMapLogger(AnalyticsLogger analyticsLogger, BaseAnalyticsConfig baseAnalyticsConfig) {
        this.f328a = analyticsLogger;
        this.f329b = baseAnalyticsConfig;
    }

    public final void m289a(String str, String str2) {
        String str3 = "oxygen_map_fullscreen_maps_launched";
        if (this.f329b.a(str3)) {
            HoneyClientEventFast a = this.f328a.a(str3, false);
            if (a.a()) {
                a.a("oxygen_map").a("surface", str).a("query_type", str2);
                a.b();
            }
        }
    }

    public final void m290b(String str, String str2) {
        String str3 = "oxygen_map_external_map_app_launched";
        if (this.f329b.a(str3)) {
            HoneyClientEventFast a = this.f328a.a(str3, false);
            if (a.a()) {
                a.a("oxygen_map").a("surface", str).a("query_type", str2);
                a.b();
            }
        }
    }

    public final void m287a() {
        String str = "oxygen_map_here_upsell_dialog_impression";
        if (this.f329b.a(str)) {
            HoneyClientEventFast a = this.f328a.a(str, false);
            if (a.a()) {
                a.a("oxygen_map");
                a.b();
            }
        }
    }

    public final void m288a(String str) {
        String str2 = "oxygen_map_here_upsell_dialog_clicked";
        if (this.f329b.a(str2)) {
            HoneyClientEventFast a = this.f328a.a(str2, false);
            if (a.a()) {
                a.a("oxygen_map").a("action_name", str);
                a.b();
            }
        }
    }
}

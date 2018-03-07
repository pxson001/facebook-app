package com.facebook.directinstall.appdetails.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: onDestroyView not allowed on MapViewDelegate */
public class AppDetailsLogger {
    private static volatile AppDetailsLogger f8730b;
    private AnalyticsLogger f8731a;

    public static com.facebook.directinstall.appdetails.analytics.AppDetailsLogger m12505a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8730b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.directinstall.appdetails.analytics.AppDetailsLogger.class;
        monitor-enter(r1);
        r0 = f8730b;	 Catch:{ all -> 0x003a }
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
        r0 = m12507b(r0);	 Catch:{ all -> 0x0035 }
        f8730b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8730b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.directinstall.appdetails.analytics.AppDetailsLogger.a(com.facebook.inject.InjectorLike):com.facebook.directinstall.appdetails.analytics.AppDetailsLogger");
    }

    private static AppDetailsLogger m12507b(InjectorLike injectorLike) {
        return new AppDetailsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AppDetailsLogger(AnalyticsLogger analyticsLogger) {
        this.f8731a = analyticsLogger;
    }

    public final void m12508a(String str, String str2, int i, Map<String, Object> map) {
        m12506a("tap", str, str2, i, map);
    }

    public final void m12510b(String str, String str2, int i, Map<String, Object> map) {
        m12506a("swipe", str, str2, i, map);
    }

    public final void m12511c(String str, String str2, int i, Map<String, Object> map) {
        m12506a("swipe_fullscreen", str, str2, i, map);
    }

    private void m12506a(String str, String str2, String str3, int i, Map<String, Object> map) {
        Map hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("interaction_type", str);
        hashMap.put("interaction_position", Integer.valueOf(i));
        m12509a("neko_di_app_details_screenshot_interaction", str2, str3, hashMap);
    }

    public final void m12509a(String str, String str2, String str3, Map<String, Object> map) {
        AnalyticsLogger analyticsLogger = this.f8731a;
        HoneyClientEvent a = new HoneyClientEvent(str).a(map).b("package_name", str2).a("app_details", true);
        a.e = str3;
        analyticsLogger.a(a);
    }
}

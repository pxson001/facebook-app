package com.facebook.adinterfaces.external.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.inject.InjectorLike;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: feedback_id */
public class AdInterfacesExternalLogger {
    private static volatile AdInterfacesExternalLogger f24435b;
    private AnalyticsLogger f24436a;

    public static com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger m32748a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f24435b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger.class;
        monitor-enter(r1);
        r0 = f24435b;	 Catch:{ all -> 0x003a }
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
        r0 = m32749b(r0);	 Catch:{ all -> 0x0035 }
        f24435b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f24435b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger.a(com.facebook.inject.InjectorLike):com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger");
    }

    private static AdInterfacesExternalLogger m32749b(InjectorLike injectorLike) {
        return new AdInterfacesExternalLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public AdInterfacesExternalLogger(AnalyticsLogger analyticsLogger) {
        this.f24436a = analyticsLogger;
    }

    public final void m32751a(BoostedComponentModule boostedComponentModule, Event event, String str, String str2, String str3, String str4, boolean z) {
        try {
            HoneyClientEventFast a = this.f24436a.mo535a(event.toString(), true);
            if (a.m17388a()) {
                a.m17379a(boostedComponentModule.toString());
                a.m17385a("post_id", str3);
                a.m17385a("placement", str2);
                a.m17385a("page_id", str);
                if (event == Event.EVENT_RENDER_FAIL_ENTRY_POINT) {
                    a.m17385a("ineligible_reason", str4);
                }
                if (z) {
                    a.m17385a("flow", "ineligible");
                }
                a.m17390b();
            }
        } catch (Exception e) {
        }
    }

    public final void m32750a(BoostedComponentModule boostedComponentModule, Event event, String str, String str2) {
        try {
            HoneyClientEventFast a = this.f24436a.mo535a(event.toString(), true);
            if (a.m17388a()) {
                a.m17379a(boostedComponentModule.toString());
                a.m17385a("placement", str2);
                a.m17385a("page_id", str);
                a.m17390b();
            }
        } catch (Exception e) {
        }
    }

    public final void m32752a(BoostedComponentModule boostedComponentModule, Event event, Map<String, String> map, FbErrorReporter fbErrorReporter) {
        try {
            HoneyClientEventFast a = this.f24436a.mo535a(event.toString(), true);
            if (a.m17388a()) {
                a.m17379a(boostedComponentModule.toString());
                for (String str : map.keySet()) {
                    a.m17385a(str, (String) map.get(str));
                }
                a.m17390b();
            }
        } catch (Throwable e) {
            fbErrorReporter.mo336a(SoftError.a("adinterface_logging_error", "Error logging event " + event.toString()).a(1).a(e).g());
        }
    }
}

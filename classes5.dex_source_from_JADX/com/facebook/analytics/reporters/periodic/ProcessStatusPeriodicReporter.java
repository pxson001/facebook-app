package com.facebook.analytics.reporters.periodic;

import com.facebook.acra.util.ProcFileReader;
import com.facebook.acra.util.ProcFileReader.OpenFDLimits;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.logger.ILegacyPeriodicEventReporter;
import com.facebook.analytics.prefs.AnalyticsPrefKeys;
import com.facebook.analytics.util.AnalyticsDeviceUtils;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: timeline_about_section_suggest_edits */
public class ProcessStatusPeriodicReporter implements ILegacyPeriodicEventReporter {
    private static volatile ProcessStatusPeriodicReporter f1904d;
    public final FbSharedPreferences f1905a;
    public final String f1906b;
    public final AnalyticsDeviceUtils f1907c;

    public static com.facebook.analytics.reporters.periodic.ProcessStatusPeriodicReporter m2588a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1904d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.reporters.periodic.ProcessStatusPeriodicReporter.class;
        monitor-enter(r1);
        r0 = f1904d;	 Catch:{ all -> 0x003a }
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
        r0 = m2589b(r0);	 Catch:{ all -> 0x0035 }
        f1904d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1904d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.reporters.periodic.ProcessStatusPeriodicReporter.a(com.facebook.inject.InjectorLike):com.facebook.analytics.reporters.periodic.ProcessStatusPeriodicReporter");
    }

    private static ProcessStatusPeriodicReporter m2589b(InjectorLike injectorLike) {
        return new ProcessStatusPeriodicReporter((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DefaultProcessUtil.a(injectorLike), AnalyticsDeviceUtils.a(injectorLike));
    }

    @Inject
    public ProcessStatusPeriodicReporter(FbSharedPreferences fbSharedPreferences, DefaultProcessUtil defaultProcessUtil, AnalyticsDeviceUtils analyticsDeviceUtils) {
        this.f1905a = fbSharedPreferences;
        this.f1906b = defaultProcessUtil.a().c();
        this.f1907c = analyticsDeviceUtils;
    }

    public final long m2590a() {
        long j = 3600000;
        if (this.f1905a.a()) {
            j = this.f1905a.a(AnalyticsPrefKeys.b, 3600000);
        }
        return j;
    }

    public final HoneyAnalyticsEvent m2591a(long j, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("process_status");
        this.f1907c.g(honeyClientEvent);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("open_fd_count", ProcFileReader.getOpenFDCount());
        OpenFDLimits openFDLimits = ProcFileReader.getOpenFDLimits();
        if (openFDLimits != null) {
            objectNode.a("open_fd_soft_limit", openFDLimits.softLimit);
            objectNode.a("open_fd_hard_limit", openFDLimits.hardLimit);
        }
        honeyClientEvent.a("fd_info", objectNode);
        honeyClientEvent.e = j;
        honeyClientEvent.c = "process";
        honeyClientEvent.i = this.f1906b;
        return honeyClientEvent;
    }
}

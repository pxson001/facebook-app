package com.facebook.redspace.analytics.logger;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Map;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: Unable to fetch tagging data */
public class RedSpaceLogger {
    private static volatile RedSpaceLogger f21263c;
    @Inject
    public volatile Provider<FbErrorReporter> f21264a = UltralightRuntime.a;
    @Inject
    public AnalyticsLogger f21265b;

    public static com.facebook.redspace.analytics.logger.RedSpaceLogger m24873a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21263c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.redspace.analytics.logger.RedSpaceLogger.class;
        monitor-enter(r1);
        r0 = f21263c;	 Catch:{ all -> 0x003a }
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
        r0 = m24875b(r0);	 Catch:{ all -> 0x0035 }
        f21263c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21263c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.redspace.analytics.logger.RedSpaceLogger.a(com.facebook.inject.InjectorLike):com.facebook.redspace.analytics.logger.RedSpaceLogger");
    }

    private static RedSpaceLogger m24875b(InjectorLike injectorLike) {
        RedSpaceLogger redSpaceLogger = new RedSpaceLogger();
        AnalyticsLogger a = AnalyticsLoggerMethodAutoProvider.a(injectorLike);
        redSpaceLogger.f21264a = IdBasedSingletonScopeProvider.a(injectorLike, 494);
        redSpaceLogger.f21265b = a;
        return redSpaceLogger;
    }

    public final void m24877a(Map<String, Integer> map) {
        HoneyClientEventFast a = this.f21265b.a("grid_friend_impressions", false);
        if (a.a()) {
            try {
                String a2 = FbObjectMapper.i().a(map);
                a.a("redspace");
                a.a("impressions", a2);
                a.b();
            } catch (JsonProcessingException e) {
                ((AbstractFbErrorReporter) this.f21264a.get()).a(getClass().getSimpleName(), e);
            }
        }
    }

    public final void m24876a(Throwable th, long j) {
        m24874a("grid_load_failure", th, j);
    }

    public final void m24878b(Throwable th, long j) {
        m24874a("wall_load_failure", th, j);
    }

    public final void m24879c(Throwable th, long j) {
        m24874a("badge_load_failure", th, j);
    }

    private void m24874a(String str, Throwable th, long j) {
        HoneyClientEventFast a = this.f21265b.a(str, false);
        if (a.a()) {
            a.a("redspace_performance");
            a.a("message", th.toString());
            a.a("elapsed_time_ms", j);
            a.b();
        }
    }
}

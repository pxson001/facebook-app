package com.facebook.interstitial.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.api.FetchInterstitialResult;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: snippet_sender_fbid */
public class InterstitialAnalyticsLogger {
    private static volatile InterstitialAnalyticsLogger f4469c;
    public final AnalyticsLogger f4470a;
    public final FunnelLoggerImpl f4471b;

    public static com.facebook.interstitial.analytics.InterstitialAnalyticsLogger m8167a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4469c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.interstitial.analytics.InterstitialAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f4469c;	 Catch:{ all -> 0x003a }
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
        r0 = m8168b(r0);	 Catch:{ all -> 0x0035 }
        f4469c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4469c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.interstitial.analytics.InterstitialAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.interstitial.analytics.InterstitialAnalyticsLogger");
    }

    private static InterstitialAnalyticsLogger m8168b(InjectorLike injectorLike) {
        return new InterstitialAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), FunnelLoggerImpl.m8018a(injectorLike));
    }

    @Inject
    public InterstitialAnalyticsLogger(AnalyticsLogger analyticsLogger, FunnelLoggerImpl funnelLoggerImpl) {
        this.f4470a = analyticsLogger;
        this.f4471b = funnelLoggerImpl;
    }

    public final void m8172b() {
        HoneyClientEventFast a = this.f4470a.mo535a("interstitials_push_fetch_start", false);
        if (a.m17388a()) {
            a.m17390b();
        }
    }

    public final void m8171a(List<FetchInterstitialResult> list) {
        HoneyClientEventFast a = this.f4470a.mo535a("interstitials_fetch_replaced", false);
        if (a.m17388a()) {
            a.m17383a("interstitial_ids", m8169c(list));
            a.m17390b();
        }
    }

    public final void m8173b(List<FetchInterstitialResult> list) {
        HoneyClientEventFast a = this.f4470a.mo535a("interstitials_fetch_updated", false);
        if (a.m17388a()) {
            a.m17383a("interstitial_ids", m8169c(list));
            a.m17390b();
        }
    }

    public final void m8170a(String str, InterstitialTrigger interstitialTrigger, long j, long j2, long j3) {
        HoneyClientEventFast a = this.f4470a.mo535a("interstitial_invalidated_by_min_delay_time", false);
        if (a.m17388a()) {
            a.m17385a("interstitial_id", str).m17385a("trigger", interstitialTrigger.toString()).m17382a("now_ms", j).m17382a("last_impression_timestamp_ms", j2).m17382a("min_impression_delay_ms", j3);
            a.m17390b();
        }
    }

    private static ArrayNode m8169c(List<FetchInterstitialResult> list) {
        ArrayNode b = JsonNodeFactory.f3121a.m5232b();
        for (FetchInterstitialResult fetchInterstitialResult : list) {
            b.m13394h(fetchInterstitialResult.interstitialId);
        }
        return b;
    }
}

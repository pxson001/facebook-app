package com.facebook.feed.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event;
import com.facebook.inject.InjectorLike;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: phone_full_number */
public class RerankingEventsLogger {
    @VisibleForTesting
    public static final int f10155a = ((int) TimeUnit.SECONDS.toMillis(2));
    private static volatile RerankingEventsLogger f10156d;
    private final AnalyticsLogger f10157b;
    public final NewsFeedEventLogger f10158c;

    public static com.facebook.feed.logging.RerankingEventsLogger m15253a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10156d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.logging.RerankingEventsLogger.class;
        monitor-enter(r1);
        r0 = f10156d;	 Catch:{ all -> 0x003a }
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
        r0 = m15255b(r0);	 Catch:{ all -> 0x0035 }
        f10156d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10156d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.RerankingEventsLogger.a(com.facebook.inject.InjectorLike):com.facebook.feed.logging.RerankingEventsLogger");
    }

    private static RerankingEventsLogger m15255b(InjectorLike injectorLike) {
        return new RerankingEventsLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), NewsFeedEventLogger.m4405a(injectorLike));
    }

    @Inject
    public RerankingEventsLogger(AnalyticsLogger analyticsLogger, NewsFeedEventLogger newsFeedEventLogger) {
        this.f10157b = analyticsLogger;
        this.f10158c = newsFeedEventLogger;
    }

    public final void m15257b() {
        m15254a(false);
    }

    public final void m15258c() {
        m15254a(true);
    }

    private void m15254a(boolean z) {
        this.f10158c.m4411a("NewsFeedFragment", Event.LOADING_INDICATOR_HIDDEN, String.valueOf(z));
    }

    public final void m15256a(FetchStats fetchStats) {
        String name;
        long min;
        HoneyClientEvent a = new HoneyClientEvent("head_fetch_stats").m5084a("duration_ms", fetchStats.b).m5084a("duration_rerank_ms", fetchStats.c).m5084a("duration_first_ms", fetchStats.d);
        String str = "fetch_feed_cause";
        FetchFeedCause fetchFeedCause = fetchStats.a;
        if (fetchFeedCause == null) {
            name = FetchFeedCause.UNKNOWN.name();
        } else {
            name = fetchFeedCause.name();
        }
        a = a.m5090b(str, name).m5087a("is_success", fetchStats.e).m5087a("is_asyncfeed", fetchStats.f);
        str = "min_duration";
        if (fetchStats.c > 0) {
            min = Math.min(fetchStats.c, fetchStats.d);
        } else {
            min = fetchStats.d;
        }
        HoneyAnalyticsEvent a2 = a.m5084a(str, min);
        a2.f3099c = "news_feed_rerank";
        this.f10157b.mo526a(a2);
    }
}

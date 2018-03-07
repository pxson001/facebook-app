package com.facebook.api.feedcache.db;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler.DbStoryLookup;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: session_token */
public class FeedStoryRefetchLogger {
    private static volatile FeedStoryRefetchLogger f5391b;
    private final AnalyticsLogger f5392a;

    public static com.facebook.api.feedcache.db.FeedStoryRefetchLogger m9281a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5391b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.db.FeedStoryRefetchLogger.class;
        monitor-enter(r1);
        r0 = f5391b;	 Catch:{ all -> 0x003a }
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
        r0 = m9282b(r0);	 Catch:{ all -> 0x0035 }
        f5391b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5391b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.db.FeedStoryRefetchLogger.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.db.FeedStoryRefetchLogger");
    }

    private static FeedStoryRefetchLogger m9282b(InjectorLike injectorLike) {
        return new FeedStoryRefetchLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public FeedStoryRefetchLogger(AnalyticsLogger analyticsLogger) {
        this.f5392a = analyticsLogger;
    }

    public final void m9283a(FetchFeedParams fetchFeedParams, int i, String str, DbStoryLookup dbStoryLookup) {
        HoneyClientEventFast a = this.f5392a.mo535a("fb4a_feed_story_refetch", false);
        if (a.m17388a()) {
            boolean a2 = dbStoryLookup.m9293a(str, fetchFeedParams.f5784b);
            a.m17385a("feed_type", fetchFeedParams.f5784b.toString());
            a.m17381a("story_index", i);
            a.m17385a("fetch_type", fetchFeedParams.f5788f.toString());
            a.m17386a("refetched", a2);
            a.m17384a("caller_context", (Object) fetchFeedParams.f5792j);
            a.m17390b();
        }
    }
}

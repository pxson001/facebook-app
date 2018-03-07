package com.facebook.feed.data;

import com.facebook.api.feed.FeedFetchContext;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType.CachePolicy;
import com.facebook.feed.server.FeedUnitPreRenderProcessor;
import com.facebook.feed.server.NewsFeedFilterHandler;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: save */
public class FeedFetcherProcessor {
    private static volatile FeedFetcherProcessor f6290d;
    private final DbFeedHomeStoriesHandler f6291a;
    private final NewsFeedFilterHandler f6292b;
    private final FeedUnitPreRenderProcessor f6293c;

    public static com.facebook.feed.data.FeedFetcherProcessor m10525a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6290d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.data.FeedFetcherProcessor.class;
        monitor-enter(r1);
        r0 = f6290d;	 Catch:{ all -> 0x003a }
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
        r0 = m10526b(r0);	 Catch:{ all -> 0x0035 }
        f6290d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6290d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.data.FeedFetcherProcessor.a(com.facebook.inject.InjectorLike):com.facebook.feed.data.FeedFetcherProcessor");
    }

    private static FeedFetcherProcessor m10526b(InjectorLike injectorLike) {
        return new FeedFetcherProcessor(DbFeedHomeStoriesHandler.m9120a(injectorLike), NewsFeedFilterHandler.m10531b(injectorLike), FeedUnitPreRenderProcessor.m9989a(injectorLike));
    }

    @Inject
    public FeedFetcherProcessor(DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler, NewsFeedFilterHandler newsFeedFilterHandler, FeedUnitPreRenderProcessor feedUnitPreRenderProcessor) {
        this.f6291a = dbFeedHomeStoriesHandler;
        this.f6292b = newsFeedFilterHandler;
        this.f6293c = feedUnitPreRenderProcessor;
    }

    public final FetchFeedResult m10527a(FetchFeedResult fetchFeedResult) {
        TracerDetour.a("FeedFetcherProcessor.processFeedResult", 1170977812);
        try {
            FetchFeedResult b = m10528b(fetchFeedResult);
            FeedFetchContext k = fetchFeedResult.m22442g().m9917k();
            ImmutableList d = b.m22439d();
            int size = d.size();
            for (int i = 0; i < size; i++) {
                this.f6293c.m9990a(((GraphQLFeedUnitEdge) d.get(i)).mo2540c(), k);
            }
            m10529c(b);
            return b;
        } finally {
            TracerDetour.a(-191371597);
        }
    }

    public final FetchFeedResult m10528b(FetchFeedResult fetchFeedResult) {
        TracerDetour.a("FeedFetcherProcessor.filterFeedResult", -182934563);
        try {
            FetchFeedResult a = this.f6292b.m10532a(fetchFeedResult, fetchFeedResult.m22442g().m9913f().m8964e() != CachePolicy.NO_CACHE);
            return a;
        } finally {
            TracerDetour.a(976345520);
        }
    }

    public final void m10529c(FetchFeedResult fetchFeedResult) {
        DbFeedHomeStoriesHandler.m9126a(fetchFeedResult);
    }
}

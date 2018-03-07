package com.facebook.feed.loader;

import com.facebook.analytics.cache.CacheTracker;
import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedcache.db.FeedDbInsertionCoordinator;
import com.facebook.api.feedcache.memory.FeedUnitCache;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.CachePolicy;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sans-serif */
public class FeedFetcherCache {
    private static volatile FeedFetcherCache f6295f;
    private final CacheTracker f6296a;
    private final CacheTracker f6297b;
    private final FeedDbInsertionCoordinator f6298c;
    private final DbFeedHomeStoriesHandler f6299d;
    private final FeedUnitCache f6300e;

    public static com.facebook.feed.loader.FeedFetcherCache m10533a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6295f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.loader.FeedFetcherCache.class;
        monitor-enter(r1);
        r0 = f6295f;	 Catch:{ all -> 0x003a }
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
        r0 = m10534b(r0);	 Catch:{ all -> 0x0035 }
        f6295f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6295f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.loader.FeedFetcherCache.a(com.facebook.inject.InjectorLike):com.facebook.feed.loader.FeedFetcherCache");
    }

    private static FeedFetcherCache m10534b(InjectorLike injectorLike) {
        return new FeedFetcherCache(Factory.m9186a(injectorLike), FeedDbInsertionCoordinator.m10538a(injectorLike), DbFeedHomeStoriesHandler.m9120a(injectorLike), FeedUnitCache.m10541a(injectorLike));
    }

    @Inject
    public FeedFetcherCache(Factory factory, FeedDbInsertionCoordinator feedDbInsertionCoordinator, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler, FeedUnitCache feedUnitCache) {
        this.f6298c = feedDbInsertionCoordinator;
        this.f6299d = dbFeedHomeStoriesHandler;
        this.f6300e = feedUnitCache;
        this.f6296a = factory.m9188a("feed_db_request");
        this.f6297b = factory.m9188a("feed_db_entries");
    }

    public final void m10536b(FetchFeedResult fetchFeedResult) {
        this.f6298c.m10540a(fetchFeedResult);
    }

    public final void m10535a(FetchFeedResult fetchFeedResult) {
        FeedType feedType = fetchFeedResult.f15756a.f5784b;
        if ((feedType.m8964e() != CachePolicy.NO_CACHE ? 1 : null) == null) {
            return;
        }
        if (!fetchFeedResult.m22439d().isEmpty()) {
            this.f6296a.mo1345b();
            this.f6297b.m9305b((long) fetchFeedResult.m22439d().size());
            if (feedType.m8964e() == CachePolicy.DISK_AND_MEMORY_CACHE) {
                m10536b(fetchFeedResult);
            }
            m10537c(fetchFeedResult);
        } else if (feedType.m8964e() == CachePolicy.DISK_AND_MEMORY_CACHE) {
            this.f6299d.m9173b(fetchFeedResult);
        }
    }

    public final void m10537c(FetchFeedResult fetchFeedResult) {
        FeedType feedType = fetchFeedResult.f15756a.f5784b;
        this.f6300e.m10554a(fetchFeedResult);
    }
}

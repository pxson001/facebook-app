package com.facebook.api.feedcache.db;

import com.facebook.analytics.cache.CacheTracker;
import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.FetchFeedParamsBuilder;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.CachePolicy;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.udppriming.client.ColdStartPrimingInformation;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.BlueServiceProgressCallback;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: webrtcTurnAllocationFetch */
public class FeedFetchCoordinator {
    private static volatile FeedFetchCoordinator f158h;
    private final AbstractFbErrorReporter f159a;
    private final PerformanceLogger f160b;
    private final DbFeedHomeStoriesHandler f161c;
    private final FeedDbInsertionCoordinator f162d;
    private final Clock f163e;
    private final CacheTracker f164f;
    private final CacheTracker f165g;

    public static com.facebook.api.feedcache.db.FeedFetchCoordinator m192a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f158h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.db.FeedFetchCoordinator.class;
        monitor-enter(r1);
        r0 = f158h;	 Catch:{ all -> 0x003a }
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
        r0 = m193b(r0);	 Catch:{ all -> 0x0035 }
        f158h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f158h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.db.FeedFetchCoordinator.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.db.FeedFetchCoordinator");
    }

    private static FeedFetchCoordinator m193b(InjectorLike injectorLike) {
        return new FeedFetchCoordinator((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), Factory.a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), DbFeedHomeStoriesHandler.a(injectorLike), FeedDbInsertionCoordinator.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FeedFetchCoordinator(AbstractFbErrorReporter abstractFbErrorReporter, Factory factory, PerformanceLogger performanceLogger, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler, FeedDbInsertionCoordinator feedDbInsertionCoordinator, Clock clock) {
        this.f159a = abstractFbErrorReporter;
        this.f160b = performanceLogger;
        this.f161c = dbFeedHomeStoriesHandler;
        this.f162d = feedDbInsertionCoordinator;
        this.f163e = clock;
        this.f164f = factory.a("feed_db_request");
        this.f165g = factory.a("feed_db_entries");
    }

    private FetchFeedResult m191a(FetchFeedParams fetchFeedParams) {
        TracerDetour.a("FeedFetchCoordinator.readFromDbCache", -814745895);
        try {
            if (fetchFeedParams.d() == null) {
                this.f159a.c("LastNewerStoriesRequestFromDb_" + fetchFeedParams.e(), fetchFeedParams + " time=" + this.f163e.a());
            } else {
                this.f159a.c("LastOlderStoriesRequestFromDb_" + fetchFeedParams.e(), fetchFeedParams + " time=" + this.f163e.a());
            }
            FetchFeedResult a = this.f161c.a(fetchFeedParams);
            if (a == null || DataFreshnessResult.NO_DATA == a.a()) {
                TracerDetour.a(-1814885285);
                return null;
            }
            this.f164f.a();
            this.f165g.a((long) a.d().size());
            return a;
        } finally {
            TracerDetour.a(-1648706615);
        }
    }

    public final FetchFeedResult m194a(FetchFeedParams fetchFeedParams, BlueServiceProgressCallback blueServiceProgressCallback, FeedBackendFetch feedBackendFetch) {
        FetchFeedResult fetchFeedResult = null;
        TracerDetour.a("FeedFetchCoordinator.handleFetchNewsFeed", -1494740930);
        try {
            CachePolicy e = fetchFeedParams.f().e();
            if (e == CachePolicy.NO_CACHE || e == CachePolicy.MEMORY_ONLY_CACHE) {
                fetchFeedResult = feedBackendFetch.mo16a(fetchFeedParams, blueServiceProgressCallback);
                return fetchFeedResult;
            }
            if (fetchFeedParams.c() != null && fetchFeedParams.c().equals("cold_start_cursor")) {
                String i;
                if (FeedType.b.equals(fetchFeedParams.f())) {
                    i = ColdStartPrimingInformation.a().i();
                } else {
                    i = null;
                }
                if (i == null) {
                    i = this.f161c.c(fetchFeedParams.f());
                }
                fetchFeedParams = new FetchFeedParamsBuilder().a(fetchFeedParams).b(i).q();
            } else if (fetchFeedParams.e() != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
                if (this.f160b.h(655361, "NNFColdStart")) {
                    this.f160b.d(655442, "NNFCold_DbCache");
                }
                try {
                    fetchFeedResult = m191a(fetchFeedParams);
                    if (this.f160b.h(655361, "NNFColdStart")) {
                        if (fetchFeedResult != null) {
                            this.f160b.c(655442, "NNFCold_DbCache");
                        } else {
                            this.f160b.a(655442, "NNFCold_DbCache");
                        }
                    }
                } catch (Throwable th) {
                    if (this.f160b.h(655361, "NNFColdStart")) {
                        this.f160b.a(655442, "NNFCold_DbCache");
                    }
                }
            }
            if (fetchFeedParams.h() != FetchFeedCause.SKIP_TAIL_GAP) {
                if (fetchFeedResult == null || fetchFeedResult.d().isEmpty()) {
                    if (!fetchFeedParams.m()) {
                        if (fetchFeedParams.e() == DataFreshnessParam.DO_NOT_CHECK_SERVER) {
                            fetchFeedResult = FetchFeedResult.a(fetchFeedParams);
                            TracerDetour.a(1878747317);
                        } else if (fetchFeedParams.e() == DataFreshnessParam.STALE_DATA_OKAY && fetchFeedParams.d() == null && fetchFeedParams.c() == null) {
                            fetchFeedResult = FetchFeedResult.a(fetchFeedParams);
                            TracerDetour.a(1782280610);
                        }
                        return fetchFeedResult;
                    }
                    fetchFeedResult = feedBackendFetch.mo16a(fetchFeedParams, blueServiceProgressCallback);
                    if (fetchFeedResult != null) {
                        this.f164f.b();
                        this.f165g.b((long) fetchFeedResult.d().size());
                        if (fetchFeedResult.d().isEmpty()) {
                            this.f161c.b(fetchFeedResult);
                        } else {
                            DbFeedHomeStoriesHandler.a(fetchFeedResult);
                            this.f162d.a(fetchFeedResult);
                        }
                    }
                } else if (fetchFeedResult != null) {
                    this.f161c.b(fetchFeedResult);
                }
            }
            TracerDetour.a(-1556449422);
            return fetchFeedResult;
        } finally {
            TracerDetour.a(-1115628449);
        }
    }
}

package com.facebook.feed.data;

import android.os.Handler;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feedcache.db.FeedBackendFetch;
import com.facebook.api.feedcache.db.FeedFetchCoordinator;
import com.facebook.api.feedtype.FeedType.CachePolicy;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_FeedFetchExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.loader.FeedFetcherCache;
import com.facebook.feed.loader.FeedLoaderParams;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: webrtc_application_receive */
public class FeedFetcher {
    private static final String f150a = FeedFetcher.class.getSimpleName();
    private final ExecutorService f151b;
    public final FeedFetchCoordinator f152c;
    @ForUiThread
    public final Handler f153d;
    public final Lazy<FeedFetcherCache> f154e;
    public final Lazy<FeedFetcherProcessor> f155f;
    public final GraphQLQueryExecutorFeedFetchProvider f156g;
    public final Lazy<FeedDataLoaderReranker> f157h;

    /* compiled from: webrtc_application_receive */
    public class FeedFetcherRunnable implements Runnable {
        final /* synthetic */ FeedFetcher f194a;
        public final FeedLoaderParams f195b;

        FeedFetcherRunnable(FeedFetcher feedFetcher, FeedLoaderParams feedLoaderParams) {
            this.f194a = feedFetcher;
            this.f195b = feedLoaderParams;
        }

        public void run() {
            TracerDetour.a("FeedFetcher.run", 2075529538);
            try {
                if (this.f195b.m213a().h() == FetchFeedCause.INITIALIZATION_RERANK) {
                    ((FeedDataLoaderReranker) this.f194a.f157h.get()).a();
                }
                TracerDetour.a("FeedFetcher.run.getQueryExecutorFetcher", 1983612622);
                int i;
                try {
                    GraphQLQueryExecutorFeedFetchProvider graphQLQueryExecutorFeedFetchProvider = this.f194a.f156g;
                    i = this.f195b;
                    FeedBackendFetch a = graphQLQueryExecutorFeedFetchProvider.m195a(i);
                    TracerDetour.a(i);
                    FetchFeedResult a2 = this.f194a.f152c.m194a(this.f195b.m213a(), null, a);
                    if (this.f195b.m214b() == DataFreshnessParam.DO_NOT_CHECK_SERVER || a2 != null) {
                        FetchFeedResult a3;
                        if (a2 == null) {
                            a3 = FetchFeedResult.a(this.f195b.m213a());
                        } else {
                            a3 = a2;
                        }
                        a3 = ((FeedFetcherProcessor) this.f194a.f155f.get()).a(a3);
                        if (this.f195b.m213a().f().e() != CachePolicy.NO_CACHE) {
                            ((FeedFetcherCache) this.f194a.f154e.get()).c(a3);
                        }
                        HandlerDetour.a(this.f194a.f153d, new Runnable(this) {
                            final /* synthetic */ FeedFetcherRunnable f7106b;

                            public void run() {
                                this.f7106b.f195b.f192f.a(a3);
                                this.f7106b.f195b.f192f.a();
                            }
                        }, 2101604311);
                        TracerDetour.a(-435135181);
                    }
                } finally {
                    i = 255391247;
                    TracerDetour.a(255391247);
                }
            } catch (Exception e) {
                HandlerDetour.a(this.f194a.f153d, new 2(this, e), 34063029);
            } finally {
                TracerDetour.a(1679699606);
            }
        }
    }

    public static FeedFetcher m189a(InjectorLike injectorLike) {
        return new FeedFetcher((ExecutorService) ListeningExecutorService_FeedFetchExecutorServiceMethodAutoProvider.a(injectorLike), FeedFetchCoordinator.m192a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 1417), IdBasedSingletonScopeProvider.b(injectorLike, 1311), (GraphQLQueryExecutorFeedFetchProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GraphQLQueryExecutorFeedFetchProvider.class), IdBasedLazy.a(injectorLike, 1309));
    }

    @Inject
    public FeedFetcher(ExecutorService executorService, FeedFetchCoordinator feedFetchCoordinator, Handler handler, Lazy<FeedFetcherCache> lazy, Lazy<FeedFetcherProcessor> lazy2, GraphQLQueryExecutorFeedFetchProvider graphQLQueryExecutorFeedFetchProvider, Lazy<FeedDataLoaderReranker> lazy3) {
        this.f151b = executorService;
        this.f152c = feedFetchCoordinator;
        this.f153d = handler;
        this.f154e = lazy;
        this.f155f = lazy2;
        this.f156g = graphQLQueryExecutorFeedFetchProvider;
        this.f157h = lazy3;
    }

    public final void m190a(FeedLoaderParams feedLoaderParams) {
        ExecutorDetour.a(this.f151b, new FeedFetcherRunnable(this, feedLoaderParams), -833038963);
    }
}

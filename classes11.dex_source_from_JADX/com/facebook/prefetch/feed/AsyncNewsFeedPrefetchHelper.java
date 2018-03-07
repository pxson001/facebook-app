package com.facebook.prefetch.feed;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.FetchFeedParamsBuilder;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.xconfig.AsyncFeedXConfigReader;
import com.facebook.api.feed.xconfig.NewsFeedXConfigReader;
import com.facebook.api.feedcache.db.DBFeedRerankHandler;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedcache.db.FeedDbMutationService;
import com.facebook.api.feedtype.FeedType;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.data.FeedFetcherProcessor;
import com.facebook.feed.loader.FeedFetcherCache;
import com.facebook.feed.loader.FetchFeedParamsGenerator;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.feed.ui.feedprefetch.FeedPrefetchLoader;
import com.facebook.feed.ui.imageloader.AsyncFeedImagePrefetchHelper;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLModelFlatbufferHelper;
import com.facebook.graphql.model.GraphQLNewsFeedEdge;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.adaptiveimagequality.base.ImageQuality;
import com.facebook.prefetch.feed.NewsFeedPrefetchConditionCheck.ConditionCheckResult;
import com.facebook.prefetch.feed.scheduler.NewsFeedPrefetchException;
import com.facebook.prefetch.feed.scheduler.NewsFeedPrefetchHelper;
import com.facebook.prefetch.feed.scheduler.NewsFeedPrefetchPrediction;
import com.facebook.prefetch.feed.scheduler.NewsFeedPrefetcher;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: TE;I */
public class AsyncNewsFeedPrefetchHelper implements NewsFeedPrefetchHelper {
    public static final Class<?> f10794a = AsyncNewsFeedPrefetchHelper.class;
    private static final FeedType f10795b = NewsFeedPrefetchRequestHandler.f10821a;
    private static final String f10796c = null;
    private static final Object f10797y = new Object();
    private final NewsFeedPrefetchRequestHandler f10798d;
    private final NewsFeedPrefetchConditionCheck f10799e;
    private final QeAccessor f10800f;
    public final Provider<Boolean> f10801g;
    private final ListeningExecutorService f10802h;
    private final FetchFeedParamsGenerator f10803i;
    public final Clock f10804j;
    public final FeedFetcherProcessor f10805k;
    public final FeedFetcherCache f10806l;
    public final FbSharedPreferences f10807m;
    public final DbFeedHomeStoriesHandler f10808n;
    public final AsyncFeedXConfigReader f10809o;
    private final AnalyticsLogger f10810p;
    private final FbNetworkManager f10811q;
    public final AsyncFeedImagePrefetchHelper f10812r;
    public final NewsFeedPrefetcher f10813s;
    public final FeedPrefetchLoader f10814t;
    public final DBFeedRerankHandler f10815u;
    public final NewsFeedXConfigReader f10816v;
    private final FeedDbMutationService f10817w;
    private final NewsFeedPrefetchPrediction f10818x;

    /* compiled from: TE;I */
    class C12821 implements Runnable {
        final /* synthetic */ AsyncNewsFeedPrefetchHelper f10788a;

        C12821(AsyncNewsFeedPrefetchHelper asyncNewsFeedPrefetchHelper) {
            this.f10788a = asyncNewsFeedPrefetchHelper;
        }

        public void run() {
            this.f10788a.m11296b();
        }
    }

    private static AsyncNewsFeedPrefetchHelper m11293b(InjectorLike injectorLike) {
        return new AsyncNewsFeedPrefetchHelper(NewsFeedPrefetchRequestHandler.m11298a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3981), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), NewsFeedPrefetchConditionCheck.m11297a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), FetchFeedParamsGenerator.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FeedFetcherProcessor.a(injectorLike), FeedFetcherCache.a(injectorLike), DbFeedHomeStoriesHandler.a(injectorLike), AsyncFeedXConfigReader.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike), AsyncFeedImagePrefetchHelper.a(injectorLike), NewsFeedPrefetcher.a(injectorLike), FeedPrefetchLoader.a(injectorLike), DBFeedRerankHandler.a(injectorLike), NewsFeedXConfigReader.a(injectorLike), FeedDbMutationService.a(injectorLike), NewsFeedPrefetchPrediction.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.prefetch.feed.AsyncNewsFeedPrefetchHelper m11290a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f10797y;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m11293b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f10797y;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.prefetch.feed.AsyncNewsFeedPrefetchHelper) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.prefetch.feed.AsyncNewsFeedPrefetchHelper) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f10797y;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.prefetch.feed.AsyncNewsFeedPrefetchHelper) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.prefetch.feed.AsyncNewsFeedPrefetchHelper.a(com.facebook.inject.InjectorLike):com.facebook.prefetch.feed.AsyncNewsFeedPrefetchHelper");
    }

    @Inject
    public AsyncNewsFeedPrefetchHelper(NewsFeedPrefetchRequestHandler newsFeedPrefetchRequestHandler, QeAccessor qeAccessor, Provider<Boolean> provider, FbSharedPreferences fbSharedPreferences, NewsFeedPrefetchConditionCheck newsFeedPrefetchConditionCheck, ListeningExecutorService listeningExecutorService, FetchFeedParamsGenerator fetchFeedParamsGenerator, Clock clock, FeedFetcherProcessor feedFetcherProcessor, FeedFetcherCache feedFetcherCache, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler, AsyncFeedXConfigReader asyncFeedXConfigReader, AnalyticsLogger analyticsLogger, FbNetworkManager fbNetworkManager, AsyncFeedImagePrefetchHelper asyncFeedImagePrefetchHelper, NewsFeedPrefetcher newsFeedPrefetcher, FeedPrefetchLoader feedPrefetchLoader, DBFeedRerankHandler dBFeedRerankHandler, NewsFeedXConfigReader newsFeedXConfigReader, FeedDbMutationService feedDbMutationService, NewsFeedPrefetchPrediction newsFeedPrefetchPrediction) {
        this.f10798d = newsFeedPrefetchRequestHandler;
        this.f10800f = qeAccessor;
        this.f10801g = provider;
        this.f10807m = fbSharedPreferences;
        this.f10799e = newsFeedPrefetchConditionCheck;
        this.f10802h = listeningExecutorService;
        this.f10803i = fetchFeedParamsGenerator;
        this.f10804j = clock;
        this.f10805k = feedFetcherProcessor;
        this.f10806l = feedFetcherCache;
        this.f10808n = dbFeedHomeStoriesHandler;
        this.f10809o = asyncFeedXConfigReader;
        this.f10810p = analyticsLogger;
        this.f10811q = fbNetworkManager;
        this.f10812r = asyncFeedImagePrefetchHelper;
        this.f10813s = newsFeedPrefetcher;
        this.f10814t = feedPrefetchLoader;
        this.f10815u = dBFeedRerankHandler;
        this.f10816v = newsFeedXConfigReader;
        this.f10817w = feedDbMutationService;
        this.f10818x = newsFeedPrefetchPrediction;
    }

    public final ListenableFuture<?> m11295a() {
        ConditionCheckResult conditionCheckResult;
        NewsFeedPrefetchConditionCheck newsFeedPrefetchConditionCheck = this.f10799e;
        if (!newsFeedPrefetchConditionCheck.f10820b.b()) {
            conditionCheckResult = ConditionCheckResult.NOT_LOGGED_IN;
        } else if (newsFeedPrefetchConditionCheck.f10819a.j()) {
            conditionCheckResult = ConditionCheckResult.SUCCESS;
        } else {
            conditionCheckResult = ConditionCheckResult.APP_NOT_IN_BACKGROUND;
        }
        ConditionCheckResult conditionCheckResult2 = conditionCheckResult;
        if (conditionCheckResult2 == ConditionCheckResult.SUCCESS) {
            return this.f10802h.a(new C12821(this));
        }
        m11292a("failure_conditions", this.f10804j.a(), 0, 0, conditionCheckResult2.toString());
        this.f10813s.a(60);
        return Futures.a(new NewsFeedPrefetchException("Prefetch conditions not satisfied"));
    }

    @VisibleForTesting
    protected final void m11296b() {
        int i = 0;
        if (m11294d()) {
            i = (int) this.f10818x.c();
        }
        if (i == 0) {
            i = this.f10809o.b(50);
        }
        final FetchFeedParams a = m11289a(i);
        final long a2 = this.f10804j.a();
        this.f10817w.init();
        this.f10798d.m11299a(a, "async-feed-prefetch", new RequestObserver<GraphQLResult<GraphQLViewer>>(this) {
            final /* synthetic */ AsyncNewsFeedPrefetchHelper f10792d;
            private int f10793e = 0;

            public final void m11287a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                this.f10792d.f10807m.edit().a(FeedPrefKeys.e, graphQLResult.clientTimeMs).commit();
                if (((GraphQLViewer) graphQLResult.e).A() != null && ((GraphQLViewer) graphQLResult.e).A().j().size() != 0) {
                    ImmutableList j = ((GraphQLViewer) graphQLResult.e).A().j();
                    Builder builder = new Builder();
                    int size = j.size();
                    for (int i = 0; i < size; i++) {
                        FeedUnit feedUnit;
                        GraphQLNewsFeedEdge graphQLNewsFeedEdge = (GraphQLNewsFeedEdge) j.get(i);
                        FeedUnit o = graphQLNewsFeedEdge.o();
                        if (o == null) {
                            feedUnit = o;
                        } else if (!((Boolean) this.f10792d.f10801g.get()).booleanValue() || o.w_() == null) {
                            feedUnit = (FeedUnit) GraphQLModelFlatbufferHelper.a(graphQLNewsFeedEdge.o());
                        } else {
                            int g = o.w_().g(graphQLNewsFeedEdge.u_(), 6);
                            if (g != 0) {
                                o.w_().a(g);
                            }
                            feedUnit = o;
                        }
                        GraphQLFeedUnitEdge.Builder builder2 = new GraphQLFeedUnitEdge.Builder();
                        builder2.i = feedUnit;
                        GraphQLFeedUnitEdge.Builder builder3 = builder2;
                        builder3.f = graphQLNewsFeedEdge.k();
                        builder3 = builder3;
                        builder3.k = graphQLNewsFeedEdge.q();
                        builder3 = builder3;
                        builder3.e = graphQLNewsFeedEdge.j();
                        builder3 = builder3;
                        builder3.j = graphQLNewsFeedEdge.p();
                        builder3 = builder3;
                        builder3.h = graphQLNewsFeedEdge.m();
                        builder3 = builder3;
                        builder3.g = graphQLNewsFeedEdge.l();
                        builder.c(builder3.a());
                    }
                    FetchFeedParams fetchFeedParams = a;
                    GraphQLFeedHomeStories.Builder builder4 = new GraphQLFeedHomeStories.Builder();
                    builder4.f = builder.b();
                    GraphQLFeedHomeStories.Builder builder5 = builder4;
                    builder5.i = ((GraphQLViewer) graphQLResult.e).A().l();
                    FetchFeedResult fetchFeedResult = new FetchFeedResult(fetchFeedParams, builder5.a(), DataFreshnessResult.FROM_SERVER, this.f10792d.f10804j.a(), false);
                    FetchFeedResult a = this.f10792d.f10805k.a(fetchFeedResult);
                    this.f10792d.f10806l.b(a);
                    this.f10792d.f10814t.a(a);
                    this.f10793e = fetchFeedResult.d().size() + this.f10793e;
                }
            }

            public final void m11286a() {
                this.f10792d.m11292a("success", a2, (long) this.f10793e, i, "");
                this.f10792d.f10815u.a(this.f10792d.f10809o.a("ranking_weight"));
                ImmutableList a = this.f10792d.f10808n.a(FeedType.b, TimeUnit.HOURS.toMillis((long) this.f10792d.f10816v.i()));
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    ClientFeedUnitEdge clientFeedUnitEdge = (ClientFeedUnitEdge) a.get(i);
                    if (clientFeedUnitEdge.z() == 0) {
                        this.f10792d.f10812r.a(clientFeedUnitEdge.c());
                    }
                }
                this.f10792d.f10812r.a(ImageQuality.OFF);
                this.f10792d.f10813s.a();
            }

            public final void m11288a(Throwable th) {
                this.f10792d.m11292a("failure", a2, (long) this.f10793e, i, th.getMessage());
                BLog.b(AsyncNewsFeedPrefetchHelper.f10794a, "loadDataForAsyncFeed error", th);
                this.f10792d.f10813s.a(60);
            }
        });
    }

    @VisibleForTesting
    private FetchFeedParams m11289a(int i) {
        FetchFeedParams a = this.f10803i.a(f10795b, this.f10808n.c(f10795b), i, false, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, FetchFeedCause.PREFETCH);
        String str = a.d;
        if (str == null || !str.equals("cold_start_cursor")) {
            return a;
        }
        FetchFeedParamsBuilder a2 = new FetchFeedParamsBuilder().a(a);
        a2.g = f10796c;
        return a2.q();
    }

    private boolean m11294d() {
        return this.f10800f.a(ExperimentsForNewsFeedAbTestModule.c, false);
    }

    private void m11292a(String str, long j, long j2, int i, String str2) {
        HoneyClientEventFast a = this.f10810p.a("android_async_feed_prefetch", false);
        if (a.a()) {
            a.a("stop_reason", str);
            a.a("network_type", this.f10811q.k());
            a.a("network_subtype", this.f10811q.l());
            a.a("total_time", this.f10804j.a() - j);
            a.a("total_stories_count", j2);
            a.a("stories_to_fetch", i);
            a.a("predictive_enabled", m11294d());
            a.a("extra_field", str2);
            a.b();
        }
    }
}

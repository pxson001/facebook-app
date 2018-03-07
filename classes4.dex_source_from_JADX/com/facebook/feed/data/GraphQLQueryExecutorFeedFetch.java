package com.facebook.feed.data;

import android.os.Handler;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParams.FetchTypeForLogging;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.data.FetchPortion;
import com.facebook.api.feedcache.db.FeedBackendFetch;
import com.facebook.common.executors.ForUiThread;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.BlueServiceProgressCallback;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.data.util.StreamingFeedLogger;
import com.facebook.feed.loader.FeedFetcherCache;
import com.facebook.feed.loader.FeedLoaderParams;
import com.facebook.feed.protocol.FetchFeedMethod.FetcherCallback;
import com.facebook.feed.sponsored.SponsoredUtils;
import com.facebook.feedback.prefetcher.FeedbackPrefetcher;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.graphql.model.GraphQLFeedHomeStories.Builder;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: warm_mapped_files_ */
public class GraphQLQueryExecutorFeedFetch implements FeedBackendFetch, FetcherCallback, RequestObserver<GraphQLResult> {
    protected GraphQLFeedHomeStories f196a;
    protected FetchFeedParams f197b;
    public final FeedLoaderParams f198c;
    private final GraphQLQueryExecutor f199d;
    @ForUiThread
    private final Handler f200e;
    private final Lazy<FeedFetcherCache> f201f;
    private final Lazy<FeedFetcherProcessor> f202g;
    private final StreamingFeedLogger f203h;
    private boolean f204i = false;
    private boolean f205j = false;
    private Provider<Boolean> f206k;
    private final ExecutorService f207l;
    public final FeedbackPrefetcher f208m;
    public final QeAccessor f209n;
    private boolean f210o = false;
    private boolean f211p;
    private int f212q = 0;
    private boolean f213r = false;
    private final RequestObserver<GraphQLResult> f214s = new C00111(this);

    /* compiled from: warm_mapped_files_ */
    class C00111 implements RequestObserver<GraphQLResult> {
        final /* synthetic */ GraphQLQueryExecutorFeedFetch f220a;

        C00111(GraphQLQueryExecutorFeedFetch graphQLQueryExecutorFeedFetch) {
            this.f220a = graphQLQueryExecutorFeedFetch;
        }

        public final void m238a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLResult.e;
            String str = null;
            Map map = graphQLResult.j;
            if (map != null) {
                str = (String) map.get("comment_id");
            }
            this.f220a.f208m.a(graphQLFeedback, false, str);
            if (this.f220a.f209n.a(ExperimentsForNewsFeedAbTestModule.u, false)) {
                this.f220a.f208m.a(graphQLFeedback, true, str);
            }
        }

        public final void m237a() {
        }

        public final void m239a(Throwable th) {
        }
    }

    /* compiled from: warm_mapped_files_ */
    class C00242 implements Runnable {
        final /* synthetic */ GraphQLQueryExecutorFeedFetch f235a;

        C00242(GraphQLQueryExecutorFeedFetch graphQLQueryExecutorFeedFetch) {
            this.f235a = graphQLQueryExecutorFeedFetch;
        }

        public void run() {
            if (!this.f235a.f198c.f192f.b()) {
                this.f235a.f198c.f192f.a();
            }
        }
    }

    public final void m225a(Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        TracerDetour.a("GraphQLQueryExecutorFeedFetch.onNext", 840276183);
        try {
            GraphQLFeedHomeStories b;
            GraphQLFeedHomeStories a = this.f198c.m215c().a(this.f197b, graphQLResult);
            if (a == null) {
                this.f203h.m235b(this.f197b);
                if (FetchTypeForLogging.HEAD == this.f197b.j()) {
                    b = m220b();
                } else {
                    TracerDetour.a(-231836333);
                    return;
                }
            }
            b = a;
            int size = b.k().size();
            for (int i = 0; i < size; i++) {
                this.f203h.m232a();
            }
            this.f212q += size;
            if (b.n() != null) {
                this.f213r = b.n().b();
            }
            if (!this.f205j && size > 0) {
                GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) b.k().get(size - 1);
                FeedUnit c = graphQLFeedUnitEdge.c();
                if (graphQLFeedUnitEdge.l() || SponsoredUtils.a(c)) {
                    this.f205j = true;
                }
            }
            if (this.f205j) {
                m218a(b);
            } else {
                this.f204i = true;
                m221c(b);
            }
            TracerDetour.a(780239920);
        } catch (Throwable th) {
            TracerDetour.a(165252963);
        }
    }

    @Inject
    public GraphQLQueryExecutorFeedFetch(@Assisted FeedLoaderParams feedLoaderParams, GraphQLQueryExecutor graphQLQueryExecutor, Handler handler, Lazy<FeedFetcherCache> lazy, Lazy<FeedFetcherProcessor> lazy2, StreamingFeedLogger streamingFeedLogger, Provider<Boolean> provider, ExecutorService executorService, FeedbackPrefetcher feedbackPrefetcher, QeAccessor qeAccessor) {
        this.f198c = feedLoaderParams;
        this.f199d = graphQLQueryExecutor;
        this.f200e = handler;
        this.f201f = lazy;
        this.f202g = lazy2;
        this.f203h = streamingFeedLogger;
        this.f206k = provider;
        this.f207l = executorService;
        this.f196a = m220b();
        this.f208m = feedbackPrefetcher;
        this.f209n = qeAccessor;
    }

    @Nullable
    public final FetchFeedResult mo16a(FetchFeedParams fetchFeedParams, BlueServiceProgressCallback blueServiceProgressCallback) {
        TracerDetour.a("GraphQLQueryExecutorFeedFetch.runBackendFetch", -789861965);
        try {
            if (fetchFeedParams.e() != DataFreshnessParam.DO_NOT_CHECK_SERVER) {
                this.f198c.m215c().a(this.f198c.m213a());
                this.f197b = fetchFeedParams;
                boolean z = ((Boolean) this.f206k.get()).booleanValue() && FetchTypeForLogging.TAIL == fetchFeedParams.j();
                this.f205j = z;
                GraphQLBatchRequest a = this.f198c.m215c().a(fetchFeedParams, this.f198c.m216d(), this);
                this.f211p = a.i();
                this.f203h.m233a(fetchFeedParams);
                this.f196a = m220b();
                this.f199d.a(a, this.f207l);
                TracerDetour.a(-263536462);
            }
            return null;
        } finally {
            TracerDetour.a(1561986106);
        }
    }

    public final void m224a() {
        TracerDetour.a("GraphQLQueryExecutorFeedFetch.onCompleted", 2130753562);
        try {
            if (!(this.f204i && this.f196a.k().isEmpty())) {
                m221c(this.f196a);
            }
            if (!this.f198c.m217f().b()) {
                HandlerDetour.a(this.f200e, new C00242(this), 411044671);
            }
            this.f203h.m234a(this.f197b, this.f212q, this.f213r);
            this.f198c.m215c().b(this.f198c.m213a());
        } finally {
            TracerDetour.a(1924848147);
        }
    }

    public final void m226a(Throwable th) {
        if (!this.f198c.f192f.b()) {
            if (!this.f196a.k().isEmpty()) {
                m221c(this.f196a);
            }
            HandlerDetour.a(this.f200e, new 3(this, th), -1570793917);
        } else if (!this.f196a.k().isEmpty()) {
            m219b(this.f196a);
        }
        this.f203h.m236b(this.f197b, this.f212q, this.f213r);
        this.f198c.f189c.a(this.f198c.f187a, new Exception(th));
    }

    private static GraphQLFeedHomeStories m220b() {
        Builder builder = new Builder();
        builder.f = RegularImmutableList.a;
        builder = builder;
        builder.i = new GraphQLPageInfo();
        return builder.a();
    }

    private void m218a(GraphQLFeedHomeStories graphQLFeedHomeStories) {
        GraphQLPageInfo n;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        builder.b(this.f196a.k());
        builder.b(graphQLFeedHomeStories.k());
        if (graphQLFeedHomeStories.n() == null) {
            n = this.f196a.n();
        } else if (this.f196a.n().v_() == null) {
            n = graphQLFeedHomeStories.n();
        } else {
            GraphQLPageInfo.Builder a = GraphQLPageInfo.Builder.a(this.f196a.n());
            a.f = graphQLFeedHomeStories.n().b();
            a = a;
            if (graphQLFeedHomeStories.n().a() != null) {
                a.e = graphQLFeedHomeStories.n().a();
            }
            n = a.a();
        }
        Builder builder2 = new Builder();
        builder2.f = builder.b();
        Builder builder3 = builder2;
        builder3.i = n;
        Builder builder4 = builder3;
        builder4.e = graphQLFeedHomeStories.j();
        builder4 = builder4;
        builder4.h = graphQLFeedHomeStories.m();
        this.f196a = builder4.a();
    }

    private FetchFeedResult m219b(GraphQLFeedHomeStories graphQLFeedHomeStories) {
        FetchPortion fetchPortion;
        if (this.f210o) {
            fetchPortion = FetchPortion.CHUNKED_REMAINDER;
        } else {
            fetchPortion = FetchPortion.CHUNKED_INITIAL;
            if (!(graphQLFeedHomeStories == null || graphQLFeedHomeStories.n() == null || !graphQLFeedHomeStories.n().b())) {
                this.f210o = true;
            }
        }
        FetchFeedResult a = ((FeedFetcherProcessor) this.f202g.get()).a(new FetchFeedResult(this.f197b, graphQLFeedHomeStories, DataFreshnessResult.FROM_SERVER, this.f198c.f191e, this.f211p, fetchPortion));
        ((FeedFetcherCache) this.f201f.get()).a(a);
        return a;
    }

    private void m221c(GraphQLFeedHomeStories graphQLFeedHomeStories) {
        final FetchFeedResult b = m219b(graphQLFeedHomeStories);
        if (!this.f198c.f192f.b()) {
            if (b.d().size() > 0) {
                this.f198c.f193g = true;
            }
            HandlerDetour.a(this.f200e, new Runnable(this) {
                final /* synthetic */ GraphQLQueryExecutorFeedFetch f234b;

                public void run() {
                    if (!this.f234b.f198c.f192f.b()) {
                        this.f234b.f198c.f192f.a(b);
                    }
                }
            }, -426950193);
        }
    }

    public final RequestObserver<GraphQLResult> m223a(String str) {
        if ("feed_subscriber".equals(str)) {
            return this;
        }
        if ("feedback_subscriber".equals(str)) {
            return this.f214s;
        }
        throw new RuntimeException("Unrecognized GraphQL Subscriber:" + str);
    }
}

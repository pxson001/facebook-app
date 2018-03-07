package com.facebook.feed.protocol;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.FetchFeedParamsBuilder;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.InvalidFeedServerResponseException;
import com.facebook.api.ufiservices.FeedbackPrefetchPolicy;
import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.graphql.model.DedupableUtil;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQLRefParam;
import com.facebook.graphql.query.GraphQLRefParam.BatchQueryFanOutStyle;
import com.facebook.graphql.query.GraphQLRefParam.FallbackStyle;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethodEvents;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.qe.api.QeAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: screen_scale */
public abstract class FetchFeedMethod extends AbstractPersistedGraphQlApiMethod<FetchFeedParams, FetchFeedResult> implements ApiMethodEvents<FetchFeedParams> {
    protected final FetchFeedbackMethod f5995c;
    protected final Clock f5996d;
    private final GraphQLProtocolHelper f5997e;
    private final AbstractFbErrorReporter f5998f;
    private final StartupPerfLogger f5999g;
    private final QeAccessor f6000h;
    private final MonotonicClock f6001i;

    /* compiled from: screen_scale */
    public interface FetcherCallback<T> {
        RequestObserver<GraphQLResult<T>> mo1593a(String str);
    }

    protected abstract String mo1430c();

    protected abstract String mo1431c(FetchFeedParams fetchFeedParams);

    protected abstract int mo1432d(FetchFeedParams fetchFeedParams);

    public /* synthetic */ void mo1429b(Object obj) {
        mo1425a((FetchFeedParams) obj);
    }

    public /* synthetic */ void mo1434c(Object obj) {
        m10112b((FetchFeedParams) obj);
    }

    public final RequestPriority mo1435j(Object obj) {
        FetchFeedCause fetchFeedCause = ((FetchFeedParams) obj).f5788f;
        if (fetchFeedCause.isAutoRefresh()) {
            return RequestPriority.NON_INTERACTIVE;
        }
        if (fetchFeedCause == FetchFeedCause.PREFETCH) {
            return RequestPriority.CAN_WAIT;
        }
        return RequestPriority.INTERACTIVE;
    }

    public FetchFeedMethod(GraphQLProtocolHelper graphQLProtocolHelper, AbstractFbErrorReporter abstractFbErrorReporter, StartupPerfLogger startupPerfLogger, Clock clock, MonotonicClock monotonicClock, QeAccessor qeAccessor, FetchFeedbackMethod fetchFeedbackMethod) {
        super(graphQLProtocolHelper);
        this.f5997e = graphQLProtocolHelper;
        this.f5998f = abstractFbErrorReporter;
        this.f5999g = startupPerfLogger;
        this.f5996d = clock;
        this.f6001i = monotonicClock;
        this.f6000h = qeAccessor;
        this.f5995c = fetchFeedbackMethod;
    }

    public FetchFeedResult mo1420a(FetchFeedParams fetchFeedParams, ApiResponse apiResponse, JsonParser jsonParser) {
        String str = mo1431c(fetchFeedParams) + "_deserialize";
        int d = mo1432d(fetchFeedParams);
        try {
            long now = this.f6001i.now();
            GraphQLFeedHomeStories a = m10103a(fetchFeedParams, jsonParser);
            String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("%s_%d", str, Integer.valueOf(a.m22430k().size()));
            this.f5999g.m3455e(d, formatStrLocaleSafe, null, null, now);
            this.f5999g.m3459i(d, formatStrLocaleSafe);
            getClass().getSimpleName();
            new StringBuilder("Server result ").append(a);
            m10099a("fetch_feed_server_failure", fetchFeedParams, a);
            long a2 = this.f5996d.mo211a();
            ImmutableList k = a.m22430k();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) k.get(i);
                if (graphQLFeedUnitEdge.mo2540c() != null) {
                    FetchTimeMsHelper.m22314a(graphQLFeedUnitEdge.mo2540c(), a2);
                }
            }
            return new FetchFeedResult(new FetchFeedParamsBuilder().m9926a(fetchFeedParams).m9930q(), a, DataFreshnessResult.FROM_SERVER, a2, apiResponse.m22209g());
        } catch (Exception e) {
            this.f5999g.m3457g(d, str);
            throw e;
        }
    }

    protected GraphQLFeedHomeStories m10103a(FetchFeedParams fetchFeedParams, JsonParser jsonParser) {
        return (GraphQLFeedHomeStories) this.f5997e.m9439a(jsonParser, GraphQLFeedHomeStories.class, mo1430c());
    }

    public void mo1425a(FetchFeedParams fetchFeedParams) {
        this.f5999g.m3458h(mo1432d(fetchFeedParams), mo1431c(fetchFeedParams));
    }

    public void m10112b(FetchFeedParams fetchFeedParams) {
        this.f5999g.m3459i(mo1432d(fetchFeedParams), mo1431c(fetchFeedParams));
    }

    public void mo1426a(FetchFeedParams fetchFeedParams, Exception exception) {
        this.f5999g.m3452d(mo1432d(fetchFeedParams), mo1431c(fetchFeedParams), null, ImmutableBiMap.m978b("exception_name", exception.toString()), this.f6001i.now());
    }

    public GraphQLBatchRequest mo1421a(FetchFeedParams fetchFeedParams, String str, FetcherCallback fetcherCallback) {
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest(str + "_single");
        GraphQLRequest a = GraphQLRequest.m11586a(mo1433f(fetchFeedParams), GraphQLFeedHomeStories.class, mo1428b(fetchFeedParams, null));
        graphQLBatchRequest.m11217a(a).m11649a(fetcherCallback.mo1593a("feed_subscriber"));
        if (m10114b()) {
            m10109a(graphQLBatchRequest, a, fetcherCallback);
        }
        return graphQLBatchRequest;
    }

    protected boolean m10114b() {
        return false;
    }

    protected final void m10109a(GraphQLBatchRequest graphQLBatchRequest, GraphQLRequest graphQLRequest, FetcherCallback fetcherCallback) {
        boolean a = this.f6000h.mo596a(ExperimentsForNewsFeedAbTestModule.f5119t, false);
        RequestObserver a2 = fetcherCallback.mo1593a("feedback_subscriber");
        if (a2 != null && a) {
            GraphQLRefParam a3 = graphQLRequest.m11599a("feedback_prefetch_id", BatchQueryFanOutStyle.EACH, FallbackStyle.SKIP);
            GraphQLRefParam graphQLRefParam = null;
            if (this.f6000h.mo596a(ExperimentsForNewsFeedAbTestModule.f5116q, false) && this.f6000h.mo596a(ExperimentsForNewsFeedAbTestModule.f5122w, false)) {
                graphQLRefParam = graphQLRequest.m11599a("focused_comment_id", BatchQueryFanOutStyle.FIRST, FallbackStyle.ALLOW);
            }
            graphQLBatchRequest.m11217a(this.f5995c.m10196a(FeedbackPrefetchPolicy.m14359h(), a3, graphQLRefParam)).m11649a(a2);
        }
    }

    public GraphQLFeedHomeStories mo1422a(FetchFeedParams fetchFeedParams, GraphQLResult graphQLResult) {
        Object obj = graphQLResult.f6203e;
        if (obj instanceof GraphQLFeedHomeStories) {
            return (GraphQLFeedHomeStories) obj;
        }
        throw new RuntimeException("Unrecognized GraphQLResult:" + graphQLResult.toString());
    }

    protected final void m10110a(GraphQLFeedHomeStories graphQLFeedHomeStories) {
        graphQLFeedHomeStories.f15749f = m10104a(graphQLFeedHomeStories.m22430k());
    }

    protected final ImmutableList<GraphQLFeedUnitEdge> m10104a(ImmutableList<GraphQLFeedUnitEdge> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) immutableList.get(i);
            String a = m10106a(graphQLFeedUnitEdge);
            GraphQLFeedUnitEdge.Builder builder2 = new GraphQLFeedUnitEdge.Builder();
            builder2.f15732i = graphQLFeedUnitEdge.mo2540c();
            builder2 = builder2;
            builder2.f15729f = a;
            GraphQLFeedUnitEdge.Builder builder3 = builder2;
            builder3.f15734k = graphQLFeedUnitEdge.m19084d();
            builder3 = builder3;
            builder3.f15728e = graphQLFeedUnitEdge.m19086g();
            builder.m1069c(builder3.m22415a());
        }
        return builder.m1068b();
    }

    protected String m10106a(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        return (String) MoreObjects.firstNonNull(DedupableUtil.m23084a(graphQLFeedUnitEdge), MoreObjects.firstNonNull(graphQLFeedUnitEdge.mo2540c() instanceof GraphQLStory ? ((GraphQLStory) graphQLFeedUnitEdge.mo2540c()).m22350c() : null, graphQLFeedUnitEdge.mo2540c().mo2507g()));
    }

    private void m10099a(String str, FetchFeedParams fetchFeedParams, @Nullable GraphQLFeedHomeStories graphQLFeedHomeStories) {
        ImmutableList immutableList = null;
        GraphQLPageInfo n = graphQLFeedHomeStories != null ? graphQLFeedHomeStories.m22433n() : null;
        if (graphQLFeedHomeStories != null) {
            immutableList = graphQLFeedHomeStories.m22430k();
        }
        if (graphQLFeedHomeStories == null || n == null || r0 == null) {
            this.f5998f.m2350b(str, str + fetchFeedParams + graphQLFeedHomeStories);
            throw new InvalidFeedServerResponseException("Response contained null stories or page info");
        }
    }
}

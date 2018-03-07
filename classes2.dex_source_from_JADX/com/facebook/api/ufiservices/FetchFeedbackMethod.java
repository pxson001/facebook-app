package com.facebook.api.ufiservices;

import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.api.feedcache.memory.visitor.ReactionsMutateCacheVisitorHelper;
import com.facebook.api.graphql.fetchfeedback.FetchFeedbackGraphQL$StaticFeedbackBatchQueryString;
import com.facebook.api.graphql.fetchfeedback.FetchFeedbackGraphQL.StaticBaseFeedbackBatchQueryString;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FetchFeedbackParams;
import com.facebook.api.ufiservices.common.FetchNodeListParams;
import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.api.ufiservices.common.ThreadedCommentParamBuilderUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.DefaultCacheProcessor;
import com.facebook.graphql.executor.DefaultCacheProcessorFactory;
import com.facebook.graphql.executor.GraphQLCacheKeySerializer;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLCachePolicy.C08631;
import com.facebook.graphql.executor.GraphQLQueryAnalyticsEvent;
import com.facebook.graphql.executor.GraphQLQueryExecutor.CacheProcessor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.query.GraphQLRefParam;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: scan_results */
public class FetchFeedbackMethod {
    public static final Collection<String> f6070m = Arrays.asList(new String[]{"max_comments", "comment_order", "include_comments_disabled_fields"});
    public static final Collection<String> f6071n = Arrays.asList(new String[]{"max_comments", "comment_order", "include_comments_disabled_fields", "enable_private_reply"});
    private final GraphQLStoryHelper f6072a;
    private final SizeAwareImageUtil f6073b;
    public final Clock f6074c;
    private DefaultCacheProcessorFactory f6075d;
    private ThreadedCommentParamBuilderUtil f6076e;
    public final ReactionsMutateCacheVisitorHelper f6077f;
    private final FetchReactorsParamBuilderUtil f6078g;
    private final FetchRecentActivityParamBuilderUtil f6079h;
    public final QeAccessor f6080i;
    public final GatekeeperStoreImpl f6081j;
    private final FetchVideoChannelParamBuilderUtil f6082k;
    private final AutomaticPhotoCaptioningUtils f6083l;

    /* compiled from: scan_results */
    class C08621 implements GraphQLCacheKeySerializer {
        final /* synthetic */ FetchFeedbackMethod f21693c;

        C08621(FetchFeedbackMethod fetchFeedbackMethod) {
            this.f21693c = fetchFeedbackMethod;
        }

        public final String mo1645a(GraphQLRequest graphQLRequest, Class<?> cls, KeyFactory keyFactory) {
            return keyFactory.m10337a(graphQLRequest.f7096o, cls, graphQLRequest.m11607d(), this.f21693c.f6080i.mo596a(ExperimentsForNewsFeedAbTestModule.f5119t, false) ? FetchFeedbackMethod.f6071n : FetchFeedbackMethod.f6070m);
        }
    }

    /* compiled from: scan_results */
    public class FetchFeedbackGQLCacheProcessor implements CacheProcessor<GraphQLFeedback> {
        @Nullable
        public final FetchNodeListParams f21695a;
        DefaultCacheProcessor<GraphQLFeedback> f21696b;
        final /* synthetic */ FetchFeedbackMethod f21697c;

        public final GraphQLResult<GraphQLFeedback> mo2684b(GraphQLResult<GraphQLFeedback> graphQLResult) {
            if (graphQLResult.freshness == DataFreshnessResult.FROM_SERVER) {
                for (GraphQLFeedback graphQLFeedback : graphQLResult.m10401e()) {
                    if (graphQLFeedback != null) {
                        graphQLFeedback.f16407s = this.f21697c.f6074c.mo211a();
                        boolean z = this.f21695a == null || (this.f21695a.d == null && this.f21695a.c == null);
                        GraphQLHelper.m22477a(graphQLFeedback, z);
                    }
                }
            }
            return graphQLResult;
        }

        public FetchFeedbackGQLCacheProcessor(FetchFeedbackMethod fetchFeedbackMethod, DefaultCacheProcessor<GraphQLFeedback> defaultCacheProcessor) {
            this.f21697c = fetchFeedbackMethod;
            this.f21695a = null;
            this.f21696b = defaultCacheProcessor;
        }

        public FetchFeedbackGQLCacheProcessor(FetchFeedbackMethod fetchFeedbackMethod, FetchNodeListParams fetchNodeListParams, DefaultCacheProcessor<GraphQLFeedback> defaultCacheProcessor) {
            this.f21697c = fetchFeedbackMethod;
            this.f21695a = fetchNodeListParams;
            this.f21696b = defaultCacheProcessor;
        }

        public final GraphQLResult<GraphQLFeedback> mo2681a() {
            return this.f21696b.mo2681a();
        }

        public final GraphQLResult<GraphQLFeedback> mo2682a(GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent) {
            return this.f21696b.mo2682a(graphQLQueryAnalyticsEvent);
        }

        public final boolean mo2683a(GraphQLResult<GraphQLFeedback> graphQLResult) {
            if (graphQLResult.f6203e != null) {
                for (GraphQLFeedback graphQLFeedback : graphQLResult.m10401e()) {
                    if (graphQLFeedback != null) {
                        this.f21697c.f6077f.m10377a(graphQLFeedback);
                    }
                }
            }
            this.f21696b.mo2683a((GraphQLResult) graphQLResult);
            return this.f21695a != null ? true : true;
        }
    }

    public static FetchFeedbackMethod m10191b(InjectorLike injectorLike) {
        return new FetchFeedbackMethod(GraphQLStoryHelper.m10197a(injectorLike), SizeAwareImageUtil.m10234a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), DefaultCacheProcessorFactory.m10240a(injectorLike), ThreadedCommentParamBuilderUtil.m10372b(injectorLike), ReactionsMutateCacheVisitorHelper.m10376b(injectorLike), FetchReactorsParamBuilderUtil.m10406a(injectorLike), FetchRecentActivityParamBuilderUtil.m10419a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), FetchVideoChannelParamBuilderUtil.m10180a(injectorLike), AutomaticPhotoCaptioningUtils.m10187b(injectorLike));
    }

    public static FetchFeedbackMethod m10189a(InjectorLike injectorLike) {
        return m10191b(injectorLike);
    }

    @Inject
    public FetchFeedbackMethod(GraphQLStoryHelper graphQLStoryHelper, SizeAwareImageUtil sizeAwareImageUtil, Clock clock, DefaultCacheProcessorFactory defaultCacheProcessorFactory, ThreadedCommentParamBuilderUtil threadedCommentParamBuilderUtil, ReactionsMutateCacheVisitorHelper reactionsMutateCacheVisitorHelper, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil, QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils) {
        this.f6072a = graphQLStoryHelper;
        this.f6073b = sizeAwareImageUtil;
        this.f6074c = clock;
        this.f6075d = defaultCacheProcessorFactory;
        this.f6076e = threadedCommentParamBuilderUtil;
        this.f6077f = reactionsMutateCacheVisitorHelper;
        this.f6078g = fetchReactorsParamBuilderUtil;
        this.f6079h = fetchRecentActivityParamBuilderUtil;
        this.f6080i = qeAccessor;
        this.f6081j = gatekeeperStoreImpl;
        this.f6082k = fetchVideoChannelParamBuilderUtil;
        this.f6083l = automaticPhotoCaptioningUtils;
    }

    private GraphQlQueryString m10192b(FetchFeedbackParams fetchFeedbackParams) {
        GraphQlQueryString fetchFeedbackGraphQL$StaticFeedbackBatchQueryString;
        boolean z;
        boolean z2 = false;
        if (fetchFeedbackParams.m29344c()) {
            fetchFeedbackGraphQL$StaticFeedbackBatchQueryString = new FetchFeedbackGraphQL$StaticFeedbackBatchQueryString();
        } else {
            fetchFeedbackGraphQL$StaticFeedbackBatchQueryString = new StaticBaseFeedbackBatchQueryString();
        }
        fetchFeedbackGraphQL$StaticFeedbackBatchQueryString.mo1608a(true);
        if (fetchFeedbackParams.m29344c()) {
            z = fetchFeedbackParams.f21637f;
        } else {
            z = false;
        }
        fetchFeedbackGraphQL$StaticFeedbackBatchQueryString.m11312a("include_comments_disabled_fields", Boolean.valueOf(z));
        if (fetchFeedbackParams.f21632a != null) {
            fetchFeedbackGraphQL$StaticFeedbackBatchQueryString.m11316a("feedback_id", Arrays.asList(new String[]{fetchFeedbackParams.f21632a}));
        }
        if (fetchFeedbackParams.m29344c()) {
            fetchFeedbackGraphQL$StaticFeedbackBatchQueryString.m11314a("profile_image_size", GraphQLStoryHelper.m10198a());
        }
        fetchFeedbackGraphQL$StaticFeedbackBatchQueryString.m11314a("angora_attachment_cover_image_size", this.f6072a.m10223r()).m11314a("angora_attachment_profile_image_size", this.f6072a.m10224s());
        fetchFeedbackGraphQL$StaticFeedbackBatchQueryString.m11314a("reading_attachment_profile_image_width", this.f6072a.m10213L()).m11314a("reading_attachment_profile_image_height", this.f6072a.m10214M());
        fetchFeedbackGraphQL$StaticFeedbackBatchQueryString.m11312a("fetch_reshare_counts", Boolean.valueOf(this.f6080i.mo596a(ExperimentsForFeedbackTestModule.f6816T, false)));
        fetchFeedbackGraphQL$StaticFeedbackBatchQueryString.m11315a("automatic_photo_captioning_enabled", Boolean.toString(this.f6083l.m10188a()));
        if (!(fetchFeedbackParams.f21636e == null || fetchFeedbackParams.f21636e.equals(CommentOrderType.DEFAULT_ORDER))) {
            fetchFeedbackGraphQL$StaticFeedbackBatchQueryString.m11315a("comment_order", fetchFeedbackParams.f21636e.toString);
        }
        if (!(fetchFeedbackParams.f21639h == null || CommentOrderType.RANKED_ORDER.equals(fetchFeedbackParams.f21636e) || !this.f6080i.mo596a(ExperimentsForFeedbackTestModule.f6828f, false))) {
            z2 = true;
        }
        if (z2) {
            fetchFeedbackGraphQL$StaticFeedbackBatchQueryString.m11315a("surround_comment_id", fetchFeedbackParams.f21639h).m11314a("num_before_surround", Integer.valueOf((fetchFeedbackParams.f21633b - 1) / 2)).m11314a("surround_max_comments", Integer.valueOf(fetchFeedbackParams.f21633b));
        } else {
            fetchFeedbackGraphQL$StaticFeedbackBatchQueryString.m11314a("max_comments", Integer.valueOf(fetchFeedbackParams.f21633b));
            if (CommentOrderType.RANKED_ORDER.equals(fetchFeedbackParams.f21636e)) {
                fetchFeedbackGraphQL$StaticFeedbackBatchQueryString.m11315a("comment_id", fetchFeedbackParams.f21639h);
            }
        }
        this.f6076e.m10373a(fetchFeedbackGraphQL$StaticFeedbackBatchQueryString, fetchFeedbackParams.f21640i);
        if (fetchFeedbackParams.m29344c()) {
            this.f6078g.m10408a(fetchFeedbackGraphQL$StaticFeedbackBatchQueryString);
        }
        this.f6079h.m10421a(fetchFeedbackGraphQL$StaticFeedbackBatchQueryString);
        this.f6082k.m10182a(fetchFeedbackGraphQL$StaticFeedbackBatchQueryString);
        return this.f6073b.m10237a(fetchFeedbackGraphQL$StaticFeedbackBatchQueryString);
    }

    private GraphQLRequest<GraphQLFeedback> m10190a(FetchFeedbackParams fetchFeedbackParams, GraphQlQueryString graphQlQueryString) {
        GraphQLCachePolicy graphQLCachePolicy;
        GraphQLRequest a = GraphQLRequest.m11585a(graphQlQueryString, GraphQLFeedback.class);
        boolean z = fetchFeedbackParams.f21638g;
        RequestPriority requestPriority = this.f6081j.m2189a(637, false) ? z ? RequestPriority.NON_INTERACTIVE : RequestPriority.INTERACTIVE : z ? RequestPriority.INTERACTIVE : RequestPriority.CAN_WAIT;
        a = a.m11596a(requestPriority);
        a.m11593a(new C08621(this));
        switch (C08631.f21694a[fetchFeedbackParams.f21635d.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                graphQLCachePolicy = GraphQLCachePolicy.f7109a;
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                graphQLCachePolicy = GraphQLCachePolicy.f7112d;
                break;
            case 3:
                graphQLCachePolicy = GraphQLCachePolicy.f7110b;
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                graphQLCachePolicy = GraphQLCachePolicy.f7109a;
                break;
            default:
                graphQLCachePolicy = GraphQLCachePolicy.f7111c;
                break;
        }
        a.m11594a(graphQLCachePolicy);
        a.m11590a(259200);
        a.f7084b = true;
        a.f7090h = m10194a(a);
        return a;
    }

    public final CacheProcessor<GraphQLFeedback> m10194a(GraphQLRequest graphQLRequest) {
        return new FetchFeedbackGQLCacheProcessor(this, this.f6075d.m10242a(graphQLRequest));
    }

    public final CacheProcessor<GraphQLFeedback> m10193a(FetchNodeListParams fetchNodeListParams, GraphQLRequest graphQLRequest) {
        return new FetchFeedbackGQLCacheProcessor(this, fetchNodeListParams, this.f6075d.m10242a(graphQLRequest));
    }

    public final GraphQLRequest<GraphQLFeedback> m10196a(FetchFeedbackParams fetchFeedbackParams, GraphQLRefParam graphQLRefParam, @Nullable GraphQLRefParam graphQLRefParam2) {
        GraphQlQueryString b = m10192b(fetchFeedbackParams);
        b.m11311a("feedback_id", graphQLRefParam);
        if (graphQLRefParam2 != null) {
            b.m11311a("comment_id", graphQLRefParam2);
        }
        return m10190a(fetchFeedbackParams, b);
    }

    public final GraphQLRequest<GraphQLFeedback> m10195a(FetchFeedbackParams fetchFeedbackParams) {
        return m10190a(fetchFeedbackParams, m10192b(fetchFeedbackParams));
    }
}

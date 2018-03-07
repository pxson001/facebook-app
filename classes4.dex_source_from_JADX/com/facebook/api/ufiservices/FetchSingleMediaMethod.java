package com.facebook.api.ufiservices;

import com.facebook.api.feedcache.memory.visitor.ReactionsMutateCacheVisitorHelper;
import com.facebook.api.graphql.fetchmedia.FetchSingleMediaGraphQL.StaticCompleteFeedbackMediaQueryString;
import com.facebook.api.graphql.fetchmedia.FetchSingleMediaGraphQL.StaticSimpleFeedbackMediaQueryString;
import com.facebook.api.graphql.fetchmedia.FetchSingleMediaGraphQL.StaticSimpleFeedbackMediaQueryWithAttributionString;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FeedbackCacheProvider;
import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchSingleMediaParams;
import com.facebook.api.ufiservices.common.FetchSingleMediaParams.FetchType;
import com.facebook.api.ufiservices.common.ThreadedCommentParamBuilderUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.graphql.executor.DefaultCacheProcessorFactory;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: platform_link_share_upload_params */
public class FetchSingleMediaMethod {
    public final GraphQLStoryHelper f4565a;
    public final SizeAwareImageUtil f4566b;
    public final Clock f4567c;
    public final QeAccessor f4568d;
    public final ReactionsMutateCacheVisitorHelper f4569e;
    public DefaultCacheProcessorFactory f4570f;
    public ThreadedCommentParamBuilderUtil f4571g;
    public FetchReactorsParamBuilderUtil f4572h;
    public FetchRecentActivityParamBuilderUtil f4573i;

    public static FetchSingleMediaMethod m5067b(InjectorLike injectorLike) {
        return new FetchSingleMediaMethod(GraphQLStoryHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ReactionsMutateCacheVisitorHelper.b(injectorLike), DefaultCacheProcessorFactory.a(injectorLike), ThreadedCommentParamBuilderUtil.b(injectorLike), FetchReactorsParamBuilderUtil.a(injectorLike), FetchRecentActivityParamBuilderUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FetchSingleMediaMethod(GraphQLStoryHelper graphQLStoryHelper, SizeAwareImageUtil sizeAwareImageUtil, Clock clock, ReactionsMutateCacheVisitorHelper reactionsMutateCacheVisitorHelper, DefaultCacheProcessorFactory defaultCacheProcessorFactory, ThreadedCommentParamBuilderUtil threadedCommentParamBuilderUtil, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil, QeAccessor qeAccessor) {
        this.f4565a = graphQLStoryHelper;
        this.f4566b = sizeAwareImageUtil;
        this.f4567c = clock;
        this.f4569e = reactionsMutateCacheVisitorHelper;
        this.f4570f = defaultCacheProcessorFactory;
        this.f4571g = threadedCommentParamBuilderUtil;
        this.f4572h = fetchReactorsParamBuilderUtil;
        this.f4573i = fetchRecentActivityParamBuilderUtil;
        this.f4568d = qeAccessor;
    }

    public final GraphQLRequest<GraphQLMedia> m5068a(FetchSingleMediaParams fetchSingleMediaParams, @Nullable FeedbackCacheProvider feedbackCacheProvider) {
        GraphQlQueryString staticCompleteFeedbackMediaQueryString;
        switch (1.a[fetchSingleMediaParams.c.ordinal()]) {
            case 1:
                staticCompleteFeedbackMediaQueryString = new StaticCompleteFeedbackMediaQueryString();
                break;
            case 2:
                staticCompleteFeedbackMediaQueryString = new StaticSimpleFeedbackMediaQueryWithAttributionString();
                break;
            default:
                staticCompleteFeedbackMediaQueryString = new StaticSimpleFeedbackMediaQueryString();
                break;
        }
        staticCompleteFeedbackMediaQueryString.a(true);
        staticCompleteFeedbackMediaQueryString.a("profile_image_size", GraphQLStoryHelper.a()).a("likers_profile_image_size", this.f4565a.c());
        if (fetchSingleMediaParams != null) {
            staticCompleteFeedbackMediaQueryString.a("media_id", fetchSingleMediaParams.a).a("max_comments", String.valueOf(fetchSingleMediaParams.b));
            if (fetchSingleMediaParams.c == FetchType.SIMPLE_WITH_ATTRIBUTION) {
                staticCompleteFeedbackMediaQueryString.a("image_scale", GraphQlQueryDefaults.a());
            }
            if (!(fetchSingleMediaParams.e == null || fetchSingleMediaParams.e.equals(CommentOrderType.DEFAULT_ORDER))) {
                staticCompleteFeedbackMediaQueryString.a("comment_order", fetchSingleMediaParams.e.toString);
            }
        }
        staticCompleteFeedbackMediaQueryString.a("angora_attachment_cover_image_size", this.f4565a.r());
        staticCompleteFeedbackMediaQueryString.a("angora_attachment_profile_image_size", this.f4565a.s());
        staticCompleteFeedbackMediaQueryString.a("fetch_reshare_counts", Boolean.valueOf(this.f4568d.a(ExperimentsForFeedbackTestModule.T, false)));
        this.f4571g.b(staticCompleteFeedbackMediaQueryString);
        this.f4572h.a(staticCompleteFeedbackMediaQueryString);
        this.f4573i.a(staticCompleteFeedbackMediaQueryString);
        GraphQLRequest<GraphQLMedia> a = GraphQLRequest.a(this.f4566b.a(staticCompleteFeedbackMediaQueryString), GraphQLMedia.class);
        a.b = true;
        if (fetchSingleMediaParams.d == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
            a.a(GraphQLCachePolicy.c);
        } else {
            a.a(GraphQLCachePolicy.a);
        }
        a.a(259200);
        a.b = true;
        a.h = new FetchSingleMediaMethodProcessor(this, fetchSingleMediaParams, this.f4570f.a(a), feedbackCacheProvider);
        return a;
    }
}

package com.facebook.feed.protocol;

import android.content.res.Resources;
import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.api.feedcache.memory.FeedUnitCache;
import com.facebook.api.feedcache.memory.visitor.ReactionsMutateCacheVisitorHelper;
import com.facebook.api.graphql.fetchstories.FetchPlatformStoryGraphQL.StaticGraphQlPlatformStoryFeedbackQueryString;
import com.facebook.api.graphql.fetchstories.FetchPlatformStoryGraphQL.StaticGraphQlPlatformStoryQueryString;
import com.facebook.api.graphql.notifications.FetchNotificationStoryGraphQL.NotificationStoryQueryDepth3String;
import com.facebook.api.story.FetchSingleStoryMethod;
import com.facebook.api.story.FetchSingleStoryParams;
import com.facebook.api.story.FetchSingleStoryParams.FetchType;
import com.facebook.api.ufiservices.common.FeedbackCacheProvider;
import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.api.ufiservices.common.ThreadedCommentParamBuilderUtil;
import com.facebook.checkin.socialsearch.parambuilder.SocialSearchParamBuilderUtil;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.protocol.FetchGraphQLStoryGraphQL.StaticGraphQlCreationStoryQueryString;
import com.facebook.feed.protocol.FetchGraphQLStoryGraphQL.StaticGraphQlStoryFeedbackQueryString;
import com.facebook.feed.protocol.FetchGraphQLStoryGraphQL.StaticGraphQlStoryQueryString;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.feed.util.injection.PermalinkClientSideInjectionTool;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.graphql.executor.DefaultCacheProcessorFactory;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: platform_delete_temp_files_params */
public class FetchGraphQLStoryMethod extends FetchSingleStoryMethod {
    protected final GraphQLStoryHelper f4574i;
    public final Clock f4575j;
    public final FeedUnitCache f4576k;
    public final PermalinkClientSideInjectionTool f4577l;
    public DefaultCacheProcessorFactory f4578m;
    private final FetchReactorsParamBuilderUtil f4579n;
    private final FetchRecentActivityParamBuilderUtil f4580o;
    public ReactionsMutateCacheVisitorHelper f4581p;
    private final ReactionsExperimentUtil f4582q;
    private FetchVideoChannelParamBuilderUtil f4583r;
    public final VideoDashConfig f4584s;

    public static FetchGraphQLStoryMethod m5070b(InjectorLike injectorLike) {
        return new FetchGraphQLStoryMethod(ResourcesMethodAutoProvider.a(injectorLike), GraphQLStoryHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike), GraphQLProtocolHelper.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FeedUnitCache.a(injectorLike), PermalinkClientSideInjectionTool.m5080a(injectorLike), DefaultCacheProcessorFactory.a(injectorLike), ThreadedCommentParamBuilderUtil.a(injectorLike), FetchReactorsParamBuilderUtil.a(injectorLike), FetchRecentActivityParamBuilderUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ReactionsMutateCacheVisitorHelper.a(injectorLike), ReactionsExperimentUtil.a(injectorLike), FetchVideoChannelParamBuilderUtil.a(injectorLike), SocialSearchParamBuilderUtil.a(injectorLike), TopicFeedsTestUtil.a(injectorLike), VideoDashConfig.a(injectorLike), AutomaticPhotoCaptioningUtils.a(injectorLike));
    }

    public static FetchGraphQLStoryMethod m5069a(InjectorLike injectorLike) {
        return m5070b(injectorLike);
    }

    public final /* synthetic */ GraphQlQueryString m5075f(Object obj) {
        return m5071b((FetchSingleStoryParams) obj);
    }

    @Inject
    public FetchGraphQLStoryMethod(Resources resources, GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, SizeAwareImageUtil sizeAwareImageUtil, GraphQLProtocolHelper graphQLProtocolHelper, Clock clock, FeedUnitCache feedUnitCache, PermalinkClientSideInjectionTool permalinkClientSideInjectionTool, DefaultCacheProcessorFactory defaultCacheProcessorFactory, ThreadedCommentParamBuilderUtil threadedCommentParamBuilderUtil, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil, QeAccessor qeAccessor, ReactionsMutateCacheVisitorHelper reactionsMutateCacheVisitorHelper, ReactionsExperimentUtil reactionsExperimentUtil, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil, SocialSearchParamBuilderUtil socialSearchParamBuilderUtil, TopicFeedsTestUtil topicFeedsTestUtil, VideoDashConfig videoDashConfig, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils) {
        super(resources, graphQLImageHelper, graphQLStoryHelper, graphQLProtocolHelper, sizeAwareImageUtil, clock, threadedCommentParamBuilderUtil, fetchReactorsParamBuilderUtil, fetchRecentActivityParamBuilderUtil, socialSearchParamBuilderUtil, qeAccessor, topicFeedsTestUtil, automaticPhotoCaptioningUtils);
        this.f4574i = graphQLStoryHelper;
        this.f4575j = clock;
        this.f4576k = feedUnitCache;
        this.f4577l = permalinkClientSideInjectionTool;
        this.f4578m = defaultCacheProcessorFactory;
        this.f4579n = fetchReactorsParamBuilderUtil;
        this.f4580o = fetchRecentActivityParamBuilderUtil;
        this.f4581p = reactionsMutateCacheVisitorHelper;
        this.f4582q = reactionsExperimentUtil;
        this.f4583r = fetchVideoChannelParamBuilderUtil;
        this.f4584s = videoDashConfig;
    }

    private GraphQlQueryString m5071b(FetchSingleStoryParams fetchSingleStoryParams) {
        GraphQlQueryString staticGraphQlStoryFeedbackQueryString;
        switch (1.a[fetchSingleStoryParams.d.ordinal()]) {
            case 1:
                staticGraphQlStoryFeedbackQueryString = new StaticGraphQlStoryFeedbackQueryString();
                break;
            case 2:
            case 3:
                staticGraphQlStoryFeedbackQueryString = new StaticGraphQlCreationStoryQueryString();
                break;
            case 4:
                staticGraphQlStoryFeedbackQueryString = new StaticGraphQlStoryQueryString();
                break;
            case 5:
                staticGraphQlStoryFeedbackQueryString = new NotificationStoryQueryDepth3String();
                staticGraphQlStoryFeedbackQueryString.a("enable_download", Boolean.toString(this.f4590h.a(ExperimentsForVideoAbTestModule.cW, false)));
                if (this.f4584s.a() && this.f4584s.Q) {
                    staticGraphQlStoryFeedbackQueryString.a("scrubbing", "MPEG_DASH");
                }
                break;
            case 6:
                staticGraphQlStoryFeedbackQueryString = new StaticGraphQlPlatformStoryQueryString();
                break;
            case 7:
                staticGraphQlStoryFeedbackQueryString = new StaticGraphQlPlatformStoryFeedbackQueryString();
                break;
            default:
                throw new RuntimeException("UNSUPPORTED");
        }
        staticGraphQlStoryFeedbackQueryString.a(true);
        m5076a(fetchSingleStoryParams, staticGraphQlStoryFeedbackQueryString);
        return staticGraphQlStoryFeedbackQueryString;
    }

    protected final void mo403b(FetchSingleStoryParams fetchSingleStoryParams, GraphQlQueryString graphQlQueryString) {
        if (fetchSingleStoryParams.d == FetchType.NOTIFICATION_FEEDBACK_DETAILS) {
            Enum a = GraphQlQueryDefaults.a();
            if (a == null) {
                a = GraphQlQueryDefaults.a;
            }
            graphQlQueryString.a("image_preview_size", String.valueOf(this.f4574i.t())).a("icon_scale", a);
        }
        this.f4579n.a(graphQlQueryString);
        this.f4580o.a(graphQlQueryString);
        this.f4583r.a(graphQlQueryString);
    }

    public final GraphQLRequest<GraphQLStory> m5072a(FetchSingleStoryParams fetchSingleStoryParams) {
        return m5073a(fetchSingleStoryParams, null, null);
    }

    public final GraphQLRequest<GraphQLStory> m5073a(FetchSingleStoryParams fetchSingleStoryParams, @Nullable String str, @Nullable FeedbackCacheProvider feedbackCacheProvider) {
        Class cls;
        if (fetchSingleStoryParams.d == FetchType.GRAPHQL_PHOTO_CREATION_STORY) {
            cls = GraphQLPhoto.class;
        } else if (fetchSingleStoryParams.d == FetchType.GRAPHQL_VIDEO_CREATION_STORY) {
            cls = GraphQLVideo.class;
        } else {
            cls = GraphQLStory.class;
        }
        GraphQLRequest<GraphQLStory> a = GraphQLRequest.a(m5071b(fetchSingleStoryParams), cls);
        if (fetchSingleStoryParams.c != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
            a.a(GraphQLCachePolicy.a);
        } else if (fetchSingleStoryParams.d == FetchType.NOTIFICATION_FEEDBACK_DETAILS) {
            a.a(GraphQLCachePolicy.c);
        } else {
            a.a(GraphQLCachePolicy.d);
        }
        a.a(259200);
        a.b = true;
        a.h = new FetchSingleStoryProcessor(this, fetchSingleStoryParams, this.f4578m.a(a), str, feedbackCacheProvider);
        return a;
    }
}

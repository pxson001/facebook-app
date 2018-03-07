package com.facebook.adpreview.protocol;

import android.content.res.Resources;
import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.adpreview.protocol.FetchAdPreviewFeedUnitGraphQL.FetchAdPreviewFeedUnitQueryString;
import com.facebook.api.feedcache.memory.FeedUnitCache;
import com.facebook.api.feedcache.memory.visitor.ReactionsMutateCacheVisitorHelper;
import com.facebook.api.story.FetchSingleStoryParams;
import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.api.ufiservices.common.ThreadedCommentParamBuilderUtil;
import com.facebook.checkin.socialsearch.parambuilder.SocialSearchParamBuilderUtil;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.protocol.FetchGraphQLStoryMethod;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.feed.util.injection.PermalinkClientSideInjectionTool;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.graphql.executor.DefaultCacheProcessorFactory;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import javax.inject.Inject;

/* compiled from: error_body */
public class FetchGraphQLAdPreviewMethod extends FetchGraphQLStoryMethod {
    public static FetchGraphQLAdPreviewMethod m14168c(InjectorLike injectorLike) {
        return new FetchGraphQLAdPreviewMethod(ResourcesMethodAutoProvider.a(injectorLike), GraphQLStoryHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike), GraphQLProtocolHelper.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FeedUnitCache.a(injectorLike), PermalinkClientSideInjectionTool.a(injectorLike), DefaultCacheProcessorFactory.a(injectorLike), ThreadedCommentParamBuilderUtil.a(injectorLike), FetchReactorsParamBuilderUtil.a(injectorLike), FetchRecentActivityParamBuilderUtil.a(injectorLike), SocialSearchParamBuilderUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ReactionsMutateCacheVisitorHelper.a(injectorLike), ReactionsExperimentUtil.a(injectorLike), FetchVideoChannelParamBuilderUtil.a(injectorLike), VideoDashConfig.a(injectorLike), TopicFeedsTestUtil.a(injectorLike), AutomaticPhotoCaptioningUtils.a(injectorLike));
    }

    public static FetchGraphQLAdPreviewMethod m14167b(InjectorLike injectorLike) {
        return m14168c(injectorLike);
    }

    @Inject
    public FetchGraphQLAdPreviewMethod(Resources resources, GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, SizeAwareImageUtil sizeAwareImageUtil, GraphQLProtocolHelper graphQLProtocolHelper, Clock clock, FeedUnitCache feedUnitCache, PermalinkClientSideInjectionTool permalinkClientSideInjectionTool, DefaultCacheProcessorFactory defaultCacheProcessorFactory, ThreadedCommentParamBuilderUtil threadedCommentParamBuilderUtil, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil, SocialSearchParamBuilderUtil socialSearchParamBuilderUtil, QeAccessor qeAccessor, ReactionsMutateCacheVisitorHelper reactionsMutateCacheVisitorHelper, ReactionsExperimentUtil reactionsExperimentUtil, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil, VideoDashConfig videoDashConfig, TopicFeedsTestUtil topicFeedsTestUtil, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils) {
        super(resources, graphQLStoryHelper, graphQLImageHelper, sizeAwareImageUtil, graphQLProtocolHelper, clock, feedUnitCache, permalinkClientSideInjectionTool, defaultCacheProcessorFactory, threadedCommentParamBuilderUtil, fetchReactorsParamBuilderUtil, fetchRecentActivityParamBuilderUtil, qeAccessor, reactionsMutateCacheVisitorHelper, reactionsExperimentUtil, fetchVideoChannelParamBuilderUtil, socialSearchParamBuilderUtil, topicFeedsTestUtil, videoDashConfig, automaticPhotoCaptioningUtils);
    }

    public final GraphQlQueryString m14169a(FetchSingleStoryParams fetchSingleStoryParams, String str) {
        GraphQlQueryString fetchAdPreviewFeedUnitQueryString = new FetchAdPreviewFeedUnitQueryString();
        fetchAdPreviewFeedUnitQueryString.a(true);
        a(fetchSingleStoryParams, fetchAdPreviewFeedUnitQueryString);
        fetchAdPreviewFeedUnitQueryString.a("preview_id", str);
        return fetchAdPreviewFeedUnitQueryString;
    }
}

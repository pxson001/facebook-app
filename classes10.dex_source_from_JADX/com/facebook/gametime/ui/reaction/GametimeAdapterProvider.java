package com.facebook.gametime.ui.reaction;

import android.content.Context;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.controller.mutation.StoryMutationHelper;
import com.facebook.feed.data.FeedStorySubscriber;
import com.facebook.feed.logging.StoryLikeHistoryLogger;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.feed.ReactionFeedAdapterFactory;
import com.facebook.reaction.feed.ReactionItemCollection;
import com.facebook.reaction.feed.environment.DefaultReactionFeedEnvironmentProvider;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandlerProvider;
import com.facebook.search.logging.SearchResultsLogger;

/* compiled from: •   */
public class GametimeAdapterProvider extends AbstractAssistedProvider<GametimeAdapter> {
    public final GametimeAdapter m1a(Context context, FeedListType feedListType, BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, ReactionCardContainer reactionCardContainer, String str, GametimePlaySubscriber gametimePlaySubscriber) {
        return new GametimeAdapter(context, feedListType, baseFeedStoryMenuHelper, reactionCardContainer, str, gametimePlaySubscriber, ReactionAnalyticsLogger.a(this), (Clock) SystemClockMethodAutoProvider.a(this), (DefaultReactionFeedEnvironmentProvider) getOnDemandAssistedProviderForStaticDi(DefaultReactionFeedEnvironmentProvider.class), ReactionExperimentController.a(this), (ReactionFeedActionHandlerProvider) getOnDemandAssistedProviderForStaticDi(ReactionFeedActionHandlerProvider.class), ReactionFeedAdapterFactory.a(this), FeedEventBus.a(this), MultipleRowsStoriesRecycleCallback.a(this), FeedStorySubscriber.a(this), GraphQLSubscriptionHolder.a(this), MultipleRowsStoriesRecycleCallback.a(this), ReactionItemCollection.a(this), (ReactionFeedActionHandlerProvider) getOnDemandAssistedProviderForStaticDi(ReactionFeedActionHandlerProvider.class), ReactionFeedAdapterFactory.a(this), ReactionUtil.a(this), (GametimeEnvironmentProvider) getOnDemandAssistedProviderForStaticDi(GametimeEnvironmentProvider.class), SearchResultsLogger.a(this), ReactionUnitValidator.a(this), StoryLikeHistoryLogger.a(this), StoryMutationHelper.a(this));
    }
}

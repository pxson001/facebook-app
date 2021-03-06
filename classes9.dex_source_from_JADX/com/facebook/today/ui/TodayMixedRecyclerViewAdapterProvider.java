package com.facebook.today.ui;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
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

/* compiled from: trim */
public class TodayMixedRecyclerViewAdapterProvider extends AbstractAssistedProvider<TodayMixedRecyclerViewAdapter> {
    public final TodayMixedRecyclerViewAdapter m1420a(Context context, FeedListType feedListType, BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, ReactionCardContainer reactionCardContainer) {
        return new TodayMixedRecyclerViewAdapter(context, feedListType, baseFeedStoryMenuHelper, reactionCardContainer, ReactionAnalyticsLogger.a(this), (Clock) SystemClockMethodAutoProvider.a(this), (DefaultReactionFeedEnvironmentProvider) getOnDemandAssistedProviderForStaticDi(DefaultReactionFeedEnvironmentProvider.class), ReactionExperimentController.a(this), (ReactionFeedActionHandlerProvider) getOnDemandAssistedProviderForStaticDi(ReactionFeedActionHandlerProvider.class), ReactionFeedAdapterFactory.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), FeedEventBus.a(this), MultipleRowsStoriesRecycleCallback.a(this), FeedStorySubscriber.a(this), GraphQLSubscriptionHolder.a(this), MultipleRowsStoriesRecycleCallback.a(this), ReactionItemCollection.a(this), (ReactionFeedActionHandlerProvider) getOnDemandAssistedProviderForStaticDi(ReactionFeedActionHandlerProvider.class), ReactionFeedAdapterFactory.a(this), ReactionUtil.a(this), (TodayEnvironmentProvider) getOnDemandAssistedProviderForStaticDi(TodayEnvironmentProvider.class), SearchResultsLogger.a(this), ReactionUnitValidator.a(this), StoryLikeHistoryLogger.a(this), StoryMutationHelper.a(this));
    }
}

package com.facebook.aplacefor;

import android.content.Context;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.controller.mutation.StoryMutationHelper;
import com.facebook.feed.data.FeedStorySubscriber;
import com.facebook.feed.logging.StoryLikeHistoryLogger;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
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

/* compiled from: kFBSearchContextSearchTapped */
public class APlaceForRecyclerViewAdapterProvider extends AbstractAssistedProvider<APlaceForRecyclerViewAdapter> {
    public final APlaceForRecyclerViewAdapter m12372a(Context context, FeedListType feedListType, BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, ReactionCardContainer reactionCardContainer) {
        return new APlaceForRecyclerViewAdapter(context, feedListType, baseFeedStoryMenuHelper, reactionCardContainer, ReactionAnalyticsLogger.m22814a((InjectorLike) this), (Clock) SystemClockMethodAutoProvider.a(this), (DefaultReactionFeedEnvironmentProvider) getOnDemandAssistedProviderForStaticDi(DefaultReactionFeedEnvironmentProvider.class), ReactionExperimentController.a(this), (ReactionFeedActionHandlerProvider) getOnDemandAssistedProviderForStaticDi(ReactionFeedActionHandlerProvider.class), ReactionFeedAdapterFactory.m22963a(this), FeedEventBus.a(this), MultipleRowsStoriesRecycleCallback.a(this), FeedStorySubscriber.a(this), GraphQLSubscriptionHolder.a(this), MultipleRowsStoriesRecycleCallback.a(this), ReactionItemCollection.m22966a((InjectorLike) this), ReactionUtil.m22637a((InjectorLike) this), SearchResultsLogger.m25460a((InjectorLike) this), ReactionUnitValidator.m22907a((InjectorLike) this), StoryLikeHistoryLogger.a(this), StoryMutationHelper.a(this), (APlaceForEnvironmentProvider) getOnDemandAssistedProviderForStaticDi(APlaceForEnvironmentProvider.class), MultiRowAdapterBuilder.a(this), IdBasedLazy.a(this, 9857));
    }
}

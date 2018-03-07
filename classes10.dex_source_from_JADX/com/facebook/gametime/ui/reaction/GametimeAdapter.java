package com.facebook.gametime.ui.reaction;

import android.content.Context;
import com.facebook.common.time.Clock;
import com.facebook.controller.mutation.StoryMutationHelper;
import com.facebook.feed.data.FeedStorySubscriber;
import com.facebook.feed.logging.StoryLikeHistoryLogger;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.inject.Assisted;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.feed.ReactionFeedAdapterFactory;
import com.facebook.reaction.feed.ReactionItemCollection;
import com.facebook.reaction.feed.environment.DefaultReactionFeedEnvironmentProvider;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandlerProvider;
import com.facebook.reaction.ui.recyclerview.ReactionMixedRecyclerViewAdapter;
import com.facebook.search.logging.SearchResultsLogger;
import javax.inject.Inject;

/* compiled from: （中文） */
public class GametimeAdapter extends ReactionMixedRecyclerViewAdapter {
    private Context f0j;
    private GametimeEnvironmentProvider f1k;
    private FeedListType f2l;
    private BaseFeedStoryMenuHelper f3m;
    private final String f4n;
    private final GametimePlaySubscriber f5o;
    private final ReactionFeedActionHandlerProvider f6p;
    private final ReactionFeedAdapterFactory f7q;

    @Inject
    public GametimeAdapter(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, @Assisted ReactionCardContainer reactionCardContainer, @Assisted String str, @Assisted GametimePlaySubscriber gametimePlaySubscriber, ReactionAnalyticsLogger reactionAnalyticsLogger, Clock clock, DefaultReactionFeedEnvironmentProvider defaultReactionFeedEnvironmentProvider, ReactionExperimentController reactionExperimentController, ReactionFeedActionHandlerProvider reactionFeedActionHandlerProvider, ReactionFeedAdapterFactory reactionFeedAdapterFactory, FeedEventBus feedEventBus, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, FeedStorySubscriber feedStorySubscriber, GraphQLSubscriptionHolder graphQLSubscriptionHolder, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback2, ReactionItemCollection reactionItemCollection, ReactionFeedActionHandlerProvider reactionFeedActionHandlerProvider2, ReactionFeedAdapterFactory reactionFeedAdapterFactory2, ReactionUtil reactionUtil, GametimeEnvironmentProvider gametimeEnvironmentProvider, SearchResultsLogger searchResultsLogger, ReactionUnitValidator reactionUnitValidator, StoryLikeHistoryLogger storyLikeHistoryLogger, StoryMutationHelper storyMutationHelper) {
        super(context, feedListType, baseFeedStoryMenuHelper, reactionCardContainer, reactionAnalyticsLogger, clock, defaultReactionFeedEnvironmentProvider, reactionExperimentController, reactionFeedActionHandlerProvider, reactionFeedAdapterFactory, feedEventBus, multipleRowsStoriesRecycleCallback, feedStorySubscriber, graphQLSubscriptionHolder, multipleRowsStoriesRecycleCallback2, reactionItemCollection, reactionUtil, searchResultsLogger, reactionUnitValidator, storyLikeHistoryLogger, storyMutationHelper);
        this.f0j = context;
        this.f1k = gametimeEnvironmentProvider;
        this.f2l = feedListType;
        this.f3m = baseFeedStoryMenuHelper;
        this.f4n = str;
        this.f5o = gametimePlaySubscriber;
        this.f6p = reactionFeedActionHandlerProvider2;
        this.f7q = reactionFeedAdapterFactory2;
    }

    protected final MultiRowRecyclerViewAdapter m0q() {
        return this.f7q.a(this.f1k.m4a(this.f0j, this.f2l, this.f3m, new 1(this), this.c, this.f6p.a(this.f0j, this.d), this.d.getInteractionTracker(), this.a, r(), this.f4n, this.f5o), this.z, null);
    }
}

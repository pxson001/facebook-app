package com.facebook.pages.common.surface.fragments.reaction;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.time.Clock;
import com.facebook.controller.mutation.StoryMutationHelper;
import com.facebook.feed.data.FeedStorySubscriber;
import com.facebook.feed.logging.StoryLikeHistoryLogger;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
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
import com.facebook.reaction.ui.recyclerview.ReactionHeaderTouchDelegateView;
import com.facebook.reaction.ui.recyclerview.ReactionMixedRecyclerViewAdapter;
import com.facebook.reaction.ui.recyclerview.ReactionSimpleViewHolder;
import com.facebook.search.logging.SearchResultsLogger;
import javax.inject.Inject;

/* compiled from: retryDelays */
public class PagesGenericReactionMixedRecyclerViewAdapter extends ReactionMixedRecyclerViewAdapter {
    private View f2424j;
    private int f2425k = 0;

    @Inject
    public PagesGenericReactionMixedRecyclerViewAdapter(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, @Assisted ReactionCardContainer reactionCardContainer, ReactionAnalyticsLogger reactionAnalyticsLogger, Clock clock, DefaultReactionFeedEnvironmentProvider defaultReactionFeedEnvironmentProvider, ReactionExperimentController reactionExperimentController, ReactionFeedActionHandlerProvider reactionFeedActionHandlerProvider, ReactionFeedAdapterFactory reactionFeedAdapterFactory, FeedEventBus feedEventBus, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, FeedStorySubscriber feedStorySubscriber, GraphQLSubscriptionHolder graphQLSubscriptionHolder, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback2, ReactionItemCollection reactionItemCollection, ReactionUtil reactionUtil, SearchResultsLogger searchResultsLogger, ReactionUnitValidator reactionUnitValidator, StoryLikeHistoryLogger storyLikeHistoryLogger, StoryMutationHelper storyMutationHelper) {
        super(context, feedListType, baseFeedStoryMenuHelper, reactionCardContainer, reactionAnalyticsLogger, clock, defaultReactionFeedEnvironmentProvider, reactionExperimentController, reactionFeedActionHandlerProvider, reactionFeedAdapterFactory, feedEventBus, multipleRowsStoriesRecycleCallback, feedStorySubscriber, graphQLSubscriptionHolder, multipleRowsStoriesRecycleCallback2, reactionItemCollection, reactionUtil, searchResultsLogger, reactionUnitValidator, storyLikeHistoryLogger, storyMutationHelper);
    }

    public final int aZ_() {
        return super.aZ_() + 1;
    }

    public final ViewHolder m3365a(ViewGroup viewGroup, int i) {
        if (i != PagesSurfaceReactionViewTypeConstants.f2475a) {
            return super.a(viewGroup, i);
        }
        this.f2424j = new View(viewGroup.getContext());
        m3367h(this.f2425k);
        return new ReactionSimpleViewHolder(this.f2424j);
    }

    public int getItemViewType(int i) {
        if (i == aZ_() - 1) {
            return PagesSurfaceReactionViewTypeConstants.f2475a;
        }
        return super.getItemViewType(i);
    }

    public final void m3367h(int i) {
        this.f2425k = i;
        if (this.f2424j != null) {
            this.f2424j.setLayoutParams(new LayoutParams(-1, this.f2425k));
        }
    }

    public final ReactionHeaderTouchDelegateView m3366b(Context context) {
        ReactionHeaderTouchDelegateView b = super.b(context);
        b.c = true;
        return b;
    }
}

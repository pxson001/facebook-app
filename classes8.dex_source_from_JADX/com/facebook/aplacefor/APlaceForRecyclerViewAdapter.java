package com.facebook.aplacefor;

import android.content.Context;
import com.facebook.common.time.Clock;
import com.facebook.controller.mutation.StoryMutationHelper;
import com.facebook.feed.data.FeedStorySubscriber;
import com.facebook.feed.logging.StoryLikeHistoryLogger;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.feed.ReactionFeedAdapterFactory;
import com.facebook.reaction.feed.ReactionItemCollection;
import com.facebook.reaction.feed.ReactionRootPartDefinition;
import com.facebook.reaction.feed.environment.DefaultReactionFeedEnvironmentProvider;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandlerProvider;
import com.facebook.reaction.ui.recyclerview.ReactionMixedRecyclerViewAdapter;
import com.facebook.search.logging.SearchResultsLogger;
import javax.inject.Inject;

/* compiled from: key_load_more_places_to_review */
public class APlaceForRecyclerViewAdapter extends ReactionMixedRecyclerViewAdapter {
    private Context f10488j;
    private FeedListType f10489k;
    private BaseFeedStoryMenuHelper f10490l;
    private APlaceForEnvironmentProvider f10491m;
    private APlaceForEnvironment f10492n;
    private ReactionItemCollection f10493o;
    private final MultiRowAdapterBuilder f10494p;
    private final Lazy<ReactionRootPartDefinition<APlaceForEnvironment>> f10495q;

    /* compiled from: key_load_more_places_to_review */
    class C11201 implements Runnable {
        final /* synthetic */ APlaceForRecyclerViewAdapter f10454a;

        C11201(APlaceForRecyclerViewAdapter aPlaceForRecyclerViewAdapter) {
            this.f10454a = aPlaceForRecyclerViewAdapter;
        }

        public void run() {
            this.f10454a.mo720k();
        }
    }

    @Inject
    public APlaceForRecyclerViewAdapter(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, @Assisted ReactionCardContainer reactionCardContainer, ReactionAnalyticsLogger reactionAnalyticsLogger, Clock clock, DefaultReactionFeedEnvironmentProvider defaultReactionFeedEnvironmentProvider, ReactionExperimentController reactionExperimentController, ReactionFeedActionHandlerProvider reactionFeedActionHandlerProvider, ReactionFeedAdapterFactory reactionFeedAdapterFactory, FeedEventBus feedEventBus, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, FeedStorySubscriber feedStorySubscriber, GraphQLSubscriptionHolder graphQLSubscriptionHolder, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback2, ReactionItemCollection reactionItemCollection, ReactionUtil reactionUtil, SearchResultsLogger searchResultsLogger, ReactionUnitValidator reactionUnitValidator, StoryLikeHistoryLogger storyLikeHistoryLogger, StoryMutationHelper storyMutationHelper, APlaceForEnvironmentProvider aPlaceForEnvironmentProvider, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<ReactionRootPartDefinition> lazy) {
        super(context, feedListType, baseFeedStoryMenuHelper, reactionCardContainer, reactionAnalyticsLogger, clock, defaultReactionFeedEnvironmentProvider, reactionExperimentController, reactionFeedActionHandlerProvider, reactionFeedAdapterFactory, feedEventBus, multipleRowsStoriesRecycleCallback, feedStorySubscriber, graphQLSubscriptionHolder, multipleRowsStoriesRecycleCallback2, reactionItemCollection, reactionUtil, searchResultsLogger, reactionUnitValidator, storyLikeHistoryLogger, storyMutationHelper);
        this.f10488j = context;
        this.f10489k = feedListType;
        this.f10490l = baseFeedStoryMenuHelper;
        this.f10491m = aPlaceForEnvironmentProvider;
        this.f10493o = reactionItemCollection;
        this.f10494p = multiRowAdapterBuilder;
        this.f10495q = lazy;
    }

    protected final MultiRowRecyclerViewAdapter mo724q() {
        this.f10492n = this.f10491m.m12306a(this.f10488j, this.f10489k, this.f10490l, new C11201(this), this.f10457c, this.f10458d.getInteractionTracker(), this.f10455a, m12370r(), this.f10493o, this.f10458d);
        Builder a = this.f10494p.a(this.f10495q, this.f10493o);
        a.f = this.f10492n;
        return a.d();
    }
}

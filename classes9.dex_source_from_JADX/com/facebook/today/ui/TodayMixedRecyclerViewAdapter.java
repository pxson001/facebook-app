package com.facebook.today.ui;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.time.Clock;
import com.facebook.controller.mutation.StoryMutationHelper;
import com.facebook.feed.data.FeedStorySubscriber;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.logging.StoryLikeHistoryLogger;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.inject.Assisted;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.common.ReactionItem;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.feed.ReactionFeedAdapterFactory;
import com.facebook.reaction.feed.ReactionItemCollection;
import com.facebook.reaction.feed.ReactionItemCollection.1;
import com.facebook.reaction.feed.environment.DefaultReactionFeedEnvironmentProvider;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandlerProvider;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.facebook.reaction.ui.recyclerview.ReactionMixedRecyclerViewAdapter;
import com.facebook.search.logging.SearchResultsLogger;
import java.util.Collections;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: trouble_logging_in */
public class TodayMixedRecyclerViewAdapter extends ReactionMixedRecyclerViewAdapter {
    private Context f1255j;
    private TodayEnvironmentProvider f1256k;
    private AbstractFbErrorReporter f1257l;
    private FeedListType f1258m;
    private BaseFeedStoryMenuHelper f1259n;
    private final ReactionFeedActionHandlerProvider f1260o;
    private final ReactionFeedAdapterFactory f1261p;

    /* compiled from: trouble_logging_in */
    class C01201 implements Runnable {
        final /* synthetic */ TodayMixedRecyclerViewAdapter f1254a;

        C01201(TodayMixedRecyclerViewAdapter todayMixedRecyclerViewAdapter) {
            this.f1254a = todayMixedRecyclerViewAdapter;
        }

        public void run() {
            this.f1254a.k();
        }
    }

    @Inject
    public TodayMixedRecyclerViewAdapter(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, @Assisted ReactionCardContainer reactionCardContainer, ReactionAnalyticsLogger reactionAnalyticsLogger, Clock clock, DefaultReactionFeedEnvironmentProvider defaultReactionFeedEnvironmentProvider, ReactionExperimentController reactionExperimentController, ReactionFeedActionHandlerProvider reactionFeedActionHandlerProvider, ReactionFeedAdapterFactory reactionFeedAdapterFactory, AbstractFbErrorReporter abstractFbErrorReporter, FeedEventBus feedEventBus, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, FeedStorySubscriber feedStorySubscriber, GraphQLSubscriptionHolder graphQLSubscriptionHolder, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback2, ReactionItemCollection reactionItemCollection, ReactionFeedActionHandlerProvider reactionFeedActionHandlerProvider2, ReactionFeedAdapterFactory reactionFeedAdapterFactory2, ReactionUtil reactionUtil, TodayEnvironmentProvider todayEnvironmentProvider, SearchResultsLogger searchResultsLogger, ReactionUnitValidator reactionUnitValidator, StoryLikeHistoryLogger storyLikeHistoryLogger, StoryMutationHelper storyMutationHelper) {
        super(context, feedListType, baseFeedStoryMenuHelper, reactionCardContainer, reactionAnalyticsLogger, clock, defaultReactionFeedEnvironmentProvider, reactionExperimentController, reactionFeedActionHandlerProvider, reactionFeedAdapterFactory, feedEventBus, multipleRowsStoriesRecycleCallback, feedStorySubscriber, graphQLSubscriptionHolder, multipleRowsStoriesRecycleCallback2, reactionItemCollection, reactionUtil, searchResultsLogger, reactionUnitValidator, storyLikeHistoryLogger, storyMutationHelper);
        this.f1255j = context;
        this.f1256k = todayEnvironmentProvider;
        this.f1257l = abstractFbErrorReporter;
        this.f1258m = feedListType;
        this.f1259n = baseFeedStoryMenuHelper;
        this.f1260o = reactionFeedActionHandlerProvider2;
        this.f1261p = reactionFeedAdapterFactory2;
    }

    public final int m1417d() {
        return super.d() - m1412t();
    }

    protected final MultiRowRecyclerViewAdapter m1419q() {
        return this.f1261p.a(this.f1256k.m1393a(this.f1255j, this.f1258m, this.f1259n, new C01201(this), this.c, this.f1260o.a(this.f1255j, this.d), this.d.getInteractionTracker(), this.a, HasScrollListenerSupportImpl.b), this.z, null);
    }

    private int m1412t() {
        int i = 0;
        int d = super.d() - 1;
        int f = f(d);
        if (f >= e()) {
            this.f1257l.a(SoftError.b("TodayMixedRecyclerViewAdapter IndexOutOfBoundsException", "Attempting to get reaction node in postion " + f + " for collection size of " + e()));
        } else {
            int i2;
            ReactionItem e = e(f);
            if (e.k() == null || e.k().s().size() <= 0 || !((ReactionUnitComponentModel) e.k().s().get(0)).a().equals(GraphQLReactionUnitComponentStyle.TEXT_DIVIDER)) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                int f2 = f(d);
                while (f == f2 && d >= 0) {
                    d--;
                    f2 = f(d);
                    i++;
                }
            }
        }
        return i;
    }

    protected final void m1415b(ReactionStories reactionStories) {
        super.b(reactionStories);
        m1413u();
    }

    public final boolean m1414a(ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType) {
        boolean b = m1416b(reactionUnitFragment, str, cardSearchType);
        if (b) {
            m1413u();
        }
        k();
        return b;
    }

    protected final boolean m1416b(@Nullable ReactionUnitFragment reactionUnitFragment, String str, CardSearchType cardSearchType) {
        int b = b(str, cardSearchType);
        if (b >= 0) {
            a(str, b);
        } else {
            b = e();
        }
        if (reactionUnitFragment != null) {
            a(reactionUnitFragment, b);
        }
        return true;
    }

    protected final boolean m1418g(int i) {
        return super.g(i) && g() > 0;
    }

    private void m1413u() {
        ReactionItemCollection reactionItemCollection = this.z;
        Collections.sort(reactionItemCollection.a, new 1(reactionItemCollection));
    }
}

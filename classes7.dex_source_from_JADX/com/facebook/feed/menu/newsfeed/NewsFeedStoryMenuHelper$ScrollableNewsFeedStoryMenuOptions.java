package com.facebook.feed.menu.newsfeed;

import android.view.Menu;
import android.view.View;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNegativeFeedbackActionsConnection;
import com.facebook.graphql.model.GraphQLNegativeFeedbackActionsEdge;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.StorySetHelper;
import com.google.common.collect.ImmutableList;

/* compiled from: all_cards_enabled_message */
class NewsFeedStoryMenuHelper$ScrollableNewsFeedStoryMenuOptions extends BaseFeedStoryMenuOptions<GraphQLStorySet> {
    final /* synthetic */ NewsFeedStoryMenuHelper f19536b;

    public final void m22848a(Menu menu, FeedProps<GraphQLStorySet> feedProps, View view) {
        FeedProps a = feedProps.a(StorySetHelper.a((GraphQLStorySet) feedProps.a));
        NewsFeedStoryMenuHelper newsFeedStoryMenuHelper = this.f19536b;
        GraphQLNegativeFeedbackActionsConnection I = ((GraphQLStorySet) feedProps.a).I();
        if (!(I == null || I.a().isEmpty())) {
            ImmutableList a2 = I.a();
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                GraphQLNegativeFeedbackActionsEdge graphQLNegativeFeedbackActionsEdge = (GraphQLNegativeFeedbackActionsEdge) a2.get(i);
                if (NewsFeedStoryMenuHelper.s.contains(graphQLNegativeFeedbackActionsEdge.a().b())) {
                    newsFeedStoryMenuHelper.a(menu, feedProps, graphQLNegativeFeedbackActionsEdge, view);
                }
            }
        }
        if (a((FeedUnit) a.a)) {
            b(menu, a, view);
        }
        if (b(a)) {
            a(menu, a, view.getContext());
        }
        super.a(menu, feedProps, view);
    }

    public NewsFeedStoryMenuHelper$ScrollableNewsFeedStoryMenuOptions(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper) {
        this.f19536b = newsFeedStoryMenuHelper;
        super(newsFeedStoryMenuHelper);
    }
}

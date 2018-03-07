package com.facebook.feed.menu.newsfeed;

import android.view.View;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.GraphQLResearchPollFeedUnit;
import com.facebook.graphql.model.HideableUnit;

/* compiled from: all_cards_enabled_message */
class NewsFeedStoryMenuHelper$ResearchPollFeedUnitMenuOptions extends NewsFeedStoryMenuHelper$HideableFeedUnitMenuOptions<GraphQLResearchPollFeedUnit> {
    final /* synthetic */ NewsFeedStoryMenuHelper f19535b;

    public NewsFeedStoryMenuHelper$ResearchPollFeedUnitMenuOptions(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper) {
        this.f19535b = newsFeedStoryMenuHelper;
        super(newsFeedStoryMenuHelper);
    }

    protected final HoneyClientEvent mo1461a(HideableUnit hideableUnit, View view) {
        GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit = (GraphQLResearchPollFeedUnit) hideableUnit;
        NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f19535b.j;
        return NewsFeedAnalyticsEventBuilder.e(FeedTrackableUtil.a(graphQLResearchPollFeedUnit), false);
    }
}

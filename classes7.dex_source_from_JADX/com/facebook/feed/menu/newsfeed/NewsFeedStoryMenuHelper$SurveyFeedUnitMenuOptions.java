package com.facebook.feed.menu.newsfeed;

import android.view.View;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.GraphQLSurveyFeedUnit;
import com.facebook.graphql.model.HideableUnit;

/* compiled from: all_cards_enabled_message */
class NewsFeedStoryMenuHelper$SurveyFeedUnitMenuOptions extends NewsFeedStoryMenuHelper$HideableFeedUnitMenuOptions<GraphQLSurveyFeedUnit> {
    final /* synthetic */ NewsFeedStoryMenuHelper f19537b;

    public NewsFeedStoryMenuHelper$SurveyFeedUnitMenuOptions(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper) {
        this.f19537b = newsFeedStoryMenuHelper;
        super(newsFeedStoryMenuHelper);
    }

    protected final HoneyClientEvent mo1461a(HideableUnit hideableUnit, View view) {
        GraphQLSurveyFeedUnit graphQLSurveyFeedUnit = (GraphQLSurveyFeedUnit) hideableUnit;
        NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f19537b.j;
        return NewsFeedAnalyticsEventBuilder.e(FeedTrackableUtil.a(graphQLSurveyFeedUnit), false);
    }
}

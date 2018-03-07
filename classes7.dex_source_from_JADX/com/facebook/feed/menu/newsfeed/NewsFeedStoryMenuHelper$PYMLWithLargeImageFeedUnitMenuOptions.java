package com.facebook.feed.menu.newsfeed;

import android.view.View;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.VisibleItemHelper;
import com.fasterxml.jackson.databind.node.ArrayNode;

/* compiled from: all_cards_enabled_message */
class NewsFeedStoryMenuHelper$PYMLWithLargeImageFeedUnitMenuOptions extends NewsFeedStoryMenuHelper$HideableFeedUnitMenuOptions<GraphQLPYMLWithLargeImageFeedUnit> {
    final /* synthetic */ NewsFeedStoryMenuHelper f19528b;

    public NewsFeedStoryMenuHelper$PYMLWithLargeImageFeedUnitMenuOptions(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper) {
        this.f19528b = newsFeedStoryMenuHelper;
        super(newsFeedStoryMenuHelper);
    }

    protected final HoneyClientEvent mo1461a(HideableUnit hideableUnit, View view) {
        String str;
        GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit = (GraphQLPYMLWithLargeImageFeedUnit) hideableUnit;
        NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f19528b.j;
        ArrayNode c = VisibleItemHelper.c(graphQLPYMLWithLargeImageFeedUnit);
        if (null != null) {
            str = "pyml_unhide_feed_unit";
        } else {
            str = "pyml_hide_feed_unit";
        }
        HoneyClientEvent a = new HoneyClientEvent(str).a("tracking", c);
        a.c = "native_newsfeed";
        return a;
    }
}

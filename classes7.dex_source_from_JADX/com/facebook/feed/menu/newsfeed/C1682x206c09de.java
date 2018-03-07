package com.facebook.feed.menu.newsfeed;

import android.view.View;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.graphql.model.GraphQLCreativePagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.VisibleItemHelper;
import com.fasterxml.jackson.databind.node.ArrayNode;

/* compiled from: all_cards_enabled_message */
class C1682x206c09de extends NewsFeedStoryMenuHelper$HideableFeedUnitMenuOptions<GraphQLCreativePagesYouMayLikeFeedUnit> {
    final /* synthetic */ NewsFeedStoryMenuHelper f19488b;

    public C1682x206c09de(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper) {
        this.f19488b = newsFeedStoryMenuHelper;
        super(newsFeedStoryMenuHelper);
    }

    protected final HoneyClientEvent mo1461a(HideableUnit hideableUnit, View view) {
        String str;
        GraphQLCreativePagesYouMayLikeFeedUnit graphQLCreativePagesYouMayLikeFeedUnit = (GraphQLCreativePagesYouMayLikeFeedUnit) hideableUnit;
        NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f19488b.j;
        ArrayNode c = VisibleItemHelper.c(graphQLCreativePagesYouMayLikeFeedUnit);
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

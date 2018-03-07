package com.facebook.feed.menu.newsfeed;

import android.view.View;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.GraphQLPagesYouMayAdvertiseFeedUnit;
import com.facebook.graphql.model.HideableUnit;
import com.fasterxml.jackson.databind.node.ArrayNode;

/* compiled from: all_cards_enabled_message */
class NewsFeedStoryMenuHelper$PagesYouMayAdvertiseFeedUnitMenuOptions extends NewsFeedStoryMenuHelper$HideableFeedUnitMenuOptions<GraphQLPagesYouMayAdvertiseFeedUnit> {
    final /* synthetic */ NewsFeedStoryMenuHelper f19529b;

    public NewsFeedStoryMenuHelper$PagesYouMayAdvertiseFeedUnitMenuOptions(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper) {
        this.f19529b = newsFeedStoryMenuHelper;
        super(newsFeedStoryMenuHelper);
    }

    protected final HoneyClientEvent mo1461a(HideableUnit hideableUnit, View view) {
        HoneyClientEvent honeyClientEvent;
        GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit = (GraphQLPagesYouMayAdvertiseFeedUnit) hideableUnit;
        NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f19529b.j;
        ArrayNode a = FeedTrackableUtil.a(graphQLPagesYouMayAdvertiseFeedUnit);
        String str = "pyma_dont_want_to_see_menu_item";
        String valueOf = String.valueOf(graphQLPagesYouMayAdvertiseFeedUnit.r());
        if (NewsFeedAnalyticsEventBuilder.B(a)) {
            honeyClientEvent = null;
        } else {
            honeyClientEvent = new HoneyClientEvent("pyma_menu_item_click").a("tracking", a).b("option_name", str).b("pyma_category", valueOf);
            honeyClientEvent.c = "native_newsfeed";
            honeyClientEvent = honeyClientEvent;
        }
        return honeyClientEvent;
    }
}

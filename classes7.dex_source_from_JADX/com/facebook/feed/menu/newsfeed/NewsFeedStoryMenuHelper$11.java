package com.facebook.feed.menu.newsfeed;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.graphql.model.SponsoredImpression;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Preconditions;

/* compiled from: all_cards_enabled_message */
class NewsFeedStoryMenuHelper$11 implements OnMenuItemClickListener {
    final /* synthetic */ FeedProps f19451a;
    final /* synthetic */ String f19452b;
    final /* synthetic */ FeedUnit f19453c;
    final /* synthetic */ NewsFeedStoryMenuHelper f19454d;

    NewsFeedStoryMenuHelper$11(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper, FeedProps feedProps, String str, FeedUnit feedUnit) {
        this.f19454d = newsFeedStoryMenuHelper;
        this.f19451a = feedProps;
        this.f19452b = str;
        this.f19453c = feedUnit;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f19454d.a(this.f19451a, menuItem.getItemId(), this.f19452b, true);
        ArrayNode b = TrackableFeedProps.b(this.f19451a);
        NewsFeedStoryMenuHelper newsFeedStoryMenuHelper = this.f19454d;
        SponsoredImpression ab_ = ((Sponsorable) this.f19453c).ab_();
        Preconditions.checkNotNull(ab_);
        ab_.w = !ab_.w;
        newsFeedStoryMenuHelper.i.c(NewsFeedAnalyticsEventBuilder.a(b, ab_.w));
        return true;
    }
}

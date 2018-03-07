package com.facebook.feed.menu.newsfeed;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.feed.menu.newsfeed.NewsFeedStoryMenuHelper.NewsFeedStoryMenuOptions;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.FeedUnit;

/* compiled from: all_cards_enabled_message */
class NewsFeedStoryMenuHelper$NewsFeedStoryMenuOptions$5 implements OnMenuItemClickListener {
    final /* synthetic */ FeedProps f19524a;
    final /* synthetic */ String f19525b;
    final /* synthetic */ Context f19526c;
    final /* synthetic */ NewsFeedStoryMenuOptions f19527d;

    NewsFeedStoryMenuHelper$NewsFeedStoryMenuOptions$5(NewsFeedStoryMenuOptions newsFeedStoryMenuOptions, FeedProps feedProps, String str, Context context) {
        this.f19527d = newsFeedStoryMenuOptions;
        this.f19524a = feedProps;
        this.f19525b = str;
        this.f19526c = context;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f19527d.b.a(this.f19524a, menuItem.getItemId(), this.f19525b, true);
        this.f19527d.b.a((FeedUnit) this.f19524a.a, this.f19526c);
        return true;
    }
}

package com.facebook.feed.menu.newsfeed;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.feed.menu.newsfeed.NewsFeedStoryMenuHelper.NewsFeedStoryMenuOptions;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.FeedUnit;

/* compiled from: all_cards_enabled_message */
class NewsFeedStoryMenuHelper$NewsFeedStoryMenuOptions$4 implements OnMenuItemClickListener {
    final /* synthetic */ FeedProps f19520a;
    final /* synthetic */ String f19521b;
    final /* synthetic */ Context f19522c;
    final /* synthetic */ NewsFeedStoryMenuOptions f19523d;

    NewsFeedStoryMenuHelper$NewsFeedStoryMenuOptions$4(NewsFeedStoryMenuOptions newsFeedStoryMenuOptions, FeedProps feedProps, String str, Context context) {
        this.f19523d = newsFeedStoryMenuOptions;
        this.f19520a = feedProps;
        this.f19521b = str;
        this.f19522c = context;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f19523d.b.a(this.f19520a, menuItem.getItemId(), this.f19521b, true);
        this.f19523d.b.b((FeedUnit) this.f19520a.a, this.f19522c);
        return true;
    }
}

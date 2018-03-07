package com.facebook.feed.menu.newsfeed;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.FeedUnit;

/* compiled from: all_cards_enabled_message */
public class NewsFeedStoryMenuHelper$6 implements OnMenuItemClickListener {
    final /* synthetic */ FeedProps f19470a;
    final /* synthetic */ View f19471b;
    final /* synthetic */ NewsFeedStoryMenuHelper f19472c;

    public NewsFeedStoryMenuHelper$6(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper, FeedProps feedProps, View view) {
        this.f19472c = newsFeedStoryMenuHelper;
        this.f19470a = feedProps;
        this.f19471b = view;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f19472c.a((FeedUnit) this.f19470a.a, this.f19471b);
        NewsFeedStoryMenuHelper.a(this.f19472c, this.f19470a, this.f19471b, null);
        return true;
    }
}

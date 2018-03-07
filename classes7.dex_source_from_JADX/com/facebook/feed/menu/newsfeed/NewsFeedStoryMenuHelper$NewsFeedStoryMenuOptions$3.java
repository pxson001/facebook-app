package com.facebook.feed.menu.newsfeed;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.feed.menu.newsfeed.NewsFeedStoryMenuHelper.NewsFeedStoryMenuOptions;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: all_cards_enabled_message */
class NewsFeedStoryMenuHelper$NewsFeedStoryMenuOptions$3 implements OnMenuItemClickListener {
    final /* synthetic */ FeedProps f19515a;
    final /* synthetic */ String f19516b;
    final /* synthetic */ GraphQLStory f19517c;
    final /* synthetic */ Context f19518d;
    final /* synthetic */ NewsFeedStoryMenuOptions f19519e;

    NewsFeedStoryMenuHelper$NewsFeedStoryMenuOptions$3(NewsFeedStoryMenuOptions newsFeedStoryMenuOptions, FeedProps feedProps, String str, GraphQLStory graphQLStory, Context context) {
        this.f19519e = newsFeedStoryMenuOptions;
        this.f19515a = feedProps;
        this.f19516b = str;
        this.f19517c = graphQLStory;
        this.f19518d = context;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f19519e.b.a(this.f19515a, menuItem.getItemId(), this.f19516b, true);
        this.f19519e.b.a(this.f19517c, this.f19518d);
        return true;
    }
}

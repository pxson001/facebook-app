package com.facebook.feed.menu.newsfeed;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.feed.menu.newsfeed.NewsFeedStoryMenuHelper.NewsFeedStoryMenuOptions;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: all_cards_enabled_message */
public class NewsFeedStoryMenuHelper$NewsFeedStoryMenuOptions$1 implements OnMenuItemClickListener {
    final /* synthetic */ Context f19507a;
    final /* synthetic */ GraphQLStory f19508b;
    final /* synthetic */ NewsFeedStoryMenuOptions f19509c;

    public NewsFeedStoryMenuHelper$NewsFeedStoryMenuOptions$1(NewsFeedStoryMenuOptions newsFeedStoryMenuOptions, Context context, GraphQLStory graphQLStory) {
        this.f19509c = newsFeedStoryMenuOptions;
        this.f19507a = context;
        this.f19508b = graphQLStory;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f19509c.b.D.a(this.f19507a, this.f19508b);
        return true;
    }
}

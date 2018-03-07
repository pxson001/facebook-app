package com.facebook.feed.menu.newsfeed;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: all_cards_enabled_message */
public class NewsFeedStoryMenuHelper$3 implements OnClickListener {
    final /* synthetic */ FeedProps f19463a;
    final /* synthetic */ Context f19464b;
    final /* synthetic */ NewsFeedStoryMenuHelper f19465c;

    public NewsFeedStoryMenuHelper$3(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper, FeedProps feedProps, Context context) {
        this.f19465c = newsFeedStoryMenuHelper;
        this.f19463a = feedProps;
        this.f19464b = context;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19465c.a((GraphQLStory) this.f19463a.a, this.f19464b);
    }
}

package com.facebook.feed.menu.newsfeed;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.feed.rows.core.props.FeedProps;

/* compiled from: all_cards_enabled_message */
public class NewsFeedStoryMenuHelper$4 implements OnClickListener {
    final /* synthetic */ FeedProps f19466a;
    final /* synthetic */ NewsFeedStoryMenuHelper f19467b;

    public NewsFeedStoryMenuHelper$4(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper, FeedProps feedProps) {
        this.f19467b = newsFeedStoryMenuHelper;
        this.f19466a = feedProps;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19467b.a(this.f19466a);
    }
}

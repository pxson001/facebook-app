package com.facebook.feed.menu.newsfeed;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.feed.rows.core.props.FeedProps;

/* compiled from: all_cards_enabled_message */
public class NewsFeedStoryMenuHelper$2 implements OnClickListener {
    final /* synthetic */ FeedProps f19461a;
    final /* synthetic */ NewsFeedStoryMenuHelper f19462b;

    public NewsFeedStoryMenuHelper$2(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper, FeedProps feedProps) {
        this.f19462b = newsFeedStoryMenuHelper;
        this.f19461a = feedProps;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19462b.a(this.f19461a);
    }
}

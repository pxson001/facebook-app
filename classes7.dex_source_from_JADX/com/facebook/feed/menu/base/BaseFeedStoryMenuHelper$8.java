package com.facebook.feed.menu.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.feed.rows.core.props.FeedProps;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$8 implements OnClickListener {
    final /* synthetic */ FeedProps f19397a;
    final /* synthetic */ BaseFeedStoryMenuHelper f19398b;

    BaseFeedStoryMenuHelper$8(BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, FeedProps feedProps) {
        this.f19398b = baseFeedStoryMenuHelper;
        this.f19397a = feedProps;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19398b.a(this.f19397a);
    }
}

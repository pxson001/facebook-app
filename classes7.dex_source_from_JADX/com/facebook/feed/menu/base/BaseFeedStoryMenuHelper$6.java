package com.facebook.feed.menu.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.feed.rows.core.props.FeedProps;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$6 implements OnClickListener {
    final /* synthetic */ FeedProps f19392a;
    final /* synthetic */ BaseFeedStoryMenuHelper f19393b;

    BaseFeedStoryMenuHelper$6(BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, FeedProps feedProps) {
        this.f19393b = baseFeedStoryMenuHelper;
        this.f19392a = feedProps;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f19393b.a(this.f19392a);
    }
}

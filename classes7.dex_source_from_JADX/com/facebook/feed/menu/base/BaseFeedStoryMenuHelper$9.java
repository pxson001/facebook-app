package com.facebook.feed.menu.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.feed.rows.core.props.FeedProps;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$9 implements OnClickListener {
    final /* synthetic */ FeedProps f19399a;
    final /* synthetic */ BaseFeedStoryMenuHelper f19400b;

    BaseFeedStoryMenuHelper$9(BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, FeedProps feedProps) {
        this.f19400b = baseFeedStoryMenuHelper;
        this.f19399a = feedProps;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        BaseFeedStoryMenuHelper.c(this.f19400b, this.f19399a);
    }
}

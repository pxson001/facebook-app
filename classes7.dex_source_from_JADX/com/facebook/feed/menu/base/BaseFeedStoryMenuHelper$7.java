package com.facebook.feed.menu.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.ProductItemEvents.ToggleAvailabilitySurface;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$7 implements OnClickListener {
    final /* synthetic */ boolean f19394a;
    final /* synthetic */ FeedProps f19395b;
    final /* synthetic */ BaseFeedStoryMenuHelper f19396c;

    BaseFeedStoryMenuHelper$7(BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, boolean z, FeedProps feedProps) {
        this.f19396c = baseFeedStoryMenuHelper;
        this.f19394a = z;
        this.f19395b = feedProps;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f19394a) {
            BaseFeedStoryMenuHelper.c(this.f19396c, this.f19395b);
        } else {
            this.f19396c.t.a(this.f19395b, ToggleAvailabilitySurface.DELETE_INTERCEPT);
        }
    }
}

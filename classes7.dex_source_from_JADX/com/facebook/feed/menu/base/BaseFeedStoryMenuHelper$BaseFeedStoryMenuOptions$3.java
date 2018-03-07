package com.facebook.feed.menu.base;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.analytics.CurationMechanism;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.rows.core.props.FeedProps;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$BaseFeedStoryMenuOptions$3 implements OnMenuItemClickListener {
    final /* synthetic */ FeedProps f19409a;
    final /* synthetic */ String f19410b;
    final /* synthetic */ BaseFeedStoryMenuOptions f19411c;

    BaseFeedStoryMenuHelper$BaseFeedStoryMenuOptions$3(BaseFeedStoryMenuOptions baseFeedStoryMenuOptions, FeedProps feedProps, String str) {
        this.f19411c = baseFeedStoryMenuOptions;
        this.f19409a = feedProps;
        this.f19410b = str;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f19411c.a.a(this.f19409a, menuItem.getItemId(), this.f19410b, true);
        this.f19411c.a.v.b(this.f19409a, CurationMechanism.CARET_MENU, this.f19411c.a.b());
        this.f19411c.a.v.a();
        return true;
    }
}

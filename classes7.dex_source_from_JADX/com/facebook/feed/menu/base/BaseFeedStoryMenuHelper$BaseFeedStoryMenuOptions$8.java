package com.facebook.feed.menu.base;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.rows.core.props.FeedProps;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$BaseFeedStoryMenuOptions$8 implements OnMenuItemClickListener {
    final /* synthetic */ FeedProps f19433a;
    final /* synthetic */ String f19434b;
    final /* synthetic */ BaseFeedStoryMenuOptions f19435c;

    BaseFeedStoryMenuHelper$BaseFeedStoryMenuOptions$8(BaseFeedStoryMenuOptions baseFeedStoryMenuOptions, FeedProps feedProps, String str) {
        this.f19435c = baseFeedStoryMenuOptions;
        this.f19433a = feedProps;
        this.f19434b = str;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f19435c.a.t.a(this.f19433a, this.f19435c.a.j());
        this.f19435c.a.a(this.f19433a, menuItem.getItemId(), this.f19434b, true);
        return true;
    }
}

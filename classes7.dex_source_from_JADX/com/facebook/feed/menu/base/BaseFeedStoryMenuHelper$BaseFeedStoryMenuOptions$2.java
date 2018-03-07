package com.facebook.feed.menu.base;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.analytics.CurationMechanism;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.rows.core.props.FeedProps;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$BaseFeedStoryMenuOptions$2 implements OnMenuItemClickListener {
    final /* synthetic */ FeedProps f19405a;
    final /* synthetic */ String f19406b;
    final /* synthetic */ View f19407c;
    final /* synthetic */ BaseFeedStoryMenuOptions f19408d;

    BaseFeedStoryMenuHelper$BaseFeedStoryMenuOptions$2(BaseFeedStoryMenuOptions baseFeedStoryMenuOptions, FeedProps feedProps, String str, View view) {
        this.f19408d = baseFeedStoryMenuOptions;
        this.f19405a = feedProps;
        this.f19406b = str;
        this.f19407c = view;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f19408d.a.a(this.f19405a, menuItem.getItemId(), this.f19406b, true);
        this.f19408d.a.v.a(this.f19405a, CurationMechanism.CARET_MENU, this.f19408d.a.b());
        this.f19408d.a.v.a(this.f19407c);
        this.f19408d.a.v.a(this.f19407c.getContext());
        return true;
    }
}

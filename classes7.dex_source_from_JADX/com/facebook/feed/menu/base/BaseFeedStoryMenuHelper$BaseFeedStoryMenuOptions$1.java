package com.facebook.feed.menu.base;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.common.util.ClipboardUtil;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$BaseFeedStoryMenuOptions$1 implements OnMenuItemClickListener {
    final /* synthetic */ FeedProps f19401a;
    final /* synthetic */ String f19402b;
    final /* synthetic */ Context f19403c;
    final /* synthetic */ BaseFeedStoryMenuOptions f19404d;

    BaseFeedStoryMenuHelper$BaseFeedStoryMenuOptions$1(BaseFeedStoryMenuOptions baseFeedStoryMenuOptions, FeedProps feedProps, String str, Context context) {
        this.f19404d = baseFeedStoryMenuOptions;
        this.f19401a = feedProps;
        this.f19402b = str;
        this.f19403c = context;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f19404d.a.a(this.f19401a, menuItem.getItemId(), this.f19402b, true);
        ClipboardUtil.a(this.f19403c, GraphQLStoryUtil.q(this.f19401a));
        ((Toaster) this.f19404d.a.d.get()).b(new ToastBuilder(2131232721));
        return true;
    }
}

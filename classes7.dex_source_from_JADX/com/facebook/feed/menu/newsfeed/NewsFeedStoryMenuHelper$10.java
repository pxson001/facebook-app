package com.facebook.feed.menu.newsfeed;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.fasterxml.jackson.databind.node.ArrayNode;

/* compiled from: all_cards_enabled_message */
public class NewsFeedStoryMenuHelper$10 implements OnMenuItemClickListener {
    final /* synthetic */ FeedProps f19447a;
    final /* synthetic */ String f19448b;
    final /* synthetic */ View f19449c;
    final /* synthetic */ NewsFeedStoryMenuHelper f19450d;

    public NewsFeedStoryMenuHelper$10(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper, FeedProps feedProps, String str, View view) {
        this.f19450d = newsFeedStoryMenuHelper;
        this.f19447a = feedProps;
        this.f19448b = str;
        this.f19449c = view;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f19450d.a(this.f19447a, menuItem.getItemId(), this.f19448b, true);
        ArrayNode b = TrackableFeedProps.b(this.f19447a);
        NewsFeedStoryMenuHelper newsFeedStoryMenuHelper = this.f19450d;
        View view = this.f19449c;
        newsFeedStoryMenuHelper.e().a(view.getContext(), StringLocaleUtil.a(FBLinks.dB, new Object[]{b}));
        return true;
    }
}

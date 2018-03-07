package com.facebook.feedplugins.pyml.controllers;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import com.facebook.feed.hscroll.HScrollFeedItem.Position;
import com.facebook.feed.hscroll.HScrollFeedItemController;
import com.facebook.feed.ui.itemlistfeedunits.FeedListItemUserActionListener;
import com.facebook.feedplugins.pyml.controllers.HScrollFeedUnitView.ItemListRecyclablePagerAdapter;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;

@Deprecated
/* compiled from: android_sdk_error_categories */
public abstract class HScrollFeedUnitController extends HScrollFeedItemController {
    public abstract void mo888a(ScrollableItemListFeedUnit scrollableItemListFeedUnit, View view, Object obj, Position position, FeedListItemUserActionListener feedListItemUserActionListener);

    public abstract void mo889a(ScrollableItemListFeedUnit scrollableItemListFeedUnit, TextView textView, View view);

    public abstract Class<? extends ScrollableItemListFeedUnit> mo890c();

    public void mo887a(ItemListRecyclablePagerAdapter itemListRecyclablePagerAdapter, ViewPager viewPager) {
    }

    public boolean mo891d() {
        return true;
    }
}

package com.facebook.feed.menu.newsfeed;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.menu.base.StoryMenuIconUtil;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;

/* compiled from: all_cards_enabled_message */
class NewsFeedStoryMenuHelper$NetEgoStoriesFeedUnitStoryMenuOptions extends BaseFeedStoryMenuOptions<HideableUnit> {
    final /* synthetic */ NewsFeedStoryMenuHelper f19506b;

    public NewsFeedStoryMenuHelper$NetEgoStoriesFeedUnitStoryMenuOptions(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper) {
        this.f19506b = newsFeedStoryMenuHelper;
        super(newsFeedStoryMenuHelper);
    }

    public final void m22842a(Menu menu, FeedProps<HideableUnit> feedProps, View view) {
        NewsFeedStoryMenuHelper newsFeedStoryMenuHelper = this.f19506b;
        MenuItem add = menu.add(2131233432);
        newsFeedStoryMenuHelper.a(add, StoryMenuIconUtil.m22824a(GraphQLNegativeFeedbackActionType.HIDE), (FeedUnit) feedProps.a);
        add.setOnMenuItemClickListener(new NewsFeedStoryMenuHelper$6(newsFeedStoryMenuHelper, feedProps, view));
        if (feedProps.a instanceof ScrollableItemListFeedUnit) {
            ScrollableItemListFeedUnit scrollableItemListFeedUnit = (ScrollableItemListFeedUnit) feedProps.a;
            FeedProps c = FeedProps.c((Flattenable) ScrollableItemListFeedUnitImpl.a(scrollableItemListFeedUnit).get(scrollableItemListFeedUnit.ac_()));
            if (a((FeedUnit) c.a)) {
                b(menu, c, view);
            }
            if (b(c)) {
                a(menu, c, view.getContext());
            }
            super.a(menu, feedProps, view);
        }
    }
}

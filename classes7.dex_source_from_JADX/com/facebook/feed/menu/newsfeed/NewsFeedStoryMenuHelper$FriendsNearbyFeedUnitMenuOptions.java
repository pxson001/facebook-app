package com.facebook.feed.menu.newsfeed;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLFriendsLocationsFeedUnit;

/* compiled from: all_cards_enabled_message */
public class NewsFeedStoryMenuHelper$FriendsNearbyFeedUnitMenuOptions extends BaseFeedStoryMenuOptions<GraphQLFriendsLocationsFeedUnit> {
    public final /* synthetic */ NewsFeedStoryMenuHelper f19492b;

    public NewsFeedStoryMenuHelper$FriendsNearbyFeedUnitMenuOptions(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper) {
        this.f19492b = newsFeedStoryMenuHelper;
        super(newsFeedStoryMenuHelper);
    }

    public final void m22838a(Menu menu, FeedProps<GraphQLFriendsLocationsFeedUnit> feedProps, final View view) {
        menu.add(2131230747).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ NewsFeedStoryMenuHelper$FriendsNearbyFeedUnitMenuOptions f19491b;

            public boolean onMenuItemClick(MenuItem menuItem) {
                NewsFeedStoryMenuHelper$FriendsNearbyFeedUnitMenuOptions newsFeedStoryMenuHelper$FriendsNearbyFeedUnitMenuOptions = this.f19491b;
                View view = view;
                Uri build = new Builder().scheme(FBLinks.a).authority("faceweb").path("f").appendQueryParameter("href", "/tour/locationsharing/learnmore").build();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(build);
                newsFeedStoryMenuHelper$FriendsNearbyFeedUnitMenuOptions.f19492b.d().a(intent, view.getContext());
                return true;
            }
        });
    }
}

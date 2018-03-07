package com.facebook.feed.menu.newsfeed;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.graphqlstory.seefirsttombstone.SeeFirstTombstonePersistentState;
import com.facebook.feedplugins.graphqlstory.seefirsttombstone.SeeFirstTombstoneStoryKey;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.calls.ProfileUpdateSecondarySubscribeStatusInputData.Location;
import com.facebook.graphql.calls.ProfileUpdateSecondarySubscribeStatusInputData.NewStatus;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: all_cards_enabled_message */
class NewsFeedStoryMenuHelper$7 implements OnMenuItemClickListener {
    final /* synthetic */ GraphQLActor f19473a;
    final /* synthetic */ FeedProps f19474b;
    final /* synthetic */ String f19475c;
    final /* synthetic */ GraphQLStory f19476d;
    final /* synthetic */ NewsFeedStoryMenuHelper f19477e;

    NewsFeedStoryMenuHelper$7(NewsFeedStoryMenuHelper newsFeedStoryMenuHelper, GraphQLActor graphQLActor, FeedProps feedProps, String str, GraphQLStory graphQLStory) {
        this.f19477e = newsFeedStoryMenuHelper;
        this.f19473a = graphQLActor;
        this.f19474b = feedProps;
        this.f19475c = str;
        this.f19476d = graphQLStory;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        boolean z;
        ((FriendingClient) this.f19477e.z.get()).a(String.valueOf(this.f19473a.H()), NewStatus.REGULAR_FOLLOW, Location.FEED_X_MENU);
        this.f19477e.a(this.f19474b, menuItem.getItemId(), this.f19475c, true);
        SeeFirstTombstonePersistentState seeFirstTombstonePersistentState = (SeeFirstTombstonePersistentState) this.f19477e.f().a(new SeeFirstTombstoneStoryKey(this.f19476d), this.f19476d);
        seeFirstTombstonePersistentState.a(this.f19473a);
        if (this.f19473a != null) {
            z = true;
        } else {
            z = false;
        }
        seeFirstTombstonePersistentState.d = z;
        this.f19477e.f().a(new FeedProps[]{this.f19474b});
        return true;
    }
}

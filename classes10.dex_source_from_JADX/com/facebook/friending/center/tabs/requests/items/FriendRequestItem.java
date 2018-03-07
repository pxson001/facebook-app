package com.facebook.friending.center.tabs.requests.items;

import com.facebook.friending.center.model.FriendRequestModel;
import com.facebook.friending.center.model.FriendsCenterListItemModel;

/* compiled from: admin_posts_only */
public class FriendRequestItem extends FriendRequestModel implements RequestsListItem {

    /* compiled from: admin_posts_only */
    public class Builder extends com.facebook.friending.center.model.FriendRequestModel.Builder<Builder> {
        public final /* synthetic */ FriendRequestModel mo896a() {
            return m20395c();
        }

        public final /* synthetic */ FriendsCenterListItemModel mo892b() {
            return m20395c();
        }

        public final FriendRequestItem m20395c() {
            return new FriendRequestItem(this);
        }
    }

    protected FriendRequestItem(Builder builder) {
        super(builder);
    }

    public final boolean mo898o() {
        return true;
    }

    public final RequestsListItemType mo897n() {
        return this.f20012e ? RequestsListItemType.FRIEND_REQUEST : RequestsListItemType.RESPONDED_REQUEST;
    }
}

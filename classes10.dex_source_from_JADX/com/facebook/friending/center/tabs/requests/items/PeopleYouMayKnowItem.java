package com.facebook.friending.center.tabs.requests.items;

import com.facebook.friending.center.model.FriendsCenterListItemModel;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;

/* compiled from: added_admin_thread_summary */
public class PeopleYouMayKnowItem extends FriendsCenterListItemModel implements RequestsListItem {

    /* compiled from: added_admin_thread_summary */
    public class Builder extends com.facebook.friending.center.model.FriendsCenterListItemModel.Builder<Builder> {
        public final /* synthetic */ FriendsCenterListItemModel mo892b() {
            return m20406a();
        }

        public final PeopleYouMayKnowItem m20406a() {
            return new PeopleYouMayKnowItem(this);
        }
    }

    protected PeopleYouMayKnowItem(Builder builder) {
        super(builder);
    }

    public final RequestsListItemType mo897n() {
        GraphQLFriendshipStatus f = m20179f();
        if (GraphQLFriendshipStatus.CAN_REQUEST.equals(f) || GraphQLFriendshipStatus.INCOMING_REQUEST.equals(f)) {
            return RequestsListItemType.PERSON_YOU_MAY_KNOW;
        }
        return RequestsListItemType.RESPONDED_PERSON_YOU_MAY_KNOW;
    }

    public final boolean mo898o() {
        return true;
    }
}

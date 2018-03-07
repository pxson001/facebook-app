package com.facebook.friending.common.list.model;

import com.facebook.graphql.enums.GraphQLFriendshipStatus;

/* compiled from: me/privacy_setting */
public interface FriendListItemModel extends FriendListUserCommonModel, HasFriendingLocation, HasMutableFriendshipStatus, HasSocialContext {
    void m16698a(GraphQLFriendshipStatus graphQLFriendshipStatus);

    GraphQLFriendshipStatus m16699c();
}

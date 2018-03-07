package com.facebook.profile.api;

import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;

/* compiled from: icons */
public enum RelationshipType {
    UNDEFINED(0),
    SELF(1),
    FRIEND(2),
    SUBSCRIBED_TO(3),
    UNKNOWN_RELATIONSHIP(4);
    
    private int mType;

    private RelationshipType(int i) {
        this.mType = i;
    }

    public final int getValue() {
        return this.mType;
    }

    public static RelationshipType getRelationshipType(boolean z, GraphQLFriendshipStatus graphQLFriendshipStatus, GraphQLSubscribeStatus graphQLSubscribeStatus) {
        if (z) {
            return SELF;
        }
        if (GraphQLFriendshipStatus.ARE_FRIENDS.equals(graphQLFriendshipStatus)) {
            return FRIEND;
        }
        if (graphQLSubscribeStatus == GraphQLSubscribeStatus.IS_SUBSCRIBED) {
            return SUBSCRIBED_TO;
        }
        return UNKNOWN_RELATIONSHIP;
    }
}

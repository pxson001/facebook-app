package com.facebook.feed.environment.impl;

import com.facebook.graphql.enums.GraphQLFriendshipStatus;

/* compiled from: multimediaInfo */
/* synthetic */ class CanFriendPersonImpl$1 {
    static final /* synthetic */ int[] f10148a = new int[GraphQLFriendshipStatus.values().length];

    static {
        try {
            f10148a[GraphQLFriendshipStatus.ARE_FRIENDS.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f10148a[GraphQLFriendshipStatus.CAN_REQUEST.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f10148a[GraphQLFriendshipStatus.INCOMING_REQUEST.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f10148a[GraphQLFriendshipStatus.OUTGOING_REQUEST.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}

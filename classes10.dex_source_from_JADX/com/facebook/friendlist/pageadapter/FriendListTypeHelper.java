package com.facebook.friendlist.pageadapter;

import com.facebook.friendlist.constants.FriendListType;
import com.google.common.collect.ImmutableList;

/* compiled from: acch */
public final class FriendListTypeHelper {
    private static final ImmutableList<FriendListType> f20419a = ImmutableList.of(FriendListType.ALL_FRIENDS, FriendListType.RECENTLY_ADDED_FRIENDS, FriendListType.FRIENDS_WITH_NEW_POSTS);
    private static final ImmutableList<FriendListType> f20420b = ImmutableList.of(FriendListType.SUGGESTIONS, FriendListType.MUTUAL_FRIENDS, FriendListType.ALL_FRIENDS);

    public static ImmutableList<FriendListType> m20682a(boolean z) {
        return z ? f20419a : f20420b;
    }
}

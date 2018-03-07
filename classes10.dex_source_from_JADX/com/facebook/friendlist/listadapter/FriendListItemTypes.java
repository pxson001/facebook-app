package com.facebook.friendlist.listadapter;

import com.google.common.collect.ImmutableList;

/* compiled from: action_context */
public enum FriendListItemTypes {
    FRIEND,
    HEADER;
    
    public static final ImmutableList<FriendListItemTypes> VALUES = null;

    static {
        VALUES = ImmutableList.copyOf(values());
    }
}

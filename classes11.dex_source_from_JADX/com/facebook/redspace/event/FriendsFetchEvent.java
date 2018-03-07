package com.facebook.redspace.event;

import com.facebook.redspace.data.RedSpaceFriendsFetchResult;
import com.facebook.redspace.data.RedSpaceFriendsSection;

/* compiled from: PenaltyLog */
public class FriendsFetchEvent implements RedSpaceEvent {
    public final RedSpaceFriendsSection f11929a;
    public final RedSpaceFriendsFetchResult f11930b;

    public FriendsFetchEvent(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsFetchResult redSpaceFriendsFetchResult) {
        this.f11929a = redSpaceFriendsSection;
        this.f11930b = redSpaceFriendsFetchResult;
    }
}

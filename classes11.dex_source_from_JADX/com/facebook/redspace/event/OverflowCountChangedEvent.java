package com.facebook.redspace.event;

import com.facebook.redspace.data.RedSpaceFriendsSection;

/* compiled from: PenaltyDropBox */
public class OverflowCountChangedEvent implements RedSpaceEvent {
    public final RedSpaceFriendsSection f11931a;
    public final int f11932b;

    public OverflowCountChangedEvent(RedSpaceFriendsSection redSpaceFriendsSection, int i) {
        this.f11931a = redSpaceFriendsSection;
        this.f11932b = i;
    }
}

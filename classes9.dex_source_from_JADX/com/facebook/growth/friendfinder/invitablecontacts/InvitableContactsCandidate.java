package com.facebook.growth.friendfinder.invitablecontacts;

import com.facebook.friends.constants.PeopleYouMayInviteLocation;

/* compiled from: page_likes */
public class InvitableContactsCandidate {
    public final long f7348a;
    public final String f7349b;
    public final String f7350c;
    public final PeopleYouMayInviteLocation f7351d = PeopleYouMayInviteLocation.CI_FRIENDS_CENTER;
    public InviteState f7352e = InviteState.UNINVITED;

    /* compiled from: page_likes */
    public enum InviteState {
        UNINVITED,
        PENDING_CAN_UNDO,
        PENDING_CANNOT_UNDO,
        INVITED
    }

    public InvitableContactsCandidate(long j, String str, String str2) {
        this.f7348a = j;
        this.f7349b = str;
        this.f7350c = str2;
    }
}

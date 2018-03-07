package com.facebook.events.invite;

import com.facebook.common.time.AwakeTimeSinceBootClock;

/* compiled from: checkCodeParams */
public class InviteSubSession {
    public InviteSubSessionTypes f17724a;
    public boolean f17725b;
    public int f17726c;
    public int f17727d;
    public int f17728e;
    public long f17729f;
    public long f17730g;

    /* compiled from: checkCodeParams */
    public enum InviteSubSessionTypes {
        ALL_CANDIDATES_ALPHABETICAL,
        ALL_CANDIDATES_SUGGESTED,
        CONTACTS,
        INVITE_SEARCH,
        REVIEW
    }

    public final void m18059e() {
        this.f17729f += Long.valueOf(AwakeTimeSinceBootClock.INSTANCE.now() - this.f17730g).longValue();
        this.f17730g = 0;
        this.f17725b = false;
    }

    public InviteSubSession(InviteSubSessionTypes inviteSubSessionTypes) {
        this.f17724a = inviteSubSessionTypes;
    }

    public final void m18058a() {
        this.f17726c++;
    }
}

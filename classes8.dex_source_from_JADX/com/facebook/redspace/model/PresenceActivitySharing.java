package com.facebook.redspace.model;

import com.facebook.presence.PresenceState;
import com.facebook.redspace.model.RedSpaceSharedActivities.SharedActivity;

/* compiled from: USER_CENTERED_MAP_REGION */
public class PresenceActivitySharing implements SharedActivity {
    public boolean f21339a;
    public boolean f21340b;
    public PresenceState f21341c = PresenceState.a;
    public long f21342d;

    public final boolean mo1161e() {
        return this.f21339a && (this.f21340b || this.f21342d > 0);
    }
}

package com.facebook.places.checkin.ipc;

/* compiled from: friend_list_id */
public enum CheckinComposerEntryPoint {
    Status("status"),
    Photo("photo"),
    Checkin("checkin"),
    Other("other");
    
    public final String mName;

    private CheckinComposerEntryPoint(String str) {
        this.mName = str;
    }

    public final String toString() {
        return this.mName;
    }
}

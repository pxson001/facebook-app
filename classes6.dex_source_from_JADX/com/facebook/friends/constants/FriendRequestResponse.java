package com.facebook.friends.constants;

/* compiled from: me/mobile_perftraces */
public enum FriendRequestResponse {
    CONFIRM("1"),
    REJECT("2");
    
    public final String value;

    private FriendRequestResponse(String str) {
        this.value = str;
    }
}

package com.facebook.gametime.constants;

/* compiled from: registration_error_id */
public enum GametimeRef {
    DASHBOARD("dashboard"),
    INTERN_SETTINGS("intern_settings"),
    NEWSFEED("newsfeed");
    
    public final String value;

    private GametimeRef(String str) {
        this.value = str;
    }
}

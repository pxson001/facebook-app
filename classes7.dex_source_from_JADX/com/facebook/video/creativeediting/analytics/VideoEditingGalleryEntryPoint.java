package com.facebook.video.creativeediting.analytics;

/* compiled from: dtsc */
public enum VideoEditingGalleryEntryPoint {
    COMPOSER("composer"),
    PROFILE_VIDEO("profile_video"),
    UNKNOWN("unknown");
    
    private final String name;

    private VideoEditingGalleryEntryPoint(String str) {
        this.name = str;
    }

    public final String getParamKey() {
        return this.name;
    }
}

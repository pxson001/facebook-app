package com.facebook.video.creativeediting.analytics;

/* compiled from: dtsl */
public enum ComposerEntryPoint {
    TAP_VIDEO("tap_video"),
    CLICK_EDIT_BUTTON("edit_button"),
    TAP_PLAYER("tap_player");
    
    private final String name;

    private ComposerEntryPoint(String str) {
        this.name = str;
    }

    public final String getParamKey() {
        return this.name;
    }
}

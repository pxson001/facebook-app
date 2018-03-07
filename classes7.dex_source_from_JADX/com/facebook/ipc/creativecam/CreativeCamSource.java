package com.facebook.ipc.creativecam;

/* compiled from: place_unsave_success */
public enum CreativeCamSource {
    UNKNOWN("unknown"),
    SIMPLEPICKER_LIVECAM_CELL("simplepicker_livecam_cell"),
    SIMPLEPICKER_CAMERA_BUTTON("simplepicker_camera_button"),
    PRODUCTION_PROMPTS("production_prompts"),
    FAVORITE_MEDIA_PICKER("favorite_media_picker");
    
    private final String name;

    private CreativeCamSource(String str) {
        this.name = str;
    }

    public final String toString() {
        return this.name;
    }
}

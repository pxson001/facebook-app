package com.facebook.ipc.creativecam;

/* compiled from: placelist_story_convert */
public enum CreativeCamMediaSource {
    CREATIVE_CAM_FRONT("creative_cam_front"),
    CREATIVE_CAM_BACK("creative_cam_back"),
    CREATIVE_CAM_PICKER("creative_cam_picker");
    
    private final String name;

    private CreativeCamMediaSource(String str) {
        this.name = str;
    }

    public final String toString() {
        return this.name;
    }
}

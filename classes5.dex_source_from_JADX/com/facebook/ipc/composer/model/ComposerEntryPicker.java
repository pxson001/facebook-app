package com.facebook.ipc.composer.model;

/* compiled from: TOGGLE_ENABLE_OR_DISABLE_UNIT_TYPE */
public enum ComposerEntryPicker {
    NONE("none"),
    MEDIA_PICKER("media_picker"),
    PLACE_PICKER("place_picker"),
    LIFE_EVENT_TYPE_PICKER("life_event_type_picker");
    
    private final String mAnalyticsName;

    private ComposerEntryPicker(String str) {
        this.mAnalyticsName = str;
    }

    public final String getAnalyticsName() {
        return this.mAnalyticsName;
    }
}

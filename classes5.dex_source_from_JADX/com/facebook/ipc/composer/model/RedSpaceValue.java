package com.facebook.ipc.composer.model;

/* compiled from: TIMELINE_ABOUT_SECTION_SUGGEST_EDITS */
public enum RedSpaceValue {
    POST_TO_REDSPACE("enabled"),
    POST_TO_NEWSFEED("disabled");
    
    private final String mApiValue;

    /* compiled from: TIMELINE_ABOUT_SECTION_SUGGEST_EDITS */
    public interface ProvidesRedSpaceValue {
        RedSpaceValue m23415k();
    }

    private RedSpaceValue(String str) {
        this.mApiValue = str;
    }

    public final String toApiString() {
        return this.mApiValue;
    }
}

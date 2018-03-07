package com.facebook.ipc.composer.model;

/* compiled from: TIMELINE_ABOUT_SECTION_SUGGEST_EDITS_V2 */
public enum PublishMode {
    NORMAL("PUBLISH"),
    SCHEDULE_POST("SCHEDULED"),
    SAVE_DRAFT("DRAFT");
    
    private final String mContentType;

    /* compiled from: TIMELINE_ABOUT_SECTION_SUGGEST_EDITS_V2 */
    public interface ProvidesPublishMode {
        PublishMode m23414j();
    }

    private PublishMode(String str) {
        this.mContentType = str;
    }

    public final String getContentType() {
        return this.mContentType;
    }
}

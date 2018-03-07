package com.facebook.photos.upload.progresspage;

/* compiled from: getSuccessNotificationPendingIntent */
public enum CompostSourceType {
    DRAFT_NOTIFICATION("draft_notification"),
    UPLOAD_NOTIFICATION("upload_notification"),
    OPTIMISTIC_STORY("optimistic_story"),
    SNACKBAR("snackbar"),
    UNKNOWN("unknown");
    
    public final String analyticsName;

    private CompostSourceType(String str) {
        this.analyticsName = str;
    }
}

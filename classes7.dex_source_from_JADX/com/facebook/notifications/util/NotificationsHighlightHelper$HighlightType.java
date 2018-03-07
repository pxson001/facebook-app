package com.facebook.notifications.util;

/* compiled from: minutiae_disk_storage_write_activities_failed */
public enum NotificationsHighlightHelper$HighlightType {
    DEFAULT("default"),
    STAR("star"),
    SUGGESTED_BADGE("badge"),
    SUGGESTED_TEXT_ONLY("text");
    
    public String mParamValue;

    private NotificationsHighlightHelper$HighlightType(String str) {
        this.mParamValue = str;
    }
}

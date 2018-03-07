package com.facebook.divebar;

/* compiled from: perf_logger_status */
public enum DivebarController$DivebarType {
    DEFAULT_DIVEBAR("divebar"),
    NOW_SIDEBAR("now_presence"),
    REDSPACE("red_space_grid"),
    UNKOWN("unknown");
    
    private final String mAnalyticsTag;

    private DivebarController$DivebarType(String str) {
        this.mAnalyticsTag = str;
    }

    public final String getAnalyticsTag() {
        return this.mAnalyticsTag;
    }
}

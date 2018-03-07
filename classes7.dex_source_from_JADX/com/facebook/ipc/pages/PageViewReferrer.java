package com.facebook.ipc.pages;

/* compiled from: place_report_successful */
public enum PageViewReferrer {
    NEWSFEED("nf"),
    SEARCH_TYPEAHEAD("ts"),
    SEARCH_RESULTS("br_rs"),
    RECENT_SEARCHS("recent_search"),
    USER_TIMELINE("profile"),
    PAGE("page_profile"),
    BOOKMARK("bookmarks"),
    NOTIFICATION("notif"),
    PERMALINK("permalink"),
    PUSH_NOTIF("push"),
    EVENT("event"),
    GROUP("group"),
    TODAY("today"),
    LAUNCH_POINT("launch_point"),
    PAGE_INTERNAL("page_internal"),
    UNKNOWN("unknown");
    
    public final String loggingName;

    private PageViewReferrer(String str) {
        this.loggingName = str;
    }
}

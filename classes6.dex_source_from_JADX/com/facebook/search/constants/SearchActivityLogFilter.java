package com.facebook.search.constants;

/* compiled from: session_end_reason */
public enum SearchActivityLogFilter {
    VIDEOS("videosearch");
    
    private final String mFilterName;

    private SearchActivityLogFilter(String str) {
        this.mFilterName = str;
    }

    public final String toString() {
        return this.mFilterName;
    }
}

package com.facebook.analytics.tagging;

/* compiled from: time_range_sentence */
public enum AnalyticsObjectProvider$ObjectType {
    PAGES("pages");
    
    private String objectType;

    private AnalyticsObjectProvider$ObjectType(String str) {
        this.objectType = str;
    }

    public final String getTypeName() {
        return this.objectType;
    }
}

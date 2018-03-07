package com.facebook.analytics.feature;

/* compiled from: timeline_context_item_friends_list */
public enum FeatureCode {
    DIALTONE("DT"),
    ZERO_RATING("ZR"),
    DATASAVINGS("DS");
    
    private final String mCode;

    private FeatureCode(String str) {
        this.mCode = str;
    }

    public final String getCode() {
        return this.mCode;
    }

    public final String toString() {
        return this.mCode;
    }
}

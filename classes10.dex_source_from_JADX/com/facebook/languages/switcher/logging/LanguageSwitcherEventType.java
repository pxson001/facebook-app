package com.facebook.languages.switcher.logging;

/* compiled from: time_token */
public enum LanguageSwitcherEventType {
    VISIT("language_switcher_visit"),
    SWITCH("language_switcher_switch"),
    SWITCH_PROMO("language_switcher_auto_uri");
    
    private final String mAnalyticsName;

    private LanguageSwitcherEventType(String str) {
        this.mAnalyticsName = str;
    }

    public final String getAnalyticsName() {
        return this.mAnalyticsName;
    }

    public final String toString() {
        return this.mAnalyticsName;
    }
}

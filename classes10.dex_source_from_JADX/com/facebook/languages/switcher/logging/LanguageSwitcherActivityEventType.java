package com.facebook.languages.switcher.logging;

/* compiled from: timed out after publish */
public enum LanguageSwitcherActivityEventType {
    STARTED("language_switcher_activity_started"),
    SUGGESTIONS_FETCHED("language_switcher_activity_suggestions_fetched"),
    NO_SUGGESTIONS("language_switcher_activity_no_suggestions"),
    SUGGESTIONS_FAILED("language_switcher_activity_suggestions_failed"),
    OTHER_LANGUAGES_CLICKED("language_switcher_activity_other_languages_clicked"),
    OTHER_LANGUAGES_SELECTED("language_switcher_activity_other_languages_selected"),
    FINISHED("language_switcher_activity_finished");
    
    private final String mAnalyticsName;

    private LanguageSwitcherActivityEventType(String str) {
        this.mAnalyticsName = str;
    }

    public final String getAnalyticsName() {
        return this.mAnalyticsName;
    }

    public final String toString() {
        return this.mAnalyticsName;
    }
}

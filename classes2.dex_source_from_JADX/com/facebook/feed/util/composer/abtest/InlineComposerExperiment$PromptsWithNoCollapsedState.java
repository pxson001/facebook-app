package com.facebook.feed.util.composer.abtest;

/* compiled from: message_requests_settings_entry_nux_shown */
public enum InlineComposerExperiment$PromptsWithNoCollapsedState {
    NONE("none"),
    MEDIA_REMINDER("media_reminder"),
    ALL("all");
    
    private final String mParamValue;

    private InlineComposerExperiment$PromptsWithNoCollapsedState(String str) {
        this.mParamValue = str;
    }

    public final String toString() {
        return this.mParamValue;
    }
}

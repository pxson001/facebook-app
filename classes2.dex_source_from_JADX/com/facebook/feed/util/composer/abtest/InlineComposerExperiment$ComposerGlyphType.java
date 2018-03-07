package com.facebook.feed.util.composer.abtest;

/* compiled from: message_requests_settings_entry_nux_shown */
public enum InlineComposerExperiment$ComposerGlyphType {
    NONE("none"),
    DEFAULT("default"),
    COLORED("colored"),
    CIRCLE("circle");
    
    private final String mValue;

    private InlineComposerExperiment$ComposerGlyphType(String str) {
        this.mValue = str;
    }

    public final String toString() {
        return this.mValue;
    }
}

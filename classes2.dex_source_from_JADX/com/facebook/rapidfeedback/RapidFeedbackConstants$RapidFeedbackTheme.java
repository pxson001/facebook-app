package com.facebook.rapidfeedback;

/* compiled from: mColumns */
public enum RapidFeedbackConstants$RapidFeedbackTheme {
    TRANSPARENT("transparent", 2131625665),
    LCAU("lcau", 2131625667),
    MESSENGER("messenger", 2131625666);
    
    private final int mThemeId;
    private final String mThemeName;

    private RapidFeedbackConstants$RapidFeedbackTheme(String str, int i) {
        this.mThemeName = str;
        this.mThemeId = i;
    }

    public final String getThemeName() {
        return this.mThemeName;
    }

    public final int getThemeId() {
        return this.mThemeId;
    }
}

package com.facebook.crowdsourcing.enums;

import javax.annotation.Nullable;

/* compiled from: com.instagram.layout */
public enum SuggestEditsInputType {
    CATEGORY_PICKER(SuggestEditsInputStyle.PICKER),
    CITY_PICKER(SuggestEditsInputStyle.PICKER),
    HOURS_PICKER(SuggestEditsInputStyle.PICKER),
    LOCATION(SuggestEditsInputStyle.LOCATION),
    PHOTO_PICKER(SuggestEditsInputStyle.PICKER),
    TEXT(SuggestEditsInputStyle.INLINE);
    
    private static final SuggestEditsInputType[] values = null;
    private final SuggestEditsInputStyle inputStyle;

    static {
        values = values();
    }

    private SuggestEditsInputType(SuggestEditsInputStyle suggestEditsInputStyle) {
        this.inputStyle = suggestEditsInputStyle;
    }

    public final SuggestEditsInputStyle getInputStyle() {
        return this.inputStyle;
    }

    @Nullable
    public static SuggestEditsInputType fromOrdinal(int i) {
        if (i < 0 || i >= values.length) {
            return null;
        }
        return values[i];
    }
}

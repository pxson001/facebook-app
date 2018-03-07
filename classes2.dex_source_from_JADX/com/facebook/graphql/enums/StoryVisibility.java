package com.facebook.graphql.enums;

/* compiled from: items */
public enum StoryVisibility {
    VISIBLE,
    CONTRACTING,
    DISAPPEARING,
    HIDDEN,
    GONE;

    public final String getRequestParamValue() {
        return name().toLowerCase();
    }

    public final boolean isHiddenOrVisible() {
        return this == HIDDEN || this == VISIBLE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: mShouldUseDefaultImage */
public enum GraphQLInstantShoppingPresentationStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    TILT_TO_PAN,
    BUTTON_OUTLINE,
    BUTTON_FILLED,
    EXPANDABLE,
    EXPANDABLE_FULLSCREEN,
    OVERLAY,
    CAPTION,
    FIT_TO_HEIGHT,
    DARK_GRADIENT,
    LIGHT_GRADIENT,
    SHOW_INTERACTION_HINT,
    NON_ADJUSTED_FIT_TO_WIDTH,
    PHOTO_GRAY_OVERLAY,
    TEXT_NO_CUSTOM_MEASURE,
    ADJUSTED_FIT_TO_HEIGHT,
    LANDSCAPE_ENABLED,
    ROTATION_ENABLED,
    VIDEO_PLAY_PAUSE_DISABLED,
    VIDEO_UNMUTED_FORCED,
    VIDEO_MUTED;

    public static GraphQLInstantShoppingPresentationStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("TILT_TO_PAN")) {
            return TILT_TO_PAN;
        }
        if (str.equalsIgnoreCase("BUTTON_OUTLINE")) {
            return BUTTON_OUTLINE;
        }
        if (str.equalsIgnoreCase("BUTTON_FILLED")) {
            return BUTTON_FILLED;
        }
        if (str.equalsIgnoreCase("EXPANDABLE")) {
            return EXPANDABLE;
        }
        if (str.equalsIgnoreCase("EXPANDABLE_FULLSCREEN")) {
            return EXPANDABLE_FULLSCREEN;
        }
        if (str.equalsIgnoreCase("OVERLAY")) {
            return OVERLAY;
        }
        if (str.equalsIgnoreCase("CAPTION")) {
            return CAPTION;
        }
        if (str.equalsIgnoreCase("FIT_TO_HEIGHT")) {
            return FIT_TO_HEIGHT;
        }
        if (str.equalsIgnoreCase("DARK_GRADIENT")) {
            return DARK_GRADIENT;
        }
        if (str.equalsIgnoreCase("LIGHT_GRADIENT")) {
            return LIGHT_GRADIENT;
        }
        if (str.equalsIgnoreCase("SHOW_INTERACTION_HINT")) {
            return SHOW_INTERACTION_HINT;
        }
        if (str.equalsIgnoreCase("NON_ADJUSTED_FIT_TO_WIDTH")) {
            return NON_ADJUSTED_FIT_TO_WIDTH;
        }
        if (str.equalsIgnoreCase("PHOTO_GRAY_OVERLAY")) {
            return PHOTO_GRAY_OVERLAY;
        }
        if (str.equalsIgnoreCase("TEXT_NO_CUSTOM_MEASURE")) {
            return TEXT_NO_CUSTOM_MEASURE;
        }
        if (str.equalsIgnoreCase("ADJUSTED_FIT_TO_HEIGHT")) {
            return ADJUSTED_FIT_TO_HEIGHT;
        }
        if (str.equalsIgnoreCase("LANDSCAPE_ENABLED")) {
            return LANDSCAPE_ENABLED;
        }
        if (str.equalsIgnoreCase("ROTATION_ENABLED")) {
            return ROTATION_ENABLED;
        }
        if (str.equalsIgnoreCase("VIDEO_PLAY_PAUSE_DISABLED")) {
            return VIDEO_PLAY_PAUSE_DISABLED;
        }
        if (str.equalsIgnoreCase("VIDEO_UNMUTED_FORCED")) {
            return VIDEO_UNMUTED_FORCED;
        }
        if (str.equalsIgnoreCase("VIDEO_MUTED")) {
            return VIDEO_MUTED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

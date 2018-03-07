package com.facebook.graphql.enums;

/* compiled from: mLightweightPlacePickerPlaces */
public enum GraphQLNotifHighlightState {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    HIGHLIGHTED,
    NONE,
    NOT_HIGHLIGHTED;

    public static GraphQLNotifHighlightState fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("HIGHLIGHTED")) {
            return HIGHLIGHTED;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("NOT_HIGHLIGHTED")) {
            return NOT_HIGHLIGHTED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

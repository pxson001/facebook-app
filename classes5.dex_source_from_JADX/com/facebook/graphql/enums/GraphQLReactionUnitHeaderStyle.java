package com.facebook.graphql.enums;

/* compiled from: local_serp */
public enum GraphQLReactionUnitHeaderStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ICON,
    THIN_FACEPILE,
    ICON_INLINE_ACTION,
    DESCRIPTIVE,
    ICON_PIVOT,
    DEPRECATED_ICON_FIELDS_ON_UNIT,
    LARGE_ICON,
    PLACE_RANKING,
    PLACE_SPOTLIGHT,
    ICON_WITH_AUX_ACTION,
    ACORN_HIDE_CONFIRMATION,
    CENTER_ALIGNED,
    PLACE_REVIEWS_WITH_SECONDARY_TEXT;

    public static GraphQLReactionUnitHeaderStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ICON")) {
            return ICON;
        }
        if (str.equalsIgnoreCase("THIN_FACEPILE")) {
            return THIN_FACEPILE;
        }
        if (str.equalsIgnoreCase("ICON_INLINE_ACTION")) {
            return ICON_INLINE_ACTION;
        }
        if (str.equalsIgnoreCase("DESCRIPTIVE")) {
            return DESCRIPTIVE;
        }
        if (str.equalsIgnoreCase("ICON_PIVOT")) {
            return ICON_PIVOT;
        }
        if (str.equalsIgnoreCase("DEPRECATED_ICON_FIELDS_ON_UNIT")) {
            return DEPRECATED_ICON_FIELDS_ON_UNIT;
        }
        if (str.equalsIgnoreCase("LARGE_ICON")) {
            return LARGE_ICON;
        }
        if (str.equalsIgnoreCase("PLACE_RANKING")) {
            return PLACE_RANKING;
        }
        if (str.equalsIgnoreCase("PLACE_SPOTLIGHT")) {
            return PLACE_SPOTLIGHT;
        }
        if (str.equalsIgnoreCase("ICON_WITH_AUX_ACTION")) {
            return ICON_WITH_AUX_ACTION;
        }
        if (str.equalsIgnoreCase("ACORN_HIDE_CONFIRMATION")) {
            return ACORN_HIDE_CONFIRMATION;
        }
        if (str.equalsIgnoreCase("CENTER_ALIGNED")) {
            return CENTER_ALIGNED;
        }
        if (str.equalsIgnoreCase("PLACE_REVIEWS_WITH_SECONDARY_TEXT")) {
            return PLACE_REVIEWS_WITH_SECONDARY_TEXT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

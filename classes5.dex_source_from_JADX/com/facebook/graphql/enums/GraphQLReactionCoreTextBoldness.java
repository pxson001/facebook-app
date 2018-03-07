package com.facebook.graphql.enums;

/* compiled from: location_tag_suggestion */
public enum GraphQLReactionCoreTextBoldness {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    LIGHT,
    REGULAR,
    SEMIBOLD,
    BOLD;

    public static GraphQLReactionCoreTextBoldness fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("LIGHT")) {
            return LIGHT;
        }
        if (str.equalsIgnoreCase("REGULAR")) {
            return REGULAR;
        }
        if (str.equalsIgnoreCase("SEMIBOLD")) {
            return SEMIBOLD;
        }
        if (str.equalsIgnoreCase("BOLD")) {
            return BOLD;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

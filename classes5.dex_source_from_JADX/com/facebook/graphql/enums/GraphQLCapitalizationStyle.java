package com.facebook.graphql.enums;

/* compiled from: media_elements */
public enum GraphQLCapitalizationStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    ALL_CAPS,
    ALL_LOWER_CASE;

    public static GraphQLCapitalizationStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("ALL_CAPS")) {
            return ALL_CAPS;
        }
        if (str.equalsIgnoreCase("ALL_LOWER_CASE")) {
            return ALL_LOWER_CASE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

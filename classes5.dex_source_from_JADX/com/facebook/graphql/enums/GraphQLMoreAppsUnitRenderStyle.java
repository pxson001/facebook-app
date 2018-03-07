package com.facebook.graphql.enums;

/* compiled from: mMatcher */
public enum GraphQLMoreAppsUnitRenderStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    LARGE_UNIT,
    SMALL_UNIT,
    LARGE_IMAGE;

    public static GraphQLMoreAppsUnitRenderStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("LARGE_UNIT")) {
            return LARGE_UNIT;
        }
        if (str.equalsIgnoreCase("SMALL_UNIT")) {
            return SMALL_UNIT;
        }
        if (str.equalsIgnoreCase("LARGE_IMAGE")) {
            return LARGE_IMAGE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

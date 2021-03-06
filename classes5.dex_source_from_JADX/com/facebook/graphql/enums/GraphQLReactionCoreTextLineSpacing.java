package com.facebook.graphql.enums;

/* compiled from: location_page_id */
public enum GraphQLReactionCoreTextLineSpacing {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SMALL,
    MEDIUM,
    LARGE,
    EXTRA_LARGE,
    EXTRA_SMALL;

    public static GraphQLReactionCoreTextLineSpacing fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("EXTRA_SMALL")) {
            return EXTRA_SMALL;
        }
        if (str.equalsIgnoreCase("SMALL")) {
            return SMALL;
        }
        if (str.equalsIgnoreCase("MEDIUM")) {
            return MEDIUM;
        }
        if (str.equalsIgnoreCase("LARGE")) {
            return LARGE;
        }
        if (str.equalsIgnoreCase("EXTRA_LARGE")) {
            return EXTRA_LARGE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

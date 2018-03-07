package com.facebook.graphql.enums;

/* compiled from: logAndroidId= */
public enum GraphQLReactionCoreComponentPadding {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    SMALL,
    MEDIUM,
    LARGE,
    EXTRA_LARGE,
    EXTRA_SMALL;

    public static GraphQLReactionCoreComponentPadding fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
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

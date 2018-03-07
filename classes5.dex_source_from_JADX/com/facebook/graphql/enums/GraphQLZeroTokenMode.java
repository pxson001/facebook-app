package com.facebook.graphql.enums;

/* compiled from: linkClicks */
public enum GraphQLZeroTokenMode {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    DIALTONE,
    NORMAL;

    public static GraphQLZeroTokenMode fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("DIALTONE")) {
            return DIALTONE;
        }
        if (str.equalsIgnoreCase("NORMAL")) {
            return NORMAL;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

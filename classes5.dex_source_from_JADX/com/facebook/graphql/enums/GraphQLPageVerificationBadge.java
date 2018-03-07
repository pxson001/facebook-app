package com.facebook.graphql.enums;

/* compiled from: mContentChanged= */
public enum GraphQLPageVerificationBadge {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    BLUE_VERIFIED,
    GRAY_VERIFIED,
    NOT_VERIFIED;

    public static GraphQLPageVerificationBadge fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("BLUE_VERIFIED")) {
            return BLUE_VERIFIED;
        }
        if (str.equalsIgnoreCase("GRAY_VERIFIED")) {
            return GRAY_VERIFIED;
        }
        if (str.equalsIgnoreCase("NOT_VERIFIED")) {
            return NOT_VERIFIED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

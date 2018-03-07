package com.facebook.graphql.enums;

/* compiled from: images_queued */
public enum GraphQLSecondarySubscribeStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    REGULAR_FOLLOW,
    RECAP,
    SEE_FIRST;

    public static GraphQLSecondarySubscribeStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("REGULAR_FOLLOW")) {
            return REGULAR_FOLLOW;
        }
        if (str.equalsIgnoreCase("RECAP")) {
            return RECAP;
        }
        if (str.equalsIgnoreCase("SEE_FIRST")) {
            return SEE_FIRST;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

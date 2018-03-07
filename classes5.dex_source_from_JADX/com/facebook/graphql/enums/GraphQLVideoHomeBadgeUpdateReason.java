package com.facebook.graphql.enums;

/* compiled from: linkEdit */
public enum GraphQLVideoHomeBadgeUpdateReason {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    LIVE_STARTED,
    LIVE_ENDED,
    LIVE_DELETED;

    public static GraphQLVideoHomeBadgeUpdateReason fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("LIVE_STARTED")) {
            return LIVE_STARTED;
        }
        if (str.equalsIgnoreCase("LIVE_ENDED")) {
            return LIVE_ENDED;
        }
        if (str.equalsIgnoreCase("LIVE_DELETED")) {
            return LIVE_DELETED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

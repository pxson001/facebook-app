package com.facebook.graphql.enums;

/* compiled from: mWifiSentBytes */
public enum GraphQLGroupSubscriptionLevel {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ALL_POSTS,
    FRIEND_POSTS,
    HIGHLIGHTS,
    OFF;

    public static GraphQLGroupSubscriptionLevel fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ALL_POSTS")) {
            return ALL_POSTS;
        }
        if (str.equalsIgnoreCase("FRIEND_POSTS")) {
            return FRIEND_POSTS;
        }
        if (str.equalsIgnoreCase("HIGHLIGHTS")) {
            return HIGHLIGHTS;
        }
        if (str.equalsIgnoreCase("OFF")) {
            return OFF;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: m_basic_home */
public enum GraphQLGroupPushSubscriptionLevel {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    OFF,
    ON,
    DEPRECATED_ALL_POSTS,
    DEPRECATED_ALL_ACTIVITY,
    HIGHLIGHTS;

    public static GraphQLGroupPushSubscriptionLevel fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("OFF")) {
            return OFF;
        }
        if (str.equalsIgnoreCase("ON")) {
            return ON;
        }
        if (str.equalsIgnoreCase("DEPRECATED_ALL_POSTS")) {
            return DEPRECATED_ALL_POSTS;
        }
        if (str.equalsIgnoreCase("DEPRECATED_ALL_ACTIVITY")) {
            return DEPRECATED_ALL_ACTIVITY;
        }
        if (str.equalsIgnoreCase("HIGHLIGHTS")) {
            return HIGHLIGHTS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

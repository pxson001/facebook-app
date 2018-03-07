package com.facebook.graphql.enums;

/* compiled from: mIsChildViewEnabled */
public enum GraphQLPageActivityFeedType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    MENTION,
    CHECKIN,
    SHARE,
    REVIEW,
    ALL;

    public static GraphQLPageActivityFeedType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("MENTION")) {
            return MENTION;
        }
        if (str.equalsIgnoreCase("CHECKIN")) {
            return CHECKIN;
        }
        if (str.equalsIgnoreCase("SHARE")) {
            return SHARE;
        }
        if (str.equalsIgnoreCase("REVIEW")) {
            return REVIEW;
        }
        if (str.equalsIgnoreCase("ALL")) {
            return ALL;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

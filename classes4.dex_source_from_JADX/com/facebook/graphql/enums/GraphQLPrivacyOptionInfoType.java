package com.facebook.graphql.enums;

/* compiled from: sleep_policy */
public enum GraphQLPrivacyOptionInfoType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    BASIC,
    SELECTED,
    MOST_RECENT,
    FRIEND_LIST,
    COMMUNITY,
    QUERY_SNAPSHOT;

    public static GraphQLPrivacyOptionInfoType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("BASIC")) {
            return BASIC;
        }
        if (str.equalsIgnoreCase("SELECTED")) {
            return SELECTED;
        }
        if (str.equalsIgnoreCase("MOST_RECENT")) {
            return MOST_RECENT;
        }
        if (str.equalsIgnoreCase("FRIEND_LIST")) {
            return FRIEND_LIST;
        }
        if (str.equalsIgnoreCase("COMMUNITY")) {
            return COMMUNITY;
        }
        if (str.equalsIgnoreCase("QUERY_SNAPSHOT")) {
            return QUERY_SNAPSHOT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

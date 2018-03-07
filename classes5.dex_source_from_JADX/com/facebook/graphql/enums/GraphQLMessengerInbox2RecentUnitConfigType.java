package com.facebook.graphql.enums;

/* compiled from: mOptinDeclineTitle */
public enum GraphQLMessengerInbox2RecentUnitConfigType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    FIXED_NUMBER,
    STALENESS_BASED,
    UNREAD_BASED;

    public static GraphQLMessengerInbox2RecentUnitConfigType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("FIXED_NUMBER")) {
            return FIXED_NUMBER;
        }
        if (str.equalsIgnoreCase("STALENESS_BASED")) {
            return STALENESS_BASED;
        }
        if (str.equalsIgnoreCase("UNREAD_BASED")) {
            return UNREAD_BASED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

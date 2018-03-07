package com.facebook.graphql.enums;

/* compiled from: mSecondaryButtonText */
public enum GraphQLLeavingGroupScenario {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    MEMBER_NOTIFICATIONS,
    MEMBER_NO_NOTIFICATIONS,
    ADMIN,
    ONLY_ADMIN,
    LAST_MEMBER,
    NON_MEMBER;

    public static GraphQLLeavingGroupScenario fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("MEMBER_NOTIFICATIONS")) {
            return MEMBER_NOTIFICATIONS;
        }
        if (str.equalsIgnoreCase("MEMBER_NO_NOTIFICATIONS")) {
            return MEMBER_NO_NOTIFICATIONS;
        }
        if (str.equalsIgnoreCase("ADMIN")) {
            return ADMIN;
        }
        if (str.equalsIgnoreCase("ONLY_ADMIN")) {
            return ONLY_ADMIN;
        }
        if (str.equalsIgnoreCase("LAST_MEMBER")) {
            return LAST_MEMBER;
        }
        if (str.equalsIgnoreCase("NON_MEMBER")) {
            return NON_MEMBER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

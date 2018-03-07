package com.facebook.graphql.enums;

/* compiled from: makeOptionalFitsSystemWindows */
public enum GraphQLEventsCalendarSubscriptionStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    ALL,
    LOCAL;

    public static GraphQLEventsCalendarSubscriptionStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("ALL")) {
            return ALL;
        }
        if (str.equalsIgnoreCase("LOCAL")) {
            return LOCAL;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

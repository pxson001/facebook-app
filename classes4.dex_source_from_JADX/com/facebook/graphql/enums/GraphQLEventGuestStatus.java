package com.facebook.graphql.enums;

/* compiled from: operationResult */
public enum GraphQLEventGuestStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    HOST,
    GOING,
    INVITED,
    MAYBE,
    NOT_GOING,
    LIKED,
    SAVED,
    SUBSCRIBED_ADMIN_CALENDAR,
    UNKNOWN;

    public static GraphQLEventGuestStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("HOST")) {
            return HOST;
        }
        if (str.equalsIgnoreCase("GOING")) {
            return GOING;
        }
        if (str.equalsIgnoreCase("INVITED")) {
            return INVITED;
        }
        if (str.equalsIgnoreCase("MAYBE")) {
            return MAYBE;
        }
        if (str.equalsIgnoreCase("NOT_GOING")) {
            return NOT_GOING;
        }
        if (str.equalsIgnoreCase("LIKED")) {
            return LIKED;
        }
        if (str.equalsIgnoreCase("SAVED")) {
            return SAVED;
        }
        if (str.equalsIgnoreCase("SUBSCRIBED_ADMIN_CALENDAR")) {
            return SUBSCRIBED_ADMIN_CALENDAR;
        }
        if (str.equalsIgnoreCase("UNKNOWN")) {
            return UNKNOWN;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

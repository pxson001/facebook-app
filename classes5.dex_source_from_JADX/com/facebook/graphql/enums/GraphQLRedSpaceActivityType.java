package com.facebook.graphql.enums;

/* compiled from: local_is_rich_notif_collapsed */
public enum GraphQLRedSpaceActivityType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PRESENCE,
    LOCATION,
    MESSAGE,
    GENERIC,
    UPCOMING_EVENT;

    public static GraphQLRedSpaceActivityType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("GENERIC")) {
            return GENERIC;
        }
        if (str.equalsIgnoreCase("LOCATION")) {
            return LOCATION;
        }
        if (str.equalsIgnoreCase("MESSAGE")) {
            return MESSAGE;
        }
        if (str.equalsIgnoreCase("PRESENCE")) {
            return PRESENCE;
        }
        if (str.equalsIgnoreCase("UPCOMING_EVENT")) {
            return UPCOMING_EVENT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

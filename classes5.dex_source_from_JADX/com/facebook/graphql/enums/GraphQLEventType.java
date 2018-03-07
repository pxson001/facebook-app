package com.facebook.graphql.enums;

/* compiled from: mapType */
public enum GraphQLEventType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NORMAL,
    VENUE_GROUP,
    HARMONIZED,
    QUICK_INVITE,
    LEGACY;

    public static GraphQLEventType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NORMAL")) {
            return NORMAL;
        }
        if (str.equalsIgnoreCase("VENUE_GROUP")) {
            return VENUE_GROUP;
        }
        if (str.equalsIgnoreCase("HARMONIZED")) {
            return HARMONIZED;
        }
        if (str.equalsIgnoreCase("QUICK_INVITE")) {
            return QUICK_INVITE;
        }
        if (str.equalsIgnoreCase("LEGACY")) {
            return LEGACY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: mWifiReceivedBytes */
public enum GraphQLGroupVisibility {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    OPEN,
    CLOSED,
    SECRET;

    public static GraphQLGroupVisibility fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("OPEN")) {
            return OPEN;
        }
        if (str.equalsIgnoreCase("CLOSED")) {
            return CLOSED;
        }
        if (str.equalsIgnoreCase("SECRET")) {
            return SECRET;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: mAuthToken */
public enum GraphQLPlaceHoursType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PERMANENTLY_CLOSED,
    ALWAYS_OPEN,
    NO_HOURS,
    OPEN_FOR_SELECTED;

    public static GraphQLPlaceHoursType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PERMANENTLY_CLOSED")) {
            return PERMANENTLY_CLOSED;
        }
        if (str.equalsIgnoreCase("ALWAYS_OPEN")) {
            return ALWAYS_OPEN;
        }
        if (str.equalsIgnoreCase("NO_HOURS")) {
            return NO_HOURS;
        }
        if (str.equalsIgnoreCase("OPEN_FOR_SELECTED")) {
            return OPEN_FOR_SELECTED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

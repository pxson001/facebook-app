package com.facebook.graphql.enums;

/* compiled from: dd */
public enum GraphQLFriendLocationCategory {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PRESENCE,
    APPROXIMATE_LOCATION,
    CURRENT_CITY,
    CHECKIN,
    PULSE;

    public static GraphQLFriendLocationCategory fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PRESENCE")) {
            return PRESENCE;
        }
        if (str.equalsIgnoreCase("APPROXIMATE_LOCATION")) {
            return APPROXIMATE_LOCATION;
        }
        if (str.equalsIgnoreCase("CURRENT_CITY")) {
            return CURRENT_CITY;
        }
        if (str.equalsIgnoreCase("CHECKIN")) {
            return CHECKIN;
        }
        if (str.equalsIgnoreCase("PULSE")) {
            return PULSE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

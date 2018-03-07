package com.facebook.graphql.enums;

/* compiled from: lowres */
public enum GraphQLPlaceType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PLACE,
    CITY,
    STATE_PROVINCE,
    COUNTRY,
    EVENT,
    RESIDENCE,
    TEXT;

    public static GraphQLPlaceType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PLACE")) {
            return PLACE;
        }
        if (str.equalsIgnoreCase("CITY")) {
            return CITY;
        }
        if (str.equalsIgnoreCase("STATE_PROVINCE")) {
            return STATE_PROVINCE;
        }
        if (str.equalsIgnoreCase("COUNTRY")) {
            return COUNTRY;
        }
        if (str.equalsIgnoreCase("EVENT")) {
            return EVENT;
        }
        if (str.equalsIgnoreCase("RESIDENCE")) {
            return RESIDENCE;
        }
        if (str.equalsIgnoreCase("TEXT")) {
            return TEXT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

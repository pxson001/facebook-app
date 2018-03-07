package com.facebook.graphql.enums;

/* compiled from: menu */
public enum GraphQLAcornLocationType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    GPS,
    PROFILE,
    GEOAPI;

    public static GraphQLAcornLocationType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("GPS")) {
            return GPS;
        }
        if (str.equalsIgnoreCase("PROFILE")) {
            return PROFILE;
        }
        if (str.equalsIgnoreCase("GEOAPI")) {
            return GEOAPI;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

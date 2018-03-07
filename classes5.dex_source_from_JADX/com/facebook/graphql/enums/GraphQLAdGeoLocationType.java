package com.facebook.graphql.enums;

/* compiled from: memberbox */
public enum GraphQLAdGeoLocationType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    COUNTRY,
    REGION,
    CITY,
    ZIP,
    MARKET,
    ELECTORAL_DISTRICT,
    PLACE,
    CUSTOM_LOCATION,
    COUNTRY_GROUP;

    public static GraphQLAdGeoLocationType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("COUNTRY_GROUP")) {
            return COUNTRY_GROUP;
        }
        if (str.equalsIgnoreCase("COUNTRY")) {
            return COUNTRY;
        }
        if (str.equalsIgnoreCase("REGION")) {
            return REGION;
        }
        if (str.equalsIgnoreCase("CITY")) {
            return CITY;
        }
        if (str.equalsIgnoreCase("ZIP")) {
            return ZIP;
        }
        if (str.equalsIgnoreCase("MARKET")) {
            return MARKET;
        }
        if (str.equalsIgnoreCase("ELECTORAL_DISTRICT")) {
            return ELECTORAL_DISTRICT;
        }
        if (str.equalsIgnoreCase("PLACE")) {
            return PLACE;
        }
        if (str.equalsIgnoreCase("CUSTOM_LOCATION")) {
            return CUSTOM_LOCATION;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

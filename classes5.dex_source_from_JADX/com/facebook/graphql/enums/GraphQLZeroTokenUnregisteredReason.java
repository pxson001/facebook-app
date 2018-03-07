package com.facebook.graphql.enums;

/* compiled from: lineNr */
public enum GraphQLZeroTokenUnregisteredReason {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    UNSUPPORTED_CARRIER,
    NOT_ON_CARRIER,
    UNSUPPORTED_CATEGORY,
    UNAVAILABLE,
    NO_CAMPAIGN,
    NOT_IN_REGION,
    NOT_IN_REGION_UNSUPPORTED_CARRIER,
    NOT_IN_REGION_WIFI,
    NOT_IN_REGION_SUPPORTED_CARRIER,
    NOT_IN_DIALTONE_COUNTRY,
    ON_WIFI,
    UNSUPPORTED_BROWSER;

    public static GraphQLZeroTokenUnregisteredReason fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("UNSUPPORTED_CARRIER")) {
            return UNSUPPORTED_CARRIER;
        }
        if (str.equalsIgnoreCase("NOT_ON_CARRIER")) {
            return NOT_ON_CARRIER;
        }
        if (str.equalsIgnoreCase("UNSUPPORTED_CATEGORY")) {
            return UNSUPPORTED_CATEGORY;
        }
        if (str.equalsIgnoreCase("UNAVAILABLE")) {
            return UNAVAILABLE;
        }
        if (str.equalsIgnoreCase("NO_CAMPAIGN")) {
            return NO_CAMPAIGN;
        }
        if (str.equalsIgnoreCase("NOT_IN_REGION")) {
            return NOT_IN_REGION;
        }
        if (str.equalsIgnoreCase("NOT_IN_REGION_UNSUPPORTED_CARRIER")) {
            return NOT_IN_REGION_UNSUPPORTED_CARRIER;
        }
        if (str.equalsIgnoreCase("NOT_IN_REGION_WIFI")) {
            return NOT_IN_REGION_WIFI;
        }
        if (str.equalsIgnoreCase("NOT_IN_REGION_SUPPORTED_CARRIER")) {
            return NOT_IN_REGION_SUPPORTED_CARRIER;
        }
        if (str.equalsIgnoreCase("NOT_IN_DIALTONE_COUNTRY")) {
            return NOT_IN_DIALTONE_COUNTRY;
        }
        if (str.equalsIgnoreCase("ON_WIFI")) {
            return ON_WIFI;
        }
        if (str.equalsIgnoreCase("UNSUPPORTED_BROWSER")) {
            return UNSUPPORTED_BROWSER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

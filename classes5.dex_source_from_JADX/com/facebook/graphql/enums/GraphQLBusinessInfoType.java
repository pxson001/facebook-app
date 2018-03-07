package com.facebook.graphql.enums;

/* compiled from: media_fb_ids */
public enum GraphQLBusinessInfoType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CUISINE,
    PARKING,
    SPECIALTY,
    SERVICES;

    public static GraphQLBusinessInfoType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CUISINE")) {
            return CUISINE;
        }
        if (str.equalsIgnoreCase("PARKING")) {
            return PARKING;
        }
        if (str.equalsIgnoreCase("SPECIALTY")) {
            return SPECIALTY;
        }
        if (str.equalsIgnoreCase("SERVICES")) {
            return SERVICES;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

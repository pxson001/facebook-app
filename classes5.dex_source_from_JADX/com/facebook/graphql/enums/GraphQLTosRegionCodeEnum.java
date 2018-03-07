package com.facebook.graphql.enums;

/* compiled from: link_edit */
public enum GraphQLTosRegionCodeEnum {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    GENERAL,
    ALDRIN,
    MOON,
    MARS;

    public static GraphQLTosRegionCodeEnum fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("GENERAL")) {
            return GENERAL;
        }
        if (str.equalsIgnoreCase("ALDRIN")) {
            return ALDRIN;
        }
        if (str.equalsIgnoreCase("MOON")) {
            return MOON;
        }
        if (str.equalsIgnoreCase("MARS")) {
            return MARS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

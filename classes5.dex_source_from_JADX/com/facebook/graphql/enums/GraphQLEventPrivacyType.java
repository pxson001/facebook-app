package com.facebook.graphql.enums;

/* compiled from: margin_style */
public enum GraphQLEventPrivacyType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PUBLIC_TYPE,
    PRIVATE_TYPE,
    GROUP,
    COMMUNITY,
    LEGACY;

    public static GraphQLEventPrivacyType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PUBLIC_TYPE")) {
            return PUBLIC_TYPE;
        }
        if (str.equalsIgnoreCase("PRIVATE_TYPE")) {
            return PRIVATE_TYPE;
        }
        if (str.equalsIgnoreCase("GROUP")) {
            return GROUP;
        }
        if (str.equalsIgnoreCase("COMMUNITY")) {
            return COMMUNITY;
        }
        if (str.equalsIgnoreCase("LEGACY")) {
            return LEGACY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

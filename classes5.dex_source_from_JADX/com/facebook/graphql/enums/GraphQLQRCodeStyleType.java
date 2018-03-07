package com.facebook.graphql.enums;

/* compiled from: logging_param */
public enum GraphQLQRCodeStyleType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    STANDARD,
    VANITY;

    public static GraphQLQRCodeStyleType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("STANDARD")) {
            return STANDARD;
        }
        if (str.equalsIgnoreCase("VANITY")) {
            return VANITY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: maxLines */
public enum GraphQLDocumentMapStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    AUTO,
    STANDARD,
    SATELLITE,
    HYBRID;

    public static GraphQLDocumentMapStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("AUTO")) {
            return AUTO;
        }
        if (str.equalsIgnoreCase("STANDARD")) {
            return STANDARD;
        }
        if (str.equalsIgnoreCase("SATELLITE")) {
            return SATELLITE;
        }
        if (str.equalsIgnoreCase("HYBRID")) {
            return HYBRID;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

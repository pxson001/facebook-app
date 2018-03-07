package com.facebook.graphql.enums;

/* compiled from: mSecondaryButtonAction */
public enum GraphQLLocationPingType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    DURATION,
    FOREVER;

    public static GraphQLLocationPingType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("DURATION")) {
            return DURATION;
        }
        if (str.equalsIgnoreCase("FOREVER")) {
            return FOREVER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

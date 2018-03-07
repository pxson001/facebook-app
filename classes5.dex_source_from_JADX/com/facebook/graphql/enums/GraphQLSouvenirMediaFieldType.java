package com.facebook.graphql.enums;

/* compiled from: live_maps */
public enum GraphQLSouvenirMediaFieldType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    BURST,
    PHOTO,
    VIDEO,
    BURST_VIDEO;

    public static GraphQLSouvenirMediaFieldType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("BURST")) {
            return BURST;
        }
        if (str.equalsIgnoreCase("PHOTO")) {
            return PHOTO;
        }
        if (str.equalsIgnoreCase("VIDEO")) {
            return VIDEO;
        }
        if (str.equalsIgnoreCase("BURST_VIDEO")) {
            return BURST_VIDEO;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

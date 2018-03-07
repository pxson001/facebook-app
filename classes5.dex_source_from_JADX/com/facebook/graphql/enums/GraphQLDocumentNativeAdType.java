package com.facebook.graphql.enums;

/* compiled from: max-input-size */
public enum GraphQLDocumentNativeAdType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    UNKNOWN,
    LINK_SHARE,
    APP_AD,
    APP_VIDEO,
    VIDEO,
    PHOTO,
    LINK_VIDEO,
    MULTI_SHARE;

    public static GraphQLDocumentNativeAdType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("UNKNOWN")) {
            return UNKNOWN;
        }
        if (str.equalsIgnoreCase("LINK_SHARE")) {
            return LINK_SHARE;
        }
        if (str.equalsIgnoreCase("APP_AD")) {
            return APP_AD;
        }
        if (str.equalsIgnoreCase("APP_VIDEO")) {
            return APP_VIDEO;
        }
        if (str.equalsIgnoreCase("VIDEO")) {
            return VIDEO;
        }
        if (str.equalsIgnoreCase("PHOTO")) {
            return PHOTO;
        }
        if (str.equalsIgnoreCase("LINK_VIDEO")) {
            return LINK_VIDEO;
        }
        if (str.equalsIgnoreCase("MULTI_SHARE")) {
            return MULTI_SHARE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

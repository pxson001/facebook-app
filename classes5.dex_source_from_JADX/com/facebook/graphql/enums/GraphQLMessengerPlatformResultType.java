package com.facebook.graphql.enums;

/* compiled from: mMobileSentBytes */
public enum GraphQLMessengerPlatformResultType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PHOTO,
    ANIMATION,
    VIDEO,
    STICKER;

    public static GraphQLMessengerPlatformResultType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PHOTO")) {
            return PHOTO;
        }
        if (str.equalsIgnoreCase("ANIMATION")) {
            return ANIMATION;
        }
        if (str.equalsIgnoreCase("VIDEO")) {
            return VIDEO;
        }
        if (str.equalsIgnoreCase("STICKER")) {
            return STICKER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

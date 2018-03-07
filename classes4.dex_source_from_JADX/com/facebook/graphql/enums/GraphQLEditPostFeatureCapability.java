package com.facebook.graphql.enums;

/* compiled from: rtc_presence */
public enum GraphQLEditPostFeatureCapability {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    FEED_TOPICS,
    STICKER;

    public static GraphQLEditPostFeatureCapability fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("FEED_TOPICS")) {
            return FEED_TOPICS;
        }
        if (str.equalsIgnoreCase("STICKER")) {
            return STICKER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

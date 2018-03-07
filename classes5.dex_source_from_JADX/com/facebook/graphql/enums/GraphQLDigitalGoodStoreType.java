package com.facebook.graphql.enums;

/* compiled from: mbasic_feed_post_like_chaining */
public enum GraphQLDigitalGoodStoreType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    AMAZON_APP_STORE,
    GOOGLE_PLAY,
    FB_CANVAS,
    ITUNES,
    ITUNES_IPAD,
    WINDOWS_STORE,
    WINDOWS_10_STORE,
    FB_ANDROID_STORE;

    public static GraphQLDigitalGoodStoreType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("AMAZON_APP_STORE")) {
            return AMAZON_APP_STORE;
        }
        if (str.equalsIgnoreCase("GOOGLE_PLAY")) {
            return GOOGLE_PLAY;
        }
        if (str.equalsIgnoreCase("FB_CANVAS")) {
            return FB_CANVAS;
        }
        if (str.equalsIgnoreCase("ITUNES")) {
            return ITUNES;
        }
        if (str.equalsIgnoreCase("ITUNES_IPAD")) {
            return ITUNES_IPAD;
        }
        if (str.equalsIgnoreCase("WINDOWS_STORE")) {
            return WINDOWS_STORE;
        }
        if (str.equalsIgnoreCase("WINDOWS_10_STORE")) {
            return WINDOWS_10_STORE;
        }
        if (str.equalsIgnoreCase("FB_ANDROID_STORE")) {
            return FB_ANDROID_STORE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

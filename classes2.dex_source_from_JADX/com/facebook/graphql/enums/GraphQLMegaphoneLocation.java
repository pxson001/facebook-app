package com.facebook.graphql.enums;

/* compiled from: messenger_transcode_video_android_v7 */
public enum GraphQLMegaphoneLocation {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NEWSFEED,
    MESSENGER_BOTTOM,
    APP_TOP,
    PAGES_MANAGER_APP_TOP,
    SNAPTU_MAIN_SCREEN;

    public static GraphQLMegaphoneLocation fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NEWSFEED")) {
            return NEWSFEED;
        }
        if (str.equalsIgnoreCase("MESSENGER_BOTTOM")) {
            return MESSENGER_BOTTOM;
        }
        if (str.equalsIgnoreCase("APP_TOP")) {
            return APP_TOP;
        }
        if (str.equalsIgnoreCase("PAGES_MANAGER_APP_TOP")) {
            return PAGES_MANAGER_APP_TOP;
        }
        if (str.equalsIgnoreCase("SNAPTU_MAIN_SCREEN")) {
            return SNAPTU_MAIN_SCREEN;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

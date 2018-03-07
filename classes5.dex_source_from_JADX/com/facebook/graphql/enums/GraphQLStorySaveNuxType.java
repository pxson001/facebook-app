package com.facebook.graphql.enums;

/* compiled from: live_comment_received */
public enum GraphQLStorySaveNuxType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    LINK_WELCOME,
    VIDEO_WELCOME,
    VIDEO_SLOW_CONNECTION,
    POST_SAVE_WELCOME,
    PHOTO_WELCOME;

    public static GraphQLStorySaveNuxType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("LINK_WELCOME")) {
            return LINK_WELCOME;
        }
        if (str.equalsIgnoreCase("VIDEO_WELCOME")) {
            return VIDEO_WELCOME;
        }
        if (str.equalsIgnoreCase("VIDEO_SLOW_CONNECTION")) {
            return VIDEO_SLOW_CONNECTION;
        }
        if (str.equalsIgnoreCase("POST_SAVE_WELCOME")) {
            return POST_SAVE_WELCOME;
        }
        if (str.equalsIgnoreCase("PHOTO_WELCOME")) {
            return PHOTO_WELCOME;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: maximum weight must not be negative */
public enum GraphQLBumpReason {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    BUMP_NONE,
    BUMP_UNREAD,
    BUMP_OUT_OF_TIME_RANGE,
    BUMP_ACTION_TYPE,
    BUMP_STORY_TIME,
    BUMP_PRIVACY_UPDATED,
    BUMP_NEW_ATTACHED_PHOTO,
    BUMP_NEW_APP,
    BUMP_COMMENT_FROM_MUTIPLE_OBJECTS,
    BUMP_SHARE_COMPOSER_ABANDON,
    BUMP_IMAGE_NOT_LOADED,
    BUMP_UNREAD_ACTION_TYPE,
    BUMP_SHORT_VPVD,
    BUMP_LIVE_VIDEO,
    BUMP_VH_LIVE;

    public static GraphQLBumpReason fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("BUMP_NONE")) {
            return BUMP_NONE;
        }
        if (str.equalsIgnoreCase("BUMP_UNREAD")) {
            return BUMP_UNREAD;
        }
        if (str.equalsIgnoreCase("BUMP_OUT_OF_TIME_RANGE")) {
            return BUMP_OUT_OF_TIME_RANGE;
        }
        if (str.equalsIgnoreCase("BUMP_ACTION_TYPE")) {
            return BUMP_ACTION_TYPE;
        }
        if (str.equalsIgnoreCase("BUMP_STORY_TIME")) {
            return BUMP_STORY_TIME;
        }
        if (str.equalsIgnoreCase("BUMP_PRIVACY_UPDATED")) {
            return BUMP_PRIVACY_UPDATED;
        }
        if (str.equalsIgnoreCase("BUMP_NEW_ATTACHED_PHOTO")) {
            return BUMP_NEW_ATTACHED_PHOTO;
        }
        if (str.equalsIgnoreCase("BUMP_NEW_APP")) {
            return BUMP_NEW_APP;
        }
        if (str.equalsIgnoreCase("BUMP_COMMENT_FROM_MUTIPLE_OBJECTS")) {
            return BUMP_COMMENT_FROM_MUTIPLE_OBJECTS;
        }
        if (str.equalsIgnoreCase("BUMP_SHARE_COMPOSER_ABANDON")) {
            return BUMP_SHARE_COMPOSER_ABANDON;
        }
        if (str.equalsIgnoreCase("BUMP_IMAGE_NOT_LOADED")) {
            return BUMP_IMAGE_NOT_LOADED;
        }
        if (str.equalsIgnoreCase("BUMP_UNREAD_ACTION_TYPE")) {
            return BUMP_UNREAD_ACTION_TYPE;
        }
        if (str.equalsIgnoreCase("BUMP_SHORT_VPVD")) {
            return BUMP_SHORT_VPVD;
        }
        if (str.equalsIgnoreCase("BUMP_LIVE_VIDEO")) {
            return BUMP_LIVE_VIDEO;
        }
        if (str.equalsIgnoreCase("BUMP_VH_LIVE")) {
            return BUMP_VH_LIVE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: link_media */
public enum GraphQLTimelineContextListTargetType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    MESSAGE,
    RECENT_FRIENDS,
    MUTUAL_FRIENDS,
    FRIENDS,
    FOLLOWERS,
    COMPOSER,
    PHOTO_UPLOADS,
    REFRESHER;

    public static GraphQLTimelineContextListTargetType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("MESSAGE")) {
            return MESSAGE;
        }
        if (str.equalsIgnoreCase("RECENT_FRIENDS")) {
            return RECENT_FRIENDS;
        }
        if (str.equalsIgnoreCase("MUTUAL_FRIENDS")) {
            return MUTUAL_FRIENDS;
        }
        if (str.equalsIgnoreCase("FRIENDS")) {
            return FRIENDS;
        }
        if (str.equalsIgnoreCase("FOLLOWERS")) {
            return FOLLOWERS;
        }
        if (str.equalsIgnoreCase("COMPOSER")) {
            return COMPOSER;
        }
        if (str.equalsIgnoreCase("PHOTO_UPLOADS")) {
            return PHOTO_UPLOADS;
        }
        if (str.equalsIgnoreCase("REFRESHER")) {
            return REFRESHER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

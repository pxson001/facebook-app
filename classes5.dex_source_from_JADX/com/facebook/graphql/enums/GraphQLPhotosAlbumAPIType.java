package com.facebook.graphql.enums;

/* compiled from: mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds. */
public enum GraphQLPhotosAlbumAPIType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PROFILE,
    COVER,
    MOBILE,
    WALL,
    FRIENDS_WALLS,
    NORMAL,
    APP,
    SHARED,
    OTHER;

    public static GraphQLPhotosAlbumAPIType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PROFILE")) {
            return PROFILE;
        }
        if (str.equalsIgnoreCase("COVER")) {
            return COVER;
        }
        if (str.equalsIgnoreCase("MOBILE")) {
            return MOBILE;
        }
        if (str.equalsIgnoreCase("WALL")) {
            return WALL;
        }
        if (str.equalsIgnoreCase("FRIENDS_WALLS")) {
            return FRIENDS_WALLS;
        }
        if (str.equalsIgnoreCase("NORMAL")) {
            return NORMAL;
        }
        if (str.equalsIgnoreCase("APP")) {
            return APP;
        }
        if (str.equalsIgnoreCase("SHARED")) {
            return SHARED;
        }
        if (str.equalsIgnoreCase("OTHER")) {
            return OTHER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

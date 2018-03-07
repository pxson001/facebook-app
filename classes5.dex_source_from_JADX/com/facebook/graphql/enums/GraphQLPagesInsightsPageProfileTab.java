package com.facebook.graphql.enums;

/* compiled from: mContent */
public enum GraphQLPagesInsightsPageProfileTab {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    OTHER,
    HOME,
    TIMELINE,
    ABOUT,
    PHOTOS,
    VIDEOS,
    REVIEWS,
    EVENTS,
    NOTES,
    LIKES,
    GROUPS;

    public static GraphQLPagesInsightsPageProfileTab fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("OTHER")) {
            return OTHER;
        }
        if (str.equalsIgnoreCase("HOME")) {
            return HOME;
        }
        if (str.equalsIgnoreCase("TIMELINE")) {
            return TIMELINE;
        }
        if (str.equalsIgnoreCase("ABOUT")) {
            return ABOUT;
        }
        if (str.equalsIgnoreCase("PHOTOS")) {
            return PHOTOS;
        }
        if (str.equalsIgnoreCase("VIDEOS")) {
            return VIDEOS;
        }
        if (str.equalsIgnoreCase("REVIEWS")) {
            return REVIEWS;
        }
        if (str.equalsIgnoreCase("EVENTS")) {
            return EVENTS;
        }
        if (str.equalsIgnoreCase("NOTES")) {
            return NOTES;
        }
        if (str.equalsIgnoreCase("LIKES")) {
            return LIKES;
        }
        if (str.equalsIgnoreCase("GROUPS")) {
            return GROUPS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: mDescriptionText */
public enum GraphQLPagePresenceTabType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ABOUT,
    BOOK_PREVIEW,
    EVENTS,
    HOME,
    LOCATIONS,
    MUSIC,
    PHOTOS,
    POSTS,
    REVIEWS,
    SERVICES,
    SHOP,
    VIDEOS,
    ACTIVITY,
    GROUPS;

    public static GraphQLPagePresenceTabType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ABOUT")) {
            return ABOUT;
        }
        if (str.equalsIgnoreCase("ACTIVITY")) {
            return ACTIVITY;
        }
        if (str.equalsIgnoreCase("BOOK_PREVIEW")) {
            return BOOK_PREVIEW;
        }
        if (str.equalsIgnoreCase("EVENTS")) {
            return EVENTS;
        }
        if (str.equalsIgnoreCase("GROUPS")) {
            return GROUPS;
        }
        if (str.equalsIgnoreCase("HOME")) {
            return HOME;
        }
        if (str.equalsIgnoreCase("LOCATIONS")) {
            return LOCATIONS;
        }
        if (str.equalsIgnoreCase("MUSIC")) {
            return MUSIC;
        }
        if (str.equalsIgnoreCase("PHOTOS")) {
            return PHOTOS;
        }
        if (str.equalsIgnoreCase("POSTS")) {
            return POSTS;
        }
        if (str.equalsIgnoreCase("REVIEWS")) {
            return REVIEWS;
        }
        if (str.equalsIgnoreCase("SERVICES")) {
            return SERVICES;
        }
        if (str.equalsIgnoreCase("SHOP")) {
            return SHOP;
        }
        if (str.equalsIgnoreCase("VIDEOS")) {
            return VIDEOS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: live_viewer_count_read_only */
public enum GraphQLSavedDashboardSectionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ALL,
    ARCHIVED,
    BOOKS,
    EVENTS,
    LINKS,
    MOVIES,
    MUSIC,
    PLACES,
    TV_SHOWS,
    VIDEOS,
    PAGES,
    PHOTOS,
    PRODUCTS,
    PROFILES,
    MEDIA,
    POSTS,
    EXTERNAL_URLS,
    MESSAGES,
    LISTS;

    public static GraphQLSavedDashboardSectionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ALL")) {
            return ALL;
        }
        if (str.equalsIgnoreCase("ARCHIVED")) {
            return ARCHIVED;
        }
        if (str.equalsIgnoreCase("BOOKS")) {
            return BOOKS;
        }
        if (str.equalsIgnoreCase("EVENTS")) {
            return EVENTS;
        }
        if (str.equalsIgnoreCase("LINKS")) {
            return LINKS;
        }
        if (str.equalsIgnoreCase("MOVIES")) {
            return MOVIES;
        }
        if (str.equalsIgnoreCase("MUSIC")) {
            return MUSIC;
        }
        if (str.equalsIgnoreCase("PLACES")) {
            return PLACES;
        }
        if (str.equalsIgnoreCase("TV_SHOWS")) {
            return TV_SHOWS;
        }
        if (str.equalsIgnoreCase("VIDEOS")) {
            return VIDEOS;
        }
        if (str.equalsIgnoreCase("PAGES")) {
            return PAGES;
        }
        if (str.equalsIgnoreCase("PHOTOS")) {
            return PHOTOS;
        }
        if (str.equalsIgnoreCase("PRODUCTS")) {
            return PRODUCTS;
        }
        if (str.equalsIgnoreCase("PROFILES")) {
            return PROFILES;
        }
        if (str.equalsIgnoreCase("MESSAGES")) {
            return MESSAGES;
        }
        if (str.equalsIgnoreCase("MEDIA")) {
            return MEDIA;
        }
        if (str.equalsIgnoreCase("POSTS")) {
            return POSTS;
        }
        if (str.equalsIgnoreCase("LISTS")) {
            return LISTS;
        }
        if (str.equalsIgnoreCase("EXTERNAL_URLS")) {
            return EXTERNAL_URLS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: link_target_store_data */
public enum GraphQLTimelineAppSectionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    APP,
    ABOUT,
    FRIENDS,
    PHOTOS,
    LIKES,
    MAP,
    SUBSCRIPTIONS,
    SUBSCRIBERS,
    PAGE_LIKES,
    NOTES,
    EVENTS,
    GROUPS,
    BOOKS,
    MUSIC,
    TV_SHOWS,
    MOVIES,
    FITNESS,
    CONTACT,
    SPORTS,
    GAMES,
    SAVED_FOR_LATER,
    REVIEWS,
    AT_WORK,
    VIDEOS,
    PERSONALITY_QUESTIONS;

    public static GraphQLTimelineAppSectionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("APP")) {
            return APP;
        }
        if (str.equalsIgnoreCase("ABOUT")) {
            return ABOUT;
        }
        if (str.equalsIgnoreCase("FRIENDS")) {
            return FRIENDS;
        }
        if (str.equalsIgnoreCase("PHOTOS")) {
            return PHOTOS;
        }
        if (str.equalsIgnoreCase("LIKES")) {
            return LIKES;
        }
        if (str.equalsIgnoreCase("MAP")) {
            return MAP;
        }
        if (str.equalsIgnoreCase("SUBSCRIPTIONS")) {
            return SUBSCRIPTIONS;
        }
        if (str.equalsIgnoreCase("SUBSCRIBERS")) {
            return SUBSCRIBERS;
        }
        if (str.equalsIgnoreCase("PAGE_LIKES")) {
            return PAGE_LIKES;
        }
        if (str.equalsIgnoreCase("NOTES")) {
            return NOTES;
        }
        if (str.equalsIgnoreCase("EVENTS")) {
            return EVENTS;
        }
        if (str.equalsIgnoreCase("GROUPS")) {
            return GROUPS;
        }
        if (str.equalsIgnoreCase("BOOKS")) {
            return BOOKS;
        }
        if (str.equalsIgnoreCase("MUSIC")) {
            return MUSIC;
        }
        if (str.equalsIgnoreCase("TV_SHOWS")) {
            return TV_SHOWS;
        }
        if (str.equalsIgnoreCase("MOVIES")) {
            return MOVIES;
        }
        if (str.equalsIgnoreCase("FITNESS")) {
            return FITNESS;
        }
        if (str.equalsIgnoreCase("CONTACT")) {
            return CONTACT;
        }
        if (str.equalsIgnoreCase("SPORTS")) {
            return SPORTS;
        }
        if (str.equalsIgnoreCase("GAMES")) {
            return GAMES;
        }
        if (str.equalsIgnoreCase("SAVED_FOR_LATER")) {
            return SAVED_FOR_LATER;
        }
        if (str.equalsIgnoreCase("REVIEWS")) {
            return REVIEWS;
        }
        if (str.equalsIgnoreCase("AT_WORK")) {
            return AT_WORK;
        }
        if (str.equalsIgnoreCase("VIDEOS")) {
            return VIDEOS;
        }
        if (str.equalsIgnoreCase("PERSONALITY_QUESTIONS")) {
            return PERSONALITY_QUESTIONS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: logo_image */
public enum GraphQLProfileTileSectionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ABOUT,
    CONTACT_INFO,
    FRIENDS,
    FOLLOWERS,
    MUTUALITY,
    PENDING,
    PHOTOS,
    PYMK,
    QUESTIONS,
    RECENT_ACTIVITY,
    VIDEOS;

    public static GraphQLProfileTileSectionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ABOUT")) {
            return ABOUT;
        }
        if (str.equalsIgnoreCase("CONTACT_INFO")) {
            return CONTACT_INFO;
        }
        if (str.equalsIgnoreCase("FRIENDS")) {
            return FRIENDS;
        }
        if (str.equalsIgnoreCase("FOLLOWERS")) {
            return FOLLOWERS;
        }
        if (str.equalsIgnoreCase("MUTUALITY")) {
            return MUTUALITY;
        }
        if (str.equalsIgnoreCase("PENDING")) {
            return PENDING;
        }
        if (str.equalsIgnoreCase("PHOTOS")) {
            return PHOTOS;
        }
        if (str.equalsIgnoreCase("PYMK")) {
            return PYMK;
        }
        if (str.equalsIgnoreCase("QUESTIONS")) {
            return QUESTIONS;
        }
        if (str.equalsIgnoreCase("RECENT_ACTIVITY")) {
            return RECENT_ACTIVITY;
        }
        if (str.equalsIgnoreCase("VIDEOS")) {
            return VIDEOS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

import android.support.v7.widget.LinearLayoutCompat;

/* compiled from: link_speed_mbps */
public enum GraphQLTimelineContextListItemType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    EDUCATION,
    WORK,
    CURRENT_CITY,
    HOMETOWN,
    MUTUAL_CITY,
    MUTUAL_EDUCATION,
    MUTUAL_HOMETOWN,
    MUTUAL_WORK,
    MUTUAL_LIKES,
    MUTUAL_GROUPS,
    MUTUAL_CITIES_VISITED,
    MUTUAL_MUSIC,
    MUTUAL_SPORTS,
    MUTUAL_TV_SHOWS,
    MUTUAL_MOVIES,
    MUTUAL_BOOKS,
    MUTUAL_PAST_EVENT,
    MUTUAL_FUTURE_EVENT,
    FRIEND_COUNT,
    FRIENDS_SINCE,
    FRIENDS,
    FOLLOWER_COUNT,
    MUTUAL_FRIENDS,
    MUTUAL_CONTACTS,
    LOCATION,
    BIRTHDAY,
    INTRO_CARD_CURRENT_CITY,
    INTRO_CARD_EDUCATION,
    INTRO_CARD_FOLLOWERS,
    INTRO_CARD_HOMETOWN,
    INTRO_CARD_RELATIONSHIP,
    INTRO_CARD_NAME_PRONUNCIATION,
    INTRO_CARD_WORK,
    INTRO_CARD_ABOUT_TAGS,
    NEW_FRIENDS,
    RECENT_VISIT,
    RECENT_EVENT,
    RECENT_OG,
    FAMILY_RELATIONSHIP,
    ANNIVERSARY,
    LIFE_EVENT,
    RECENT_ACTIVITY_TAG,
    FOLLOWS_POSTS,
    SELF_TIMELINE_REVIEW,
    SELF_PROFILE_QUESTIONS,
    SELF_PROFILE_REFRESHER,
    RELATIONSHIP,
    JOB_ANNIVERSARY,
    NAME_DAY,
    LOCAL_CHECKIN,
    LAST_UPDATED,
    BORN,
    FRIENDS_YOU_MAY_KNOW,
    RECENT_UNSEEN_POSTS,
    JOINED_FACEBOOK,
    NAME_PRONUNCIATION,
    EMAIL,
    PHONE,
    MESSENGER_DEFAULT,
    ABOUT_TAGS,
    CONTACT,
    CONTACT_OF,
    AT_WORK_JOB_TITLE,
    AT_WORK_JOB_LOCATION,
    TIME_JOINED_GROUP,
    FOR_SALE_IN_GROUP,
    DEGREES_OF_SEPARATION;

    public static GraphQLTimelineContextListItemType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        switch ((((Character.toUpperCase(str.charAt(0)) * 961) + (Character.toUpperCase(str.charAt(str.length() - 1)) * 31)) + str.length()) & 63) {
            case 0:
                if (str.equalsIgnoreCase("EDUCATION")) {
                    return EDUCATION;
                }
                if (str.equalsIgnoreCase("FOLLOWER_COUNT")) {
                    return FOLLOWER_COUNT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (str.equalsIgnoreCase("HOMETOWN")) {
                    return HOMETOWN;
                }
                if (str.equalsIgnoreCase("LIFE_EVENT")) {
                    return LIFE_EVENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 6:
                if (str.equalsIgnoreCase("LOCATION")) {
                    return LOCATION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 7:
                if (str.equalsIgnoreCase("CONTACT_OF")) {
                    return CONTACT_OF;
                }
                if (str.equalsIgnoreCase("AT_WORK_JOB_LOCATION")) {
                    return AT_WORK_JOB_LOCATION;
                }
                if (str.equalsIgnoreCase("FOR_SALE_IN_GROUP")) {
                    return FOR_SALE_IN_GROUP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 9:
                if (str.equalsIgnoreCase("FAMILY_RELATIONSHIP")) {
                    return FAMILY_RELATIONSHIP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 10:
                if (str.equalsIgnoreCase("MUTUAL_PAST_EVENT")) {
                    return MUTUAL_PAST_EVENT;
                }
                if (str.equalsIgnoreCase("RECENT_VISIT")) {
                    return RECENT_VISIT;
                }
                if (str.equalsIgnoreCase("RECENT_EVENT")) {
                    return RECENT_EVENT;
                }
                if (str.equalsIgnoreCase("MESSENGER_DEFAULT")) {
                    return MESSENGER_DEFAULT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 11:
                if (str.equalsIgnoreCase("LOCAL_CHECKIN")) {
                    return LOCAL_CHECKIN;
                }
                if (str.equalsIgnoreCase("DEGREES_OF_SEPARATION")) {
                    return DEGREES_OF_SEPARATION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 12:
                if (str.equalsIgnoreCase("MUTUAL_FUTURE_EVENT")) {
                    return MUTUAL_FUTURE_EVENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 14:
                if (str.equalsIgnoreCase("MUTUAL_HOMETOWN")) {
                    return MUTUAL_HOMETOWN;
                }
                if (str.equalsIgnoreCase("INTRO_CARD_HOMETOWN")) {
                    return INTRO_CARD_HOMETOWN;
                }
                if (str.equalsIgnoreCase("RELATIONSHIP")) {
                    return RELATIONSHIP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 15:
                if (str.equalsIgnoreCase("MUTUAL_EDUCATION")) {
                    return MUTUAL_EDUCATION;
                }
                if (str.equalsIgnoreCase("INTRO_CARD_EDUCATION")) {
                    return INTRO_CARD_EDUCATION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 16:
                if (str.equalsIgnoreCase("INTRO_CARD_RELATIONSHIP")) {
                    return INTRO_CARD_RELATIONSHIP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 17:
                if (str.equalsIgnoreCase("BIRTHDAY")) {
                    return BIRTHDAY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 18:
                if (str.equalsIgnoreCase("NAME_PRONUNCIATION")) {
                    return NAME_PRONUNCIATION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 19:
                if (str.equalsIgnoreCase("ANNIVERSARY")) {
                    return ANNIVERSARY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 20:
                if (str.equalsIgnoreCase("LAST_UPDATED")) {
                    return LAST_UPDATED;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 21:
                if (str.equalsIgnoreCase("TIME_JOINED_GROUP")) {
                    return TIME_JOINED_GROUP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 22:
                if (str.equalsIgnoreCase("CURRENT_CITY")) {
                    return CURRENT_CITY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 23:
                if (str.equalsIgnoreCase("SELF_PROFILE_REFRESHER")) {
                    return SELF_PROFILE_REFRESHER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 24:
                if (str.equalsIgnoreCase("INTRO_CARD_NAME_PRONUNCIATION")) {
                    return INTRO_CARD_NAME_PRONUNCIATION;
                }
                if (str.equalsIgnoreCase("ABOUT_TAGS")) {
                    return ABOUT_TAGS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 26:
                if (str.equalsIgnoreCase("FRIENDS")) {
                    return FRIENDS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 29:
                if (str.equalsIgnoreCase("NAME_DAY")) {
                    return NAME_DAY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 30:
                if (str.equalsIgnoreCase("MUTUAL_CITIES_VISITED")) {
                    return MUTUAL_CITIES_VISITED;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 31:
                if (str.equalsIgnoreCase("MUTUAL_CITY")) {
                    return MUTUAL_CITY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 32:
                if (str.equalsIgnoreCase("FOLLOWS_POSTS")) {
                    return FOLLOWS_POSTS;
                }
                if (str.equalsIgnoreCase("JOB_ANNIVERSARY")) {
                    return JOB_ANNIVERSARY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 35:
                if (str.equalsIgnoreCase("FRIENDS_YOU_MAY_KNOW")) {
                    return FRIENDS_YOU_MAY_KNOW;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 38:
                if (str.equalsIgnoreCase("MUTUAL_LIKES")) {
                    return MUTUAL_LIKES;
                }
                if (str.equalsIgnoreCase("MUTUAL_BOOKS")) {
                    return MUTUAL_BOOKS;
                }
                if (str.equalsIgnoreCase("NEW_FRIENDS")) {
                    return NEW_FRIENDS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 39:
                if (str.equalsIgnoreCase("MUTUAL_GROUPS")) {
                    return MUTUAL_GROUPS;
                }
                if (str.equalsIgnoreCase("MUTUAL_SPORTS")) {
                    return MUTUAL_SPORTS;
                }
                if (str.equalsIgnoreCase("MUTUAL_MOVIES")) {
                    return MUTUAL_MOVIES;
                }
                if (str.equalsIgnoreCase("INTRO_CARD_CURRENT_CITY")) {
                    return INTRO_CARD_CURRENT_CITY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 40:
                if (str.equalsIgnoreCase("MUTUAL_FRIENDS")) {
                    return MUTUAL_FRIENDS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 41:
                if (str.equalsIgnoreCase("MUTUAL_TV_SHOWS")) {
                    return MUTUAL_TV_SHOWS;
                }
                if (str.equalsIgnoreCase("MUTUAL_CONTACTS")) {
                    return MUTUAL_CONTACTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 42:
                if (str.equalsIgnoreCase("INTRO_CARD_FOLLOWERS")) {
                    return INTRO_CARD_FOLLOWERS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 43:
                if (str.equalsIgnoreCase("INTRO_CARD_ABOUT_TAGS")) {
                    return INTRO_CARD_ABOUT_TAGS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 45:
                if (str.equalsIgnoreCase("MUTUAL_WORK")) {
                    return MUTUAL_WORK;
                }
                if (str.equalsIgnoreCase("INTRO_CARD_WORK")) {
                    return INTRO_CARD_WORK;
                }
                if (str.equalsIgnoreCase("AT_WORK_JOB_TITLE")) {
                    return AT_WORK_JOB_TITLE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 46:
                if (str.equalsIgnoreCase("FRIENDS_SINCE")) {
                    return FRIENDS_SINCE;
                }
                if (str.equalsIgnoreCase("JOINED_FACEBOOK")) {
                    return JOINED_FACEBOOK;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 48:
                if (str.equalsIgnoreCase("WORK")) {
                    return WORK;
                }
                if (str.equalsIgnoreCase("SELF_TIMELINE_REVIEW")) {
                    return SELF_TIMELINE_REVIEW;
                }
                if (str.equalsIgnoreCase("PHONE")) {
                    return PHONE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 50:
                if (str.equalsIgnoreCase("RECENT_UNSEEN_POSTS")) {
                    return RECENT_UNSEEN_POSTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 52:
                if (str.equalsIgnoreCase("RECENT_OG")) {
                    return RECENT_OG;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 54:
                if (str.equalsIgnoreCase("MUTUAL_MUSIC")) {
                    return MUTUAL_MUSIC;
                }
                if (str.equalsIgnoreCase("SELF_PROFILE_QUESTIONS")) {
                    return SELF_PROFILE_QUESTIONS;
                }
                if (str.equalsIgnoreCase("CONTACT")) {
                    return CONTACT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 56:
                if (str.equalsIgnoreCase("BORN")) {
                    return BORN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 62:
                if (str.equalsIgnoreCase("FRIEND_COUNT")) {
                    return FRIEND_COUNT;
                }
                if (str.equalsIgnoreCase("RECENT_ACTIVITY_TAG")) {
                    return RECENT_ACTIVITY_TAG;
                }
                if (str.equalsIgnoreCase("EMAIL")) {
                    return EMAIL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            default:
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }
}

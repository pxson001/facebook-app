package com.facebook.graphql.enums;

import android.support.v7.widget.LinearLayoutCompat;

/* compiled from: marketplace_cross_post_setting_model */
public enum GraphQLEntityCardContextItemType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SAVE_ITEM,
    MOVIE_DETAILS,
    BUY_MOVIE_TICKETS,
    IN_THEATER,
    TV_SHOW_DETAILS,
    TEAM_LIKE,
    FRIEND_TEAM_LIKE,
    GAME_SCORE,
    READ_BOOK,
    RESERVE_TABLE,
    DISTANCE_FROM_USER,
    CALL,
    OPEN_STATUS,
    FRIENDS_VISITED,
    PLACE_INFO,
    PLACE_CLAIM,
    MENU,
    LIKES,
    LIKES_AP,
    MENTIONS_APP_LIKES,
    VISITS,
    VISITS_AP,
    GLOBAL_INFORMATION,
    FRIEND_REVIEW,
    FRIENDS_INTERESTED,
    SELF_REVIEW,
    AIRING,
    ABOUT,
    SPORTS_DATA,
    SPORTS_TEAM_SCHEDULE,
    SIMILAR_PAGES,
    ADD_PAGE_INFO,
    SUGGEST_EDITS,
    IMPRESSUM,
    VIEW_WEBSITE,
    LONG_DESC,
    PAGE_INVITE_REMINDER,
    FRIEND_LIKES_AND_VISITS,
    RATINGS_AND_REVIEWS,
    FRIEND_LIKES,
    WATCH_MOVIE,
    PAGE_POPULAR_CONTENT,
    PAGE_FRIENDS_POPULAR_CONTENT,
    EVENT_TIME,
    EVENT_LOCATION,
    EVENT_FRIENDS_ATTENDING,
    EVENT_TICKETS,
    EVENT_INVITED_BY,
    EVENT_GLOBAL_ATTENDING,
    EVENT_DESCRIPTION,
    ADMIN_TIP_ADD_PROFILE_PIC,
    ADMIN_TIP_PUBLISH_PAGE,
    ADMIN_TIP_ADD_COVER_PHOTO,
    ADMIN_TIP_ADD_BASIC_INFO,
    ADMIN_TIP_ADD_CONTACT_INFO,
    ADMIN_TIP_ADD_PHOTO_MENU,
    ADMIN_TIP_PROMOTE_PAGE,
    ADMIN_TIP_PROMOTE_POST,
    ADMIN_TIP_PROMOTE_WEBSITE,
    ADMIN_TIP_CREATE_POST,
    ADMIN_TIP_CREATE_PHOTO_POST,
    ADMIN_TIP_PUBLISH_DRAFT_POST,
    ADMIN_TIP_SUCCESS_STORIES,
    ADS_AFTER_PARTY_AYMT_TIPS,
    ADMIN_TIP_TURN_ON_NOTIFICATIONS,
    ADMIN_TIP_P2P_MIGRATION_REMINDER,
    ADMIN_TIP_SELECT_PAGE_GOAL,
    ADMIN_PAGES_FEED,
    ADMIN_TIP_FROM_AYMT,
    ADMIN_WEEKLY_NEW_LIKES,
    ADMIN_WEEKLY_NEW_VISITS,
    ADMIN_WEEKLY_POST_REACH,
    ADMIN_VIEW_PROMOTIONS,
    ADMIN_MESSAGE_ACTIVE_TROPHY,
    ADMIN_MESSAGE_INACTIVE_TROPHY,
    ADMIN_WEEKLY_TOTAL_REACH,
    ADMIN_WEEKLY_TOTAL_ENGAGEMENT,
    ADMIN_MESSAGE_TROPHY_TEXT,
    ADMIN_MESSAGE_TROPHY_EXPLANATION,
    ADMIN_MESSAGE_TROPHY_VISIBLE_TEXT,
    PAGE_WEEKLY_NEW_REVIEWS,
    PAGE_WEEKLY_NEW_CHECKINS,
    PAGE_WEEKLY_NEW_SHARES,
    PAGE_UNREAD_MESSAGES,
    VISIT_YOUR_PAGE,
    MANAGE_ALL_YOUR_PAGES,
    PAGE_WEEKLY_NEW_MENTIONS,
    ADMIN_PAGE_DELETION_STATUS,
    ADMIN_BEACON_ORDER_STATUS,
    LISTEN,
    CALL_TO_ACTION,
    OG_DESCRIPTION,
    GROUP_MEMBERS,
    GROUP_DESCRIPTION,
    GROUP_PRIVACY,
    GROUP_PHOTOS,
    GROUP_EVENTS,
    GROUP_FILES,
    ASSOCIATED_APPLICATION_INSTALL,
    ASSOCIATED_APPLICATION_OPEN,
    ASSOCIATED_APPLICATION_REQUESTS,
    FRIEND_INVITER,
    ASSOCIATED_APPLICATION_TRAILER,
    MESSAGE_PAGE,
    PROMOTE_CCTA,
    PROMOTE_PAGE,
    PROMOTE_LOCAL_AWARENESS,
    PROMOTE_LOCAL_AWARENESS_RESULTS,
    PROMOTE_WEBSITE,
    PAGE_EVENTS_CALENDAR_SUBSCRIPTION,
    PAGE_MESSAGE_RESPONSE,
    PAGE_MESSAGE_RESPONSE_TIME,
    PAGE_CREATE_CALL_TO_ACTION,
    PAGE_FRIEND_CONTENT,
    PLACE_STREET_ADDRESS_QUESTION,
    PLACE_CITY_QUESTION,
    PLACE_ZIP_CODE_QUESTION,
    PAGE_CAREERS,
    PLACE_CATEGORY_QUESTION,
    PAGE_VERIFICATION,
    PAGE_OPENTABLE_INTEGRATION,
    PAGE_REDIRECT_BEST_PAGE_OPTIONS,
    PAGE_REACTION_UNITS_SANDBOX,
    PAGES_LITE_UPSELL,
    PAGE_CATEGORIES,
    ADMIN_TIP_TRY_ADS_MANAGER_APP,
    GET_DIRECTIONS;

    public static GraphQLEntityCardContextItemType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        switch ((((Character.toUpperCase(str.charAt(0)) * 961) + (Character.toUpperCase(str.charAt(str.length() - 1)) * 31)) + str.length()) & 63) {
            case 0:
                if (str.equalsIgnoreCase("ADMIN_TIP_FROM_AYMT")) {
                    return ADMIN_TIP_FROM_AYMT;
                }
                if (str.equalsIgnoreCase("VISIT_YOUR_PAGE")) {
                    return VISIT_YOUR_PAGE;
                }
                if (str.equalsIgnoreCase("PAGE_MESSAGE_RESPONSE")) {
                    return PAGE_MESSAGE_RESPONSE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 1:
                if (str.equalsIgnoreCase("IN_THEATER")) {
                    return IN_THEATER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (str.equalsIgnoreCase("SPORTS_TEAM_SCHEDULE")) {
                    return SPORTS_TEAM_SCHEDULE;
                }
                if (str.equalsIgnoreCase("ADMIN_TIP_CREATE_POST")) {
                    return ADMIN_TIP_CREATE_POST;
                }
                if (str.equalsIgnoreCase("FRIEND_INVITER")) {
                    return FRIEND_INVITER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 3:
                if (str.equalsIgnoreCase("ADMIN_TIP_PROMOTE_POST")) {
                    return ADMIN_TIP_PROMOTE_POST;
                }
                if (str.equalsIgnoreCase("CALL_TO_ACTION")) {
                    return CALL_TO_ACTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                if (str.equalsIgnoreCase("DISTANCE_FROM_USER")) {
                    return DISTANCE_FROM_USER;
                }
                if (str.equalsIgnoreCase("LIKES_AP")) {
                    return LIKES_AP;
                }
                if (str.equalsIgnoreCase("LISTEN")) {
                    return LISTEN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 5:
                if (str.equalsIgnoreCase("EVENT_LOCATION")) {
                    return EVENT_LOCATION;
                }
                if (str.equalsIgnoreCase("PAGE_MESSAGE_RESPONSE_TIME")) {
                    return PAGE_MESSAGE_RESPONSE_TIME;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 6:
                if (str.equalsIgnoreCase("ADMIN_MESSAGE_TROPHY_TEXT")) {
                    return ADMIN_MESSAGE_TROPHY_TEXT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 8:
                if (str.equalsIgnoreCase("EVENT_DESCRIPTION")) {
                    return EVENT_DESCRIPTION;
                }
                if (str.equalsIgnoreCase("ADMIN_TIP_CREATE_PHOTO_POST")) {
                    return ADMIN_TIP_CREATE_PHOTO_POST;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 9:
                if (str.equalsIgnoreCase("ADMIN_TIP_PUBLISH_DRAFT_POST")) {
                    return ADMIN_TIP_PUBLISH_DRAFT_POST;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 10:
                if (str.equalsIgnoreCase("ADMIN_WEEKLY_TOTAL_ENGAGEMENT")) {
                    return ADMIN_WEEKLY_TOTAL_ENGAGEMENT;
                }
                if (str.equalsIgnoreCase("GROUP_DESCRIPTION")) {
                    return GROUP_DESCRIPTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 11:
                if (str.equalsIgnoreCase("GLOBAL_INFORMATION")) {
                    return GLOBAL_INFORMATION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 13:
                if (str.equalsIgnoreCase("ADMIN_PAGES_FEED")) {
                    return ADMIN_PAGES_FEED;
                }
                if (str.equalsIgnoreCase("ASSOCIATED_APPLICATION_TRAILER")) {
                    return ASSOCIATED_APPLICATION_TRAILER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 14:
                if (str.equalsIgnoreCase("ADMIN_TIP_TRY_ADS_MANAGER_APP")) {
                    return ADMIN_TIP_TRY_ADS_MANAGER_APP;
                }
                if (str.equalsIgnoreCase("ADMIN_MESSAGE_TROPHY_VISIBLE_TEXT")) {
                    return ADMIN_MESSAGE_TROPHY_VISIBLE_TEXT;
                }
                if (str.equalsIgnoreCase("ASSOCIATED_APPLICATION_OPEN")) {
                    return ASSOCIATED_APPLICATION_OPEN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 15:
                if (str.equalsIgnoreCase("VISITS_AP")) {
                    return VISITS_AP;
                }
                if (str.equalsIgnoreCase("ADMIN_TIP_P2P_MIGRATION_REMINDER")) {
                    return ADMIN_TIP_P2P_MIGRATION_REMINDER;
                }
                if (str.equalsIgnoreCase("ADMIN_TIP_SELECT_PAGE_GOAL")) {
                    return ADMIN_TIP_SELECT_PAGE_GOAL;
                }
                if (str.equalsIgnoreCase("OG_DESCRIPTION")) {
                    return OG_DESCRIPTION;
                }
                if (str.equalsIgnoreCase("PAGE_FRIEND_CONTENT")) {
                    return PAGE_FRIEND_CONTENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 16:
                if (str.equalsIgnoreCase("PAGE_POPULAR_CONTENT")) {
                    return PAGE_POPULAR_CONTENT;
                }
                if (str.equalsIgnoreCase("ADMIN_WEEKLY_POST_REACH")) {
                    return ADMIN_WEEKLY_POST_REACH;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 17:
                if (str.equalsIgnoreCase("FRIENDS_VISITED")) {
                    return FRIENDS_VISITED;
                }
                if (str.equalsIgnoreCase("ADMIN_WEEKLY_TOTAL_REACH")) {
                    return ADMIN_WEEKLY_TOTAL_REACH;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 18:
                if (str.equalsIgnoreCase("PAGE_INVITE_REMINDER")) {
                    return PAGE_INVITE_REMINDER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 19:
                if (str.equalsIgnoreCase("ADMIN_MESSAGE_TROPHY_EXPLANATION")) {
                    return ADMIN_MESSAGE_TROPHY_EXPLANATION;
                }
                if (str.equalsIgnoreCase("ASSOCIATED_APPLICATION_INSTALL")) {
                    return ASSOCIATED_APPLICATION_INSTALL;
                }
                if (str.equalsIgnoreCase("PAGE_VERIFICATION")) {
                    return PAGE_VERIFICATION;
                }
                if (str.equalsIgnoreCase("PAGE_REACTION_UNITS_SANDBOX")) {
                    return PAGE_REACTION_UNITS_SANDBOX;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 20:
                if (str.equalsIgnoreCase("FRIENDS_INTERESTED")) {
                    return FRIENDS_INTERESTED;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 21:
                if (str.equalsIgnoreCase("PLACE_CITY_QUESTION")) {
                    return PLACE_CITY_QUESTION;
                }
                if (str.equalsIgnoreCase("PAGES_LITE_UPSELL")) {
                    return PAGES_LITE_UPSELL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 24:
                if (str.equalsIgnoreCase("PAGE_FRIENDS_POPULAR_CONTENT")) {
                    return PAGE_FRIENDS_POPULAR_CONTENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 25:
                if (str.equalsIgnoreCase("PLACE_ZIP_CODE_QUESTION")) {
                    return PLACE_ZIP_CODE_QUESTION;
                }
                if (str.equalsIgnoreCase("PLACE_CATEGORY_QUESTION")) {
                    return PLACE_CATEGORY_QUESTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 27:
                if (str.equalsIgnoreCase("GROUP_PRIVACY")) {
                    return GROUP_PRIVACY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 28:
                if (str.equalsIgnoreCase("MENU")) {
                    return MENU;
                }
                if (str.equalsIgnoreCase("FRIEND_REVIEW")) {
                    return FRIEND_REVIEW;
                }
                if (str.equalsIgnoreCase("EVENT_INVITED_BY")) {
                    return EVENT_INVITED_BY;
                }
                if (str.equalsIgnoreCase("PAGE_CREATE_CALL_TO_ACTION")) {
                    return PAGE_CREATE_CALL_TO_ACTION;
                }
                if (str.equalsIgnoreCase("PAGE_OPENTABLE_INTEGRATION")) {
                    return PAGE_OPENTABLE_INTEGRATION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 30:
                if (str.equalsIgnoreCase("LIKES")) {
                    return LIKES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 31:
                if (str.equalsIgnoreCase("ADD_PAGE_INFO")) {
                    return ADD_PAGE_INFO;
                }
                if (str.equalsIgnoreCase("FRIEND_LIKES")) {
                    return FRIEND_LIKES;
                }
                if (str.equalsIgnoreCase("EVENT_TICKETS")) {
                    return EVENT_TICKETS;
                }
                if (str.equalsIgnoreCase("GROUP_FILES")) {
                    return GROUP_FILES;
                }
                if (str.equalsIgnoreCase("PLACE_STREET_ADDRESS_QUESTION")) {
                    return PLACE_STREET_ADDRESS_QUESTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 32:
                if (str.equalsIgnoreCase("BUY_MOVIE_TICKETS")) {
                    return BUY_MOVIE_TICKETS;
                }
                if (str.equalsIgnoreCase("AIRING")) {
                    return AIRING;
                }
                if (str.equalsIgnoreCase("GROUP_PHOTOS")) {
                    return GROUP_PHOTOS;
                }
                if (str.equalsIgnoreCase("GROUP_EVENTS")) {
                    return GROUP_EVENTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 33:
                if (str.equalsIgnoreCase("GROUP_MEMBERS")) {
                    return GROUP_MEMBERS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 34:
                if (str.equalsIgnoreCase("GET_DIRECTIONS")) {
                    return GET_DIRECTIONS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 35:
                if (str.equalsIgnoreCase("ADMIN_VIEW_PROMOTIONS")) {
                    return ADMIN_VIEW_PROMOTIONS;
                }
                if (str.equalsIgnoreCase("ADMIN_MESSAGE_ACTIVE_TROPHY")) {
                    return ADMIN_MESSAGE_ACTIVE_TROPHY;
                }
                if (str.equalsIgnoreCase("PAGE_EVENTS_CALENDAR_SUBSCRIPTION")) {
                    return PAGE_EVENTS_CALENDAR_SUBSCRIPTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 36:
                if (str.equalsIgnoreCase("ADMIN_TIP_ADD_PHOTO_MENU")) {
                    return ADMIN_TIP_ADD_PHOTO_MENU;
                }
                if (str.equalsIgnoreCase("ADMIN_WEEKLY_NEW_LIKES")) {
                    return ADMIN_WEEKLY_NEW_LIKES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 37:
                if (str.equalsIgnoreCase("IMPRESSUM")) {
                    return IMPRESSUM;
                }
                if (str.equalsIgnoreCase("ADMIN_WEEKLY_NEW_VISITS")) {
                    return ADMIN_WEEKLY_NEW_VISITS;
                }
                if (str.equalsIgnoreCase("ADMIN_MESSAGE_INACTIVE_TROPHY")) {
                    return ADMIN_MESSAGE_INACTIVE_TROPHY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 39:
                if (str.equalsIgnoreCase("MOVIE_DETAILS")) {
                    return MOVIE_DETAILS;
                }
                if (str.equalsIgnoreCase("OPEN_STATUS")) {
                    return OPEN_STATUS;
                }
                if (str.equalsIgnoreCase("SELF_REVIEW")) {
                    return SELF_REVIEW;
                }
                if (str.equalsIgnoreCase("ADMIN_TIP_SUCCESS_STORIES")) {
                    return ADMIN_TIP_SUCCESS_STORIES;
                }
                if (str.equalsIgnoreCase("ADS_AFTER_PARTY_AYMT_TIPS")) {
                    return ADS_AFTER_PARTY_AYMT_TIPS;
                }
                if (str.equalsIgnoreCase("ADMIN_BEACON_ORDER_STATUS")) {
                    return ADMIN_BEACON_ORDER_STATUS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 40:
                if (str.equalsIgnoreCase("ADMIN_PAGE_DELETION_STATUS")) {
                    return ADMIN_PAGE_DELETION_STATUS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 41:
                if (str.equalsIgnoreCase("VISITS")) {
                    return VISITS;
                }
                if (str.equalsIgnoreCase("PAGE_CAREERS")) {
                    return PAGE_CAREERS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 42:
                if (str.equalsIgnoreCase("FRIEND_LIKES_AND_VISITS")) {
                    return FRIEND_LIKES_AND_VISITS;
                }
                if (str.equalsIgnoreCase("EVENT_TIME")) {
                    return EVENT_TIME;
                }
                if (str.equalsIgnoreCase("ADMIN_TIP_ADD_BASIC_INFO")) {
                    return ADMIN_TIP_ADD_BASIC_INFO;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 43:
                if (str.equalsIgnoreCase("PLACE_INFO")) {
                    return PLACE_INFO;
                }
                if (str.equalsIgnoreCase("ADMIN_TIP_ADD_COVER_PHOTO")) {
                    return ADMIN_TIP_ADD_COVER_PHOTO;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 44:
                if (str.equalsIgnoreCase("GAME_SCORE")) {
                    return GAME_SCORE;
                }
                if (str.equalsIgnoreCase("MENTIONS_APP_LIKES")) {
                    return MENTIONS_APP_LIKES;
                }
                if (str.equalsIgnoreCase("ADMIN_TIP_ADD_CONTACT_INFO")) {
                    return ADMIN_TIP_ADD_CONTACT_INFO;
                }
                if (str.equalsIgnoreCase("PAGE_CATEGORIES")) {
                    return PAGE_CATEGORIES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 45:
                if (str.equalsIgnoreCase("SIMILAR_PAGES")) {
                    return SIMILAR_PAGES;
                }
                if (str.equalsIgnoreCase("SUGGEST_EDITS")) {
                    return SUGGEST_EDITS;
                }
                if (str.equalsIgnoreCase("ADMIN_TIP_TURN_ON_NOTIFICATIONS")) {
                    return ADMIN_TIP_TURN_ON_NOTIFICATIONS;
                }
                if (str.equalsIgnoreCase("ASSOCIATED_APPLICATION_REQUESTS")) {
                    return ASSOCIATED_APPLICATION_REQUESTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 46:
                if (str.equalsIgnoreCase("PLACE_CLAIM")) {
                    return PLACE_CLAIM;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 47:
                if (str.equalsIgnoreCase("SAVE_ITEM")) {
                    return SAVE_ITEM;
                }
                if (str.equalsIgnoreCase("MANAGE_ALL_YOUR_PAGES")) {
                    return MANAGE_ALL_YOUR_PAGES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 48:
                if (str.equalsIgnoreCase("TV_SHOW_DETAILS")) {
                    return TV_SHOW_DETAILS;
                }
                if (str.equalsIgnoreCase("READ_BOOK")) {
                    return READ_BOOK;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 49:
                if (str.equalsIgnoreCase("FRIEND_TEAM_LIKE")) {
                    return FRIEND_TEAM_LIKE;
                }
                if (str.equalsIgnoreCase("PAGE_UNREAD_MESSAGES")) {
                    return PAGE_UNREAD_MESSAGES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 50:
                if (str.equalsIgnoreCase("ABOUT")) {
                    return ABOUT;
                }
                if (str.equalsIgnoreCase("LONG_DESC")) {
                    return LONG_DESC;
                }
                if (str.equalsIgnoreCase("RATINGS_AND_REVIEWS")) {
                    return RATINGS_AND_REVIEWS;
                }
                if (str.equalsIgnoreCase("ADMIN_TIP_PUBLISH_PAGE")) {
                    return ADMIN_TIP_PUBLISH_PAGE;
                }
                if (str.equalsIgnoreCase("ADMIN_TIP_PROMOTE_PAGE")) {
                    return ADMIN_TIP_PROMOTE_PAGE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 51:
                if (str.equalsIgnoreCase("PAGE_WEEKLY_NEW_SHARES")) {
                    return PAGE_WEEKLY_NEW_SHARES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 52:
                if (str.equalsIgnoreCase("EVENT_GLOBAL_ATTENDING")) {
                    return EVENT_GLOBAL_ATTENDING;
                }
                if (str.equalsIgnoreCase("PAGE_WEEKLY_NEW_REVIEWS")) {
                    return PAGE_WEEKLY_NEW_REVIEWS;
                }
                if (str.equalsIgnoreCase("MESSAGE_PAGE")) {
                    return MESSAGE_PAGE;
                }
                if (str.equalsIgnoreCase("PROMOTE_LOCAL_AWARENESS")) {
                    return PROMOTE_LOCAL_AWARENESS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 53:
                if (str.equalsIgnoreCase("EVENT_FRIENDS_ATTENDING")) {
                    return EVENT_FRIENDS_ATTENDING;
                }
                if (str.equalsIgnoreCase("ADMIN_TIP_PROMOTE_WEBSITE")) {
                    return ADMIN_TIP_PROMOTE_WEBSITE;
                }
                if (str.equalsIgnoreCase("PAGE_WEEKLY_NEW_CHECKINS")) {
                    return PAGE_WEEKLY_NEW_CHECKINS;
                }
                if (str.equalsIgnoreCase("PAGE_WEEKLY_NEW_MENTIONS")) {
                    return PAGE_WEEKLY_NEW_MENTIONS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 55:
                if (str.equalsIgnoreCase("ADMIN_TIP_ADD_PROFILE_PIC")) {
                    return ADMIN_TIP_ADD_PROFILE_PIC;
                }
                if (str.equalsIgnoreCase("PROMOTE_PAGE")) {
                    return PROMOTE_PAGE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 56:
                if (str.equalsIgnoreCase("TEAM_LIKE")) {
                    return TEAM_LIKE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 58:
                if (str.equalsIgnoreCase("RESERVE_TABLE")) {
                    return RESERVE_TABLE;
                }
                if (str.equalsIgnoreCase("PROMOTE_WEBSITE")) {
                    return PROMOTE_WEBSITE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 59:
                if (str.equalsIgnoreCase("CALL")) {
                    return CALL;
                }
                if (str.equalsIgnoreCase("PROMOTE_CCTA")) {
                    return PROMOTE_CCTA;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 60:
                if (str.equalsIgnoreCase("PROMOTE_LOCAL_AWARENESS_RESULTS")) {
                    return PROMOTE_LOCAL_AWARENESS_RESULTS;
                }
                if (str.equalsIgnoreCase("PAGE_REDIRECT_BEST_PAGE_OPTIONS")) {
                    return PAGE_REDIRECT_BEST_PAGE_OPTIONS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 61:
                if (str.equalsIgnoreCase("SPORTS_DATA")) {
                    return SPORTS_DATA;
                }
                if (str.equalsIgnoreCase("VIEW_WEBSITE")) {
                    return VIEW_WEBSITE;
                }
                if (str.equalsIgnoreCase("WATCH_MOVIE")) {
                    return WATCH_MOVIE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            default:
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }
}

package com.facebook.graphql.enums;

import android.support.v7.widget.LinearLayoutCompat;

/* compiled from: location_extra_data */
public enum GraphQLReactionRequestedUnit {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CONTEXT_ROWS_PLACEHOLDER,
    RELATED_PAGES_PLACEHOLDER,
    SERVICES_NUX,
    SERVICES,
    SHOP_NUX,
    PHOTOS_BY_PAGE,
    LOCAL_CONTENT,
    PHOTOS_OF_PAGE,
    PHOTOS_AT_PAGE,
    PAGE_INFO,
    PAGE_INFO_3D_TOUCH,
    COMMERCE,
    COMMERCE_EMPTY_SHOP,
    VIDEOS,
    CHILD_LOCATIONS,
    PINNED_POST,
    UPCOMING_EVENTS,
    FUNDRAISERS,
    POSTS_TO_PAGE,
    REVIEWS,
    WELCOME_HOME,
    GAME_CTA_ACTION_BAR,
    UNOWNED_PAGE_ATTRIBUTION,
    GAME_CHALLENGE,
    GAME_ABOUT,
    MORE_GAMES,
    CRITIC_REVIEWS,
    OFFERS,
    INVITE_FRIENDS_TO_LIKE,
    UNKNOWN_UNIT_TYPE,
    PHOTOS_AND_ALBUMS,
    PAGE_OLD_INFO_CARD_PLACEHOLDER,
    PAGE_APPOINTMENT_STATUS,
    PAGE_PHOTOS_SOCIAL_CONTEXT,
    PAGE_PHOTOS_HSCROLLABLE_ALBUMS,
    GAMETIME_TEAM_PAGE_RECENT_MATCHES,
    PAGE_SERVICES_CARD,
    PAGE_COMPOSER_CARD,
    PAGE_LIKE_INVITE_CARD,
    PAGE_OPTIMISTIC_VIDEO_POSTS_CARD,
    PAGE_UNPUBLISHED_POSTS_CARD,
    PAGE_JUST_PUBLISHED_POSTS_CARD,
    PAGE_ADMIN_SUMMARY,
    PAGE_ADMIN_OVERVIEW_COMMENTS_CARD,
    PAGE_ADMIN_OVERVIEW_ENGAGEMENT_CARD,
    PAGE_ADMIN_OVERVIEW_IDENTITY_CARD,
    PAGE_ADMIN_OVERVIEW_INSIGHTS_CARD,
    PAGE_ADMIN_OVERVIEW_MARKETWATCH_CARD,
    PAGE_ADMIN_OVERVIEW_MESSAGES_CARD,
    PAGE_ADMIN_OVERVIEW_POSTS_CARD,
    PAGE_ADMIN_OVERVIEW_PROMOTIONS_CARD,
    FUNDRAISERS_NATIVE,
    PAGE_ADMIN_TIPS,
    PUBLIC_GROUPS,
    PRIVATE_GROUPS,
    PAGE_PHOTOS_OF_FRIENDS_AT_PLACE_PAGE_SURFACE,
    PAGE_PHOTOS_BY_FRIENDS_AT_PLACE_PAGE_SURFACE,
    PAGE_FRIENDS_POSTS_AT_PLACE_PAGE_SURFACE,
    PAGE_AFTER_PARTY_CARD;

    public static GraphQLReactionRequestedUnit fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        switch ((((Character.toUpperCase(str.charAt(0)) * 961) + (Character.toUpperCase(str.charAt(str.length() - 1)) * 31)) + str.length()) & 31) {
            case 1:
                if (str.equalsIgnoreCase("UNKNOWN_UNIT_TYPE")) {
                    return UNKNOWN_UNIT_TYPE;
                }
                if (str.equalsIgnoreCase("PAGE_LIKE_INVITE_CARD")) {
                    return PAGE_LIKE_INVITE_CARD;
                }
                if (str.equalsIgnoreCase("PAGE_AFTER_PARTY_CARD")) {
                    return PAGE_AFTER_PARTY_CARD;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (str.equalsIgnoreCase("OFFERS")) {
                    return OFFERS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 3:
                if (str.equalsIgnoreCase("SHOP_NUX")) {
                    return SHOP_NUX;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                if (str.equalsIgnoreCase("MORE_GAMES")) {
                    return MORE_GAMES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 5:
                if (str.equalsIgnoreCase("LOCAL_CONTENT")) {
                    return LOCAL_CONTENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 6:
                if (str.equalsIgnoreCase("COMMERCE")) {
                    return COMMERCE;
                }
                if (str.equalsIgnoreCase("COMMERCE_EMPTY_SHOP")) {
                    return COMMERCE_EMPTY_SHOP;
                }
                if (str.equalsIgnoreCase("REVIEWS")) {
                    return REVIEWS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 7:
                if (str.equalsIgnoreCase("SERVICES_NUX")) {
                    return SERVICES_NUX;
                }
                if (str.equalsIgnoreCase("PINNED_POST")) {
                    return PINNED_POST;
                }
                if (str.equalsIgnoreCase("PAGE_UNPUBLISHED_POSTS_CARD")) {
                    return PAGE_UNPUBLISHED_POSTS_CARD;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 8:
                if (str.equalsIgnoreCase("SERVICES")) {
                    return SERVICES;
                }
                if (str.equalsIgnoreCase("GAME_CTA_ACTION_BAR")) {
                    return GAME_CTA_ACTION_BAR;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 9:
                if (str.equalsIgnoreCase("CONTEXT_ROWS_PLACEHOLDER")) {
                    return CONTEXT_ROWS_PLACEHOLDER;
                }
                if (str.equalsIgnoreCase("VIDEOS")) {
                    return VIDEOS;
                }
                if (str.equalsIgnoreCase("PAGE_ADMIN_SUMMARY")) {
                    return PAGE_ADMIN_SUMMARY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 10:
                if (str.equalsIgnoreCase("PAGE_INFO")) {
                    return PAGE_INFO;
                }
                if (str.equalsIgnoreCase("PUBLIC_GROUPS")) {
                    return PUBLIC_GROUPS;
                }
                if (str.equalsIgnoreCase("PAGE_JUST_PUBLISHED_POSTS_CARD")) {
                    return PAGE_JUST_PUBLISHED_POSTS_CARD;
                }
                if (str.equalsIgnoreCase("PAGE_ADMIN_OVERVIEW_POSTS_CARD")) {
                    return PAGE_ADMIN_OVERVIEW_POSTS_CARD;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 11:
                if (str.equalsIgnoreCase("PRIVATE_GROUPS")) {
                    return PRIVATE_GROUPS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 12:
                if (str.equalsIgnoreCase("PAGE_OPTIMISTIC_VIDEO_POSTS_CARD")) {
                    return PAGE_OPTIMISTIC_VIDEO_POSTS_CARD;
                }
                if (str.equalsIgnoreCase("PAGE_ADMIN_TIPS")) {
                    return PAGE_ADMIN_TIPS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 13:
                if (str.equalsIgnoreCase("PAGE_ADMIN_OVERVIEW_COMMENTS_CARD")) {
                    return PAGE_ADMIN_OVERVIEW_COMMENTS_CARD;
                }
                if (str.equalsIgnoreCase("PAGE_ADMIN_OVERVIEW_IDENTITY_CARD")) {
                    return PAGE_ADMIN_OVERVIEW_IDENTITY_CARD;
                }
                if (str.equalsIgnoreCase("PAGE_ADMIN_OVERVIEW_INSIGHTS_CARD")) {
                    return PAGE_ADMIN_OVERVIEW_INSIGHTS_CARD;
                }
                if (str.equalsIgnoreCase("PAGE_ADMIN_OVERVIEW_MESSAGES_CARD")) {
                    return PAGE_ADMIN_OVERVIEW_MESSAGES_CARD;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 14:
                if (str.equalsIgnoreCase("PHOTOS_AND_ALBUMS")) {
                    return PHOTOS_AND_ALBUMS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 15:
                if (str.equalsIgnoreCase("PAGE_ADMIN_OVERVIEW_ENGAGEMENT_CARD")) {
                    return PAGE_ADMIN_OVERVIEW_ENGAGEMENT_CARD;
                }
                if (str.equalsIgnoreCase("PAGE_ADMIN_OVERVIEW_PROMOTIONS_CARD")) {
                    return PAGE_ADMIN_OVERVIEW_PROMOTIONS_CARD;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 16:
                if (str.equalsIgnoreCase("GAME_CHALLENGE")) {
                    return GAME_CHALLENGE;
                }
                if (str.equalsIgnoreCase("PAGE_ADMIN_OVERVIEW_MARKETWATCH_CARD")) {
                    return PAGE_ADMIN_OVERVIEW_MARKETWATCH_CARD;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 17:
                if (str.equalsIgnoreCase("UPCOMING_EVENTS")) {
                    return UPCOMING_EVENTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 19:
                if (str.equalsIgnoreCase("FUNDRAISERS_NATIVE")) {
                    return FUNDRAISERS_NATIVE;
                }
                if (str.equalsIgnoreCase("PAGE_FRIENDS_POSTS_AT_PLACE_PAGE_SURFACE")) {
                    return PAGE_FRIENDS_POSTS_AT_PLACE_PAGE_SURFACE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 20:
                if (str.equalsIgnoreCase("PAGE_APPOINTMENT_STATUS")) {
                    return PAGE_APPOINTMENT_STATUS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 21:
                if (str.equalsIgnoreCase("GAMETIME_TEAM_PAGE_RECENT_MATCHES")) {
                    return GAMETIME_TEAM_PAGE_RECENT_MATCHES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 22:
                if (str.equalsIgnoreCase("PAGE_PHOTOS_SOCIAL_CONTEXT")) {
                    return PAGE_PHOTOS_SOCIAL_CONTEXT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 23:
                if (str.equalsIgnoreCase("PAGE_PHOTOS_OF_FRIENDS_AT_PLACE_PAGE_SURFACE")) {
                    return PAGE_PHOTOS_OF_FRIENDS_AT_PLACE_PAGE_SURFACE;
                }
                if (str.equalsIgnoreCase("PAGE_PHOTOS_BY_FRIENDS_AT_PLACE_PAGE_SURFACE")) {
                    return PAGE_PHOTOS_BY_FRIENDS_AT_PLACE_PAGE_SURFACE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 24:
                if (str.equalsIgnoreCase("POSTS_TO_PAGE")) {
                    return POSTS_TO_PAGE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 25:
                if (str.equalsIgnoreCase("RELATED_PAGES_PLACEHOLDER")) {
                    return RELATED_PAGES_PLACEHOLDER;
                }
                if (str.equalsIgnoreCase("PHOTOS_BY_PAGE")) {
                    return PHOTOS_BY_PAGE;
                }
                if (str.equalsIgnoreCase("PHOTOS_OF_PAGE")) {
                    return PHOTOS_OF_PAGE;
                }
                if (str.equalsIgnoreCase("PHOTOS_AT_PAGE")) {
                    return PHOTOS_AT_PAGE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 26:
                if (str.equalsIgnoreCase("PAGE_INFO_3D_TOUCH")) {
                    return PAGE_INFO_3D_TOUCH;
                }
                if (str.equalsIgnoreCase("INVITE_FRIENDS_TO_LIKE")) {
                    return INVITE_FRIENDS_TO_LIKE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 27:
                if (str.equalsIgnoreCase("PAGE_PHOTOS_HSCROLLABLE_ALBUMS")) {
                    return PAGE_PHOTOS_HSCROLLABLE_ALBUMS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 28:
                if (str.equalsIgnoreCase("PAGE_OLD_INFO_CARD_PLACEHOLDER")) {
                    return PAGE_OLD_INFO_CARD_PLACEHOLDER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 29:
                if (str.equalsIgnoreCase("GAME_ABOUT")) {
                    return GAME_ABOUT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 30:
                if (str.equalsIgnoreCase("PAGE_SERVICES_CARD")) {
                    return PAGE_SERVICES_CARD;
                }
                if (str.equalsIgnoreCase("FUNDRAISERS")) {
                    return FUNDRAISERS;
                }
                if (str.equalsIgnoreCase("WELCOME_HOME")) {
                    return WELCOME_HOME;
                }
                if (str.equalsIgnoreCase("CRITIC_REVIEWS")) {
                    return CRITIC_REVIEWS;
                }
                if (str.equalsIgnoreCase("PAGE_COMPOSER_CARD")) {
                    return PAGE_COMPOSER_CARD;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 31:
                if (str.equalsIgnoreCase("CHILD_LOCATIONS")) {
                    return CHILD_LOCATIONS;
                }
                if (str.equalsIgnoreCase("UNOWNED_PAGE_ATTRIBUTION")) {
                    return UNOWNED_PAGE_ATTRIBUTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            default:
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }
}

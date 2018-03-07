package com.facebook.graphql.enums;

import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: ja_JP */
public enum GraphQLGraphSearchResultsDisplayStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    USERS,
    PAGES,
    BOOKS,
    MOVIES,
    MUSIC,
    GROUPS,
    STORIES,
    AGGREGATED_STORIES,
    PHOTOS,
    VIDEOS,
    VIDEO_PERMALINK,
    VIDEO_SHARE_PERMALINK,
    VIDEO_STATE,
    APPS,
    GAMES,
    PLACES,
    EVENTS,
    WIKIPEDIA,
    BLENDED,
    QUERY,
    BLENDED_ENTITIES,
    EMPTY_RESULTS,
    WEB,
    ENTITY_FULLWIDTH_FADEIN_EXPANDABLE,
    ENTITY_FULLWIDTH_FADEIN_NONEXPANDABLE,
    ENTITY_LARGE_SNIPPET,
    ENTITY_COMPACT,
    ENTITY_LARGER_HEADER,
    ENTITY_LARGER_FOOTER,
    ENTITY_HSCROLL,
    CARD_NO_FADE_EXPANDABLE,
    CARD_FADE_IN_EXPANDABLE,
    PUBLIC_POST_LIMITED_SOCIAL,
    PUBLIC_POST_UNLIMITED_SOCIAL,
    CELEBRITY_TOP_MEDIA,
    SALE_POST,
    LATEST,
    VIDEOS_LIVE,
    VIDEO_PUBLISHERS,
    FINITE_MODULE,
    BLENDED_VIDEOS,
    TRENDING_FINITE_SERP_SEE_MORE,
    VIDEOS_WEB,
    MARKETPLACE,
    COMPACT_POST_SETS_MODULE;

    public static GraphQLGraphSearchResultsDisplayStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        switch ((((Character.toUpperCase(str.charAt(0)) * 961) + (Character.toUpperCase(str.charAt(str.length() - 1)) * 31)) + str.length()) & 31) {
            case 0:
                if (str.equalsIgnoreCase("MOVIES")) {
                    return MOVIES;
                }
                if (str.equalsIgnoreCase("AGGREGATED_STORIES")) {
                    return AGGREGATED_STORIES;
                }
                if (str.equalsIgnoreCase("VIDEO_SHARE_PERMALINK")) {
                    return VIDEO_SHARE_PERMALINK;
                }
                if (str.equalsIgnoreCase("PUBLIC_POST_UNLIMITED_SOCIAL")) {
                    return PUBLIC_POST_UNLIMITED_SOCIAL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (str.equalsIgnoreCase("PAGES")) {
                    return PAGES;
                }
                if (str.equalsIgnoreCase("ENTITY_FULLWIDTH_FADEIN_EXPANDABLE")) {
                    return ENTITY_FULLWIDTH_FADEIN_EXPANDABLE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 3:
                if (str.equalsIgnoreCase("PHOTOS")) {
                    return PHOTOS;
                }
                if (str.equalsIgnoreCase("PLACES")) {
                    return PLACES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 5:
                if (str.equalsIgnoreCase("BLENDED")) {
                    return BLENDED;
                }
                if (str.equalsIgnoreCase("ENTITY_FULLWIDTH_FADEIN_NONEXPANDABLE")) {
                    return ENTITY_FULLWIDTH_FADEIN_NONEXPANDABLE;
                }
                if (str.equalsIgnoreCase("ENTITY_LARGE_SNIPPET")) {
                    return ENTITY_LARGE_SNIPPET;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 7:
                if (str.equalsIgnoreCase("USERS")) {
                    return USERS;
                }
                if (str.equalsIgnoreCase("STORIES")) {
                    return STORIES;
                }
                if (str.equalsIgnoreCase("ENTITY_LARGER_HEADER")) {
                    return ENTITY_LARGER_HEADER;
                }
                if (str.equalsIgnoreCase("ENTITY_LARGER_FOOTER")) {
                    return ENTITY_LARGER_FOOTER;
                }
                if (str.equalsIgnoreCase("ENTITY_HSCROLL")) {
                    return ENTITY_HSCROLL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                if (str.equalsIgnoreCase("SALE_POST")) {
                    return SALE_POST;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 9:
                if (str.equalsIgnoreCase("VIDEOS")) {
                    return VIDEOS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 12:
                if (str.equalsIgnoreCase("TRENDING_FINITE_SERP_SEE_MORE")) {
                    return TRENDING_FINITE_SERP_SEE_MORE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 14:
                if (str.equalsIgnoreCase("FINITE_MODULE")) {
                    return FINITE_MODULE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 15:
                if (str.equalsIgnoreCase("MUSIC")) {
                    return MUSIC;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 18:
                if (str.equalsIgnoreCase("APPS")) {
                    return APPS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 19:
                if (str.equalsIgnoreCase("VIDEO_PUBLISHERS")) {
                    return VIDEO_PUBLISHERS;
                }
                if (str.equalsIgnoreCase("MARKETPLACE")) {
                    return MARKETPLACE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 20:
                if (str.equalsIgnoreCase("BOOKS")) {
                    return BOOKS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 21:
                if (str.equalsIgnoreCase("CARD_NO_FADE_EXPANDABLE")) {
                    return CARD_NO_FADE_EXPANDABLE;
                }
                if (str.equalsIgnoreCase("CARD_FADE_IN_EXPANDABLE")) {
                    return CARD_FADE_IN_EXPANDABLE;
                }
                if (str.equalsIgnoreCase("CELEBRITY_TOP_MEDIA")) {
                    return CELEBRITY_TOP_MEDIA;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 22:
                if (str.equalsIgnoreCase("COMPACT_POST_SETS_MODULE")) {
                    return COMPACT_POST_SETS_MODULE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 24:
                if (str.equalsIgnoreCase("EVENTS")) {
                    return EVENTS;
                }
                if (str.equalsIgnoreCase("WEB")) {
                    return WEB;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 25:
                if (str.equalsIgnoreCase("GAMES")) {
                    return GAMES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 26:
                if (str.equalsIgnoreCase("GROUPS")) {
                    return GROUPS;
                }
                if (str.equalsIgnoreCase("VIDEO_PERMALINK")) {
                    return VIDEO_PERMALINK;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 28:
                if (str.equalsIgnoreCase("VIDEOS_LIVE")) {
                    return VIDEOS_LIVE;
                }
                if (str.equalsIgnoreCase("VIDEO_STATE")) {
                    return VIDEO_STATE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 29:
                if (str.equalsIgnoreCase("QUERY")) {
                    return QUERY;
                }
                if (str.equalsIgnoreCase("BLENDED_VIDEOS")) {
                    return BLENDED_VIDEOS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 30:
                if (str.equalsIgnoreCase("VIDEOS_WEB")) {
                    return VIDEOS_WEB;
                }
                if (str.equalsIgnoreCase("PUBLIC_POST_LIMITED_SOCIAL")) {
                    return PUBLIC_POST_LIMITED_SOCIAL;
                }
                if (str.equalsIgnoreCase("LATEST")) {
                    return LATEST;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 31:
                if (str.equalsIgnoreCase("WIKIPEDIA")) {
                    return WIKIPEDIA;
                }
                if (str.equalsIgnoreCase("BLENDED_ENTITIES")) {
                    return BLENDED_ENTITIES;
                }
                if (str.equalsIgnoreCase("EMPTY_RESULTS")) {
                    return EMPTY_RESULTS;
                }
                if (str.equalsIgnoreCase("ENTITY_COMPACT")) {
                    return ENTITY_COMPACT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            default:
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }
}

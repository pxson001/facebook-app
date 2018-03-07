package com.facebook.graphql.enums;

import android.support.v7.widget.LinearLayoutCompat;

/* compiled from: m_normalized_requests */
public enum GraphQLGraphSearchResultRole {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CENTRAL,
    NONE,
    WIKIPEDIA_CARD,
    RELATED_ENTITIES,
    LIVE_CONVERSATION_MODULE,
    SEARCH_SUGGESTIONS_MODULE,
    TRENDING_TOPIC_MODULE,
    RELATED_TOPICS,
    NEWS_KEY_VOICES,
    NEWS_SOCIAL,
    NEWS_EYEWITNESSES,
    NEWS_PUBLISHERS,
    NEWS_HEADLINE,
    NEWS_CONTEXT,
    PROGRAMMATIC_NEWS_CONTEXT,
    TOPIC_MEDIA,
    TOPIC_METADATA,
    SPORT_MODULE,
    SPORT_ENTRY,
    GAMETIME_FAN_FAVORITE,
    OPTIONAL,
    TOP_MAIN_MODULE,
    MAIN_MODULE,
    GRAMMAR,
    PREFILLED_COMPOSER,
    NEWS_TOP_VIDEO,
    SPORTS_DATA_PHOTO,
    GLOBAL_SHARE_METADATA,
    GLOBAL_SHARE_POSTS,
    NEWS_MODULE,
    PUBLIC_POSTS,
    FEED_POSTS,
    PUBLIC_MEDIA,
    FEED_MEDIA,
    COVER_MEDIA,
    NEWS_PIVOT,
    RELATED_SHARES,
    EMOTIONAL_ANALYSIS,
    COMMON_PHRASES,
    COMMON_QUOTES,
    TEST_SPLITTABLE,
    TEST_NON_SPLITTABLE,
    PROMOTED_ENTITY_MEDIA,
    PROMOTED_ENTITY_RELATED_SEARCHES,
    PXS_PIVOTS,
    SEE_MORE_PIVOT,
    SECTION_HEADER,
    FEATURED_POST,
    RELATED_SHARES_WITH_POSTS,
    EMPTY_CARD,
    POST_SEARCH_SECTION_HEADER,
    SPORT_VIDEO,
    SPORT_LINKS,
    REACTION_UNIT,
    VIDEOS,
    VIDEOS_WEB,
    VIDEOS_LIVE,
    VIDEO_PUBLISHERS,
    TOP_VIDEOS,
    FEED_VIDEOS,
    DEBATE_FEELS,
    DEBATE_ISSUES,
    MY_POSTS,
    EMPTY_ENTITY,
    POSTS_ABOUT,
    TOP_POSTS_BY,
    PHOTOS_WITH_MY_FRIENDS,
    MUTUALLY_LIKED_POSTS,
    MUTUALLY_COMMENTED_POSTS,
    MUTUALLY_LIKED_COMMENTED_POSTS,
    SPORT_REDIRECT,
    BIRTHDAY,
    TIME,
    ELECTIONS,
    CURRENCY,
    WEATHER,
    INSTAGRAM_PHOTOS_MODULE,
    LINKEDIN_RESUME,
    DEFINITION,
    SENTIMENT,
    COMMERCE_B2C,
    MUTUALITY_MODULE,
    POST_CONTEXT,
    SAFETY_CHECK,
    FOR_SALE_PRODUCTS,
    EXTERNAL_ACCOUNTS_MODULE,
    POSTS_SET_CELEBRITIES,
    POSTS_SET_RELATED_AUTHORS,
    POSTS_SET_REVIEWS,
    POSTS_SET_EXPERIENTIAL,
    POSTS_SET_HOW_TO,
    POSTS_SET_MINUTIAE,
    POSTS_SET_FEATURED,
    POSTS_SET_GOVERNMENT,
    POSTS_SET_TOPIC_1,
    POSTS_SET_TOPIC_2,
    POSTS_SET_TOPIC_3,
    POSTS_SET_RECENT_TOP,
    POSTS_SET_COMMENTARY,
    POSTS_SET_ENGAGEMENT,
    POSTS_SET_LOCATION,
    COMMERCE_COMBINED,
    SIMILAR_PEOPLE_MODULE,
    ENTITY_USER,
    DEPRECATED_105,
    DEPRECATED_106,
    ENTITY_PAGES,
    ENTITY_EVENTS,
    ENTITY_PLACES,
    ENTITY_GROUPS,
    ENTITY_APPS,
    POSTS,
    MEDIA_WEB,
    NAVIGATIONAL_LINKS,
    PLACES_SET_SEARCH,
    PLACES_IN,
    PLACES_NEARBY,
    POSTS_SET_CELEBRITIES_MENTION,
    POSTS_SET_VITAL_AUTHORS,
    POSTS_SET_REVIEWS_PEOPLE,
    POSTS_SET_RECIPES,
    VIDEO_MODULE,
    COMMERCE_C2C,
    POST_SET,
    TOP_VITAL,
    MEDIA_SOCIAL,
    POSTS_CONTENTS,
    POSTS_SET_CONTENTS,
    GRAMMAR_QUERY_ENTITY_MODULE,
    VOTING_ACTIONS,
    TIMELINE_HEADER,
    TIMELINE_HEADER_CARD,
    SERP_HEADER,
    PUBLIC_POST_SEE_MORE,
    MEDIA_COMBINED,
    ENTITY_PIVOTS,
    VIDEOS_MIXED,
    MUSIC_LINKS,
    POSTS_SET_BEHIND_THE_SCENE;

    public static GraphQLGraphSearchResultRole fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        switch ((((Character.toUpperCase(str.charAt(0)) * 961) + (Character.toUpperCase(str.charAt(str.length() - 1)) * 31)) + str.length()) & 127) {
            case 3:
                if (str.equalsIgnoreCase("SIMILAR_PEOPLE_MODULE")) {
                    return SIMILAR_PEOPLE_MODULE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                if (str.equalsIgnoreCase("NEWS_PIVOT")) {
                    return NEWS_PIVOT;
                }
                if (str.equalsIgnoreCase("POST_SET")) {
                    return POST_SET;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 6:
                if (str.equalsIgnoreCase("NEWS_CONTEXT")) {
                    return NEWS_CONTEXT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 7:
                if (str.equalsIgnoreCase("SEARCH_SUGGESTIONS_MODULE")) {
                    return SEARCH_SUGGESTIONS_MODULE;
                }
                if (str.equalsIgnoreCase("POSTS_ABOUT")) {
                    return POSTS_ABOUT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 8:
                if (str.equalsIgnoreCase("POST_CONTEXT")) {
                    return POST_CONTEXT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 11:
                if (str.equalsIgnoreCase("REACTION_UNIT")) {
                    return REACTION_UNIT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 12:
                if (str.equalsIgnoreCase("SERP_HEADER")) {
                    return SERP_HEADER;
                }
                if (str.equalsIgnoreCase("WEATHER")) {
                    return WEATHER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 13:
                if (str.equalsIgnoreCase("NEWS_SOCIAL")) {
                    return NEWS_SOCIAL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 14:
                if (str.equalsIgnoreCase("POSTS_SET_TOPIC_3")) {
                    return POSTS_SET_TOPIC_3;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 15:
                if (str.equalsIgnoreCase("SECTION_HEADER")) {
                    return SECTION_HEADER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 16:
                if (str.equalsIgnoreCase("POSTS_SET_GOVERNMENT")) {
                    return POSTS_SET_GOVERNMENT;
                }
                if (str.equalsIgnoreCase("POSTS_SET_ENGAGEMENT")) {
                    return POSTS_SET_ENGAGEMENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 17:
                if (str.equalsIgnoreCase("TOP_VITAL")) {
                    return TOP_VITAL;
                }
                if (str.equalsIgnoreCase("BIRTHDAY")) {
                    return BIRTHDAY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 20:
                if (str.equalsIgnoreCase("MEDIA_WEB")) {
                    return MEDIA_WEB;
                }
                if (str.equalsIgnoreCase("POSTS_SET_RECENT_TOP")) {
                    return POSTS_SET_RECENT_TOP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 21:
                if (str.equalsIgnoreCase("PROGRAMMATIC_NEWS_CONTEXT")) {
                    return PROGRAMMATIC_NEWS_CONTEXT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 25:
                if (str.equalsIgnoreCase("PLACES_SET_SEARCH")) {
                    return PLACES_SET_SEARCH;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 26:
                if (str.equalsIgnoreCase("POSTS_SET_EXPERIENTIAL")) {
                    return POSTS_SET_EXPERIENTIAL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 27:
                if (str.equalsIgnoreCase("ELECTIONS")) {
                    return ELECTIONS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 29:
                if (str.equalsIgnoreCase("COMMON_QUOTES")) {
                    return COMMON_QUOTES;
                }
                if (str.equalsIgnoreCase("ENTITY_APPS")) {
                    return ENTITY_APPS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 30:
                if (str.equalsIgnoreCase("COMMON_PHRASES")) {
                    return COMMON_PHRASES;
                }
                if (str.equalsIgnoreCase("VIDEOS_MIXED")) {
                    return VIDEOS_MIXED;
                }
                if (str.equalsIgnoreCase("POSTS_SET_FEATURED")) {
                    return POSTS_SET_FEATURED;
                }
                if (str.equalsIgnoreCase("ENTITY_PAGES")) {
                    return ENTITY_PAGES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 31:
                if (str.equalsIgnoreCase("ENTITY_PIVOTS")) {
                    return ENTITY_PIVOTS;
                }
                if (str.equalsIgnoreCase("ENTITY_EVENTS")) {
                    return ENTITY_EVENTS;
                }
                if (str.equalsIgnoreCase("ENTITY_PLACES")) {
                    return ENTITY_PLACES;
                }
                if (str.equalsIgnoreCase("ENTITY_GROUPS")) {
                    return ENTITY_GROUPS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 34:
                if (str.equalsIgnoreCase("MY_POSTS")) {
                    return MY_POSTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 36:
                if (str.equalsIgnoreCase("EMOTIONAL_ANALYSIS")) {
                    return EMOTIONAL_ANALYSIS;
                }
                if (str.equalsIgnoreCase("PLACES_NEARBY")) {
                    return PLACES_NEARBY;
                }
                if (str.equalsIgnoreCase("TIMELINE_HEADER_CARD")) {
                    return TIMELINE_HEADER_CARD;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 37:
                if (str.equalsIgnoreCase("MUSIC_LINKS")) {
                    return MUSIC_LINKS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 38:
                if (str.equalsIgnoreCase("GLOBAL_SHARE_POSTS")) {
                    return GLOBAL_SHARE_POSTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 39:
                if (str.equalsIgnoreCase("TOP_POSTS_BY")) {
                    return TOP_POSTS_BY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 43:
                if (str.equalsIgnoreCase("SPORT_LINKS")) {
                    return SPORT_LINKS;
                }
                if (str.equalsIgnoreCase("POSTS_SET_COMMENTARY")) {
                    return POSTS_SET_COMMENTARY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 44:
                if (str.equalsIgnoreCase("COMMERCE_B2C")) {
                    return COMMERCE_B2C;
                }
                if (str.equalsIgnoreCase("COMMERCE_C2C")) {
                    return COMMERCE_C2C;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 45:
                if (str.equalsIgnoreCase("NONE")) {
                    return NONE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 46:
                if (str.equalsIgnoreCase("MUTUALLY_LIKED_POSTS")) {
                    return MUTUALLY_LIKED_POSTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 47:
                if (str.equalsIgnoreCase("FEED_MEDIA")) {
                    return FEED_MEDIA;
                }
                if (str.equalsIgnoreCase("SPORT_VIDEO")) {
                    return SPORT_VIDEO;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 50:
                if (str.equalsIgnoreCase("MUTUALLY_COMMENTED_POSTS")) {
                    return MUTUALLY_COMMENTED_POSTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 51:
                if (str.equalsIgnoreCase("TIME")) {
                    return TIME;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 52:
                if (str.equalsIgnoreCase("NEWS_MODULE")) {
                    return NEWS_MODULE;
                }
                if (str.equalsIgnoreCase("SAFETY_CHECK")) {
                    return SAFETY_CHECK;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 53:
                if (str.equalsIgnoreCase("SPORTS_DATA_PHOTO")) {
                    return SPORTS_DATA_PHOTO;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 54:
                if (str.equalsIgnoreCase("NEWS_HEADLINE")) {
                    return NEWS_HEADLINE;
                }
                if (str.equalsIgnoreCase("LINKEDIN_RESUME")) {
                    return LINKEDIN_RESUME;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 56:
                if (str.equalsIgnoreCase("MUTUALLY_LIKED_COMMENTED_POSTS")) {
                    return MUTUALLY_LIKED_COMMENTED_POSTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 59:
                if (str.equalsIgnoreCase("PUBLIC_MEDIA")) {
                    return PUBLIC_MEDIA;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 60:
                if (str.equalsIgnoreCase("VIDEOS_LIVE")) {
                    return VIDEOS_LIVE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 61:
                if (str.equalsIgnoreCase("POSTS_SET_MINUTIAE")) {
                    return POSTS_SET_MINUTIAE;
                }
                if (str.equalsIgnoreCase("VIDEO_MODULE")) {
                    return VIDEO_MODULE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 62:
                if (str.equalsIgnoreCase("CENTRAL")) {
                    return CENTRAL;
                }
                if (str.equalsIgnoreCase("TOPIC_MEDIA")) {
                    return TOPIC_MEDIA;
                }
                if (str.equalsIgnoreCase("TOP_MAIN_MODULE")) {
                    return TOP_MAIN_MODULE;
                }
                if (str.equalsIgnoreCase("TEST_SPLITTABLE")) {
                    return TEST_SPLITTABLE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 63:
                if (str.equalsIgnoreCase("LIVE_CONVERSATION_MODULE")) {
                    return LIVE_CONVERSATION_MODULE;
                }
                if (str.equalsIgnoreCase("PUBLIC_POST_SEE_MORE")) {
                    return PUBLIC_POST_SEE_MORE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 64:
                if (str.equalsIgnoreCase("DEFINITION")) {
                    return DEFINITION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 65:
                if (str.equalsIgnoreCase("TOPIC_METADATA")) {
                    return TOPIC_METADATA;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 66:
                if (str.equalsIgnoreCase("TEST_NON_SPLITTABLE")) {
                    return TEST_NON_SPLITTABLE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 67:
                if (str.equalsIgnoreCase("POSTS_SET_REVIEWS_PEOPLE")) {
                    return POSTS_SET_REVIEWS_PEOPLE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 68:
                if (str.equalsIgnoreCase("TRENDING_TOPIC_MODULE")) {
                    return TRENDING_TOPIC_MODULE;
                }
                if (str.equalsIgnoreCase("PROMOTED_ENTITY_MEDIA")) {
                    return PROMOTED_ENTITY_MEDIA;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 69:
                if (str.equalsIgnoreCase("POSTS_SET_BEHIND_THE_SCENE")) {
                    return POSTS_SET_BEHIND_THE_SCENE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 72:
                if (str.equalsIgnoreCase("SENTIMENT")) {
                    return SENTIMENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 75:
                if (str.equalsIgnoreCase("OPTIONAL")) {
                    return OPTIONAL;
                }
                if (str.equalsIgnoreCase("EMPTY_CARD")) {
                    return EMPTY_CARD;
                }
                if (str.equalsIgnoreCase("PLACES_IN")) {
                    return PLACES_IN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 77:
                if (str.equalsIgnoreCase("MEDIA_SOCIAL")) {
                    return MEDIA_SOCIAL;
                }
                if (str.equalsIgnoreCase("SEE_MORE_PIVOT")) {
                    return SEE_MORE_PIVOT;
                }
                if (str.equalsIgnoreCase("SPORT_REDIRECT")) {
                    return SPORT_REDIRECT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 80:
                if (str.equalsIgnoreCase("PREFILLED_COMPOSER")) {
                    return PREFILLED_COMPOSER;
                }
                if (str.equalsIgnoreCase("POSTS_SET_TOPIC_1")) {
                    return POSTS_SET_TOPIC_1;
                }
                if (str.equalsIgnoreCase("COMMERCE_COMBINED")) {
                    return COMMERCE_COMBINED;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 81:
                if (str.equalsIgnoreCase("TIMELINE_HEADER")) {
                    return TIMELINE_HEADER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 82:
                if (str.equalsIgnoreCase("CURRENCY")) {
                    return CURRENCY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 84:
                if (str.equalsIgnoreCase("POSTS_SET_LOCATION")) {
                    return POSTS_SET_LOCATION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 87:
                if (str.equalsIgnoreCase("MEDIA_COMBINED")) {
                    return MEDIA_COMBINED;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 88:
                if (str.equalsIgnoreCase("POST_SEARCH_SECTION_HEADER")) {
                    return POST_SEARCH_SECTION_HEADER;
                }
                if (str.equalsIgnoreCase("EMPTY_ENTITY")) {
                    return EMPTY_ENTITY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 93:
                if (str.equalsIgnoreCase("FEED_POSTS")) {
                    return FEED_POSTS;
                }
                if (str.equalsIgnoreCase("DEBATE_FEELS")) {
                    return DEBATE_FEELS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 94:
                if (str.equalsIgnoreCase("VIDEOS_WEB")) {
                    return VIDEOS_WEB;
                }
                if (str.equalsIgnoreCase("FEED_VIDEOS")) {
                    return FEED_VIDEOS;
                }
                if (str.equalsIgnoreCase("DEBATE_ISSUES")) {
                    return DEBATE_ISSUES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 95:
                if (str.equalsIgnoreCase("POSTS_SET_CELEBRITIES_MENTION")) {
                    return POSTS_SET_CELEBRITIES_MENTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 97:
                if (str.equalsIgnoreCase("WIKIPEDIA_CARD")) {
                    return WIKIPEDIA_CARD;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 98:
                if (str.equalsIgnoreCase("POSTS")) {
                    return POSTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 100:
                if (str.equalsIgnoreCase("FOR_SALE_PRODUCTS")) {
                    return FOR_SALE_PRODUCTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 101:
                if (str.equalsIgnoreCase("SPORT_ENTRY")) {
                    return SPORT_ENTRY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 103:
                if (str.equalsIgnoreCase("PXS_PIVOTS")) {
                    return PXS_PIVOTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 105:
                if (str.equalsIgnoreCase("PUBLIC_POSTS")) {
                    return PUBLIC_POSTS;
                }
                if (str.equalsIgnoreCase("VIDEOS")) {
                    return VIDEOS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 106:
                if (str.equalsIgnoreCase("NEWS_KEY_VOICES")) {
                    return NEWS_KEY_VOICES;
                }
                if (str.equalsIgnoreCase("NEWS_PUBLISHERS")) {
                    return NEWS_PUBLISHERS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 107:
                if (str.equalsIgnoreCase("TOP_VIDEOS")) {
                    return TOP_VIDEOS;
                }
                if (str.equalsIgnoreCase("POSTS_CONTENTS")) {
                    return POSTS_CONTENTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 108:
                if (str.equalsIgnoreCase("NEWS_EYEWITNESSES")) {
                    return NEWS_EYEWITNESSES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 109:
                if (str.equalsIgnoreCase("RELATED_TOPICS")) {
                    return RELATED_TOPICS;
                }
                if (str.equalsIgnoreCase("NEWS_TOP_VIDEO")) {
                    return NEWS_TOP_VIDEO;
                }
                if (str.equalsIgnoreCase("COVER_MEDIA")) {
                    return COVER_MEDIA;
                }
                if (str.equalsIgnoreCase("RELATED_SHARES")) {
                    return RELATED_SHARES;
                }
                if (str.equalsIgnoreCase("NAVIGATIONAL_LINKS")) {
                    return NAVIGATIONAL_LINKS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 110:
                if (str.equalsIgnoreCase("POSTS_SET_REVIEWS")) {
                    return POSTS_SET_REVIEWS;
                }
                if (str.equalsIgnoreCase("POSTS_SET_RECIPES")) {
                    return POSTS_SET_RECIPES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 111:
                if (str.equalsIgnoreCase("RELATED_ENTITIES")) {
                    return RELATED_ENTITIES;
                }
                if (str.equalsIgnoreCase("POSTS_SET_TOPIC_2")) {
                    return POSTS_SET_TOPIC_2;
                }
                if (str.equalsIgnoreCase("POSTS_SET_CONTENTS")) {
                    return POSTS_SET_CONTENTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 113:
                if (str.equalsIgnoreCase("VOTING_ACTIONS")) {
                    return VOTING_ACTIONS;
                }
                if (str.equalsIgnoreCase("POSTS_SET_HOW_TO")) {
                    return POSTS_SET_HOW_TO;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 114:
                if (str.equalsIgnoreCase("POSTS_SET_CELEBRITIES")) {
                    return POSTS_SET_CELEBRITIES;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 115:
                if (str.equalsIgnoreCase("MAIN_MODULE")) {
                    return MAIN_MODULE;
                }
                if (str.equalsIgnoreCase("VIDEO_PUBLISHERS")) {
                    return VIDEO_PUBLISHERS;
                }
                if (str.equalsIgnoreCase("PHOTOS_WITH_MY_FRIENDS")) {
                    return PHOTOS_WITH_MY_FRIENDS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 116:
                if (str.equalsIgnoreCase("POSTS_SET_VITAL_AUTHORS")) {
                    return POSTS_SET_VITAL_AUTHORS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 118:
                if (str.equalsIgnoreCase("POSTS_SET_RELATED_AUTHORS")) {
                    return POSTS_SET_RELATED_AUTHORS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 119:
                if (str.equalsIgnoreCase("GAMETIME_FAN_FAVORITE")) {
                    return GAMETIME_FAN_FAVORITE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 120:
                if (str.equalsIgnoreCase("RELATED_SHARES_WITH_POSTS")) {
                    return RELATED_SHARES_WITH_POSTS;
                }
                if (str.equalsIgnoreCase("MUTUALITY_MODULE")) {
                    return MUTUALITY_MODULE;
                }
                if (str.equalsIgnoreCase("EXTERNAL_ACCOUNTS_MODULE")) {
                    return EXTERNAL_ACCOUNTS_MODULE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 122:
                if (str.equalsIgnoreCase("SPORT_MODULE")) {
                    return SPORT_MODULE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 123:
                if (str.equalsIgnoreCase("GLOBAL_SHARE_METADATA")) {
                    return GLOBAL_SHARE_METADATA;
                }
                if (str.equalsIgnoreCase("INSTAGRAM_PHOTOS_MODULE")) {
                    return INSTAGRAM_PHOTOS_MODULE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 124:
                if (str.equalsIgnoreCase("GRAMMAR")) {
                    return GRAMMAR;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 125:
                if (str.equalsIgnoreCase("PROMOTED_ENTITY_RELATED_SEARCHES")) {
                    return PROMOTED_ENTITY_RELATED_SEARCHES;
                }
                if (str.equalsIgnoreCase("GRAMMAR_QUERY_ENTITY_MODULE")) {
                    return GRAMMAR_QUERY_ENTITY_MODULE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 126:
                if (str.equalsIgnoreCase("ENTITY_USER")) {
                    return ENTITY_USER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 127:
                if (str.equalsIgnoreCase("FEATURED_POST")) {
                    return FEATURED_POST;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            default:
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }
}

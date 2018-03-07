package com.facebook.graphql.enums;

import android.support.v7.widget.LinearLayoutCompat;

/* compiled from: list_feed */
public enum GraphQLTaggableActivitySuggestionMechanism {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    MOVIE_THEATER_CHECKIN,
    MINUTIAE_TO_PLACE_MOVIE_THEATER_CHECKIN,
    MOVIE_THEATER_CHECKIN_SUGGESTIFIER,
    TRAIN_CHECKIN,
    TRAIN_CHECKIN_SUGGESTIFIER,
    AIRPORT_CHECKIN,
    AIRPORT_CHECKIN_SUGGESTIFIER,
    MINUTIAE_TO_PLACE_TRAVELING_CHECKIN,
    CURRENT_SONG,
    RECENT_ACTION,
    AUDIO_FINGERPRINT,
    WHITELISTED_SUGGESTION,
    COOL_PLACE_CHECKIN,
    COOL_PLACE_CHECKIN_SUGGESTIFIER,
    FEED_SPECIFIC_SUGGESTION,
    DETECTED_FROM_TEXT_INPUT,
    EVENT_VENUE_CHECKIN,
    EVENT_VENUE_CHECKIN_SUGGESTIFIER,
    UNIT_TEST,
    SUPPORTING_CLASSIFIER,
    LISTENING_LINK_CLASSIFIER,
    LINK_TO_OG_CLASSIFIER,
    GK_BASED_SUGGESTION_CLASSIFIER,
    EVENT_TO_ATTEND,
    MINUTIAE_TO_PLACE_EVENT_TO_ATTEND,
    EVENT_TO_ATTEND_SUGGESTIFIER,
    GK_BASED_PRODUCTION_PROMPT_CLASSIFIER,
    SPA_CHECKIN,
    SPA_CHECKIN_SUGGESTIFIER,
    MEDICAL_CHECKIN,
    MEDICAL_CHECKIN_SUGGESTIFIER,
    TRANSPORTATION_CHECKIN,
    TRANSPORTATION_CHECKIN_SUGGESTIFIER,
    SWEETS_SHOP_CHECKIN,
    SWEETS_SHOP_CHECKIN_SUGGESTIFIER,
    FAST_FOOD_CHECKIN,
    FAST_FOOD_CHECKIN_SUGGESTIFIER,
    SPECIFIC_CUISINE_CHECKIN,
    SPECIFIC_CUISINE_SUGGESTIFIER,
    TOPIC_BAR_CHECKIN,
    TOPIC_BAR_CHECKIN_SUGGESTIFIER,
    RESTAURANT_CHECKIN,
    RESTAURANT_CHECKIN_SUGGESTIFIER,
    COFFEE_SHOP_CHECKIN,
    COFFEE_SHOP_SUGGESTIFIER,
    MINUTIAE_TO_PLACE_CELEBRATING,
    MINUTIAE_TO_PLACE_FEELING_HUNGRY,
    MINUTIAE_TO_PLACE_GAME_STADIUM_CHECKIN,
    MINUTIAE_TO_PLACE_CONCERT_VENUE_CHECKIN,
    MINUTIAE_TO_PLACE_COOL_PLACE_CHECKIN,
    MINUTIAE_TO_PLACE_FEELING_RELAXED,
    MINUTIAE_TO_PLACE_CELEBRATING_HOLIDAY,
    MINUTIAE_TO_PLACE_FEELING,
    MINUTIAE_TO_PLACE_FEELING_TO_HOTEL_CHECKIN,
    MINUTIAE_TO_PLACE_CELEBRATING_EXPERIMENT;

    public static GraphQLTaggableActivitySuggestionMechanism fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        switch ((((Character.toUpperCase(str.charAt(0)) * 961) + (Character.toUpperCase(str.charAt(str.length() - 1)) * 31)) + str.length()) & 31) {
            case 0:
                if (str.equalsIgnoreCase("TOPIC_BAR_CHECKIN_SUGGESTIFIER")) {
                    return TOPIC_BAR_CHECKIN_SUGGESTIFIER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 1:
                if (str.equalsIgnoreCase("SWEETS_SHOP_CHECKIN_SUGGESTIFIER")) {
                    return SWEETS_SHOP_CHECKIN_SUGGESTIFIER;
                }
                if (str.equalsIgnoreCase("MINUTIAE_TO_PLACE_CELEBRATING_EXPERIMENT")) {
                    return MINUTIAE_TO_PLACE_CELEBRATING_EXPERIMENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (str.equalsIgnoreCase("AIRPORT_CHECKIN")) {
                    return AIRPORT_CHECKIN;
                }
                if (str.equalsIgnoreCase("MINUTIAE_TO_PLACE_TRAVELING_CHECKIN")) {
                    return MINUTIAE_TO_PLACE_TRAVELING_CHECKIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 3:
                if (str.equalsIgnoreCase("MINUTIAE_TO_PLACE_CELEBRATING")) {
                    return MINUTIAE_TO_PLACE_CELEBRATING;
                }
                if (str.equalsIgnoreCase("MINUTIAE_TO_PLACE_COOL_PLACE_CHECKIN")) {
                    return MINUTIAE_TO_PLACE_COOL_PLACE_CHECKIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 5:
                if (str.equalsIgnoreCase("TRANSPORTATION_CHECKIN_SUGGESTIFIER")) {
                    return TRANSPORTATION_CHECKIN_SUGGESTIFIER;
                }
                if (str.equalsIgnoreCase("MINUTIAE_TO_PLACE_GAME_STADIUM_CHECKIN")) {
                    return MINUTIAE_TO_PLACE_GAME_STADIUM_CHECKIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 6:
                if (str.equalsIgnoreCase("MINUTIAE_TO_PLACE_MOVIE_THEATER_CHECKIN")) {
                    return MINUTIAE_TO_PLACE_MOVIE_THEATER_CHECKIN;
                }
                if (str.equalsIgnoreCase("MINUTIAE_TO_PLACE_CONCERT_VENUE_CHECKIN")) {
                    return MINUTIAE_TO_PLACE_CONCERT_VENUE_CHECKIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 7:
                if (str.equalsIgnoreCase("COOL_PLACE_CHECKIN")) {
                    return COOL_PLACE_CHECKIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 8:
                if (str.equalsIgnoreCase("CURRENT_SONG")) {
                    return CURRENT_SONG;
                }
                if (str.equalsIgnoreCase("DETECTED_FROM_TEXT_INPUT")) {
                    return DETECTED_FROM_TEXT_INPUT;
                }
                if (str.equalsIgnoreCase("COFFEE_SHOP_CHECKIN")) {
                    return COFFEE_SHOP_CHECKIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 9:
                if (str.equalsIgnoreCase("FAST_FOOD_CHECKIN")) {
                    return FAST_FOOD_CHECKIN;
                }
                if (str.equalsIgnoreCase("COFFEE_SHOP_SUGGESTIFIER")) {
                    return COFFEE_SHOP_SUGGESTIFIER;
                }
                if (str.equalsIgnoreCase("MINUTIAE_TO_PLACE_FEELING_TO_HOTEL_CHECKIN")) {
                    return MINUTIAE_TO_PLACE_FEELING_TO_HOTEL_CHECKIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 10:
                if (str.equalsIgnoreCase("EVENT_VENUE_CHECKIN")) {
                    return EVENT_VENUE_CHECKIN;
                }
                if (str.equalsIgnoreCase("UNIT_TEST")) {
                    return UNIT_TEST;
                }
                if (str.equalsIgnoreCase("MINUTIAE_TO_PLACE_EVENT_TO_ATTEND")) {
                    return MINUTIAE_TO_PLACE_EVENT_TO_ATTEND;
                }
                if (str.equalsIgnoreCase("MINUTIAE_TO_PLACE_FEELING_RELAXED")) {
                    return MINUTIAE_TO_PLACE_FEELING_RELAXED;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 11:
                if (str.equalsIgnoreCase("AIRPORT_CHECKIN_SUGGESTIFIER")) {
                    return AIRPORT_CHECKIN_SUGGESTIFIER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 14:
                if (str.equalsIgnoreCase("MEDICAL_CHECKIN")) {
                    return MEDICAL_CHECKIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 15:
                if (str.equalsIgnoreCase("LINK_TO_OG_CLASSIFIER")) {
                    return LINK_TO_OG_CLASSIFIER;
                }
                if (str.equalsIgnoreCase("EVENT_TO_ATTEND_SUGGESTIFIER")) {
                    return EVENT_TO_ATTEND_SUGGESTIFIER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 16:
                if (str.equalsIgnoreCase("COOL_PLACE_CHECKIN_SUGGESTIFIER")) {
                    return COOL_PLACE_CHECKIN_SUGGESTIFIER;
                }
                if (str.equalsIgnoreCase("FEED_SPECIFIC_SUGGESTION")) {
                    return FEED_SPECIFIC_SUGGESTION;
                }
                if (str.equalsIgnoreCase("EVENT_TO_ATTEND")) {
                    return EVENT_TO_ATTEND;
                }
                if (str.equalsIgnoreCase("SPA_CHECKIN")) {
                    return SPA_CHECKIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 17:
                if (str.equalsIgnoreCase("RECENT_ACTION")) {
                    return RECENT_ACTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 18:
                if (str.equalsIgnoreCase("FAST_FOOD_CHECKIN_SUGGESTIFIER")) {
                    return FAST_FOOD_CHECKIN_SUGGESTIFIER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 19:
                if (str.equalsIgnoreCase("TRAIN_CHECKIN")) {
                    return TRAIN_CHECKIN;
                }
                if (str.equalsIgnoreCase("EVENT_VENUE_CHECKIN_SUGGESTIFIER")) {
                    return EVENT_VENUE_CHECKIN_SUGGESTIFIER;
                }
                if (str.equalsIgnoreCase("LISTENING_LINK_CLASSIFIER")) {
                    return LISTENING_LINK_CLASSIFIER;
                }
                if (str.equalsIgnoreCase("GK_BASED_SUGGESTION_CLASSIFIER")) {
                    return GK_BASED_SUGGESTION_CLASSIFIER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 20:
                if (str.equalsIgnoreCase("MOVIE_THEATER_CHECKIN")) {
                    return MOVIE_THEATER_CHECKIN;
                }
                if (str.equalsIgnoreCase("MINUTIAE_TO_PLACE_FEELING_HUNGRY")) {
                    return MINUTIAE_TO_PLACE_FEELING_HUNGRY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 22:
                if (str.equalsIgnoreCase("SUPPORTING_CLASSIFIER")) {
                    return SUPPORTING_CLASSIFIER;
                }
                if (str.equalsIgnoreCase("RESTAURANT_CHECKIN")) {
                    return RESTAURANT_CHECKIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 23:
                if (str.equalsIgnoreCase("MEDICAL_CHECKIN_SUGGESTIFIER")) {
                    return MEDICAL_CHECKIN_SUGGESTIFIER;
                }
                if (str.equalsIgnoreCase("TOPIC_BAR_CHECKIN")) {
                    return TOPIC_BAR_CHECKIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 24:
                if (str.equalsIgnoreCase("SWEETS_SHOP_CHECKIN")) {
                    return SWEETS_SHOP_CHECKIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 25:
                if (str.equalsIgnoreCase("SPA_CHECKIN_SUGGESTIFIER")) {
                    return SPA_CHECKIN_SUGGESTIFIER;
                }
                if (str.equalsIgnoreCase("MINUTIAE_TO_PLACE_CELEBRATING_HOLIDAY")) {
                    return MINUTIAE_TO_PLACE_CELEBRATING_HOLIDAY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 26:
                if (str.equalsIgnoreCase("GK_BASED_PRODUCTION_PROMPT_CLASSIFIER")) {
                    return GK_BASED_PRODUCTION_PROMPT_CLASSIFIER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 28:
                if (str.equalsIgnoreCase("TRAIN_CHECKIN_SUGGESTIFIER")) {
                    return TRAIN_CHECKIN_SUGGESTIFIER;
                }
                if (str.equalsIgnoreCase("TRANSPORTATION_CHECKIN")) {
                    return TRANSPORTATION_CHECKIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 29:
                if (str.equalsIgnoreCase("MOVIE_THEATER_CHECKIN_SUGGESTIFIER")) {
                    return MOVIE_THEATER_CHECKIN_SUGGESTIFIER;
                }
                if (str.equalsIgnoreCase("SPECIFIC_CUISINE_CHECKIN")) {
                    return SPECIFIC_CUISINE_CHECKIN;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 30:
                if (str.equalsIgnoreCase("AUDIO_FINGERPRINT")) {
                    return AUDIO_FINGERPRINT;
                }
                if (str.equalsIgnoreCase("SPECIFIC_CUISINE_SUGGESTIFIER")) {
                    return SPECIFIC_CUISINE_SUGGESTIFIER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 31:
                if (str.equalsIgnoreCase("WHITELISTED_SUGGESTION")) {
                    return WHITELISTED_SUGGESTION;
                }
                if (str.equalsIgnoreCase("RESTAURANT_CHECKIN_SUGGESTIFIER")) {
                    return RESTAURANT_CHECKIN_SUGGESTIFIER;
                }
                if (str.equalsIgnoreCase("MINUTIAE_TO_PLACE_FEELING")) {
                    return MINUTIAE_TO_PLACE_FEELING;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            default:
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }
}

package com.facebook.graphql.enums;

/* compiled from: locationPageID */
public enum GraphQLReactionStoryAttachmentsStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PROFILE_BLOCKS,
    PHOTOS,
    FEED_STORY_PROFILE_BLOCKS,
    SINGLE_LARGE_PHOTO,
    PHOTO_COLLAGE,
    FACEPILE,
    TOPIC_LIST,
    RATING,
    PAGE_PRODUCT_LIST,
    EVENT_BLOCKS,
    FEED_STORY_SINGLE,
    PROFILE_TWO_LINE_HORIZONTAL_SCROLL,
    EVENT_HORIZONTAL_SCROLL,
    GROUP_HORIZONTAL_SCROLL,
    DISCOVERY_PLACE_PROFILE,
    VIDEO_HORIZONTAL_SCROLL,
    NEARBY_FRIENDS_FACEPILE,
    PLACE_QUESTION_HORIZONTAL,
    PLACE_QUESTION_VERTICAL,
    FACEPILE_HORIZONTAL_SCROLL,
    PLACE_SURVEY_THANK_YOU,
    TODAY_GENERIC_MLE_IMAGE_BLOCKS,
    RESIDENCE_MIGRATION,
    PAGE_LIKES_AND_VISITS,
    SIMPLE_TEXT,
    SIMPLE_LEFT_RIGHT_TEXT,
    CRITIC_REVIEW_HORIZONTAL_SCROLL,
    EVENT_PROFILE_BLOCKS,
    SIMPLE_TEXT_WITHOUT_LABEL,
    IMAGE_TEXT_BLOCK,
    PAGE_PROMOTION,
    PAGE_SERVICE_LIST,
    EVENT_CARD_LARGE,
    PHOTOS_LARGE,
    REVIEW_NEEDY,
    PROFILE_MULTILINE_SUBTITLE,
    ADMINED_PAGES_LIST,
    EVENT_CARD_LARGE_HORIZONTAL_SCROLL,
    PAGE_ATTRIBUTION_FOOTER,
    PAGE_COMMERCE_UNITS,
    PHOTOS_WITH_ATTRIBUTION,
    PAGE_WELCOME_HOME,
    PAGE_YOU_MAY_LIKE_HORIZONTAL_SCROLL,
    VIDEOS,
    PAGE_POST_STORY,
    RATINGS_INCL_DRAFTS,
    FRIEND_YOU_MAY_INVITE_TO_LIKE_PAGE,
    CREATE_OWNED_PAGE_UPSELL,
    PHOTOS_FULL_WIDTH_COUNTER,
    SPOTLIGHT_STORY_PREVIEW,
    FUNDRAISER_LIST,
    PAGE_INFO_CARD_PLACEHOLDER,
    FEED_STORY_ATTACHMENT_BLOCKS,
    PROFILE_HORIZONTAL_SCROLL,
    APP_AD_BLOCKS,
    NO_ACTOR_FEED_STORY,
    PHOTO_WITH_CAPTION,
    FEELING_ICON_STRIP,
    SPORTS_GAME_SINGLE,
    SPORTS_GAME_LIST,
    APP_AD_SINGLE,
    HEADLINE_STORY,
    NOTIFICATIONS_LIST,
    OG_OBJECT_BLOCKS,
    SONG_PLAYING,
    NEXT_PLACE_HORIZONTAL_SCROLL,
    CITY_GUIDE_PLACE_BLOCK,
    PAGE_POST_HORIZONTAL_SCROLL,
    BOOSTED_LOCAL_AWARENESS_TIP;

    public static GraphQLReactionStoryAttachmentsStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        switch ((((Character.toUpperCase(str.charAt(0)) * 961) + (Character.toUpperCase(str.charAt(str.length() - 1)) * 31)) + str.length()) & 63) {
            case 0:
                if (str.equalsIgnoreCase("NEARBY_FRIENDS_FACEPILE")) {
                    return NEARBY_FRIENDS_FACEPILE;
                }
                if (str.equalsIgnoreCase("SPORTS_GAME_SINGLE")) {
                    return SPORTS_GAME_SINGLE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 1:
                if (str.equalsIgnoreCase("FUNDRAISER_LIST")) {
                    return FUNDRAISER_LIST;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 3:
                if (str.equalsIgnoreCase("FRIEND_YOU_MAY_INVITE_TO_LIKE_PAGE")) {
                    return FRIEND_YOU_MAY_INVITE_TO_LIKE_PAGE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 5:
                if (str.equalsIgnoreCase("PROFILE_MULTILINE_SUBTITLE")) {
                    return PROFILE_MULTILINE_SUBTITLE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 8:
                if (str.equalsIgnoreCase("FEELING_ICON_STRIP")) {
                    return FEELING_ICON_STRIP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 10:
                if (str.equalsIgnoreCase("TOPIC_LIST")) {
                    return TOPIC_LIST;
                }
                if (str.equalsIgnoreCase("SIMPLE_TEXT")) {
                    return SIMPLE_TEXT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 12:
                if (str.equalsIgnoreCase("NOTIFICATIONS_LIST")) {
                    return NOTIFICATIONS_LIST;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 13:
                if (str.equalsIgnoreCase("PAGE_PRODUCT_LIST")) {
                    return PAGE_PRODUCT_LIST;
                }
                if (str.equalsIgnoreCase("PAGE_SERVICE_LIST")) {
                    return PAGE_SERVICE_LIST;
                }
                if (str.equalsIgnoreCase("BOOSTED_LOCAL_AWARENESS_TIP")) {
                    return BOOSTED_LOCAL_AWARENESS_TIP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 15:
                if (str.equalsIgnoreCase("CREATE_OWNED_PAGE_UPSELL")) {
                    return CREATE_OWNED_PAGE_UPSELL;
                }
                if (str.equalsIgnoreCase("SPORTS_GAME_LIST")) {
                    return SPORTS_GAME_LIST;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 16:
                if (str.equalsIgnoreCase("EVENT_HORIZONTAL_SCROLL")) {
                    return EVENT_HORIZONTAL_SCROLL;
                }
                if (str.equalsIgnoreCase("PAGE_PROMOTION")) {
                    return PAGE_PROMOTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 18:
                if (str.equalsIgnoreCase("GROUP_HORIZONTAL_SCROLL")) {
                    return GROUP_HORIZONTAL_SCROLL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 20:
                if (str.equalsIgnoreCase("FACEPILE_HORIZONTAL_SCROLL")) {
                    return FACEPILE_HORIZONTAL_SCROLL;
                }
                if (str.equalsIgnoreCase("PHOTO_WITH_CAPTION")) {
                    return PHOTO_WITH_CAPTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 21:
                if (str.equalsIgnoreCase("SIMPLE_LEFT_RIGHT_TEXT")) {
                    return SIMPLE_LEFT_RIGHT_TEXT;
                }
                if (str.equalsIgnoreCase("PAGE_ATTRIBUTION_FOOTER")) {
                    return PAGE_ATTRIBUTION_FOOTER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 22:
                if (str.equalsIgnoreCase("CRITIC_REVIEW_HORIZONTAL_SCROLL")) {
                    return CRITIC_REVIEW_HORIZONTAL_SCROLL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 23:
                if (str.equalsIgnoreCase("RESIDENCE_MIGRATION")) {
                    return RESIDENCE_MIGRATION;
                }
                if (str.equalsIgnoreCase("PHOTOS_FULL_WIDTH_COUNTER")) {
                    return PHOTOS_FULL_WIDTH_COUNTER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 24:
                if (str.equalsIgnoreCase("PAGE_INFO_CARD_PLACEHOLDER")) {
                    return PAGE_INFO_CARD_PLACEHOLDER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 25:
                if (str.equalsIgnoreCase("PHOTOS_WITH_ATTRIBUTION")) {
                    return PHOTOS_WITH_ATTRIBUTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 27:
                if (str.equalsIgnoreCase("PLACE_QUESTION_VERTICAL")) {
                    return PLACE_QUESTION_VERTICAL;
                }
                if (str.equalsIgnoreCase("EVENT_CARD_LARGE_HORIZONTAL_SCROLL")) {
                    return EVENT_CARD_LARGE_HORIZONTAL_SCROLL;
                }
                if (str.equalsIgnoreCase("APP_AD_BLOCKS")) {
                    return APP_AD_BLOCKS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 29:
                if (str.equalsIgnoreCase("PLACE_QUESTION_HORIZONTAL")) {
                    return PLACE_QUESTION_HORIZONTAL;
                }
                if (str.equalsIgnoreCase("PROFILE_HORIZONTAL_SCROLL")) {
                    return PROFILE_HORIZONTAL_SCROLL;
                }
                if (str.equalsIgnoreCase("HEADLINE_STORY")) {
                    return HEADLINE_STORY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 30:
                if (str.equalsIgnoreCase("EVENT_BLOCKS")) {
                    return EVENT_BLOCKS;
                }
                if (str.equalsIgnoreCase("NEXT_PLACE_HORIZONTAL_SCROLL")) {
                    return NEXT_PLACE_HORIZONTAL_SCROLL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 31:
                if (str.equalsIgnoreCase("PAGE_POST_HORIZONTAL_SCROLL")) {
                    return PAGE_POST_HORIZONTAL_SCROLL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 32:
                if (str.equalsIgnoreCase("SIMPLE_TEXT_WITHOUT_LABEL")) {
                    return SIMPLE_TEXT_WITHOUT_LABEL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 33:
                if (str.equalsIgnoreCase("VIDEO_HORIZONTAL_SCROLL")) {
                    return VIDEO_HORIZONTAL_SCROLL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 35:
                if (str.equalsIgnoreCase("PHOTOS")) {
                    return PHOTOS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 37:
                if (str.equalsIgnoreCase("REVIEW_NEEDY")) {
                    return REVIEW_NEEDY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 38:
                if (str.equalsIgnoreCase("PROFILE_TWO_LINE_HORIZONTAL_SCROLL")) {
                    return PROFILE_TWO_LINE_HORIZONTAL_SCROLL;
                }
                if (str.equalsIgnoreCase("EVENT_PROFILE_BLOCKS")) {
                    return EVENT_PROFILE_BLOCKS;
                }
                if (str.equalsIgnoreCase("PAGE_POST_STORY")) {
                    return PAGE_POST_STORY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 39:
                if (str.equalsIgnoreCase("PAGE_YOU_MAY_LIKE_HORIZONTAL_SCROLL")) {
                    return PAGE_YOU_MAY_LIKE_HORIZONTAL_SCROLL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 40:
                if (str.equalsIgnoreCase("NO_ACTOR_FEED_STORY")) {
                    return NO_ACTOR_FEED_STORY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 41:
                if (str.equalsIgnoreCase("FACEPILE")) {
                    return FACEPILE;
                }
                if (str.equalsIgnoreCase("VIDEOS")) {
                    return VIDEOS;
                }
                if (str.equalsIgnoreCase("APP_AD_SINGLE")) {
                    return APP_AD_SINGLE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 43:
                if (str.equalsIgnoreCase("PROFILE_BLOCKS")) {
                    return PROFILE_BLOCKS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 44:
                if (str.equalsIgnoreCase("FEED_STORY_PROFILE_BLOCKS")) {
                    return FEED_STORY_PROFILE_BLOCKS;
                }
                if (str.equalsIgnoreCase("OG_OBJECT_BLOCKS")) {
                    return OG_OBJECT_BLOCKS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 46:
                if (str.equalsIgnoreCase("IMAGE_TEXT_BLOCK")) {
                    return IMAGE_TEXT_BLOCK;
                }
                if (str.equalsIgnoreCase("CITY_GUIDE_PLACE_BLOCK")) {
                    return CITY_GUIDE_PLACE_BLOCK;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 47:
                if (str.equalsIgnoreCase("FEED_STORY_ATTACHMENT_BLOCKS")) {
                    return FEED_STORY_ATTACHMENT_BLOCKS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 48:
                if (str.equalsIgnoreCase("EVENT_CARD_LARGE")) {
                    return EVENT_CARD_LARGE;
                }
                if (str.equalsIgnoreCase("PAGE_COMMERCE_UNITS")) {
                    return PAGE_COMMERCE_UNITS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 49:
                if (str.equalsIgnoreCase("RATING")) {
                    return RATING;
                }
                if (str.equalsIgnoreCase("PLACE_SURVEY_THANK_YOU")) {
                    return PLACE_SURVEY_THANK_YOU;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 50:
                if (str.equalsIgnoreCase("FEED_STORY_SINGLE")) {
                    return FEED_STORY_SINGLE;
                }
                if (str.equalsIgnoreCase("PAGE_LIKES_AND_VISITS")) {
                    return PAGE_LIKES_AND_VISITS;
                }
                if (str.equalsIgnoreCase("RATINGS_INCL_DRAFTS")) {
                    return RATINGS_INCL_DRAFTS;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 51:
                if (str.equalsIgnoreCase("SPOTLIGHT_STORY_PREVIEW")) {
                    return SPOTLIGHT_STORY_PREVIEW;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 54:
                if (str.equalsIgnoreCase("SINGLE_LARGE_PHOTO")) {
                    return SINGLE_LARGE_PHOTO;
                }
                if (str.equalsIgnoreCase("DISCOVERY_PLACE_PROFILE")) {
                    return DISCOVERY_PLACE_PROFILE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 55:
                if (str.equalsIgnoreCase("PHOTOS_LARGE")) {
                    return PHOTOS_LARGE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 56:
                if (str.equalsIgnoreCase("PHOTO_COLLAGE")) {
                    return PHOTO_COLLAGE;
                }
                if (str.equalsIgnoreCase("SONG_PLAYING")) {
                    return SONG_PLAYING;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 60:
                if (str.equalsIgnoreCase("PAGE_WELCOME_HOME")) {
                    return PAGE_WELCOME_HOME;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 63:
                if (str.equalsIgnoreCase("TODAY_GENERIC_MLE_IMAGE_BLOCKS")) {
                    return TODAY_GENERIC_MLE_IMAGE_BLOCKS;
                }
                if (str.equalsIgnoreCase("ADMINED_PAGES_LIST")) {
                    return ADMINED_PAGES_LIST;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            default:
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }
}

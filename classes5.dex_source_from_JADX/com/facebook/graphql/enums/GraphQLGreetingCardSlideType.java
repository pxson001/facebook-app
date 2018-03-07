package com.facebook.graphql.enums;

/* compiled from: m_home_welcome */
public enum GraphQLGreetingCardSlideType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    COVER_SLIDE,
    STORY_SLIDE,
    CLOSING_SLIDE,
    ORIGIN_COVER_SLIDE,
    ORIGIN_STORY_SLIDE,
    ORIGIN_CLOSING_SLIDE;

    public static GraphQLGreetingCardSlideType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("COVER_SLIDE")) {
            return COVER_SLIDE;
        }
        if (str.equalsIgnoreCase("STORY_SLIDE")) {
            return STORY_SLIDE;
        }
        if (str.equalsIgnoreCase("CLOSING_SLIDE")) {
            return CLOSING_SLIDE;
        }
        if (str.equalsIgnoreCase("ORIGIN_COVER_SLIDE")) {
            return ORIGIN_COVER_SLIDE;
        }
        if (str.equalsIgnoreCase("ORIGIN_STORY_SLIDE")) {
            return ORIGIN_STORY_SLIDE;
        }
        if (str.equalsIgnoreCase("ORIGIN_CLOSING_SLIDE")) {
            return ORIGIN_CLOSING_SLIDE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

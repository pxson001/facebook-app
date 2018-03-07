package com.facebook.graphql.enums;

/* compiled from: never_while_plugged */
public enum GraphQLStoryHeaderStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    FALLBACK,
    HAPPY_BIRTHDAY,
    FACEBOOK_VOICE,
    EGO,
    PAGE_LIKE,
    CONNECTION_QUESTIONS,
    TITLE_ONLY,
    DAILY_DIALOGUE_LIGHTWEIGHT,
    THROWBACK_SHARED_STORY;

    public static GraphQLStoryHeaderStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("FALLBACK")) {
            return FALLBACK;
        }
        if (str.equalsIgnoreCase("HAPPY_BIRTHDAY")) {
            return HAPPY_BIRTHDAY;
        }
        if (str.equalsIgnoreCase("FACEBOOK_VOICE")) {
            return FACEBOOK_VOICE;
        }
        if (str.equalsIgnoreCase("EGO")) {
            return EGO;
        }
        if (str.equalsIgnoreCase("PAGE_LIKE")) {
            return PAGE_LIKE;
        }
        if (str.equalsIgnoreCase("CONNECTION_QUESTIONS")) {
            return CONNECTION_QUESTIONS;
        }
        if (str.equalsIgnoreCase("TITLE_ONLY")) {
            return TITLE_ONLY;
        }
        if (str.equalsIgnoreCase("DAILY_DIALOGUE_LIGHTWEIGHT")) {
            return DAILY_DIALOGUE_LIGHTWEIGHT;
        }
        if (str.equalsIgnoreCase("THROWBACK_SHARED_STORY")) {
            return THROWBACK_SHARED_STORY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

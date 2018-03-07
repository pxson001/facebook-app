package com.facebook.graphql.enums;

/* compiled from: live_video_timestamp */
public enum GraphQLSearchAwarenessTutorialNUXTemplate {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    BASIC,
    INTRO,
    CARD;

    public static GraphQLSearchAwarenessTutorialNUXTemplate fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("BASIC")) {
            return BASIC;
        }
        if (str.equalsIgnoreCase("INTRO")) {
            return INTRO;
        }
        if (str.equalsIgnoreCase("CARD")) {
            return CARD;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

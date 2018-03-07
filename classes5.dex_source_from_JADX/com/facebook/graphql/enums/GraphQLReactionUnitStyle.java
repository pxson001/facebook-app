package com.facebook.graphql.enums;

/* compiled from: local_seen_state_session_number */
public enum GraphQLReactionUnitStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    STORY,
    UNIT_STACK,
    GRAVITY_PAGE_ABOUT,
    GRAVITY_NUX,
    VERTICAL_COMPONENTS,
    PLACEHOLDER,
    VERTICAL_COMPONENTS_WITH_TRANSPARENT_BACKGROUND,
    ACORN_HIDE_CONFIRMATION,
    FLUSH_TO_BOTTOM,
    XHP,
    VERTICAL_COMPONENTS_RECYCLE,
    STORY_WITHOUT_HEADER,
    QUESTION,
    ADS_AFTER_PARTY_HIDE_CONFIRMATION;

    public static GraphQLReactionUnitStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("STORY")) {
            return STORY;
        }
        if (str.equalsIgnoreCase("UNIT_STACK")) {
            return UNIT_STACK;
        }
        if (str.equalsIgnoreCase("VERTICAL_COMPONENTS")) {
            return VERTICAL_COMPONENTS;
        }
        if (str.equalsIgnoreCase("PLACEHOLDER")) {
            return PLACEHOLDER;
        }
        if (str.equalsIgnoreCase("VERTICAL_COMPONENTS_WITH_TRANSPARENT_BACKGROUND")) {
            return VERTICAL_COMPONENTS_WITH_TRANSPARENT_BACKGROUND;
        }
        if (str.equalsIgnoreCase("ACORN_HIDE_CONFIRMATION")) {
            return ACORN_HIDE_CONFIRMATION;
        }
        if (str.equalsIgnoreCase("FLUSH_TO_BOTTOM")) {
            return FLUSH_TO_BOTTOM;
        }
        if (str.equalsIgnoreCase("XHP")) {
            return XHP;
        }
        if (str.equalsIgnoreCase("VERTICAL_COMPONENTS_RECYCLE")) {
            return VERTICAL_COMPONENTS_RECYCLE;
        }
        if (str.equalsIgnoreCase("STORY_WITHOUT_HEADER")) {
            return STORY_WITHOUT_HEADER;
        }
        if (str.equalsIgnoreCase("QUESTION")) {
            return QUESTION;
        }
        if (str.equalsIgnoreCase("GRAVITY_PAGE_ABOUT")) {
            return GRAVITY_PAGE_ABOUT;
        }
        if (str.equalsIgnoreCase("GRAVITY_NUX")) {
            return GRAVITY_NUX;
        }
        if (str.equalsIgnoreCase("ADS_AFTER_PARTY_HIDE_CONFIRMATION")) {
            return ADS_AFTER_PARTY_HIDE_CONFIRMATION;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

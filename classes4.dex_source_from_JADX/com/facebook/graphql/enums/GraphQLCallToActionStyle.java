package com.facebook.graphql.enums;

/* compiled from: desktop */
public enum GraphQLCallToActionStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    BUTTON_WITH_TEXT_ONLY,
    BUTTON_WITH_ICON_ONLY,
    HIDE_FROM_FEED,
    ATTACHMENT_AND_ENDSCREEN,
    SHOW_SPONSORSHIP,
    VIDEO_DR_STYLE,
    BUTTON_UNDER_DESC;

    public static GraphQLCallToActionStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("BUTTON_WITH_TEXT_ONLY")) {
            return BUTTON_WITH_TEXT_ONLY;
        }
        if (str.equalsIgnoreCase("BUTTON_WITH_ICON_ONLY")) {
            return BUTTON_WITH_ICON_ONLY;
        }
        if (str.equalsIgnoreCase("HIDE_FROM_FEED")) {
            return HIDE_FROM_FEED;
        }
        if (str.equalsIgnoreCase("ATTACHMENT_AND_ENDSCREEN")) {
            return ATTACHMENT_AND_ENDSCREEN;
        }
        if (str.equalsIgnoreCase("SHOW_SPONSORSHIP")) {
            return SHOW_SPONSORSHIP;
        }
        if (str.equalsIgnoreCase("VIDEO_DR_STYLE")) {
            return VIDEO_DR_STYLE;
        }
        if (str.equalsIgnoreCase("BUTTON_UNDER_DESC")) {
            return BUTTON_UNDER_DESC;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: match_page */
public enum GraphQLDocumentWebviewPresentationStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SOCIAL_EMBED,
    FULL_SCREEN,
    HTML_INTERACTIVE,
    AD,
    TRACKER,
    TWEET,
    INSTAGRAM,
    YOUTUBE,
    VINE,
    FACEBOOK;

    public static GraphQLDocumentWebviewPresentationStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SOCIAL_EMBED")) {
            return SOCIAL_EMBED;
        }
        if (str.equalsIgnoreCase("FULL_SCREEN")) {
            return FULL_SCREEN;
        }
        if (str.equalsIgnoreCase("HTML_INTERACTIVE")) {
            return HTML_INTERACTIVE;
        }
        if (str.equalsIgnoreCase("AD")) {
            return AD;
        }
        if (str.equalsIgnoreCase("TRACKER")) {
            return TRACKER;
        }
        if (str.equalsIgnoreCase("TWEET")) {
            return TWEET;
        }
        if (str.equalsIgnoreCase("INSTAGRAM")) {
            return INSTAGRAM;
        }
        if (str.equalsIgnoreCase("YOUTUBE")) {
            return YOUTUBE;
        }
        if (str.equalsIgnoreCase("VINE")) {
            return VINE;
        }
        if (str.equalsIgnoreCase("FACEBOOK")) {
            return FACEBOOK;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

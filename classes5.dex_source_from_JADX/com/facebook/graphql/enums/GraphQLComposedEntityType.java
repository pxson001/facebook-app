package com.facebook.graphql.enums;

/* compiled from: med_res_theme_image */
public enum GraphQLComposedEntityType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    IMAGE,
    LINK,
    MENTION,
    VIDEO,
    EMOTICON,
    TOKEN,
    HASHTAG,
    IMPLICIT_LINK,
    EMBED,
    EMOJI;

    public static GraphQLComposedEntityType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("IMAGE")) {
            return IMAGE;
        }
        if (str.equalsIgnoreCase("LINK")) {
            return LINK;
        }
        if (str.equalsIgnoreCase("MENTION")) {
            return MENTION;
        }
        if (str.equalsIgnoreCase("VIDEO")) {
            return VIDEO;
        }
        if (str.equalsIgnoreCase("EMOTICON")) {
            return EMOTICON;
        }
        if (str.equalsIgnoreCase("TOKEN")) {
            return TOKEN;
        }
        if (str.equalsIgnoreCase("HASHTAG")) {
            return HASHTAG;
        }
        if (str.equalsIgnoreCase("IMPLICIT_LINK")) {
            return IMPLICIT_LINK;
        }
        if (str.equalsIgnoreCase("EMBED")) {
            return EMBED;
        }
        if (str.equalsIgnoreCase("EMOJI")) {
            return EMOJI;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

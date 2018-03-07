package com.facebook.graphql.enums;

/* compiled from: mFriendsText */
public enum GraphQLPageCtaConfigFieldType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PHONE_NUMBER,
    EMAIL_ADDRESS,
    URL,
    DEEPLINK,
    TEXT,
    SELECT,
    TEXT_WITH_ENTITIES,
    TEXT_MULTILINE,
    TEXT_WITH_CLEARBUTTON,
    CHECK_BOX,
    GROUP,
    NONE,
    TEXT_MULTILINE_CHAR_LIMIT;

    public static GraphQLPageCtaConfigFieldType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PHONE_NUMBER")) {
            return PHONE_NUMBER;
        }
        if (str.equalsIgnoreCase("EMAIL_ADDRESS")) {
            return EMAIL_ADDRESS;
        }
        if (str.equalsIgnoreCase("URL")) {
            return URL;
        }
        if (str.equalsIgnoreCase("DEEPLINK")) {
            return DEEPLINK;
        }
        if (str.equalsIgnoreCase("TEXT")) {
            return TEXT;
        }
        if (str.equalsIgnoreCase("SELECT")) {
            return SELECT;
        }
        if (str.equalsIgnoreCase("TEXT_WITH_ENTITIES")) {
            return TEXT_WITH_ENTITIES;
        }
        if (str.equalsIgnoreCase("TEXT_MULTILINE")) {
            return TEXT_MULTILINE;
        }
        if (str.equalsIgnoreCase("TEXT_MULTILINE_CHAR_LIMIT")) {
            return TEXT_MULTILINE_CHAR_LIMIT;
        }
        if (str.equalsIgnoreCase("TEXT_WITH_CLEARBUTTON")) {
            return TEXT_WITH_CLEARBUTTON;
        }
        if (str.equalsIgnoreCase("CHECK_BOX")) {
            return CHECK_BOX;
        }
        if (str.equalsIgnoreCase("GROUP")) {
            return GROUP;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: link_data */
public enum GraphQLUserChatContextType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NEARBY,
    VISITING,
    TRAVELING,
    BIRTHDAY,
    CELEBRATION,
    NEIGHBOURHOOD,
    LISTENING,
    PLAYING,
    PRESENCE,
    OTHER,
    OG_COMPOSER;

    public static GraphQLUserChatContextType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NEARBY")) {
            return NEARBY;
        }
        if (str.equalsIgnoreCase("VISITING")) {
            return VISITING;
        }
        if (str.equalsIgnoreCase("TRAVELING")) {
            return TRAVELING;
        }
        if (str.equalsIgnoreCase("BIRTHDAY")) {
            return BIRTHDAY;
        }
        if (str.equalsIgnoreCase("CELEBRATION")) {
            return CELEBRATION;
        }
        if (str.equalsIgnoreCase("NEIGHBOURHOOD")) {
            return NEIGHBOURHOOD;
        }
        if (str.equalsIgnoreCase("LISTENING")) {
            return LISTENING;
        }
        if (str.equalsIgnoreCase("PLAYING")) {
            return PLAYING;
        }
        if (str.equalsIgnoreCase("PRESENCE")) {
            return PRESENCE;
        }
        if (str.equalsIgnoreCase("OTHER")) {
            return OTHER;
        }
        if (str.equalsIgnoreCase("OG_COMPOSER")) {
            return OG_COMPOSER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: m_friend_requests */
public enum GraphQLGroupCreationSuggestionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    FAMILY,
    TOP_PAGE,
    PAGE_ADMIN,
    LIFE_EVENT,
    WORK,
    SCHOOL,
    MESSENGER,
    FRIEND_LIST,
    GAMES,
    EVENT,
    CLOSE_FRIENDS;

    public static GraphQLGroupCreationSuggestionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("FAMILY")) {
            return FAMILY;
        }
        if (str.equalsIgnoreCase("TOP_PAGE")) {
            return TOP_PAGE;
        }
        if (str.equalsIgnoreCase("PAGE_ADMIN")) {
            return PAGE_ADMIN;
        }
        if (str.equalsIgnoreCase("LIFE_EVENT")) {
            return LIFE_EVENT;
        }
        if (str.equalsIgnoreCase("WORK")) {
            return WORK;
        }
        if (str.equalsIgnoreCase("SCHOOL")) {
            return SCHOOL;
        }
        if (str.equalsIgnoreCase("MESSENGER")) {
            return MESSENGER;
        }
        if (str.equalsIgnoreCase("FRIEND_LIST")) {
            return FRIEND_LIST;
        }
        if (str.equalsIgnoreCase("GAMES")) {
            return GAMES;
        }
        if (str.equalsIgnoreCase("EVENT")) {
            return EVENT;
        }
        if (str.equalsIgnoreCase("CLOSE_FRIENDS")) {
            return CLOSE_FRIENDS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

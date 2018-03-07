package com.facebook.graphql.enums;

/* compiled from: map_uri */
public enum GraphQLEventSuggestionCutType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ALL,
    EVENT_RELATED,
    PAGE_YOU_LIKE,
    GROUP_YOU_ARE_IN,
    POPULAR_AMONG_FRIENDS,
    POPULAR_NEARBY,
    FRIENDS_EVENTS,
    NON_FRIENDS_EVENTS;

    public static GraphQLEventSuggestionCutType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ALL")) {
            return ALL;
        }
        if (str.equalsIgnoreCase("EVENT_RELATED")) {
            return EVENT_RELATED;
        }
        if (str.equalsIgnoreCase("PAGE_YOU_LIKE")) {
            return PAGE_YOU_LIKE;
        }
        if (str.equalsIgnoreCase("GROUP_YOU_ARE_IN")) {
            return GROUP_YOU_ARE_IN;
        }
        if (str.equalsIgnoreCase("POPULAR_AMONG_FRIENDS")) {
            return POPULAR_AMONG_FRIENDS;
        }
        if (str.equalsIgnoreCase("POPULAR_NEARBY")) {
            return POPULAR_NEARBY;
        }
        if (str.equalsIgnoreCase("FRIENDS_EVENTS")) {
            return FRIENDS_EVENTS;
        }
        if (str.equalsIgnoreCase("NON_FRIENDS_EVENTS")) {
            return NON_FRIENDS_EVENTS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

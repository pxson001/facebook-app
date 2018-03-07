package com.facebook.graphql.enums;

/* compiled from: is_async */
public enum GraphQLStorySeenState {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SEEN_AND_READ,
    UNSEEN_AND_UNREAD,
    SEEN_BUT_UNREAD;

    public static GraphQLStorySeenState fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SEEN_AND_READ")) {
            return SEEN_AND_READ;
        }
        if (str.equalsIgnoreCase("UNSEEN_AND_UNREAD")) {
            return UNSEEN_AND_UNREAD;
        }
        if (str.equalsIgnoreCase("SEEN_BUT_UNREAD")) {
            return SEEN_BUT_UNREAD;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: open_people_list */
public enum GraphQLEventWatchStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    WATCHED,
    GOING,
    UNWATCHED,
    DECLINED;

    public static GraphQLEventWatchStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("WATCHED")) {
            return WATCHED;
        }
        if (str.equalsIgnoreCase("GOING")) {
            return GOING;
        }
        if (str.equalsIgnoreCase("UNWATCHED")) {
            return UNWATCHED;
        }
        if (str.equalsIgnoreCase("DECLINED")) {
            return DECLINED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: map_zoom_level */
public enum GraphQLEventSeenState {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SEEN,
    UNSEEN,
    UNKNOWN;

    public static GraphQLEventSeenState fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SEEN")) {
            return SEEN;
        }
        if (str.equalsIgnoreCase("UNSEEN")) {
            return UNSEEN;
        }
        if (str.equalsIgnoreCase("UNKNOWN")) {
            return UNKNOWN;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

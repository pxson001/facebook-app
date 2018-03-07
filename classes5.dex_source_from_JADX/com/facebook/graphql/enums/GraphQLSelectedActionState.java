package com.facebook.graphql.enums;

/* compiled from: live_video_count */
public enum GraphQLSelectedActionState {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NEGATIVE,
    UNSELECTED,
    POSITIVE;

    public static GraphQLSelectedActionState fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NEGATIVE")) {
            return NEGATIVE;
        }
        if (str.equalsIgnoreCase("UNSELECTED")) {
            return UNSELECTED;
        }
        if (str.equalsIgnoreCase("POSITIVE")) {
            return POSITIVE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

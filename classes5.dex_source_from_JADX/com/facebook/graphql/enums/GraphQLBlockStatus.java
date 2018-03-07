package com.facebook.graphql.enums;

/* compiled from: media_question_photos */
public enum GraphQLBlockStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    BLOCKED_BY_VIEWER,
    BLOCKED_BY_SOME,
    BLOCKED_BY_MANY,
    WHITELISTED_BY_VIEWER;

    public static GraphQLBlockStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("BLOCKED_BY_VIEWER")) {
            return BLOCKED_BY_VIEWER;
        }
        if (str.equalsIgnoreCase("BLOCKED_BY_SOME")) {
            return BLOCKED_BY_SOME;
        }
        if (str.equalsIgnoreCase("BLOCKED_BY_MANY")) {
            return BLOCKED_BY_MANY;
        }
        if (str.equalsIgnoreCase("WHITELISTED_BY_VIEWER")) {
            return WHITELISTED_BY_VIEWER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

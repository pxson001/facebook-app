package com.facebook.graphql.enums;

/* compiled from: max_daily_budget */
public enum GraphQLDocumentFeedbackOptions {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    LIKES,
    LIKES_AND_COMMENTS;

    public static GraphQLDocumentFeedbackOptions fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("LIKES")) {
            return LIKES;
        }
        if (str.equalsIgnoreCase("LIKES_AND_COMMENTS")) {
            return LIKES_AND_COMMENTS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

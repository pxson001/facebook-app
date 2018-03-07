package com.facebook.graphql.enums;

/* compiled from: main_question */
public enum GraphQLFeedbackRealTimeActivityType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    COMMENT,
    LIKE;

    public static GraphQLFeedbackRealTimeActivityType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("COMMENT")) {
            return COMMENT;
        }
        if (str.equalsIgnoreCase("LIKE")) {
            return LIKE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

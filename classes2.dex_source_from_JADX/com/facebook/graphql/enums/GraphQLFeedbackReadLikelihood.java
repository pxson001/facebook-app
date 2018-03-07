package com.facebook.graphql.enums;

/* compiled from: post_comment */
public enum GraphQLFeedbackReadLikelihood {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    UNKNOWN,
    LOW,
    HIGH;

    public static GraphQLFeedbackReadLikelihood fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("UNKNOWN")) {
            return UNKNOWN;
        }
        if (str.equalsIgnoreCase("LOW")) {
            return LOW;
        }
        if (str.equalsIgnoreCase("HIGH")) {
            return HIGH;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

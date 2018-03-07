package com.facebook.graphql.enums;

/* compiled from: log_message */
public enum GraphQLQuestionPollAnswersState {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    LEGACY,
    LOCKED,
    OPEN;

    public static GraphQLQuestionPollAnswersState fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("LEGACY")) {
            return LEGACY;
        }
        if (str.equalsIgnoreCase("LOCKED")) {
            return LOCKED;
        }
        if (str.equalsIgnoreCase("OPEN")) {
            return OPEN;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: loaded_time */
public enum GraphQLResearchPollQuestionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    RADIO,
    CHECKBOX;

    public static GraphQLResearchPollQuestionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("RADIO")) {
            return RADIO;
        }
        if (str.equalsIgnoreCase("CHECKBOX")) {
            return CHECKBOX;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

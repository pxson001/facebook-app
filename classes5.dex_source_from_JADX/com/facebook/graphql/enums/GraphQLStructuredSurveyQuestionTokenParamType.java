package com.facebook.graphql.enums;

/* compiled from: list_title */
public enum GraphQLStructuredSurveyQuestionTokenParamType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ANSWER,
    VIEWER,
    QE,
    SESSION,
    TESSA_EVENT,
    QB_OPTIMIZED,
    PREVIOUS_VALUE,
    CONTEXT_DATA,
    GROUP;

    public static GraphQLStructuredSurveyQuestionTokenParamType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ANSWER")) {
            return ANSWER;
        }
        if (str.equalsIgnoreCase("VIEWER")) {
            return VIEWER;
        }
        if (str.equalsIgnoreCase("QE")) {
            return QE;
        }
        if (str.equalsIgnoreCase("SESSION")) {
            return SESSION;
        }
        if (str.equalsIgnoreCase("TESSA_EVENT")) {
            return TESSA_EVENT;
        }
        if (str.equalsIgnoreCase("QB_OPTIMIZED")) {
            return QB_OPTIMIZED;
        }
        if (str.equalsIgnoreCase("PREVIOUS_VALUE")) {
            return PREVIOUS_VALUE;
        }
        if (str.equalsIgnoreCase("CONTEXT_DATA")) {
            return CONTEXT_DATA;
        }
        if (str.equalsIgnoreCase("GROUP")) {
            return GROUP;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

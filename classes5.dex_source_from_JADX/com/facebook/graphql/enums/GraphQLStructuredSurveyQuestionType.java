package com.facebook.graphql.enums;

/* compiled from: list_style */
public enum GraphQLStructuredSurveyQuestionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CUSTOM,
    PORT,
    INVALID,
    MESSAGE,
    RADIO,
    CHECKBOX,
    DROPDOWN,
    TEXT,
    RATINGMATRIX,
    STARS,
    LIKERT,
    CONSTANTSUM,
    FLOWNODE,
    ICONSCALE;

    public static GraphQLStructuredSurveyQuestionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CUSTOM")) {
            return CUSTOM;
        }
        if (str.equalsIgnoreCase("PORT")) {
            return PORT;
        }
        if (str.equalsIgnoreCase("INVALID")) {
            return INVALID;
        }
        if (str.equalsIgnoreCase("MESSAGE")) {
            return MESSAGE;
        }
        if (str.equalsIgnoreCase("RADIO")) {
            return RADIO;
        }
        if (str.equalsIgnoreCase("CHECKBOX")) {
            return CHECKBOX;
        }
        if (str.equalsIgnoreCase("DROPDOWN")) {
            return DROPDOWN;
        }
        if (str.equalsIgnoreCase("TEXT")) {
            return TEXT;
        }
        if (str.equalsIgnoreCase("RATINGMATRIX")) {
            return RATINGMATRIX;
        }
        if (str.equalsIgnoreCase("STARS")) {
            return STARS;
        }
        if (str.equalsIgnoreCase("LIKERT")) {
            return LIKERT;
        }
        if (str.equalsIgnoreCase("CONSTANTSUM")) {
            return CONSTANTSUM;
        }
        if (str.equalsIgnoreCase("FLOWNODE")) {
            return FLOWNODE;
        }
        if (str.equalsIgnoreCase("ICONSCALE")) {
            return ICONSCALE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

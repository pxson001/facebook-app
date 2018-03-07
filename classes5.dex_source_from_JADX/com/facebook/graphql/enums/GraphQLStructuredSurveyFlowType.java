package com.facebook.graphql.enums;

/* compiled from: listview index is not valid */
public enum GraphQLStructuredSurveyFlowType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    LINEAR,
    CONTROL_NODE,
    RANDOMIZED,
    BLOCK_SURVEYS;

    public static GraphQLStructuredSurveyFlowType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("LINEAR")) {
            return LINEAR;
        }
        if (str.equalsIgnoreCase("CONTROL_NODE")) {
            return CONTROL_NODE;
        }
        if (str.equalsIgnoreCase("RANDOMIZED")) {
            return RANDOMIZED;
        }
        if (str.equalsIgnoreCase("BLOCK_SURVEYS")) {
            return BLOCK_SURVEYS;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

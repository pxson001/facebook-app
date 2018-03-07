package com.facebook.graphql.enums;

/* compiled from: logSourceName= */
public enum GraphQLQuestionResponseMethod {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NON_POLL,
    CHOOSE_ONE,
    CHOOSE_MULTIPLE;

    public static GraphQLQuestionResponseMethod fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NON_POLL")) {
            return NON_POLL;
        }
        if (str.equalsIgnoreCase("CHOOSE_ONE")) {
            return CHOOSE_ONE;
        }
        if (str.equalsIgnoreCase("CHOOSE_MULTIPLE")) {
            return CHOOSE_MULTIPLE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

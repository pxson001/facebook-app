package com.facebook.graphql.enums;

/* compiled from: mAdded */
public enum GraphQLPlaceQuestionOrientation {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    HORIZONTAL,
    VERTICAL;

    public static GraphQLPlaceQuestionOrientation fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("HORIZONTAL")) {
            return HORIZONTAL;
        }
        if (str.equalsIgnoreCase("VERTICAL")) {
            return VERTICAL;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

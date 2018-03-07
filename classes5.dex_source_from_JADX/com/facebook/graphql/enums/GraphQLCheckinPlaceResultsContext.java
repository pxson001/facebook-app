package com.facebook.graphql.enums;

/* compiled from: media_editor_review_duplicates_module */
public enum GraphQLCheckinPlaceResultsContext {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NORMAL,
    SOCIAL_SEARCH;

    public static GraphQLCheckinPlaceResultsContext fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NORMAL")) {
            return NORMAL;
        }
        if (str.equalsIgnoreCase("SOCIAL_SEARCH")) {
            return SOCIAL_SEARCH;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

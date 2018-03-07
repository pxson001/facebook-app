package com.facebook.graphql.enums;

/* compiled from: mActionTitle */
public enum GraphQLPlaceSuggestionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SUGGESTIFIER,
    FALLBACK;

    public static GraphQLPlaceSuggestionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SUGGESTIFIER")) {
            return SUGGESTIFIER;
        }
        if (str.equalsIgnoreCase("FALLBACK")) {
            return FALLBACK;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: show */
public enum GraphQLPrivacyTagExpansionState {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    TAGGEES,
    UNSPECIFIED;

    public static GraphQLPrivacyTagExpansionState fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("TAGGEES")) {
            return TAGGEES;
        }
        if (str.equalsIgnoreCase("UNSPECIFIED")) {
            return UNSPECIFIED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

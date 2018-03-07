package com.facebook.graphql.enums;

/* compiled from: lineage_snippets */
public enum GraphQLZeroTokenRegStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    REGISTERED,
    UNREGISTERED;

    public static GraphQLZeroTokenRegStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("REGISTERED")) {
            return REGISTERED;
        }
        if (str.equalsIgnoreCase("UNREGISTERED")) {
            return UNREGISTERED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

package com.facebook.graphql.enums;

/* compiled from: mUri= */
public enum GraphQLInfoRequestFieldStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    FILLED,
    REQUESTABLE,
    REQUESTED;

    public static GraphQLInfoRequestFieldStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("FILLED")) {
            return FILLED;
        }
        if (str.equalsIgnoreCase("REQUESTABLE")) {
            return REQUESTABLE;
        }
        if (str.equalsIgnoreCase("REQUESTED")) {
            return REQUESTED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

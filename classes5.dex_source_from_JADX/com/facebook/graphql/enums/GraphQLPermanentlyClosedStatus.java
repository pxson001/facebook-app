package com.facebook.graphql.enums;

/* compiled from: mBudgetData */
public enum GraphQLPermanentlyClosedStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NOT_PERMANENTLY_CLOSED,
    REPORTED_PERMANENTLY_CLOSED,
    PERMANENTLY_CLOSED;

    public static GraphQLPermanentlyClosedStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NOT_PERMANENTLY_CLOSED")) {
            return NOT_PERMANENTLY_CLOSED;
        }
        if (str.equalsIgnoreCase("REPORTED_PERMANENTLY_CLOSED")) {
            return REPORTED_PERMANENTLY_CLOSED;
        }
        if (str.equalsIgnoreCase("PERMANENTLY_CLOSED")) {
            return PERMANENTLY_CLOSED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

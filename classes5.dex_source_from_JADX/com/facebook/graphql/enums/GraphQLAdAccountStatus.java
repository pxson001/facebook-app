package com.facebook.graphql.enums;

/* compiled from: memorial_contact_tools */
public enum GraphQLAdAccountStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ACTIVE,
    DISABLED,
    UNSETTLED,
    PENDING_RISK_REVIEW,
    PENDING_SETTLEMENT,
    IN_GRACE_PERIOD,
    PENDING_CLOSURE,
    CLOSED;

    public static GraphQLAdAccountStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ACTIVE")) {
            return ACTIVE;
        }
        if (str.equalsIgnoreCase("DISABLED")) {
            return DISABLED;
        }
        if (str.equalsIgnoreCase("UNSETTLED")) {
            return UNSETTLED;
        }
        if (str.equalsIgnoreCase("PENDING_RISK_REVIEW")) {
            return PENDING_RISK_REVIEW;
        }
        if (str.equalsIgnoreCase("PENDING_SETTLEMENT")) {
            return PENDING_SETTLEMENT;
        }
        if (str.equalsIgnoreCase("IN_GRACE_PERIOD")) {
            return IN_GRACE_PERIOD;
        }
        if (str.equalsIgnoreCase("PENDING_CLOSURE")) {
            return PENDING_CLOSURE;
        }
        if (str.equalsIgnoreCase("CLOSED")) {
            return CLOSED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

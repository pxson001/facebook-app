package com.facebook.graphql.enums;

/* compiled from: mDelayInterval */
public enum GraphQLPageProductTransactionOrderStatusEnum {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PENDING_APPROVAL,
    PAYMENT_APPROVED,
    SHIPPED,
    AWAITING_PAYMENT,
    PAYMENT_SUBMITTED,
    VOIDED,
    AWAITING_PAYMENT_METHOD,
    PAYMENT_EXPIRED;

    public static GraphQLPageProductTransactionOrderStatusEnum fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("AWAITING_PAYMENT_METHOD")) {
            return AWAITING_PAYMENT_METHOD;
        }
        if (str.equalsIgnoreCase("AWAITING_PAYMENT")) {
            return AWAITING_PAYMENT;
        }
        if (str.equalsIgnoreCase("PAYMENT_SUBMITTED")) {
            return PAYMENT_SUBMITTED;
        }
        if (str.equalsIgnoreCase("PAYMENT_EXPIRED")) {
            return PAYMENT_EXPIRED;
        }
        if (str.equalsIgnoreCase("SHIPPED")) {
            return SHIPPED;
        }
        if (str.equalsIgnoreCase("VOIDED")) {
            return VOIDED;
        }
        if (str.equalsIgnoreCase("PENDING_APPROVAL")) {
            return PENDING_APPROVAL;
        }
        if (str.equalsIgnoreCase("PAYMENT_APPROVED")) {
            return PAYMENT_APPROVED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

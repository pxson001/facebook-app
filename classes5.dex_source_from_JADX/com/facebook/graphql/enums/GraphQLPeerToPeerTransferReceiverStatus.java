package com.facebook.graphql.enums;

/* compiled from: mClickableLinkText */
public enum GraphQLPeerToPeerTransferReceiverStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    R_PENDING,
    R_PENDING_VERIFICATION,
    R_PENDING_VERIFICATION_PROCESSING,
    R_PENDING_MANUAL_REVIEW,
    R_CANCELED,
    R_CANCELED_SENDER_RISK,
    R_CANCELED_RECIPIENT_RISK,
    R_CANCELED_DECLINED,
    R_CANCELED_EXPIRED,
    R_CANCELED_SAME_CARD,
    R_CANCELED_CUSTOMER_SERVICE,
    R_CANCELED_CHARGEBACK,
    R_CANCELED_SYSTEM_FAIL,
    R_COMPLETED,
    R_PENDING_NUX,
    R_PENDING_PROCESSING,
    R_PENDING_PUSH_FAIL,
    R_PENDING_PUSH_FAIL_CARD_EXPIRED;

    public static GraphQLPeerToPeerTransferReceiverStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("R_PENDING")) {
            return R_PENDING;
        }
        if (str.equalsIgnoreCase("R_PENDING_VERIFICATION")) {
            return R_PENDING_VERIFICATION;
        }
        if (str.equalsIgnoreCase("R_PENDING_VERIFICATION_PROCESSING")) {
            return R_PENDING_VERIFICATION_PROCESSING;
        }
        if (str.equalsIgnoreCase("R_PENDING_MANUAL_REVIEW")) {
            return R_PENDING_MANUAL_REVIEW;
        }
        if (str.equalsIgnoreCase("R_CANCELED")) {
            return R_CANCELED;
        }
        if (str.equalsIgnoreCase("R_CANCELED_SENDER_RISK")) {
            return R_CANCELED_SENDER_RISK;
        }
        if (str.equalsIgnoreCase("R_CANCELED_RECIPIENT_RISK")) {
            return R_CANCELED_RECIPIENT_RISK;
        }
        if (str.equalsIgnoreCase("R_CANCELED_DECLINED")) {
            return R_CANCELED_DECLINED;
        }
        if (str.equalsIgnoreCase("R_CANCELED_EXPIRED")) {
            return R_CANCELED_EXPIRED;
        }
        if (str.equalsIgnoreCase("R_CANCELED_SAME_CARD")) {
            return R_CANCELED_SAME_CARD;
        }
        if (str.equalsIgnoreCase("R_CANCELED_CUSTOMER_SERVICE")) {
            return R_CANCELED_CUSTOMER_SERVICE;
        }
        if (str.equalsIgnoreCase("R_CANCELED_CHARGEBACK")) {
            return R_CANCELED_CHARGEBACK;
        }
        if (str.equalsIgnoreCase("R_CANCELED_SYSTEM_FAIL")) {
            return R_CANCELED_SYSTEM_FAIL;
        }
        if (str.equalsIgnoreCase("R_COMPLETED")) {
            return R_COMPLETED;
        }
        if (str.equalsIgnoreCase("R_PENDING_NUX")) {
            return R_PENDING_NUX;
        }
        if (str.equalsIgnoreCase("R_PENDING_PROCESSING")) {
            return R_PENDING_PROCESSING;
        }
        if (str.equalsIgnoreCase("R_PENDING_PUSH_FAIL")) {
            return R_PENDING_PUSH_FAIL;
        }
        if (str.equalsIgnoreCase("R_PENDING_PUSH_FAIL_CARD_EXPIRED")) {
            return R_PENDING_PUSH_FAIL_CARD_EXPIRED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

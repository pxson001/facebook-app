package com.facebook.graphql.enums;

/* compiled from: mByteArrayOutputStream is null */
public enum GraphQLPeerToPeerTransferStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PENDING_SENDER_MANUAL_REVIEW,
    PENDING_SENDER_VERIFICATION,
    CANCELED_SENDER_RISK,
    PENDING_RECIPIENT_NUX,
    CANCELED_DECLINED,
    PENDING_RECIPIENT_VERIFICATION,
    PENDING_RECIPIENT_MANUAL_REVIEW,
    PENDING_RECIPIENT_PROCESSING,
    PENDING_PUSH_FAIL,
    CANCELED_RECIPIENT_RISK,
    CANCELED_SYSTEM_FAIL,
    CANCELED_EXPIRED,
    COMPLETED,
    INTERMEDIATE_PROCESSING,
    PENDING_SENDER_INITED,
    CANCELED_SAME_CARD,
    PENDING_SENDER_VERIFICATION_PROCESSING,
    PENDING_RECIPIENT_VERIFICATION_PROCESSING;

    public static GraphQLPeerToPeerTransferStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PENDING_SENDER_MANUAL_REVIEW")) {
            return PENDING_SENDER_MANUAL_REVIEW;
        }
        if (str.equalsIgnoreCase("PENDING_SENDER_VERIFICATION")) {
            return PENDING_SENDER_VERIFICATION;
        }
        if (str.equalsIgnoreCase("CANCELED_SENDER_RISK")) {
            return CANCELED_SENDER_RISK;
        }
        if (str.equalsIgnoreCase("PENDING_RECIPIENT_NUX")) {
            return PENDING_RECIPIENT_NUX;
        }
        if (str.equalsIgnoreCase("CANCELED_DECLINED")) {
            return CANCELED_DECLINED;
        }
        if (str.equalsIgnoreCase("PENDING_RECIPIENT_VERIFICATION")) {
            return PENDING_RECIPIENT_VERIFICATION;
        }
        if (str.equalsIgnoreCase("PENDING_RECIPIENT_MANUAL_REVIEW")) {
            return PENDING_RECIPIENT_MANUAL_REVIEW;
        }
        if (str.equalsIgnoreCase("PENDING_RECIPIENT_PROCESSING")) {
            return PENDING_RECIPIENT_PROCESSING;
        }
        if (str.equalsIgnoreCase("PENDING_PUSH_FAIL")) {
            return PENDING_PUSH_FAIL;
        }
        if (str.equalsIgnoreCase("CANCELED_RECIPIENT_RISK")) {
            return CANCELED_RECIPIENT_RISK;
        }
        if (str.equalsIgnoreCase("CANCELED_SYSTEM_FAIL")) {
            return CANCELED_SYSTEM_FAIL;
        }
        if (str.equalsIgnoreCase("CANCELED_EXPIRED")) {
            return CANCELED_EXPIRED;
        }
        if (str.equalsIgnoreCase("COMPLETED")) {
            return COMPLETED;
        }
        if (str.equalsIgnoreCase("INTERMEDIATE_PROCESSING")) {
            return INTERMEDIATE_PROCESSING;
        }
        if (str.equalsIgnoreCase("PENDING_SENDER_INITED")) {
            return PENDING_SENDER_INITED;
        }
        if (str.equalsIgnoreCase("CANCELED_SAME_CARD")) {
            return CANCELED_SAME_CARD;
        }
        if (str.equalsIgnoreCase("PENDING_SENDER_VERIFICATION_PROCESSING")) {
            return PENDING_SENDER_VERIFICATION_PROCESSING;
        }
        if (str.equalsIgnoreCase("PENDING_RECIPIENT_VERIFICATION_PROCESSING")) {
            return PENDING_RECIPIENT_VERIFICATION_PROCESSING;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

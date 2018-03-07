package com.facebook.graphql.enums;

/* compiled from: mCampaignTokenToRefreshType */
public enum GraphQLPeerToPeerTransferSenderStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    S_PENDING,
    S_PENDING_VERIFICATION,
    S_PENDING_VERIFICATION_PROCESSING,
    S_PENDING_MANUAL_REVIEW,
    S_CANCELED,
    S_CANCELED_SENDER_RISK,
    S_CANCELED_RECIPIENT_RISK,
    S_CANCELED_DECLINED,
    S_CANCELED_EXPIRED,
    S_CANCELED_SAME_CARD,
    S_CANCELED_CUSTOMER_SERVICE,
    S_CANCELED_CHARGEBACK,
    S_CANCELED_SYSTEM_FAIL,
    S_COMPLETED,
    S_SENT;

    public static GraphQLPeerToPeerTransferSenderStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("S_PENDING")) {
            return S_PENDING;
        }
        if (str.equalsIgnoreCase("S_PENDING_VERIFICATION")) {
            return S_PENDING_VERIFICATION;
        }
        if (str.equalsIgnoreCase("S_PENDING_VERIFICATION_PROCESSING")) {
            return S_PENDING_VERIFICATION_PROCESSING;
        }
        if (str.equalsIgnoreCase("S_PENDING_MANUAL_REVIEW")) {
            return S_PENDING_MANUAL_REVIEW;
        }
        if (str.equalsIgnoreCase("S_CANCELED")) {
            return S_CANCELED;
        }
        if (str.equalsIgnoreCase("S_CANCELED_SENDER_RISK")) {
            return S_CANCELED_SENDER_RISK;
        }
        if (str.equalsIgnoreCase("S_CANCELED_RECIPIENT_RISK")) {
            return S_CANCELED_RECIPIENT_RISK;
        }
        if (str.equalsIgnoreCase("S_CANCELED_DECLINED")) {
            return S_CANCELED_DECLINED;
        }
        if (str.equalsIgnoreCase("S_CANCELED_EXPIRED")) {
            return S_CANCELED_EXPIRED;
        }
        if (str.equalsIgnoreCase("S_CANCELED_SAME_CARD")) {
            return S_CANCELED_SAME_CARD;
        }
        if (str.equalsIgnoreCase("S_CANCELED_CUSTOMER_SERVICE")) {
            return S_CANCELED_CUSTOMER_SERVICE;
        }
        if (str.equalsIgnoreCase("S_CANCELED_CHARGEBACK")) {
            return S_CANCELED_CHARGEBACK;
        }
        if (str.equalsIgnoreCase("S_CANCELED_SYSTEM_FAIL")) {
            return S_CANCELED_SYSTEM_FAIL;
        }
        if (str.equalsIgnoreCase("S_COMPLETED")) {
            return S_COMPLETED;
        }
        if (str.equalsIgnoreCase("S_SENT")) {
            return S_SENT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

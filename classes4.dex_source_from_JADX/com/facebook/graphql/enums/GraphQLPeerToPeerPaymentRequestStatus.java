package com.facebook.graphql.enums;

/* compiled from: internal_error */
public enum GraphQLPeerToPeerPaymentRequestStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    INITED,
    DECLINED,
    TRANSFER_INITED,
    TRANSFER_COMPLETED,
    TRANSFER_FAILED,
    CANCELED,
    EXPIRED;

    public static GraphQLPeerToPeerPaymentRequestStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("INITED")) {
            return INITED;
        }
        if (str.equalsIgnoreCase("DECLINED")) {
            return DECLINED;
        }
        if (str.equalsIgnoreCase("TRANSFER_INITED")) {
            return TRANSFER_INITED;
        }
        if (str.equalsIgnoreCase("TRANSFER_COMPLETED")) {
            return TRANSFER_COMPLETED;
        }
        if (str.equalsIgnoreCase("TRANSFER_FAILED")) {
            return TRANSFER_FAILED;
        }
        if (str.equalsIgnoreCase("CANCELED")) {
            return CANCELED;
        }
        if (str.equalsIgnoreCase("EXPIRED")) {
            return EXPIRED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

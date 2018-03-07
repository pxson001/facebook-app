package com.facebook.graphql.enums;

/* compiled from: mClickableLinkUrl */
public enum GraphQLPeerToPeerPaymentMessageType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SENT_IN_GROUP,
    CANCELED_SENDER_RISK,
    CANCELED_DECLINED,
    CANCELED_RECIPIENT_RISK,
    CANCELED_EXPIRED,
    CANCELED_SAME_CARD,
    CANCELED_CUSTOMER_SERVICE,
    CANCELED_CHARGEBACK,
    CANCELED_SYSTEM_FAIL,
    REQUEST_CANCELED_BY_REQUESTER,
    REQUEST_DECLINED_BY_REQUESTEE,
    REQUEST_EXPIRED;

    public static GraphQLPeerToPeerPaymentMessageType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SENT_IN_GROUP")) {
            return SENT_IN_GROUP;
        }
        if (str.equalsIgnoreCase("CANCELED_SENDER_RISK")) {
            return CANCELED_SENDER_RISK;
        }
        if (str.equalsIgnoreCase("CANCELED_DECLINED")) {
            return CANCELED_DECLINED;
        }
        if (str.equalsIgnoreCase("CANCELED_RECIPIENT_RISK")) {
            return CANCELED_RECIPIENT_RISK;
        }
        if (str.equalsIgnoreCase("CANCELED_EXPIRED")) {
            return CANCELED_EXPIRED;
        }
        if (str.equalsIgnoreCase("CANCELED_SAME_CARD")) {
            return CANCELED_SAME_CARD;
        }
        if (str.equalsIgnoreCase("CANCELED_CUSTOMER_SERVICE")) {
            return CANCELED_CUSTOMER_SERVICE;
        }
        if (str.equalsIgnoreCase("CANCELED_CHARGEBACK")) {
            return CANCELED_CHARGEBACK;
        }
        if (str.equalsIgnoreCase("CANCELED_SYSTEM_FAIL")) {
            return CANCELED_SYSTEM_FAIL;
        }
        if (str.equalsIgnoreCase("REQUEST_CANCELED_BY_REQUESTER")) {
            return REQUEST_CANCELED_BY_REQUESTER;
        }
        if (str.equalsIgnoreCase("REQUEST_DECLINED_BY_REQUESTEE")) {
            return REQUEST_DECLINED_BY_REQUESTEE;
        }
        if (str.equalsIgnoreCase("REQUEST_EXPIRED")) {
            return REQUEST_EXPIRED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}

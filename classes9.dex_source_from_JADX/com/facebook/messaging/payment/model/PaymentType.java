package com.facebook.messaging.payment.model;

/* compiled from: i_id */
public enum PaymentType {
    MESSENGER_COMMERCE("MessengerCommercePayment"),
    NMOR_TRANSFER("NmorPayment"),
    PEER_TO_PEER_SINGLE_SIDED_INCENTIVE("PeerToPeerSingleSidedIncentivePayment"),
    PEER_TO_PEER_TRANSFER("PeerToPeerTransfer"),
    UNKNOWN("Unknown");
    
    private final String mValue;

    private PaymentType(String str) {
        this.mValue = str;
    }

    public final String getValue() {
        return this.mValue;
    }

    public static PaymentType fromString(String str) {
        for (PaymentType paymentType : values()) {
            if (paymentType.mValue.equalsIgnoreCase(str)) {
                return paymentType;
            }
        }
        return UNKNOWN;
    }
}

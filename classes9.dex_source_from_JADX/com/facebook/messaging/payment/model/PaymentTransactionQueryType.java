package com.facebook.messaging.payment.model;

/* compiled from: iab_disabled_opening_webview_uri */
public enum PaymentTransactionQueryType {
    ALL("all_messenger_payments"),
    INCOMING("incoming_messenger_payments"),
    OUTGOING("outgoing_messenger_payments");
    
    private final String mTypeName;

    private PaymentTransactionQueryType(String str) {
        this.mTypeName = str;
    }

    public final String toString() {
        return this.mTypeName;
    }
}

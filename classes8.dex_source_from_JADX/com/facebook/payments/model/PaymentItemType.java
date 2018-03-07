package com.facebook.payments.model;

import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: target_privacy_picker_backbutton */
public enum PaymentItemType {
    NONE("none", false),
    EVENT_TICKETING("event_ticketing", false),
    INVOICE("ads_invoice", false),
    MESSENGER_COMMERCE("messenger_commerce", false),
    PAGES_COMMERCE("pages_commerce", true),
    NMOR_PAGES_COMMERCE("nmor_pages_commerce", true),
    P2P_TRANSFER("p2p_transfer", false);
    
    private final boolean mIsNMORPayment;
    private final String mValue;

    private PaymentItemType(String str, boolean z) {
        this.mValue = str;
        this.mIsNMORPayment = z;
    }

    public final String getValue() {
        return this.mValue;
    }

    public final boolean isNMORPayment() {
        return this.mIsNMORPayment;
    }
}

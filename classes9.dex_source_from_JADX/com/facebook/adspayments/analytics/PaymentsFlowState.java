package com.facebook.adspayments.analytics;

/* compiled from: sender_hmac_key */
public enum PaymentsFlowState {
    START_STATE("start_state"),
    PREPARE_PAYMENT_METHOD_STATE("prepare_payment_method"),
    SELECT_PAYMENT_METHOD_STATE("select_payment_method"),
    SELECT_COUNTRY_STATE("select_country"),
    ADD_CC_STATE("add_cc"),
    ADD_PAYPAL_STATE("add_paypal"),
    DONE_STATE("done");
    
    private final String mValue;

    private PaymentsFlowState(String str) {
        this.mValue = str;
    }

    public final String getReliabilityEventName() {
        return "payments_android_reliability_" + toString();
    }

    public final String toString() {
        return this.mValue;
    }
}

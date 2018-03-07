package com.facebook.payments.checkout.statemachine;

/* compiled from: caller_camp_rtc */
public enum CheckoutStateMachineState {
    PREPARE_CHECKOUT,
    VERIFY_PAYMENT_METHOD,
    PROCESSING_VERIFY_PAYMENT_METHOD,
    CHECK_PIN,
    PROCESSING_CHECK_PIN,
    SEND_PAYMENT,
    PROCESSING_SEND_PAYMENT,
    FINISH
}

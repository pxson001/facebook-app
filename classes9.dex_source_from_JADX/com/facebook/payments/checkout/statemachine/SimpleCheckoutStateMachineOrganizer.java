package com.facebook.payments.checkout.statemachine;

import com.facebook.payments.checkout.model.CheckoutData;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap.Builder;

/* compiled from: caller_camp_mqtt */
public class SimpleCheckoutStateMachineOrganizer {
    public final ImmutableSortedMap m18612a(CheckoutData checkoutData) {
        Builder b = ImmutableSortedMap.b();
        b.a(Integer.valueOf(1), CheckoutStateMachineState.PREPARE_CHECKOUT);
        b.a(Integer.valueOf(2), CheckoutStateMachineState.VERIFY_PAYMENT_METHOD);
        b.a(Integer.valueOf(3), CheckoutStateMachineState.PROCESSING_VERIFY_PAYMENT_METHOD);
        b.a(Integer.valueOf(4), CheckoutStateMachineState.CHECK_PIN);
        b.a(Integer.valueOf(5), CheckoutStateMachineState.PROCESSING_CHECK_PIN);
        b.a(Integer.valueOf(6), CheckoutStateMachineState.SEND_PAYMENT);
        b.a(Integer.valueOf(7), CheckoutStateMachineState.PROCESSING_SEND_PAYMENT);
        b.a(Integer.valueOf(8), CheckoutStateMachineState.FINISH);
        return b.a();
    }
}

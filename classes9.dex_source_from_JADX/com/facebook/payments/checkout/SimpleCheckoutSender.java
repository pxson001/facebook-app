package com.facebook.payments.checkout;

import com.facebook.payments.checkout.model.CheckoutData;
import com.facebook.payments.checkout.statemachine.SimpleCheckoutStateMachineHandler.C21531;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: ephemeral_dialog_open */
public class SimpleCheckoutSender {
    public C21531 f15712a;

    public ListenableFuture mo631a(CheckoutData checkoutData) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    protected static boolean m15895a(ListenableFuture listenableFuture) {
        return listenableFuture == null || listenableFuture.isDone();
    }
}

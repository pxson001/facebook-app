package com.facebook.messaging.payment.value.input.checkout;

import com.facebook.payments.ui.PaymentsComponentRow;
import com.facebook.payments.ui.PaymentsComponentViewHolder;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;

/* compiled from: enter_flow */
public class MDescriptionCheckoutViewHolder extends PaymentsComponentViewHolder<MDescriptionCheckoutView, MDescriptionCheckoutRow> {
    public final void m15916a(PaymentsComponentRow paymentsComponentRow) {
        ((MDescriptionCheckoutView) this.a).setText(((MDescriptionCheckoutRow) paymentsComponentRow).f15735a);
    }

    public MDescriptionCheckoutViewHolder(MDescriptionCheckoutView mDescriptionCheckoutView) {
        super(mDescriptionCheckoutView);
    }

    public final void m15917a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
    }
}

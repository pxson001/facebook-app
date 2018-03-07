package com.facebook.payments.checkout.recyclerview;

import com.facebook.payments.ui.PaymentsComponentRow;
import com.facebook.payments.ui.PaymentsComponentViewHolder;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.facebook.payments.ui.SingleItemInfoView;

/* compiled from: can_change_rsvp_status */
public class SingleItemInfoViewHolder extends PaymentsComponentViewHolder<SingleItemInfoView, SingleItemInfoCheckoutRow> {
    public final void m18585a(PaymentsComponentRow paymentsComponentRow) {
        ((SingleItemInfoView) this.a).setViewParams(((SingleItemInfoCheckoutRow) paymentsComponentRow).f18558a);
    }

    public SingleItemInfoViewHolder(SingleItemInfoView singleItemInfoView) {
        super(singleItemInfoView);
    }

    public final void m18586a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
    }
}

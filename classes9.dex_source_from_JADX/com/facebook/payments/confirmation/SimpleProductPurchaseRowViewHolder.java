package com.facebook.payments.confirmation;

import com.facebook.payments.ui.PaymentsComponentRow;
import com.facebook.payments.ui.PaymentsComponentViewHolder;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;

/* compiled from: ca6e646d9944ff94d02a1a0a8b870fd3 */
public class SimpleProductPurchaseRowViewHolder extends PaymentsComponentViewHolder<SimpleProductPurchaseRowView, SimpleProductPurchaseRow> {
    public final void m18661a(PaymentsComponentRow paymentsComponentRow) {
        ((SimpleProductPurchaseRowView) this.a).setMessageText(((SimpleProductPurchaseRow) paymentsComponentRow).f18639a);
    }

    public SimpleProductPurchaseRowViewHolder(SimpleProductPurchaseRowView simpleProductPurchaseRowView) {
        super(simpleProductPurchaseRowView);
    }

    public final void m18662a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
    }
}

package com.facebook.payments.checkout.recyclerview;

import com.facebook.payments.ui.PaymentsComponentRow;
import com.facebook.payments.ui.PaymentsComponentViewHolder;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;

/* compiled from: cancel_label */
public class PriceTableCheckoutViewHolder extends PaymentsComponentViewHolder<PriceTableView, PriceTableCheckoutRow> {
    public final void m18573a(PaymentsComponentRow paymentsComponentRow) {
        ((PriceTableView) this.a).setRowDatas(((PriceTableCheckoutRow) paymentsComponentRow).f18545a);
    }

    public PriceTableCheckoutViewHolder(PriceTableView priceTableView) {
        super(priceTableView);
    }

    public final void m18574a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
    }
}

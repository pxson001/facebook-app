package com.facebook.payments.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

/* compiled from: styles */
public abstract class PaymentsComponentViewHolder<VIEW extends PaymentsComponentView, MODEL extends PaymentsComponentRow> extends ViewHolder {
    public abstract void mo104a(MODEL model);

    public abstract void mo105a(SimplePaymentsComponentCallback simplePaymentsComponentCallback);

    public PaymentsComponentViewHolder(VIEW view) {
        super((View) view);
    }
}

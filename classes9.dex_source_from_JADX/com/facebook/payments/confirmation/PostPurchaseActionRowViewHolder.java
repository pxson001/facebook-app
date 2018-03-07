package com.facebook.payments.confirmation;

import com.facebook.payments.ui.PaymentsComponentRow;
import com.facebook.payments.ui.PaymentsComponentViewHolder;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;

/* compiled from: call_message_type */
public class PostPurchaseActionRowViewHolder extends PaymentsComponentViewHolder<PostPurchaseActionRowView, PostPurchaseActionRow> {
    private SimplePaymentsComponentCallback f18623l;

    public final void m18643a(PaymentsComponentRow paymentsComponentRow) {
        PostPurchaseActionRow postPurchaseActionRow = (PostPurchaseActionRow) paymentsComponentRow;
        PostPurchaseActionRowView postPurchaseActionRowView = (PostPurchaseActionRowView) this.a;
        postPurchaseActionRowView.setPaymentsComponentCallback(this.f18623l);
        postPurchaseActionRowView.m18642a(postPurchaseActionRow);
    }

    public PostPurchaseActionRowViewHolder(PostPurchaseActionRowView postPurchaseActionRowView) {
        super(postPurchaseActionRowView);
    }

    public final void m18644a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f18623l = simplePaymentsComponentCallback;
    }
}

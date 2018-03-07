package com.facebook.payments.checkout.recyclerview;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.PaymentsComponentRow;
import com.facebook.payments.ui.PaymentsComponentViewHolder;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;

/* compiled from: cancel_uri */
public class PayButtonCheckoutViewHolder extends PaymentsComponentViewHolder<PayButtonCheckoutView, PayButtonCheckoutRow> implements OnClickListener {
    private SimplePaymentsComponentCallback f18540l;

    public final void m18563a(PaymentsComponentRow paymentsComponentRow) {
        PayButtonCheckoutRow payButtonCheckoutRow = (PayButtonCheckoutRow) paymentsComponentRow;
        PayButtonCheckoutView payButtonCheckoutView = (PayButtonCheckoutView) this.a;
        payButtonCheckoutView.setPaymentsComponentCallback(this.f18540l);
        switch (payButtonCheckoutRow.f18534a) {
            case INIT:
                m18560a(payButtonCheckoutView, payButtonCheckoutRow);
                return;
            case READY_FOR_PAYMENT:
                m18562b(payButtonCheckoutView, payButtonCheckoutRow);
                return;
            case PROCESSING_PAYMENT:
                m18559a(payButtonCheckoutView);
                return;
            case PAYMENT_COMPLETED:
                m18561b(payButtonCheckoutView);
                return;
            default:
                throw new IllegalStateException("Unknown state seen: " + payButtonCheckoutRow.f18534a);
        }
    }

    public PayButtonCheckoutViewHolder(PayButtonCheckoutView payButtonCheckoutView) {
        super(payButtonCheckoutView);
    }

    private static void m18560a(PayButtonCheckoutView payButtonCheckoutView, PayButtonCheckoutRow payButtonCheckoutRow) {
        payButtonCheckoutView.setEnabled(false);
        payButtonCheckoutView.setPayButtonText(payButtonCheckoutRow.f18535b);
        payButtonCheckoutView.setOnClickListener(null);
        payButtonCheckoutView.m18556b();
        payButtonCheckoutView.m18558f();
    }

    private void m18562b(PayButtonCheckoutView payButtonCheckoutView, PayButtonCheckoutRow payButtonCheckoutRow) {
        payButtonCheckoutView.setEnabled(true);
        payButtonCheckoutView.setPayButtonText(payButtonCheckoutRow.f18535b);
        payButtonCheckoutView.setOnClickListener(this);
        payButtonCheckoutView.m18556b();
        payButtonCheckoutView.m18558f();
    }

    private static void m18559a(PayButtonCheckoutView payButtonCheckoutView) {
        payButtonCheckoutView.setPayButtonText(null);
        payButtonCheckoutView.setOnClickListener(null);
        payButtonCheckoutView.setEnabled(true);
        payButtonCheckoutView.m18558f();
        payButtonCheckoutView.m18555a();
    }

    private static void m18561b(PayButtonCheckoutView payButtonCheckoutView) {
        payButtonCheckoutView.setPayButtonText(null);
        payButtonCheckoutView.setOnClickListener(null);
        payButtonCheckoutView.setEnabled(true);
        payButtonCheckoutView.m18556b();
        payButtonCheckoutView.m18557e();
    }

    public final void m18564a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f18540l = simplePaymentsComponentCallback;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1976367124);
        Bundle bundle = new Bundle();
        bundle.putString("button_name", "pay_button_name");
        this.f18540l.a(new PaymentsComponentAction(Action.USER_ACTION, bundle));
        Logger.a(2, EntryType.UI_INPUT_END, 1478191313, a);
    }
}

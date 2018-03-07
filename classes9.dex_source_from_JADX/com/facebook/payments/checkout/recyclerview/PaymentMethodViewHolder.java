package com.facebook.payments.checkout.recyclerview;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.paymentmethods.picker.PickerScreenActivity;
import com.facebook.payments.ui.FloatingLabelMultiOptionsView;
import com.facebook.payments.ui.PaymentsComponentRow;
import com.facebook.payments.ui.PaymentsComponentViewHolder;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.google.common.base.Preconditions;

/* compiled from: cancel_payment_transaction */
public class PaymentMethodViewHolder extends PaymentsComponentViewHolder<FloatingLabelMultiOptionsView, PaymentMethodCheckoutRow> implements OnClickListener {
    private SimplePaymentsComponentCallback f18543l;
    private PaymentMethodCheckoutRow f18544m;

    public final void m18568a(PaymentsComponentRow paymentsComponentRow) {
        PaymentMethodCheckoutRow paymentMethodCheckoutRow = (PaymentMethodCheckoutRow) paymentsComponentRow;
        Preconditions.checkNotNull(this.f18543l);
        this.f18544m = paymentMethodCheckoutRow;
        FloatingLabelMultiOptionsView floatingLabelMultiOptionsView = (FloatingLabelMultiOptionsView) this.a;
        floatingLabelMultiOptionsView.setPaymentsComponentCallback(this.f18543l);
        floatingLabelMultiOptionsView.setViewParams(paymentMethodCheckoutRow.f18541a);
        floatingLabelMultiOptionsView.setOnClickListener(this);
        floatingLabelMultiOptionsView.b.setOnClickListener(this);
    }

    public PaymentMethodViewHolder(FloatingLabelMultiOptionsView floatingLabelMultiOptionsView) {
        super(floatingLabelMultiOptionsView);
    }

    public final void m18569a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f18543l = simplePaymentsComponentCallback;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1356592119);
        if (this.f18544m.f18542b != null) {
            this.f18543l.a(PickerScreenActivity.m18779a(view.getContext(), this.f18544m.f18542b), 100);
        }
        Logger.a(2, EntryType.UI_INPUT_END, -333396950, a);
    }
}

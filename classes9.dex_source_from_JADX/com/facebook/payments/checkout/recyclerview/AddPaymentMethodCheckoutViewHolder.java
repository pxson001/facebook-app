package com.facebook.payments.checkout.recyclerview;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.paymentmethods.picker.PickerScreenActivity;
import com.facebook.payments.ui.PaymentsComponentRow;
import com.facebook.payments.ui.PaymentsComponentViewHolder;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.google.common.base.Preconditions;

/* compiled from: canonical_presence_lastread_stale_lessthanthreshold */
public class AddPaymentMethodCheckoutViewHolder extends PaymentsComponentViewHolder<CheckoutActionTextRowView, AddPaymentMethodCheckoutRow> implements OnClickListener {
    private SimplePaymentsComponentCallback f18523l;
    private AddPaymentMethodCheckoutRow f18524m;

    public final void m18538a(PaymentsComponentRow paymentsComponentRow) {
        AddPaymentMethodCheckoutRow addPaymentMethodCheckoutRow = (AddPaymentMethodCheckoutRow) paymentsComponentRow;
        Preconditions.checkNotNull(this.f18523l);
        this.f18524m = addPaymentMethodCheckoutRow;
        CheckoutActionTextRowView checkoutActionTextRowView = (CheckoutActionTextRowView) this.a;
        checkoutActionTextRowView.setPaymentsComponentCallback(this.f18523l);
        checkoutActionTextRowView.setText(addPaymentMethodCheckoutRow.f18521a);
        checkoutActionTextRowView.setOnClickListener(this);
    }

    public AddPaymentMethodCheckoutViewHolder(CheckoutActionTextRowView checkoutActionTextRowView) {
        super(checkoutActionTextRowView);
    }

    public final void m18539a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f18523l = simplePaymentsComponentCallback;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1158348016);
        this.f18523l.a(PickerScreenActivity.m18779a(view.getContext(), this.f18524m.f18522b), 101);
        Logger.a(2, EntryType.UI_INPUT_END, 684875434, a);
    }
}

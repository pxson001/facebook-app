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

/* compiled from: can_reply_to */
public class ShippingOptionCheckoutViewHolder extends PaymentsComponentViewHolder<FloatingLabelMultiOptionsView, ShippingOptionCheckoutRow> implements OnClickListener {
    private SimplePaymentsComponentCallback f18553l;
    private ShippingOptionCheckoutRow f18554m;

    public final void m18580a(PaymentsComponentRow paymentsComponentRow) {
        ShippingOptionCheckoutRow shippingOptionCheckoutRow = (ShippingOptionCheckoutRow) paymentsComponentRow;
        Preconditions.checkNotNull(this.f18553l);
        this.f18554m = shippingOptionCheckoutRow;
        FloatingLabelMultiOptionsView floatingLabelMultiOptionsView = (FloatingLabelMultiOptionsView) this.a;
        floatingLabelMultiOptionsView.setPaymentsComponentCallback(this.f18553l);
        floatingLabelMultiOptionsView.setViewParams(shippingOptionCheckoutRow.f18551a);
        floatingLabelMultiOptionsView.setOnClickListener(this);
        floatingLabelMultiOptionsView.b.setOnClickListener(this);
    }

    public ShippingOptionCheckoutViewHolder(FloatingLabelMultiOptionsView floatingLabelMultiOptionsView) {
        super(floatingLabelMultiOptionsView);
    }

    public final void m18581a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f18553l = simplePaymentsComponentCallback;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1081197932);
        if (this.f18554m.f18552b != null) {
            this.f18553l.a(PickerScreenActivity.m18779a(view.getContext(), this.f18554m.f18552b), 102);
        }
        Logger.a(2, EntryType.UI_INPUT_END, 1046161671, a);
    }
}

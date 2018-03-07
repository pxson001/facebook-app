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

/* compiled from: cannot_reply_reason */
public class MailingAddressCheckoutViewHolder extends PaymentsComponentViewHolder<FloatingLabelMultiOptionsView, MailingAddressCheckoutRow> implements OnClickListener {
    private SimplePaymentsComponentCallback f18532l;
    private MailingAddressCheckoutRow f18533m;

    public final void m18549a(PaymentsComponentRow paymentsComponentRow) {
        MailingAddressCheckoutRow mailingAddressCheckoutRow = (MailingAddressCheckoutRow) paymentsComponentRow;
        Preconditions.checkNotNull(this.f18532l);
        this.f18533m = mailingAddressCheckoutRow;
        FloatingLabelMultiOptionsView floatingLabelMultiOptionsView = (FloatingLabelMultiOptionsView) this.a;
        floatingLabelMultiOptionsView.setPaymentsComponentCallback(this.f18532l);
        floatingLabelMultiOptionsView.setViewParams(mailingAddressCheckoutRow.f18530a);
        floatingLabelMultiOptionsView.setOnClickListener(this);
        floatingLabelMultiOptionsView.b.setOnClickListener(this);
    }

    public MailingAddressCheckoutViewHolder(FloatingLabelMultiOptionsView floatingLabelMultiOptionsView) {
        super(floatingLabelMultiOptionsView);
    }

    public final void m18550a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f18532l = simplePaymentsComponentCallback;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 160783778);
        if (this.f18533m.f18531b != null) {
            this.f18532l.a(PickerScreenActivity.m18779a(view.getContext(), this.f18533m.f18531b), 103);
        }
        Logger.a(2, EntryType.UI_INPUT_END, -859526358, a);
    }
}

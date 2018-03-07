package com.facebook.payments.checkout.recyclerview;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.shipping.form.ShippingAddressActivity;
import com.facebook.payments.ui.PaymentsComponentRow;
import com.facebook.payments.ui.PaymentsComponentViewHolder;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.google.common.base.Preconditions;

/* compiled from: canonical_presence_lastsent_stale_lessthanthreshold */
public class AddMailingAddressCheckoutViewHolder extends PaymentsComponentViewHolder<CheckoutActionTextRowView, AddMailingAddressCheckoutRow> implements OnClickListener {
    private SimplePaymentsComponentCallback f18519l;
    private AddMailingAddressCheckoutRow f18520m;

    public final void m18533a(PaymentsComponentRow paymentsComponentRow) {
        AddMailingAddressCheckoutRow addMailingAddressCheckoutRow = (AddMailingAddressCheckoutRow) paymentsComponentRow;
        Preconditions.checkNotNull(this.f18519l);
        this.f18520m = addMailingAddressCheckoutRow;
        CheckoutActionTextRowView checkoutActionTextRowView = (CheckoutActionTextRowView) this.a;
        checkoutActionTextRowView.setPaymentsComponentCallback(this.f18519l);
        checkoutActionTextRowView.setText(addMailingAddressCheckoutRow.f18517a);
        checkoutActionTextRowView.setOnClickListener(this);
    }

    public AddMailingAddressCheckoutViewHolder(CheckoutActionTextRowView checkoutActionTextRowView) {
        super(checkoutActionTextRowView);
    }

    public final void m18534a(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f18519l = simplePaymentsComponentCallback;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 278316258);
        this.f18519l.a(ShippingAddressActivity.m18920a(view.getContext(), this.f18520m.f18518b), 104);
        Logger.a(2, EntryType.UI_INPUT_END, 796433014, a);
    }
}

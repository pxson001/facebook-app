package com.facebook.messaging.payment.value.input.checkout;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.payments.checkout.recyclerview.CheckoutRowType;
import com.facebook.payments.checkout.recyclerview.SimpleCheckoutRowViewHolderFactory;
import com.facebook.payments.checkout.recyclerview.SingleItemInfoViewHolder;
import com.facebook.payments.ui.PaymentsComponentViewHolder;
import com.facebook.payments.ui.SingleItemInfoView;

/* compiled from: err_type */
public class MCheckoutRowViewHolderFactory extends SimpleCheckoutRowViewHolderFactory {
    public final PaymentsComponentViewHolder mo628a(ViewGroup viewGroup, CheckoutRowType checkoutRowType) {
        switch (checkoutRowType) {
            case DESCRIPTION:
                return new MDescriptionCheckoutViewHolder((MDescriptionCheckoutView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907790, viewGroup, false));
            case SINGLE_ITEM_INFO:
                return new SingleItemInfoViewHolder((SingleItemInfoView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907792, viewGroup, false));
            default:
                return super.mo628a(viewGroup, checkoutRowType);
        }
    }
}

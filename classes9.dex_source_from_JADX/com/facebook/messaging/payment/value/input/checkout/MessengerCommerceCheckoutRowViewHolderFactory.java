package com.facebook.messaging.payment.value.input.checkout;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.payments.checkout.recyclerview.CheckoutRowType;
import com.facebook.payments.checkout.recyclerview.SimpleCheckoutRowViewHolderFactory;
import com.facebook.payments.ui.PaymentsComponentViewHolder;

/* compiled from: end_battery_level */
public class MessengerCommerceCheckoutRowViewHolderFactory extends SimpleCheckoutRowViewHolderFactory {
    public final PaymentsComponentViewHolder mo628a(ViewGroup viewGroup, CheckoutRowType checkoutRowType) {
        switch (checkoutRowType) {
            case SINGLE_ITEM_INFO:
                return new MessengerCommerceItemInfoCheckoutViewHolder((MessengerCommerceItemInfoCheckoutView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907795, viewGroup, false));
            default:
                return super.mo628a(viewGroup, checkoutRowType);
        }
    }
}

package com.facebook.payments.checkout.recyclerview.decorator;

import com.facebook.payments.checkout.recyclerview.CheckoutRow;
import com.facebook.payments.checkout.recyclerview.PayButtonCheckoutRow;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: camera_position */
public class AddPayButtonDecorator extends CheckoutRowsDecorator {
    private final PayButtonCheckoutRow f18575a;

    public AddPayButtonDecorator(CheckoutRows checkoutRows, PayButtonCheckoutRow payButtonCheckoutRow) {
        super(checkoutRows);
        this.f18575a = payButtonCheckoutRow;
    }

    public final ImmutableList<CheckoutRow> mo731a() {
        Builder builder = new Builder();
        builder.b(super.mo731a());
        builder.c(this.f18575a);
        return builder.b();
    }
}

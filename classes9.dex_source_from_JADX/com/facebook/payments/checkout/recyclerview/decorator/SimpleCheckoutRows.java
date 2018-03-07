package com.facebook.payments.checkout.recyclerview.decorator;

import com.facebook.payments.checkout.recyclerview.CheckoutRow;
import com.google.common.collect.ImmutableList;

/* compiled from: camera_direction */
public class SimpleCheckoutRows implements CheckoutRows {
    private final ImmutableList<CheckoutRow> f18578a;

    public SimpleCheckoutRows(ImmutableList<CheckoutRow> immutableList) {
        this.f18578a = immutableList;
    }

    public final ImmutableList<CheckoutRow> mo731a() {
        return this.f18578a;
    }
}

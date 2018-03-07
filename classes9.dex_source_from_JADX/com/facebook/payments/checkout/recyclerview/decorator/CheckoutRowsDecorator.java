package com.facebook.payments.checkout.recyclerview.decorator;

import com.facebook.payments.checkout.recyclerview.CheckoutRow;
import com.google.common.collect.ImmutableList;

/* compiled from: camera_source */
public abstract class CheckoutRowsDecorator implements CheckoutRows {
    private CheckoutRows f18574a;

    public CheckoutRowsDecorator(CheckoutRows checkoutRows) {
        this.f18574a = checkoutRows;
    }

    public ImmutableList<CheckoutRow> mo731a() {
        return this.f18574a.mo731a();
    }
}

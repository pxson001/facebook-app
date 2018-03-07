package com.facebook.payments.checkout.recyclerview.decorator;

import com.facebook.payments.checkout.recyclerview.CheckoutRow;
import com.facebook.payments.checkout.recyclerview.DividerCheckoutRow;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: calling_class_name */
public class SplitWithDividersDecorator extends CheckoutRowsDecorator {
    private final DividerCheckoutRow f18579a;

    public SplitWithDividersDecorator(CheckoutRows checkoutRows, DividerCheckoutRow dividerCheckoutRow) {
        super(checkoutRows);
        this.f18579a = dividerCheckoutRow;
    }

    public final ImmutableList<CheckoutRow> mo731a() {
        ImmutableList a = super.mo731a();
        Builder builder = new Builder();
        for (int i = 0; i < a.size() - 1; i++) {
            builder.c(a.get(i));
            if (!((CheckoutRow) a.get(i)).mo636b()) {
                builder.c(this.f18579a);
            }
        }
        if (!a.isEmpty()) {
            builder.c(a.get(a.size() - 1));
        }
        return builder.b();
    }
}

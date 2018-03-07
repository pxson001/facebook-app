package com.facebook.payments.checkout.recyclerview.decorator;

import com.facebook.payments.checkout.recyclerview.CheckoutRow;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: caller_id_payload */
public class SuffixWithActionsDecorator extends CheckoutRowsDecorator {
    public SuffixWithActionsDecorator(CheckoutRows checkoutRows) {
        super(checkoutRows);
    }

    public final ImmutableList<CheckoutRow> mo731a() {
        ImmutableList a = super.mo731a();
        Builder builder = new Builder();
        Builder builder2 = new Builder();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            CheckoutRow checkoutRow = (CheckoutRow) a.get(i);
            if (checkoutRow.mo636b()) {
                builder2.c(checkoutRow);
            } else {
                builder.c(checkoutRow);
            }
        }
        return new Builder().b(builder.b()).b(builder2.b()).b();
    }
}

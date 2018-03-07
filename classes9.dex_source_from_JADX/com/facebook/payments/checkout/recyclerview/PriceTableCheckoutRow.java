package com.facebook.payments.checkout.recyclerview;

import com.facebook.payments.checkout.recyclerview.PriceTableRowView.RowData;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: cancel_payment_request */
public class PriceTableCheckoutRow implements CheckoutRow {
    public final ImmutableList<RowData> f18545a;

    public PriceTableCheckoutRow(ImmutableList<RowData> immutableList) {
        boolean z;
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            if (((RowData) immutableList.get(i)).f18548c) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (i2 == 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f18545a = immutableList;
    }

    public final CheckoutRowType mo635a() {
        return CheckoutRowType.PRICE_TABLE;
    }

    public final boolean mo636b() {
        return false;
    }

    public final boolean mo637c() {
        return false;
    }
}

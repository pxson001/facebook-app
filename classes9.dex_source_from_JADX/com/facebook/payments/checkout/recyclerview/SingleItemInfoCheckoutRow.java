package com.facebook.payments.checkout.recyclerview;

import com.facebook.payments.ui.SingleItemInfoViewParams;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: can_reply */
public class SingleItemInfoCheckoutRow implements CheckoutRow {
    public final SingleItemInfoViewParams f18558a;

    public SingleItemInfoCheckoutRow(SingleItemInfoViewParams singleItemInfoViewParams) {
        this.f18558a = singleItemInfoViewParams;
    }

    public final CheckoutRowType mo635a() {
        return CheckoutRowType.SINGLE_ITEM_INFO;
    }

    public final boolean mo636b() {
        return false;
    }

    public final boolean mo637c() {
        return false;
    }
}

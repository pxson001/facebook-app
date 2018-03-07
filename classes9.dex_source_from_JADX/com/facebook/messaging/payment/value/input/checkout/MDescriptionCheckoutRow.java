package com.facebook.messaging.payment.value.input.checkout;

import android.support.annotation.StringRes;
import com.facebook.payments.checkout.recyclerview.CheckoutRow;
import com.facebook.payments.checkout.recyclerview.CheckoutRowType;

/* compiled from: enter_fullscreen_swipe */
public class MDescriptionCheckoutRow implements CheckoutRow {
    @StringRes
    public final int f15735a;

    public MDescriptionCheckoutRow(@StringRes int i) {
        this.f15735a = i;
    }

    public final CheckoutRowType mo635a() {
        return CheckoutRowType.DESCRIPTION;
    }

    public final boolean mo636b() {
        return false;
    }

    public final boolean mo637c() {
        return false;
    }
}

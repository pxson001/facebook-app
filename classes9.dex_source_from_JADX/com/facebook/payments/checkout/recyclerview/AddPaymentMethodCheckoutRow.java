package com.facebook.payments.checkout.recyclerview;

import android.support.annotation.StringRes;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: canonical_presence_lastread_stale_morethanthreshold */
public class AddPaymentMethodCheckoutRow implements CheckoutRow {
    @StringRes
    public final int f18521a;
    public final PickerScreenParams f18522b;

    public AddPaymentMethodCheckoutRow(@StringRes int i, PickerScreenParams pickerScreenParams) {
        this.f18521a = i;
        this.f18522b = pickerScreenParams;
    }

    public final CheckoutRowType mo635a() {
        return CheckoutRowType.ADD_PAYMENT_METHOD;
    }

    public final boolean mo636b() {
        return true;
    }

    public final boolean mo637c() {
        return true;
    }
}

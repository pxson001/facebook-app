package com.facebook.payments.checkout.recyclerview;

import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.ui.FloatingLabelMultiOptionsViewParams;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: cancel_stream_upload */
public class PaymentMethodCheckoutRow implements CheckoutRow {
    public final FloatingLabelMultiOptionsViewParams f18541a;
    @Nullable
    public final PickerScreenParams f18542b;

    public PaymentMethodCheckoutRow(FloatingLabelMultiOptionsViewParams floatingLabelMultiOptionsViewParams, @Nullable PickerScreenParams pickerScreenParams) {
        this.f18541a = floatingLabelMultiOptionsViewParams;
        this.f18542b = pickerScreenParams;
    }

    public final CheckoutRowType mo635a() {
        return CheckoutRowType.PAYMENT_METHOD;
    }

    public final boolean mo636b() {
        return false;
    }

    public final boolean mo637c() {
        return true;
    }
}

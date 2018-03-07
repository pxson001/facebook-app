package com.facebook.payments.checkout.recyclerview;

import com.facebook.payments.shipping.optionpicker.ShippingOptionPickerScreenParams;
import com.facebook.payments.ui.FloatingLabelMultiOptionsViewParams;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: can_viewer_send_money */
public class ShippingOptionCheckoutRow implements CheckoutRow {
    public final FloatingLabelMultiOptionsViewParams f18551a;
    @Nullable
    public final ShippingOptionPickerScreenParams f18552b;

    public ShippingOptionCheckoutRow(FloatingLabelMultiOptionsViewParams floatingLabelMultiOptionsViewParams, ShippingOptionPickerScreenParams shippingOptionPickerScreenParams) {
        this.f18551a = floatingLabelMultiOptionsViewParams;
        this.f18552b = shippingOptionPickerScreenParams;
    }

    public final CheckoutRowType mo635a() {
        return CheckoutRowType.SHIPPING_OPTION;
    }

    public final boolean mo636b() {
        return false;
    }

    public final boolean mo637c() {
        return true;
    }
}

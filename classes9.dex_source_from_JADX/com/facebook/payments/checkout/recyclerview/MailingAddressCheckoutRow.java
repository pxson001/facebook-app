package com.facebook.payments.checkout.recyclerview;

import com.facebook.payments.shipping.addresspicker.ShippingPickerScreenParams;
import com.facebook.payments.ui.FloatingLabelMultiOptionsViewParams;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: canonicalPath */
public class MailingAddressCheckoutRow implements CheckoutRow {
    public final FloatingLabelMultiOptionsViewParams f18530a;
    @Nullable
    public final ShippingPickerScreenParams f18531b;

    public MailingAddressCheckoutRow(FloatingLabelMultiOptionsViewParams floatingLabelMultiOptionsViewParams, ShippingPickerScreenParams shippingPickerScreenParams) {
        this.f18530a = floatingLabelMultiOptionsViewParams;
        this.f18531b = shippingPickerScreenParams;
    }

    public final CheckoutRowType mo635a() {
        return CheckoutRowType.MAILING_ADDRESS;
    }

    public final boolean mo636b() {
        return false;
    }

    public final boolean mo637c() {
        return true;
    }
}

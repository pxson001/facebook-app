package com.facebook.payments.checkout.recyclerview;

import android.support.annotation.StringRes;
import com.facebook.payments.shipping.model.ShippingParams;

/* compiled from: canonical_presence_lastsent_stale_morethanthreshold */
public class AddMailingAddressCheckoutRow implements CheckoutRow {
    @StringRes
    public final int f18517a;
    public final ShippingParams f18518b;

    public AddMailingAddressCheckoutRow(@StringRes int i, ShippingParams shippingParams) {
        this.f18517a = i;
        this.f18518b = shippingParams;
    }

    public final CheckoutRowType mo635a() {
        return CheckoutRowType.ADD_MAILING_ADDRESS;
    }

    public final boolean mo636b() {
        return true;
    }

    public final boolean mo637c() {
        return true;
    }
}

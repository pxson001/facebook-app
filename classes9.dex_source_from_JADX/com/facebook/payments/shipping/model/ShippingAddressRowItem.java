package com.facebook.payments.shipping.model;

import android.content.Intent;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.picker.model.RowType;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: backstage_reactions_list_open */
public class ShippingAddressRowItem implements RowItem {
    public final ShippingSource f18981a;
    @Nullable
    public final Intent f18982b;
    public final int f18983c;
    public final String f18984d;
    public final boolean f18985e;
    public final MailingAddress f18986f;

    public ShippingAddressRowItem(ShippingSource shippingSource, @Nullable Intent intent, int i, MailingAddress mailingAddress, String str, boolean z) {
        this.f18981a = shippingSource;
        if (this.f18981a != ShippingSource.CHECKOUT) {
            intent = (Intent) Preconditions.checkNotNull(intent);
        }
        this.f18982b = intent;
        this.f18983c = i;
        this.f18986f = mailingAddress;
        this.f18984d = str;
        this.f18985e = z;
    }

    public final RowType mo657a() {
        return RowType.SHIPPING_ADDRESS;
    }
}

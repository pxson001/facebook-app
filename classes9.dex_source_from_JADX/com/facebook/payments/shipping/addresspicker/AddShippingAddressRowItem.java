package com.facebook.payments.shipping.addresspicker;

import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.picker.model.RowType;
import com.facebook.payments.shipping.model.ShippingParams;

/* compiled from: basketball */
public class AddShippingAddressRowItem implements RowItem {
    public final ShippingParams f18887a;

    public AddShippingAddressRowItem(ShippingParams shippingParams) {
        this.f18887a = shippingParams;
    }

    public final RowType mo657a() {
        return RowType.ADD_SHIPPING_ADDRESS;
    }
}

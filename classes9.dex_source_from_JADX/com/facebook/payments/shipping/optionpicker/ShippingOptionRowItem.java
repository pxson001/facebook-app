package com.facebook.payments.shipping.optionpicker;

import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.picker.model.RowType;

/* compiled from: backstage_exit */
public class ShippingOptionRowItem implements RowItem {
    public final String f19033a;
    public final boolean f19034b;
    public final String f19035c;

    public ShippingOptionRowItem(String str, boolean z, String str2) {
        this.f19033a = str;
        this.f19034b = z;
        this.f19035c = str2;
    }

    public final RowType mo657a() {
        return RowType.SHIPPING_OPTION;
    }
}

package com.facebook.payments.shipping.addresspicker;

import com.facebook.payments.paymentmethods.picker.PickerScreenDataMutator;
import com.facebook.payments.paymentmethods.picker.PickerScreenFragment.C21992;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;

/* compiled from: bank_info */
public class ShippingPickerScreenDataMutator implements PickerScreenDataMutator<ShippingPickerScreenData> {
    private C21992 f18896a;

    public final void mo747a(PickerScreenData pickerScreenData, String str) {
        ShippingPickerScreenData shippingPickerScreenData = (ShippingPickerScreenData) pickerScreenData;
        this.f18896a.m18806a(new ShippingPickerScreenData(shippingPickerScreenData.f18895c, shippingPickerScreenData.f18893a, str));
    }

    public final void mo746a(C21992 c21992) {
        this.f18896a = c21992;
    }
}

package com.facebook.payments.shipping.optionpicker;

import com.facebook.payments.paymentmethods.picker.PickerScreenDataMutator;
import com.facebook.payments.paymentmethods.picker.PickerScreenFragment.C21992;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;

/* compiled from: backstage_emote_flow_started */
public class ShippingOptionsPickerScreenDataMutator implements PickerScreenDataMutator<ShippingOptionPickerScreenData> {
    private C21992 f19040a;

    public final void mo747a(PickerScreenData pickerScreenData, String str) {
        this.f19040a.m18806a(new ShippingOptionPickerScreenData(((ShippingOptionPickerScreenData) pickerScreenData).f19025a, str));
    }

    public final void mo746a(C21992 c21992) {
        this.f19040a = c21992;
    }
}

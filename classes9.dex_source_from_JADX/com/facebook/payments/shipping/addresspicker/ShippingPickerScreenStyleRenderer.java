package com.facebook.payments.shipping.addresspicker;

import android.content.Context;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleRenderer;
import com.facebook.payments.shipping.form.SimpleShippingManager;
import javax.inject.Inject;

/* compiled from: bad_latencies_deserialization */
public class ShippingPickerScreenStyleRenderer implements PickerScreenStyleRenderer<ShippingPickerScreenParams> {
    private final SimpleShippingManager f18906a;

    public final void mo656a(Context context, PickerScreenParams pickerScreenParams) {
        this.f18906a.m18958b(((ShippingPickerScreenParams) pickerScreenParams).f18899b.mo759a().f18987a).mo516a(context);
    }

    @Inject
    public ShippingPickerScreenStyleRenderer(SimpleShippingManager simpleShippingManager) {
        this.f18906a = simpleShippingManager;
    }
}

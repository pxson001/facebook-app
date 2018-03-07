package com.facebook.payments.shipping.addresspicker;

import com.facebook.payments.paymentmethods.picker.PickerScreenDataFetcher;
import com.facebook.payments.paymentmethods.picker.PickerScreenDataFetcher.Listener;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.picker.model.PickerScreenFetcherParams;

/* compiled from: barcode */
public class ShippingPickerScreenDataFetcher implements PickerScreenDataFetcher<ShippingPickerScreenParams, PickerScreenFetcherParams> {
    public final void mo745a(Listener listener, PickerScreenParams pickerScreenParams, PickerScreenFetcherParams pickerScreenFetcherParams) {
        ShippingPickerScreenParams shippingPickerScreenParams = (ShippingPickerScreenParams) pickerScreenParams;
        listener.mo749a(new ShippingPickerScreenData(shippingPickerScreenParams, shippingPickerScreenParams.f18900c, shippingPickerScreenParams.f18901d));
    }

    public final void mo744a() {
    }
}

package com.facebook.payments.shipping.optionpicker;

import com.facebook.payments.paymentmethods.picker.PickerScreenDataFetcher;
import com.facebook.payments.paymentmethods.picker.PickerScreenDataFetcher.Listener;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.picker.model.PickerScreenFetcherParams;

/* compiled from: backstage_import_share */
public class ShippingOptionPickerScreenDataFetcher implements PickerScreenDataFetcher<ShippingOptionPickerScreenParams, PickerScreenFetcherParams> {
    public final void mo745a(Listener listener, PickerScreenParams pickerScreenParams, PickerScreenFetcherParams pickerScreenFetcherParams) {
        ShippingOptionPickerScreenParams shippingOptionPickerScreenParams = (ShippingOptionPickerScreenParams) pickerScreenParams;
        listener.mo749a(new ShippingOptionPickerScreenData(shippingOptionPickerScreenParams, shippingOptionPickerScreenParams.f19029c));
    }

    public final void mo744a() {
    }
}

package com.facebook.adspayments;

import com.facebook.payments.paymentmethods.picker.PickerScreenDataMutator;
import com.facebook.payments.paymentmethods.picker.PickerScreenFragment.C21992;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;

/* compiled from: Unable to serialize PhotoQualityCacheItem collection */
public class AdsPaymentsPickerScreenDataMutator implements PickerScreenDataMutator<AdsPaymentsPickerScreenData> {
    private C21992 f23520a;

    public final void mo747a(PickerScreenData pickerScreenData, String str) {
        AdsPaymentsPickerScreenData adsPaymentsPickerScreenData = (AdsPaymentsPickerScreenData) pickerScreenData;
        this.f23520a.m18806a(new AdsPaymentsPickerScreenData(adsPaymentsPickerScreenData.f18844a, adsPaymentsPickerScreenData.f18845b, str, adsPaymentsPickerScreenData.f23519d));
    }

    public final void mo746a(C21992 c21992) {
        this.f23520a = c21992;
    }
}

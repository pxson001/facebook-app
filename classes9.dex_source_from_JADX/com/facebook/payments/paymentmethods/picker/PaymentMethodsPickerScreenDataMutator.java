package com.facebook.payments.paymentmethods.picker;

import com.facebook.payments.paymentmethods.picker.PickerScreenFragment.C21992;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenData;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;

/* compiled from: bool */
public class PaymentMethodsPickerScreenDataMutator implements PickerScreenDataMutator<PaymentMethodsPickerScreenData> {
    private C21992 f18753a;

    public final void mo747a(PickerScreenData pickerScreenData, String str) {
        PaymentMethodsPickerScreenData paymentMethodsPickerScreenData = (PaymentMethodsPickerScreenData) pickerScreenData;
        this.f18753a.m18806a(new PaymentMethodsPickerScreenData(paymentMethodsPickerScreenData.f18844a, paymentMethodsPickerScreenData.f18845b, str));
    }

    public final void mo746a(C21992 c21992) {
        this.f18753a = c21992;
    }
}

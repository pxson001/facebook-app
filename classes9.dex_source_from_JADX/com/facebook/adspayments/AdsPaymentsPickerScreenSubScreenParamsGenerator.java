package com.facebook.adspayments;

import android.content.Context;
import android.content.Intent;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsPickerScreenSubScreenParamsGenerator;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenData;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import javax.inject.Inject;

/* compiled from: Unable to retrieve bitmap for expired ephemeral message animation. */
public class AdsPaymentsPickerScreenSubScreenParamsGenerator extends PaymentMethodsPickerScreenSubScreenParamsGenerator {
    @Inject
    public AdsPaymentsPickerScreenSubScreenParamsGenerator(Context context) {
        super(context);
    }

    public final Intent mo654a(PickerScreenData pickerScreenData, PickerScreenParams pickerScreenParams) {
        return AddPaymentCardActivity.m25389a(this.f15846a, pickerScreenParams.mo743a().m18791b(), ((PaymentMethodsPickerScreenData) pickerScreenData).f18844a.a);
    }
}

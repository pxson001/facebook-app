package com.facebook.payments.settings;

import android.content.Intent;
import com.facebook.payments.paymentmethods.picker.PaymentsLoadingIndicatorHelper;
import com.facebook.payments.paymentmethods.picker.PickerScreenOnActivityResultHandler;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;

/* compiled from: logged_out_settings */
public class PaymentSettingsPickerScreenOnActivityResultHandler implements PickerScreenOnActivityResultHandler {
    public final void m8355a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, PaymentsLoadingIndicatorHelper paymentsLoadingIndicatorHelper) {
    }

    public final boolean m8356a(PickerScreenData pickerScreenData, int i, int i2, Intent intent) {
        switch (i) {
            case 402:
                return true;
            default:
                return false;
        }
    }
}

package com.facebook.payments.paymentmethods.picker;

import android.content.Intent;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;

/* compiled from: emoji */
public interface PickerScreenOnActivityResultHandler<DATA extends PickerScreenData> {
    void mo649a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, PaymentsLoadingIndicatorHelper paymentsLoadingIndicatorHelper);

    boolean mo650a(DATA data, int i, int i2, Intent intent);
}

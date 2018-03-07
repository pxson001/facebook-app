package com.facebook.messaging.payment.value.input.picker;

import android.content.Intent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsPickerScreenOnActivityResultHandler;
import com.facebook.payments.paymentmethods.picker.SimplePickerScreenManager;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import javax.inject.Inject;

/* compiled from: eligible_threads */
public class CommercePaymentMethodsPickerScreenOnActivityResultHandler extends PaymentMethodsPickerScreenOnActivityResultHandler {
    @Inject
    public CommercePaymentMethodsPickerScreenOnActivityResultHandler(AbstractFbErrorReporter abstractFbErrorReporter, AnalyticsLogger analyticsLogger, SimplePickerScreenManager simplePickerScreenManager) {
        super(abstractFbErrorReporter, analyticsLogger, simplePickerScreenManager);
    }

    public final boolean mo650a(PickerScreenData pickerScreenData, int i, int i2, Intent intent) {
        switch (i) {
            case 201:
                if (i2 == -1 && intent != null) {
                    m16017a(pickerScreenData, (PaymentMethod) intent.getParcelableExtra("selected_payment_method"));
                }
                return true;
            default:
                return super.mo650a(pickerScreenData, i, i2, intent);
        }
    }
}

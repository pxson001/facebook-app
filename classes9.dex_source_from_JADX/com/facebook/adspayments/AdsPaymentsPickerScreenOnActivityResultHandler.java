package com.facebook.adspayments;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsPickerScreenOnActivityResultHandler;
import com.facebook.payments.paymentmethods.picker.SimplePickerScreenManager;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import javax.inject.Inject;

/* compiled from: Unable to send stun ping to new address */
public class AdsPaymentsPickerScreenOnActivityResultHandler extends PaymentMethodsPickerScreenOnActivityResultHandler {
    @Inject
    public AdsPaymentsPickerScreenOnActivityResultHandler(AbstractFbErrorReporter abstractFbErrorReporter, AnalyticsLogger analyticsLogger, SimplePickerScreenManager simplePickerScreenManager) {
        super(abstractFbErrorReporter, analyticsLogger, simplePickerScreenManager);
    }

    public final boolean mo650a(PickerScreenData pickerScreenData, int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 != -1) {
                    return true;
                }
                m16017a(pickerScreenData, AddPaymentCardActivity.m25404b(intent));
                return true;
            case 301:
                if (i2 == -1) {
                    AdsPaymentsPickerScreenData adsPaymentsPickerScreenData = (AdsPaymentsPickerScreenData) pickerScreenData;
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("extra_reset_data", new AdsPaymentsPickerScreenData(adsPaymentsPickerScreenData.f18844a, adsPaymentsPickerScreenData.mo752a(), adsPaymentsPickerScreenData.f18846c, false));
                    this.f15827b.a(new PaymentsComponentAction(Action.RESET, bundle));
                    return true;
                }
                this.f15827b.a(new PaymentsComponentAction(Action.FINISH_ACTIVITY));
                return true;
            default:
                return super.mo650a(pickerScreenData, i, i2, intent);
        }
    }
}

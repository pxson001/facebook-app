package com.facebook.adspayments;

import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsInfoCache;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsPickerScreenDataFetcher;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Unable to understand proto buffer */
public class AdsPaymentsPickerScreenDataFetcher extends PaymentMethodsPickerScreenDataFetcher {
    @Inject
    public AdsPaymentsPickerScreenDataFetcher(FbErrorReporter fbErrorReporter, Provider<PaymentMethodsInfoCache> provider, TasksManager tasksManager) {
        super(fbErrorReporter, provider, tasksManager);
    }

    protected final PickerScreenData mo1079a(PaymentMethodsInfo paymentMethodsInfo, PickerScreenParams pickerScreenParams) {
        return new AdsPaymentsPickerScreenData(paymentMethodsInfo, pickerScreenParams, pickerScreenParams.mo743a().f18784a.f18813b == null ? null : pickerScreenParams.mo743a().f18784a.f18813b.a(), ((AdsPaymentsPickerScreenParams) pickerScreenParams).f23522b);
    }
}

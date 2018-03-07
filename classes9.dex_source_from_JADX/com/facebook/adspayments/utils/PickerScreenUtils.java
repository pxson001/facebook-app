package com.facebook.adspayments.utils;

import com.facebook.adspayments.AdsPaymentsPickerScreenParams;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.model.PaymentsFlowType;
import com.facebook.payments.paymentmethods.picker.PickerScreenAnalyticsParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenAnalyticsParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleParams;
import com.facebook.payments.picker.model.PickerScreenFetcherParams;

/* compiled from: UPLOAD_SETTING_SET */
public class PickerScreenUtils {
    public static PickerScreenParams m25756a(String str, PaymentsFlowContext paymentsFlowContext, PickerScreenFetcherParams pickerScreenFetcherParams, boolean z) {
        PickerScreenAnalyticsParamsBuilder newBuilder = PickerScreenAnalyticsParams.newBuilder();
        newBuilder.f18780a = paymentsFlowContext.f3966a;
        newBuilder = newBuilder;
        newBuilder.f18782c = PaymentsFlowType.PICKER_SCREEN;
        newBuilder = newBuilder;
        newBuilder.f18783d = paymentsFlowContext.f3968c;
        PickerScreenAnalyticsParams e = newBuilder.m18789e();
        PickerScreenCommonParamsBuilder newBuilder2 = PickerScreenCommonParams.newBuilder();
        newBuilder2.f18793a = e;
        PickerScreenCommonParamsBuilder pickerScreenCommonParamsBuilder = newBuilder2;
        pickerScreenCommonParamsBuilder.f18794b = PickerScreenStyleParams.newBuilder().m18827c();
        pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
        pickerScreenCommonParamsBuilder.f18795c = PickerScreenStyle.ADS_PAYMENTS;
        pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
        pickerScreenCommonParamsBuilder.f18796d = PaymentItemType.INVOICE;
        pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
        pickerScreenCommonParamsBuilder.f18798f = paymentsFlowContext.f3969d;
        pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
        pickerScreenCommonParamsBuilder.f18801i = paymentsFlowContext;
        pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
        pickerScreenCommonParamsBuilder.f18800h = pickerScreenFetcherParams;
        pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
        pickerScreenCommonParamsBuilder.f18799g = str;
        return new AdsPaymentsPickerScreenParams(pickerScreenCommonParamsBuilder.m18799j(), z);
    }
}

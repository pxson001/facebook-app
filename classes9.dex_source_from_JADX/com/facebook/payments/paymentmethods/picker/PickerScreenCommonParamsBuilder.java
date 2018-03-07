package com.facebook.payments.paymentmethods.picker;

import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.facebook.payments.picker.model.PickerScreenFetcherParams;
import com.google.common.collect.ImmutableList;

/* compiled from: bookmark_id */
public class PickerScreenCommonParamsBuilder {
    public PickerScreenAnalyticsParams f18793a;
    public PickerScreenStyleParams f18794b;
    public PickerScreenStyle f18795c;
    public PaymentItemType f18796d;
    public ImmutableList<NewPaymentOptionType> f18797e;
    public String f18798f;
    public String f18799g;
    public PickerScreenFetcherParams f18800h;
    public PaymentsFlowContext f18801i;

    public final PickerScreenCommonParamsBuilder m18793a(PickerScreenAnalyticsParams pickerScreenAnalyticsParams) {
        this.f18793a = pickerScreenAnalyticsParams;
        return this;
    }

    public final PickerScreenCommonParamsBuilder m18795a(PickerScreenStyleParams pickerScreenStyleParams) {
        this.f18794b = pickerScreenStyleParams;
        return this;
    }

    public final PickerScreenCommonParamsBuilder m18794a(PickerScreenStyle pickerScreenStyle) {
        this.f18795c = pickerScreenStyle;
        return this;
    }

    public final PickerScreenCommonParamsBuilder m18797a(ImmutableList<NewPaymentOptionType> immutableList) {
        this.f18797e = immutableList;
        return this;
    }

    public final PickerScreenCommonParamsBuilder m18792a(PaymentItemType paymentItemType) {
        this.f18796d = paymentItemType;
        return this;
    }

    public final PickerScreenCommonParamsBuilder m18798b(String str) {
        this.f18799g = str;
        return this;
    }

    public final PickerScreenCommonParamsBuilder m18796a(PickerScreenFetcherParams pickerScreenFetcherParams) {
        this.f18800h = pickerScreenFetcherParams;
        return this;
    }

    public final PickerScreenCommonParams m18799j() {
        return new PickerScreenCommonParams(this);
    }
}

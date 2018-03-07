package com.facebook.payments.paymentsflow;

import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.model.PaymentsFlowType;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.google.common.collect.ImmutableList;

/* compiled from: pageScrollState */
public class PayViewControllerParamsBuilder {
    public String f4370a;
    public String f4371b;
    public PaymentsFlowType f4372c;
    public PaymentItemType f4373d;
    public ImmutableList<NewPaymentOptionType> f4374e;
    public long f4375f;

    public final PayViewControllerParams m5362g() {
        return new PayViewControllerParams(this);
    }
}

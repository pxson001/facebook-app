package com.facebook.payments.paymentmethods.cardform.validation;

import com.facebook.payments.paymentmethods.model.FbPaymentCardType;

/* compiled from: supports_full_resolution_images */
public class SecurityCodeInputValidatorParams implements InputValidatorParams {
    private final String f1939a;
    public final FbPaymentCardType f1940b;

    public SecurityCodeInputValidatorParams(String str, FbPaymentCardType fbPaymentCardType) {
        this.f1939a = str;
        this.f1940b = fbPaymentCardType;
    }

    public final String mo93a() {
        return this.f1939a;
    }
}

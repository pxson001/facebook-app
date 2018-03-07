package com.facebook.adspayments.validation;

import com.facebook.inject.InjectorLike;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;

/* compiled from: UPLOADING */
public class SecurityCodeInputValidator extends InputValidatorCallbackHandler {

    /* compiled from: UPLOADING */
    public /* synthetic */ class C28711 {
        public static final /* synthetic */ int[] f23731a = new int[FbPaymentCardType.values().length];

        static {
            try {
                f23731a[FbPaymentCardType.AMEX.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23731a[FbPaymentCardType.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static SecurityCodeInputValidator m25766a(InjectorLike injectorLike) {
        return new SecurityCodeInputValidator();
    }

    public static int m25765a(FbPaymentCardType fbPaymentCardType) {
        return fbPaymentCardType == FbPaymentCardType.AMEX ? 4 : 3;
    }
}

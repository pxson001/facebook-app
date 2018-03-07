package com.facebook.payments.paymentmethods.cardform.validation;

import com.facebook.common.util.StringUtil;
import com.facebook.payments.paymentmethods.cardform.CardFormParams;
import com.facebook.payments.paymentmethods.cardform.PaymentMethodInputFormattingUtils;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormManager;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: surface_placetips_upsell */
public class CardNumberInputValidator implements TextInputValidator {
    private static final Class<?> f1930a = CardNumberInputValidator.class;
    private final SimpleCardFormManager f1931b;

    @Inject
    public CardNumberInputValidator(SimpleCardFormManager simpleCardFormManager) {
        this.f1931b = simpleCardFormManager;
    }

    public final boolean mo91a(InputValidatorParams inputValidatorParams) {
        Object a = ((CardNumberInputValidatorParams) inputValidatorParams).mo93a();
        Object obj = null;
        if (!StringUtil.a(a)) {
            String b = PaymentMethodInputFormattingUtils.m2051b(a);
            FbPaymentCardType a2 = PaymentMethodInputFormattingUtils.m2044a(b);
            int length = b.length();
            int i;
            switch (a2) {
                case AMEX:
                    if (length == 15 && m2127b(b)) {
                        i = 1;
                        break;
                    }
                case DISCOVER:
                    if (length == 16 && m2127b(b)) {
                        i = 1;
                        break;
                    }
                case JCB:
                    if (length == 16 && m2127b(b)) {
                        i = 1;
                        break;
                    }
                case MASTER_CARD:
                    if (length == 16 && m2127b(b)) {
                        i = 1;
                        break;
                    }
                case VISA:
                    if (length == 16 && m2127b(b)) {
                        i = 1;
                        break;
                    }
                default:
                    break;
            }
        }
        return obj != null && m2130c(inputValidatorParams);
    }

    public final boolean m2130c(InputValidatorParams inputValidatorParams) {
        CardNumberInputValidatorParams cardNumberInputValidatorParams = (CardNumberInputValidatorParams) inputValidatorParams;
        FbPaymentCardType a = PaymentMethodInputFormattingUtils.m2044a(cardNumberInputValidatorParams.mo93a());
        CardFormParams cardFormParams = cardNumberInputValidatorParams.f1933b;
        return this.f1931b.m2075c(cardFormParams.mo78a().f1772a).m2062a(a, cardFormParams);
    }

    public final String mo92b(InputValidatorParams inputValidatorParams) {
        CardFormParams cardFormParams = ((CardNumberInputValidatorParams) inputValidatorParams).f1933b;
        return this.f1931b.m2075c(cardFormParams.mo78a().f1772a).m2060a(cardFormParams);
    }

    @VisibleForTesting
    public static boolean m2127b(@Nonnull String str) {
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int charAt = str.charAt((length - 1) - i2) - 48;
            if (i2 % 2 == 0) {
                i += charAt;
            } else {
                charAt *= 2;
                if (charAt > 9) {
                    i += (charAt - 10) + 1;
                } else {
                    i += charAt;
                }
            }
        }
        return i % 10 == 0;
    }
}

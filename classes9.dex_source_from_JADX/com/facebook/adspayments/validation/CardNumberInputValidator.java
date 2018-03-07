package com.facebook.adspayments.validation;

import com.facebook.common.util.StringUtil;
import com.facebook.payments.paymentmethods.cardform.PaymentMethodInputFormattingUtils;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.google.common.annotations.VisibleForTesting;
import java.util.EnumSet;
import java.util.Set;

/* compiled from: UPLOAD_COMPLETED */
public class CardNumberInputValidator extends InputValidatorCallbackHandler {
    public static final Set<FbPaymentCardType> f23728a = EnumSet.of(FbPaymentCardType.VISA, FbPaymentCardType.AMEX, FbPaymentCardType.DISCOVER, FbPaymentCardType.JCB, FbPaymentCardType.MASTER_CARD);

    public static boolean m25761d(String str) {
        if (StringUtil.a(str)) {
            return false;
        }
        String b = PaymentMethodInputFormattingUtils.b(str);
        FbPaymentCardType a = PaymentMethodInputFormattingUtils.a(b);
        if (a != FbPaymentCardType.UNKNOWN && b.length() == a.getCardLength() && m25762e(b)) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    private static boolean m25762e(String str) {
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

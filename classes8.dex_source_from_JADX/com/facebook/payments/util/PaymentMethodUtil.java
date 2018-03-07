package com.facebook.payments.util;

import android.content.res.Resources;
import com.facebook.common.util.StringUtil;
import com.facebook.payments.paymentmethods.model.CreditCard;
import com.facebook.payments.paymentmethods.model.FbPaymentCard;
import com.facebook.payments.paymentmethods.model.PayPalBillingAgreement;
import com.facebook.payments.paymentmethods.model.PaymentMethod;

/* compiled from: storyteller-pkvs */
public class PaymentMethodUtil {
    public static String m2244a(PaymentMethod paymentMethod, Resources resources) {
        switch (paymentMethod.mo95b()) {
            case CREDIT_CARD:
                return resources.getString(2131238342, new Object[]{m2243a((CreditCard) paymentMethod)});
            case PAYPAL_BILLING_AGREEMENT:
                return ((PayPalBillingAgreement) paymentMethod).m2181c();
            default:
                return "";
        }
    }

    public static String m2243a(FbPaymentCard fbPaymentCard) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(fbPaymentCard.mo96c());
        stringBuilder.append('/');
        stringBuilder.append(StringUtil.b(fbPaymentCard.mo97d(), 2));
        return stringBuilder.toString();
    }

    public static String m2245b(PaymentMethod paymentMethod, Resources resources) {
        switch (paymentMethod.mo95b()) {
            case CREDIT_CARD:
                CreditCard creditCard = (CreditCard) paymentMethod;
                return resources.getString(2131238334, new Object[]{creditCard.mo99f().getHumanReadableName(), creditCard.mo98e()});
            case PAYPAL_BILLING_AGREEMENT:
                return resources.getString(2131238335);
            case MANUAL_TRANSFER:
                return resources.getString(2131238336);
            case PAY_OVER_COUNTER:
                return resources.getString(2131238337);
            case NET_BANKING:
                return resources.getString(2131238339);
            default:
                return "";
        }
    }
}

package com.facebook.payments.paymentmethods.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* compiled from: suggestifier_footer_thank_you_text */
public class FbPaymentCardUtil {
    public static boolean m2174a(FbPaymentCard fbPaymentCard) {
        Calendar instance = GregorianCalendar.getInstance();
        int i = instance.get(1);
        int i2 = instance.get(2) + 1;
        int parseInt = Integer.parseInt(fbPaymentCard.mo96c());
        int parseInt2 = Integer.parseInt(fbPaymentCard.mo97d());
        if (i > parseInt2) {
            return true;
        }
        if (i != parseInt2 || i2 <= parseInt) {
            return false;
        }
        return true;
    }
}

package com.facebook.commerce.core.util;

import com.facebook.commerce.core.util.CommerceConstants.PaymentProvider;

/* compiled from: pre */
public class CommerceMerchantUtil {
    private CommerceMerchantUtil() {
    }

    public static boolean m10678a(int i, boolean z) {
        return m10677a(i) && z;
    }

    public static boolean m10677a(int i) {
        return i == PaymentProvider.f7552a;
    }
}

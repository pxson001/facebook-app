package com.facebook.payments.model;

import java.math.BigDecimal;

/* compiled from: target_data */
public class PriceFormatter {
    public static String m1959a(CurrencyAmount currencyAmount) {
        return currencyAmount.toString();
    }

    @Deprecated
    public static String m1960a(String str, BigDecimal bigDecimal) {
        return m1959a(new CurrencyAmount(str, bigDecimal));
    }
}

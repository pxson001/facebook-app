package com.facebook.common.util;

import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;

/* compiled from: share_preview_story_placeholder */
public class FinanceUtils {
    private FinanceUtils() {
    }

    public static String m3901a(String str, long j, int i) {
        Preconditions.checkArgument(i >= 0);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        currencyInstance.setCurrency(Currency.getInstance(str));
        currencyInstance.setMinimumFractionDigits(i);
        currencyInstance.setMaximumFractionDigits(i);
        return currencyInstance.format(new BigDecimal(j).divide(new BigDecimal(100))).replaceAll("\\s", "");
    }
}

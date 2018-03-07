package com.facebook.payments.currency;

import android.content.Context;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/* compiled from: isAutoTag */
public class CurrencyConfig {
    public static ImmutableList<String> m19187a(Context context) {
        if (LocalizedCurrencyConfig.f12290a == null) {
            LocalizedCurrencyConfig.m19192c(context);
        }
        ImmutableList<String> immutableList = LocalizedCurrencyConfig.f12290a;
        if (immutableList == null || immutableList.isEmpty()) {
            return DefaultCurrencyConfig.f12288a;
        }
        return immutableList;
    }

    public static String m19188a(Context context, String str) {
        if (LocalizedCurrencyConfig.f12291b == null) {
            LocalizedCurrencyConfig.m19192c(context);
        }
        ImmutableMap immutableMap = LocalizedCurrencyConfig.f12291b;
        if (immutableMap != null && immutableMap.containsKey(str)) {
            return (String) ((ImmutableMap) immutableMap.get(str)).get("name");
        }
        immutableMap = DefaultCurrencyConfig.f12289b;
        if (immutableMap != null && immutableMap.containsKey(str)) {
            return (String) ((ImmutableMap) immutableMap.get(str)).get("name");
        }
        throw new IllegalArgumentException("Unsupported currency " + str);
    }
}

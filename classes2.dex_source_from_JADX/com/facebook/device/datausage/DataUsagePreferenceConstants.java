package com.facebook.device.datausage;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: liger  */
public class DataUsagePreferenceConstants {
    public static final PrefKey f17618a;
    public static final PrefKey f17619b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("data_usage/");
        f17618a = prefKey;
        f17619b = (PrefKey) prefKey.m2011a("data_usage_detailed_logging");
    }
}

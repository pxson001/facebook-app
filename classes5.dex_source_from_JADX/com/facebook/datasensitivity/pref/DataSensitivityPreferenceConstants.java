package com.facebook.datasensitivity.pref;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: _msec */
public class DataSensitivityPreferenceConstants {
    public static final PrefKey f11769a;
    public static final PrefKey f11770b;
    public static final PrefKey f11771c = ((PrefKey) f11769a.a("auto_mode_enabled"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("data_sensitivity/");
        f11769a = prefKey;
        f11770b = (PrefKey) prefKey.a("data_savings_mode_enabled");
    }
}

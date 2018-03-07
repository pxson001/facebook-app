package com.facebook.messaging.lowdatamode;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: selected privacy option is empty */
public class LowDataModePrefKeys {
    @Deprecated
    public static final PrefKey f3021a;
    public static final PrefKey f3022b = ((PrefKey) f3023c.a("low_data_mode_nux_anchor"));
    private static final PrefKey f3023c;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.c.a("low_data_mode/");
        f3023c = prefKey;
        f3021a = (PrefKey) prefKey.a("low_data_mode_enabled");
    }
}

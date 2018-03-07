package com.facebook.aldrin.status.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: ispx_plc */
public class AldrinStatusPrefKeys {
    public static final PrefKey f9755a;
    private static final PrefKey f9756b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("aldrin_status/");
        f9756b = prefKey;
        f9755a = (PrefKey) prefKey.a("aldrin_status_cached_data");
    }
}

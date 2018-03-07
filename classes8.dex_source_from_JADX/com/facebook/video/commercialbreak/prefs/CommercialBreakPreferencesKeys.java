package com.facebook.video.commercialbreak.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: location_settings_perf_render */
public class CommercialBreakPreferencesKeys {
    public static final PrefKey f9778a;
    private static final PrefKey f9779b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("commercial_break/");
        f9779b = prefKey;
        f9778a = (PrefKey) prefKey.a("debug_toasts");
    }
}

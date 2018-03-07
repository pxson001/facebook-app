package com.facebook.abtest.qe.sessionlessqe;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: enabled_temp_modules */
public class SessionlessQuickExperimentConfigPrefKeys {
    public static final PrefKey f13087a;
    public static final PrefKey f13088b;
    public static final PrefKey f13089c = ((PrefKey) f13087a.a("last_fetch_locale"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.d.a("sessionlessqe/");
        f13087a = prefKey;
        f13088b = (PrefKey) prefKey.a("last_fetch_time_ms");
    }

    protected SessionlessQuickExperimentConfigPrefKeys() {
    }
}

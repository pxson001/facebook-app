package com.facebook.location.foreground;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: is_promoted */
class ForegroundLocationPrefKeys {
    static final PrefKey f9920a;
    static final PrefKey f9921b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("foreground_location/");
        f9920a = prefKey;
        f9921b = (PrefKey) prefKey.a("last_request_time_ms");
    }

    private ForegroundLocationPrefKeys() {
    }
}

package com.facebook.gk.internal;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: zoom_threshold */
public class SessionlessGkPrefKeys {
    public static final PrefKey f43a;
    public static final PrefKey f44b;
    public static final PrefKey f45c = ((PrefKey) f43a.a("last_fetch_keys_hash"));
    public static final PrefKey f46d = ((PrefKey) f43a.a("values/"));
    public static final PrefKey f47e = ((PrefKey) f43a.a("version"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.d.a("sessionless_gk/");
        f43a = prefKey;
        f44b = (PrefKey) prefKey.a("last_fetch_time_ms");
    }

    private SessionlessGkPrefKeys() {
    }
}

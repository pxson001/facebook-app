package com.facebook.gk.internal;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: time_elapsed_since_fetch_attempt */
public class GkPrefKeys {
    public static final PrefKey f2939a;
    public static final PrefKey f2940b;
    public static final PrefKey f2941c = ((PrefKey) f2939a.m2011a("last_fetch_time_ms"));
    public static final PrefKey f2942d = ((PrefKey) f2939a.m2011a("last_fetch_hash"));
    public static final PrefKey f2943e = ((PrefKey) f2939a.m2011a("last_check_time_ms"));
    public static final PrefKey f2944f = ((PrefKey) f2939a.m2011a("last_fetch_keys_hash"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f990d.m2011a("gk/");
        f2939a = prefKey;
        f2940b = (PrefKey) prefKey.m2011a("values/");
    }
}

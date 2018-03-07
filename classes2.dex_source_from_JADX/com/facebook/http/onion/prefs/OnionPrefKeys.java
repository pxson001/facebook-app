package com.facebook.http.onion.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: sent */
public class OnionPrefKeys {
    public static final PrefKey f5574a;
    public static final PrefKey f5575b;
    public static final PrefKey f5576c = ((PrefKey) f5574a.m2011a("tor_enabled"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("onion/");
        f5574a = prefKey;
        f5575b = (PrefKey) prefKey.m2011a("rewrite_enabled");
    }
}

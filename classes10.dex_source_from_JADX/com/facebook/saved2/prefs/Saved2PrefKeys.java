package com.facebook.saved2.prefs;

import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: instant_shopping_catalog_session_id */
public class Saved2PrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f9441a;
    public static final PrefKey f9442b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("saved2/");
        f9441a = prefKey;
        f9442b = (PrefKey) prefKey.a("has_fetched_since_login/");
    }

    public static PrefKey m9711a(String str) {
        return (PrefKey) f9442b.a(str);
    }

    public final ImmutableSet<PrefKey> m9712b() {
        return ImmutableSet.of(f9441a);
    }
}

package com.facebook.platform.auth;

import com.facebook.platform.common.prefs.PlatformPrefKeys;
import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.collect.ImmutableSet;

/* compiled from: location_services_enabled */
public class NativeGdpPrefsKeys implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f8448a;
    public static final PrefKey f8449b;

    static {
        PrefKey prefKey = (PrefKey) PlatformPrefKeys.a.a("nativegdp/");
        f8448a = prefKey;
        f8449b = (PrefKey) prefKey.a("nux_status_count");
    }

    public final ImmutableSet<PrefKey> m8373a() {
        return ImmutableSet.of(f8448a);
    }
}

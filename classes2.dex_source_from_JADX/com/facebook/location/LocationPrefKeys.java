package com.facebook.location;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: launch */
public class LocationPrefKeys {
    public static final PrefKey f17767a;
    public static final PrefKey f17768b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f991e.m2011a("location/");
        f17767a = prefKey;
        f17768b = (PrefKey) prefKey.m2011a("location_implementation");
    }
}

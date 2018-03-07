package com.facebook.feed.firstlaunch;

import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: messenger_payments_sync_v3_android */
public class FirstLaunchSharedPrefs implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f13834a;
    private static final PrefKey f13835b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("feed_first_launch/");
        f13835b = prefKey;
        f13834a = (PrefKey) prefKey.m2011a("auth_finished_at");
    }

    public final ImmutableSet<PrefKey> mo1206a() {
        return ImmutableSet.of(f13834a);
    }
}

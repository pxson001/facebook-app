package com.facebook.goodwill.feed.data;

import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: Videohome force prefetching */
public class ThrowbackFeedPrefKeys implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f21081a;
    public static final PrefKey f21082b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("throwback/");
        f21081a = prefKey;
        f21082b = (PrefKey) prefKey.a("megaphone_last_dismissed");
    }

    public final ImmutableSet<PrefKey> m22045a() {
        return ImmutableSet.of(f21082b);
    }
}

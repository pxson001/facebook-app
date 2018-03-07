package com.facebook.friending.newuserpromotion;

import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: field_value */
public class NewUserFriendingPrefKeys implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f13373a;
    public static final PrefKey f13374b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("friending/");
        f13373a = prefKey;
        f13374b = (PrefKey) prefKey.a("impression_time");
    }

    public final ImmutableSet<PrefKey> m15010a() {
        return ImmutableSet.of(f13374b);
    }
}

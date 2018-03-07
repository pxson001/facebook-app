package com.facebook.growth.prefs;

import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: total_cost */
public class GrowthPrefKeys implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f902a;
    public static final PrefKey f903b;
    private static final PrefKey f904c = ((PrefKey) f902a.a("growth_ci_continuous_sync/"));
    private static final PrefKey f905d = ((PrefKey) f902a.a("reg_ccu_terms_accepted/"));
    private static final PrefKey f906e = ((PrefKey) f902a.a("reg_profile_photo_step_seen/"));
    private static final PrefKey f907f = ((PrefKey) f902a.a("friendable_contacts_count"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("growth/");
        f902a = prefKey;
        f903b = (PrefKey) prefKey.a("user_account_nux_shown");
    }

    public final ImmutableSet<PrefKey> m1231a() {
        return ImmutableSet.of(f903b);
    }

    public static PrefKey m1227a(String str) {
        return (PrefKey) f904c.a(str);
    }

    public static PrefKey m1228b(String str) {
        return (PrefKey) f905d.a(str);
    }

    public static PrefKey m1229c(String str) {
        return (PrefKey) f906e.a(str);
    }

    public static PrefKey m1230d(String str) {
        return (PrefKey) f907f.a(str);
    }
}

package com.facebook.abtest.qe.data;

import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: error_msg */
public class QuickExperimentConfigPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f12797a;
    public static final PrefKey f12798b;
    public static final PrefKey f12799c = ((PrefKey) f12797a.a("last_fetch_time_ms"));
    public static final PrefKey f12800d = ((PrefKey) f12797a.a("last_fetch_locale"));
    public static final PrefKey f12801e = ((PrefKey) f12797a.a("expire_ttl_ms_override"));
    public static final PrefKey f12802f = ((PrefKey) f12797a.a("experiments_filter"));
    public static final PrefKey f12803g = ((PrefKey) f12797a.a("first_visible_item_index"));
    public static final PrefKey f12804h = ((PrefKey) f12797a.a("first_visible_item_offset"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.d.a("qe/");
        f12797a = prefKey;
        f12798b = (PrefKey) prefKey.a("latest_users");
    }

    public final ImmutableSet<PrefKey> m13651b() {
        return ImmutableSet.of(f12799c, f12800d, f12801e);
    }
}

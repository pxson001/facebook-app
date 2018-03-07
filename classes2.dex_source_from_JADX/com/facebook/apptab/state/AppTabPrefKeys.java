package com.facebook.apptab.state;

import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: reaction_android_profile_ids */
public class AppTabPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f8140a;
    public static final PrefKey f8141b = ((PrefKey) f8144e.m2011a("next_memory_config"));
    public static final PrefKey f8142c = ((PrefKey) f8144e.m2011a("next_polling_config"));
    public static final PrefKey f8143d = ((PrefKey) f8144e.m2011a("tab_nux"));
    private static final PrefKey f8144e;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f990d.m2011a("apptab/");
        f8144e = prefKey;
        f8140a = (PrefKey) prefKey.m2011a("next_immersive_tab_config");
    }

    public final ImmutableSet<PrefKey> mo671b() {
        return ImmutableSet.of(f8140a, f8141b, f8142c);
    }
}

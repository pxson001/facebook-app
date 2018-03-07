package com.facebook.saved.prefs;

import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: interface */
public class SavedPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f19743a;
    public static final PrefKey f19744b;
    public static final PrefKey f19745c = ((PrefKey) f19743a.m2011a("has_ever_saved"));
    public static final PrefKey f19746d = ((PrefKey) f19743a.m2011a("last_save_date"));
    public static final PrefKey f19747e = ((PrefKey) f19743a.m2011a("dashboard_loaded_since_login"));
    public static final PrefKey f19748f = ((PrefKey) f19743a.m2011a("has_pending_saved_bookmark_nux"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("saved/");
        f19743a = prefKey;
        f19744b = (PrefKey) prefKey.m2011a("has_seen_saved_dashboard_interstitial");
    }

    public final ImmutableSet<PrefKey> mo671b() {
        return ImmutableSet.of(f19744b, f19745c, f19747e, f19748f);
    }
}

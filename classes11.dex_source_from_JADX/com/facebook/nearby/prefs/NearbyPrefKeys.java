package com.facebook.nearby.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: unexpected object type  */
public class NearbyPrefKeys {
    public static final PrefKey f507a;
    public static final PrefKey f508b;
    public static final PrefKey f509c;
    public static final PrefKey f510d = ((PrefKey) f508b.a("restore_button_nux_completed"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("nearby/");
        f507a = prefKey;
        prefKey = (PrefKey) prefKey.a("nux/");
        f508b = prefKey;
        f509c = (PrefKey) prefKey.a("search_button_nux_completed");
    }
}

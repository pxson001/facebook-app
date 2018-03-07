package com.facebook.composer.minutiae.prefs;

import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: timespent_watching_video */
public class MinutiaePrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f1613a;
    public static final PrefKey f1614b;
    public static final PrefKey f1615c = ((PrefKey) f1613a.a("minutiae_reshare_composer_nux"));
    public static final PrefKey f1616d = ((PrefKey) f1613a.a("ridge_opt_in"));
    public static final PrefKey f1617e = ((PrefKey) f1613a.a("ridge_enabled"));
    public static final PrefKey f1618f = ((PrefKey) f1613a.a("ridge_full_nux"));
    public static final PrefKey f1619g = ((PrefKey) f1613a.a("ridge_nux_dismiss"));
    public static final PrefKey f1620h = ((PrefKey) f1613a.a("last_minutiae_opened"));
    public static final PrefKey f1621i = ((PrefKey) f1613a.a("ridge_composer_toolip"));
    public static final PrefKey f1622j = ((PrefKey) f1613a.a("ridge_tooltip_nux_impressions"));
    public static final PrefKey f1623k = ((PrefKey) f1613a.a("ridge_post_optout_tooltip_seen"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("minutiae/");
        f1613a = prefKey;
        f1614b = (PrefKey) prefKey.a("minutiae_composer_nux");
    }

    public final ImmutableSet<PrefKey> m1665b() {
        return ImmutableSet.of(f1614b, f1615c, f1616d, f1618f, f1617e, f1619g, new PrefKey[]{f1622j, f1623k});
    }
}

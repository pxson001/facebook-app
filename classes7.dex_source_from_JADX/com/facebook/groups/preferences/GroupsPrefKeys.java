package com.facebook.groups.preferences;

import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: profile_timeline_scroll */
public class GroupsPrefKeys implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f5806a;
    public static final PrefKey f5807b;
    public static final PrefKey f5808c;
    public static final PrefKey f5809d = ((PrefKey) f5807b.a("mall_friends_nag_seen/"));
    public static final PrefKey f5810e = ((PrefKey) f5807b.a("friends_nag_impressions/"));
    public static final PrefKey f5811f = ((PrefKey) f5806a.a("groups_sort_filter/"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("groups/");
        f5806a = prefKey;
        prefKey = (PrefKey) prefKey.a("nux/");
        f5807b = prefKey;
        f5808c = (PrefKey) prefKey.a("mall_visits_count/");
    }

    public final ImmutableSet<PrefKey> m7208a() {
        return ImmutableSet.of(f5808c, f5809d, f5810e, f5811f);
    }
}

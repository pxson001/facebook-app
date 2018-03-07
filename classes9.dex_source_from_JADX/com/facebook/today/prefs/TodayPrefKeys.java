package com.facebook.today.prefs;

import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: turn_user_id */
public class TodayPrefKeys implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f1229a;
    public static final PrefKey f1230b;
    public static final PrefKey f1231c = ((PrefKey) f1229a.a("has_seen_today_nux_animation"));
    public static final PrefKey f1232d = ((PrefKey) f1229a.a("has_seen_today_nux_interstitial"));
    public static final PrefKey f1233e = ((PrefKey) f1229a.a("last_seen"));
    public static final PrefKey f1234f = ((PrefKey) f1229a.a("location_history_changed"));
    public static final PrefKey f1235g = ((PrefKey) f1229a.a("location_service_enabled"));
    public static final PrefKey f1236h = ((PrefKey) f1229a.a("notification_expanded"));
    public static final PrefKey f1237i = ((PrefKey) f1229a.a("nux_banner_trigger_count"));
    public static final PrefKey f1238j = ((PrefKey) f1229a.a("nux_scroll_trigger_count"));
    public static final PrefKey f1239k = ((PrefKey) f1229a.a("power_user_expansion_count"));
    public static final PrefKey f1240l = ((PrefKey) f1229a.a("power_user_expansion_timer"));
    public static final PrefKey f1241m = ((PrefKey) f1229a.a("should_upsell_location"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("today/");
        f1229a = prefKey;
        f1230b = (PrefKey) prefKey.a("has_closed_today_nux_banner");
    }

    public final ImmutableSet<PrefKey> m1389a() {
        return ImmutableSet.of(f1229a);
    }
}

package com.facebook.privacy;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: since_boot_clock_now_ms */
public class PrivacyPrefKeys implements IHaveNonCriticalKeysToClear, IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f2159a;
    public static final PrefKey f2160b;
    @Deprecated
    public static final PrefKey f2161c = ((PrefKey) f2159a.a("breakfast_club_composer_nux_v2"));
    @Deprecated
    public static final PrefKey f2162d = ((PrefKey) f2159a.a("small_audience_privacy_nux"));
    @Deprecated
    public static final PrefKey f2163e = ((PrefKey) f2159a.a("small_audience_privacy_nux_config"));
    public static final PrefKey f2164f = ((PrefKey) f2159a.a("REVIEW_PRIVACY_REMINDER_NUX"));
    public static final PrefKey f2165g = ((PrefKey) f2159a.a("education_banner_nux_config"));
    public static final PrefKey f2166h = ((PrefKey) f2159a.a("audience_alignment_should_show_tux"));
    public static final PrefKey f2167i = ((PrefKey) f2159a.a("audience_alignment_only_me_should_show_tux"));
    public static final PrefKey f2168j = ((PrefKey) f2159a.a("newcomer_audience_should_show_selector"));
    public static final PrefKey f2169k = ((PrefKey) f2159a.a("newcomer_audience_seen_selector"));
    public static final PrefKey f2170l = ((PrefKey) f2159a.a("sticky_guardrail_config"));
    public static final PrefKey f2171m = ((PrefKey) f2159a.a("default_privacy_client_override"));
    public static final PrefKey f2172n = ((PrefKey) f2159a.a("default_privacy_enabled"));
    public static final PrefKey f2173o = ((PrefKey) f2159a.a("inline_privacy_survey_config"));
    @Deprecated
    public static final PrefKey f2174p = ((PrefKey) f2159a.a("alignment_roadblock_preference"));
    @Deprecated
    public static final PrefKey f2175q = ((PrefKey) f2159a.a("alignment_roadblock_impressions"));
    @Deprecated
    public static final PrefKey f2176r = ((PrefKey) f2159a.a("alignment_roadblock_finished_state"));
    @Deprecated
    private static final PrefKey f2177s = ((PrefKey) f2159a.a("audience_alignment_should_show_roadblock"));
    @Deprecated
    private static final PrefKey f2178t = ((PrefKey) f2159a.a("audience_alignment_seen_tux"));

    public static PrivacyPrefKeys m2318a(InjectorLike injectorLike) {
        return new PrivacyPrefKeys();
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("privacy/");
        f2159a = prefKey;
        f2160b = (PrefKey) prefKey.a("selected_privacy_option");
    }

    public final ImmutableSet<PrefKey> m2320b() {
        return ImmutableSet.of(f2160b, f2170l, f2171m, f2172n, f2173o, f2174p, new PrefKey[0]);
    }

    public final ImmutableSet<PrefKey> m2319a() {
        return ImmutableSet.of(f2161c, f2162d, f2163e, f2164f, f2166h, f2167i, new PrefKey[]{f2177s, f2178t, f2165g, f2168j, f2169k, f2175q});
    }
}

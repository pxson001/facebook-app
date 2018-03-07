package com.facebook.katana.prefs;

import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.vault.prefs.VaultPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: ip_addr */
public class FbandroidPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f19409a;
    public static final PrefKey f19410b;
    public static final PrefKey f19411c = ((PrefKey) f19409a.m2011a("uvm/"));
    public static final PrefKey f19412d = ((PrefKey) f19409a.m2011a("events/"));
    public static final PrefKey f19413e = ((PrefKey) f19409a.m2011a("client_time_offset_via_login_approvals/"));
    public static final PrefKey f19414f = ((PrefKey) f19409a.m2011a("login_approvals_secret/"));
    public static final PrefKey f19415g = ((PrefKey) f19409a.m2011a("video_spec_display"));
    public static final PrefKey f19416h = ((PrefKey) f19409a.m2011a("video_inline_unmute"));
    public static final PrefKey f19417i = ((PrefKey) f19409a.m2011a("video_logging_level"));
    public static final PrefKey f19418j = ((PrefKey) f19409a.m2011a("video_home_force_prefetch"));
    public static final PrefKey f19419k = ((PrefKey) f19409a.m2011a("video_home_prefetch_toast"));
    public static final PrefKey f19420l = ((PrefKey) f19409a.m2011a("in_progress_login_timestamp"));
    public static final PrefKey f19421m = ((PrefKey) f19409a.m2011a("last_login_time"));
    public static final PrefKey f19422n = ((PrefKey) f19409a.m2011a("last_username"));
    public static final PrefKey f19423o = ((PrefKey) f19409a.m2011a("hashed_uid"));
    public static final PrefKey f19424p = ((PrefKey) f19409a.m2011a("last_logout_time"));
    public static final PrefKey f19425q = ((PrefKey) f19409a.m2011a("intern_settings_history"));
    public static final PrefKey f19426r = ((PrefKey) f19409a.m2011a("jewel_footer_promo_times_shown_since_last_reset"));
    public static final PrefKey f19427s = ((PrefKey) f19409a.m2011a("jewel_footer_promo_times_shown_total"));
    public static final PrefKey f19428t = ((PrefKey) f19409a.m2011a("jewel_footer_promo_last_shown_secs"));
    public static final PrefKey f19429u = ((PrefKey) f19409a.m2011a("in_app_browser_profiling"));
    public static final PrefKey f19430v = ((PrefKey) f19409a.m2011a("in_app_browser_debug_overlay"));
    public static final PrefKey f19431w = ((PrefKey) f19409a.m2011a("video_debug_mode"));
    public static final PrefKey f19432x = ((PrefKey) f19409a.m2011a("login_broadcasted_cross_app"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("fb_android/");
        f19409a = prefKey;
        f19410b = (PrefKey) prefKey.m2011a("kvm/");
    }

    public final ImmutableSet<PrefKey> mo671b() {
        return ImmutableSet.of(FeedPrefKeys.f5752p, VaultPrefKeys.a, f19432x);
    }
}

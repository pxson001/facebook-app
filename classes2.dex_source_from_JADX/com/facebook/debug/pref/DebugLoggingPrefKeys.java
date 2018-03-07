package com.facebook.debug.pref;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: time_spent_pending_ms */
public class DebugLoggingPrefKeys {
    public static final PrefKey f2803a;
    public static final PrefKey f2804b;
    public static final PrefKey f2805c = ((PrefKey) f2803a.m2011a("logging_level"));
    public static final PrefKey f2806d = ((PrefKey) SharedPrefKeys.f989c.m2011a("perfmarker_to_logcat"));
    public static final PrefKey f2807e = ((PrefKey) f2803a.m2011a("thread_tracking"));
    public static final PrefKey f2808f = ((PrefKey) f2803a.m2011a("data_connection_overlay"));
    public static final PrefKey f2809g = ((PrefKey) f2803a.m2011a("nonemployee_mode"));
    public static final PrefKey f2810h = ((PrefKey) f2803a.m2011a("home_stories_overlay"));
    public static final PrefKey f2811i = ((PrefKey) f2803a.m2011a("fresh_feed_overlay"));
    public static final PrefKey f2812j = ((PrefKey) f2803a.m2011a("components_conversion_overlay"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f989c.m2011a("logging/");
        f2803a = prefKey;
        f2804b = (PrefKey) prefKey.m2011a("debug_logs");
    }
}

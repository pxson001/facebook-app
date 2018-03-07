package com.facebook.backgroundlocation.reporting;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: item_comment */
public class BackgroundLocationReportingPrefKeys {
    public static final PrefKey f9727a;
    public static final PrefKey f9728b = ((PrefKey) f9730d.a("last_refresh_time_ms"));
    static final PrefKey f9729c = ((PrefKey) f9730d.a("high_frequency_end_time"));
    private static final PrefKey f9730d;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("background_location_reporting/");
        f9730d = prefKey;
        f9727a = (PrefKey) prefKey.a("location_history_enabled");
    }

    private BackgroundLocationReportingPrefKeys() {
    }
}

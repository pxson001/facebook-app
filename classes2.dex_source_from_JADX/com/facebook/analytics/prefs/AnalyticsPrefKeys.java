package com.facebook.analytics.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: share_link */
public class AnalyticsPrefKeys {
    public static final PrefKey f4979a;
    public static final PrefKey f4980b;
    public static final PrefKey f4981c = ((PrefKey) f4979a.m2011a("batch_size"));
    public static final PrefKey f4982d = ((PrefKey) f4979a.m2011a("contacts_upload_interval"));
    public static final PrefKey f4983e = ((PrefKey) f4979a.m2011a("device_info_interval"));
    public static final PrefKey f4984f = ((PrefKey) f4979a.m2011a("device_stat_interval"));
    public static final PrefKey f4985g = ((PrefKey) f4979a.m2011a("user_logged_in"));
    public static final PrefKey f4986h = ((PrefKey) f4979a.m2011a("sampling_config"));
    public static final PrefKey f4987i = ((PrefKey) f4979a.m2011a("sampling_config_checksum"));
    public static final PrefKey f4988j = ((PrefKey) f4979a.m2011a("periodic_events_last_sent"));
    private static final PrefKey f4989k = ((PrefKey) f4979a.m2011a("device_info_need_upload_phone/"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f989c.m2011a("analytics");
        f4979a = prefKey;
        f4980b = (PrefKey) prefKey.m2011a("process_stat_interval");
    }

    public static PrefKey m8909a(String str) {
        return (PrefKey) f4989k.m2011a(str);
    }
}

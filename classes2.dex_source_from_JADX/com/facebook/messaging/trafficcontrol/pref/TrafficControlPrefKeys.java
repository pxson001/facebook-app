package com.facebook.messaging.trafficcontrol.pref;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: fetched_at */
public class TrafficControlPrefKeys {
    public static final PrefKey f23792a;
    public static final PrefKey f23793b;
    public static final PrefKey f23794c = ((PrefKey) f23792a.m2011a("last_enabled"));
    public static final PrefKey f23795d = ((PrefKey) f23792a.m2011a("last_expired"));
    public static final PrefKey f23796e = ((PrefKey) f23792a.m2011a("last_wall"));
    public static final PrefKey f23797f = ((PrefKey) f23792a.m2011a("last_auto_on_time"));
    public static final PrefKey f23798g = ((PrefKey) f23792a.m2011a("auto_on_count"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f989c.m2011a("2gempathy");
        f23792a = prefKey;
        f23793b = (PrefKey) prefKey.m2011a("enabled");
    }
}

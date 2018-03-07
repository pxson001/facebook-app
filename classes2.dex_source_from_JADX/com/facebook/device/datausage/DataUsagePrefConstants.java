package com.facebook.device.datausage;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: liger_android_http2 */
public class DataUsagePrefConstants {
    static final PrefKey f17612a;
    public static final PrefKey f17613b;
    public static final PrefKey f17614c = ((PrefKey) f17612a.m2011a("data_sent"));
    public static final PrefKey f17615d = ((PrefKey) f17612a.m2011a("last_sync_date"));
    public static final PrefKey f17616e = ((PrefKey) f17612a.m2011a("data_received_offset"));
    public static final PrefKey f17617f = ((PrefKey) f17612a.m2011a("data_sent_offset"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("data_usage/");
        f17612a = prefKey;
        f17613b = (PrefKey) prefKey.m2011a("data_received");
    }
}

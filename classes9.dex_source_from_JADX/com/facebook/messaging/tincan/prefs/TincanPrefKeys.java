package com.facebook.messaging.tincan.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: click_pickup_location_row */
public class TincanPrefKeys {
    public static final PrefKey f18076a;
    public static final PrefKey f18077b;
    public static final PrefKey f18078c = ((PrefKey) f18076a.a("show_error_toasts"));
    public static final PrefKey f18079d = ((PrefKey) f18076a.a("mangle_accept_packets"));
    public static final PrefKey f18080e = ((PrefKey) f18076a.a("mangle_accept_crypto"));
    public static final PrefKey f18081f = ((PrefKey) f18076a.a("mangle_salamanders"));
    public static final PrefKey f18082g = ((PrefKey) f18076a.a("mangle_empty_salamanders"));
    public static final PrefKey f18083h = ((PrefKey) f18076a.a("mangle_request_packets"));
    public static final PrefKey f18084i = ((PrefKey) f18076a.a("mangle_empty_request"));
    public static final PrefKey f18085j = ((PrefKey) f18076a.a("mangle_id_key"));
    public static final PrefKey f18086k = ((PrefKey) f18076a.a("mangle_request_no_body"));
    public static final PrefKey f18087l = ((PrefKey) f18076a.a("mangle_request_wrong_body"));
    public static final PrefKey f18088m = ((PrefKey) f18076a.a("mangle_salamander_crypto"));
    public static final PrefKey f18089n = ((PrefKey) f18076a.a("mangle_salamander_no_body"));
    public static final PrefKey f18090o = ((PrefKey) f18076a.a("mangle_salamander_wrong_body"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("tincan/");
        f18076a = prefKey;
        f18077b = (PrefKey) prefKey.a("use_out_dev");
    }
}

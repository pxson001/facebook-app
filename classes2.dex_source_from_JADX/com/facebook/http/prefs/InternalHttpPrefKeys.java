package com.facebook.http.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: tls_cache_persistence */
public class InternalHttpPrefKeys {
    public static final PrefKey f2505A = ((PrefKey) f2526u.m2011a("fetch_more_messages"));
    public static final PrefKey f2506a;
    public static final PrefKey f2507b;
    public static final PrefKey f2508c = ((PrefKey) f2506a.m2011a("wirehog_profiling"));
    public static final PrefKey f2509d = ((PrefKey) f2506a.m2011a("teak_profiling"));
    public static final PrefKey f2510e = ((PrefKey) f2506a.m2011a("fbtrace"));
    public static final PrefKey f2511f = ((PrefKey) f2506a.m2011a("artillery"));
    public static final PrefKey f2512g = ((PrefKey) f2506a.m2011a("debug_show_queue"));
    public static final PrefKey f2513h = ((PrefKey) f2506a.m2011a("log_http_queue_events"));
    public static final PrefKey f2514i = ((PrefKey) f2506a.m2011a("carrier_id"));
    public static final PrefKey f2515j = ((PrefKey) f2506a.m2011a("check_certs"));
    public static final PrefKey f2516k = ((PrefKey) f2506a.m2011a("user_certs"));
    public static final PrefKey f2517l = ((PrefKey) f2506a.m2011a("http_proxy"));
    public static final PrefKey f2518m = ((PrefKey) f2506a.m2011a("empathy"));
    public static final PrefKey f2519n = ((PrefKey) f2506a.m2011a("liger_trace_event"));
    public static final PrefKey f2520o;
    public static final PrefKey f2521p;
    public static final PrefKey f2522q;
    public static final PrefKey f2523r = ((PrefKey) f2521p.m2011a("sandbox"));
    public static final PrefKey f2524s = ((PrefKey) f2521p.m2011a("weinre"));
    public static final PrefKey f2525t = ((PrefKey) f2521p.m2011a("upload"));
    public static final PrefKey f2526u;
    public static final PrefKey f2527v;
    public static final PrefKey f2528w = ((PrefKey) f2526u.m2011a("fetch_more_threads"));
    public static final PrefKey f2529x = ((PrefKey) f2526u.m2011a("fetch_thread"));
    public static final PrefKey f2530y = ((PrefKey) f2526u.m2011a("fetch_multiple_threads"));
    public static final PrefKey f2531z = ((PrefKey) f2526u.m2011a("fetch_group_threads"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f989c.m2011a("http/");
        f2506a = prefKey;
        f2507b = (PrefKey) prefKey.m2011a("php_profiling");
        prefKey = (PrefKey) SharedPrefKeys.f989c.m2011a("sandbox/");
        f2520o = prefKey;
        prefKey = (PrefKey) prefKey.m2011a("web/");
        f2521p = prefKey;
        f2522q = (PrefKey) prefKey.m2011a("server_tier");
        prefKey = (PrefKey) SharedPrefKeys.f989c.m2011a("fetch_alerts/");
        f2526u = prefKey;
        f2527v = (PrefKey) prefKey.m2011a("fetch_thread_list");
    }
}

package com.facebook.appirater;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: send_contacts_async */
public class AppiraterPrefKeys {
    static final PrefKey f2842a;
    public static final PrefKey f2843b;
    static final PrefKey f2844c = ((PrefKey) f2842a.a("reminder_request_date"));
    static final PrefKey f2845d = ((PrefKey) f2842a.a("use_count"));
    static final PrefKey f2846e = ((PrefKey) f2842a.a("event_count"));
    static final PrefKey f2847f = ((PrefKey) f2842a.a("last_seen_version"));
    public static final PrefKey f2848g = ((PrefKey) f2842a.a("last_rated_version"));
    public static final PrefKey f2849h = ((PrefKey) f2842a.a("last_declined_version"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("appirater/");
        f2842a = prefKey;
        f2843b = (PrefKey) prefKey.a("first_use");
    }
}

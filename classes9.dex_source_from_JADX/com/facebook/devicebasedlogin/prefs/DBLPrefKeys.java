package com.facebook.devicebasedlogin.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: personal_transfer_eligible */
public class DBLPrefKeys {
    public static final PrefKey f6631a;
    public static final PrefKey f6632b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.c.a("dbl/");
        f6631a = prefKey;
        f6632b = (PrefKey) prefKey.a("has_seen_tooltip/");
    }

    public static PrefKey m6947a(String str) {
        return (PrefKey) f6632b.a(str);
    }
}

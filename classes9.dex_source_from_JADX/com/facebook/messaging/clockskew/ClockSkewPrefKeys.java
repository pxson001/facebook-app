package com.facebook.messaging.clockskew;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: messenger_pay_history_loader_result */
public class ClockSkewPrefKeys {
    public static final PrefKey f9767a;
    private static final PrefKey f9768b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.c.a("clock_skew/");
        f9768b = prefKey;
        f9767a = (PrefKey) prefKey.a("last_known_skew");
    }
}

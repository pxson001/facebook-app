package com.facebook.aldrin.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: lineBreak */
public class AldrinPrefKeys {
    public static final PrefKey f10343a;
    public static final PrefKey f10344b = ((PrefKey) f10346d.a("aldrin_status_last_fetch_fail_time"));
    public static final PrefKey f10345c = ((PrefKey) f10346d.a("aldrin_status_last_fetch_fail_cooldown_time"));
    private static final PrefKey f10346d;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("aldrin/");
        f10346d = prefKey;
        f10343a = (PrefKey) prefKey.a("aldrin_status_last_fetch_success_time");
    }
}

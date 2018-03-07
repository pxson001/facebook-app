package com.facebook.fbui.runtimelinter;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: qp/%s?fallback_url=%s */
public class RuntimeLinterPrefKeys {
    public static final PrefKey f8519a;
    public static final PrefKey f8520b;
    public static final Boolean f8521c = Boolean.valueOf(false);

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f989c.m2011a("linter/");
        f8519a = prefKey;
        f8520b = (PrefKey) prefKey.m2011a("enable");
    }
}

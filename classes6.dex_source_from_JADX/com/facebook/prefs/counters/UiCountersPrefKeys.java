package com.facebook.prefs.counters;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: sticker_uri */
public class UiCountersPrefKeys {
    public static final PrefKey f4115a;
    public static final PrefKey f4116b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("messages/");
        f4115a = prefKey;
        f4116b = (PrefKey) prefKey.a("ui_counters/");
    }
}

package com.facebook.messengerwear.support;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: getImmutableIndex */
public class MessengerWearPrefKeys {
    public static final PrefKey f11146a;
    public static final PrefKey f11147b;
    public static final PrefKey f11148c = ((PrefKey) f11146a.a("wear_app_paired"));
    public static final PrefKey f11149d = ((PrefKey) f11146a.a("wear_app_soft_alarm"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("messenger_wear/");
        f11146a = prefKey;
        f11147b = (PrefKey) prefKey.a("wear_app_reachable");
    }
}

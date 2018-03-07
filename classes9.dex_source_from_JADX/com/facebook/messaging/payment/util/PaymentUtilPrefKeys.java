package com.facebook.messaging.payment.util;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: extra_transfer_status */
public class PaymentUtilPrefKeys {
    public static final PrefKey f15173a;
    public static final PrefKey f15174b;
    public static final PrefKey f15175c;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.c.a("messages/");
        f15173a = prefKey;
        prefKey = (PrefKey) prefKey.a("notifications/");
        f15174b = prefKey;
        f15175c = (PrefKey) prefKey.a("in_app_sounds_enabled");
    }
}

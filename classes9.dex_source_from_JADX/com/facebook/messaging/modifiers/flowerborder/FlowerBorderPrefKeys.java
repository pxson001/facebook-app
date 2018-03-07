package com.facebook.messaging.modifiers.flowerborder;

import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.PrefKey;

/* compiled from: key_permissions */
public class FlowerBorderPrefKeys {
    public static final PrefKey f12270a;
    private static final PrefKey f12271b;

    static {
        PrefKey prefKey = (PrefKey) MessagingPrefKeys.c.a("flower_border/");
        f12271b = prefKey;
        f12270a = (PrefKey) prefKey.a("show_entry_points");
    }
}

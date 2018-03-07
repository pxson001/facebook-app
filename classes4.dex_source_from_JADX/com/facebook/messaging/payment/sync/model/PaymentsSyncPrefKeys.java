package com.facebook.messaging.payment.sync.model;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: frameElapsedMsBuffer */
public class PaymentsSyncPrefKeys {
    public static final PrefKey f11442a;
    public static final PrefKey f11443b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("payments_sync/");
        f11442a = prefKey;
        f11443b = (PrefKey) prefKey.a("payments_sync_gk_override_off_ms");
    }
}

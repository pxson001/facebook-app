package com.facebook.messaging.payment.model;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: ignoreMessageRequestsParams */
public class MessengerPayPrefKeys {
    public static final PrefKey f13198a;
    public static final PrefKey f13199b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("messenger_pay/");
        f13198a = prefKey;
        f13199b = (PrefKey) prefKey.a("requests_eligible_for_ack_count");
    }
}

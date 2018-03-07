package com.facebook.messaging.smsbridge;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.user.model.User;

/* compiled from: publish_stream */
public class SmsBridgePrefKeys {
    private static final PrefKey f4260a;
    private static final PrefKey f4261b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("/sms_bridge");
        f4260a = prefKey;
        f4261b = (PrefKey) prefKey.a("/sms_user_added_dialog_shown");
    }

    public static PrefKey m3881a(User user) {
        return (PrefKey) f4261b.a("/" + user.T);
    }
}

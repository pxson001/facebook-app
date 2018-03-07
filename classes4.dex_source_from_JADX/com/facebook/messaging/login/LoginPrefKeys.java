package com.facebook.messaging.login;

import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.PrefKey;

/* compiled from: enable_debug_logging */
class LoginPrefKeys {
    public static final PrefKey f13107a;
    public static final PrefKey f13108b;

    LoginPrefKeys() {
    }

    static {
        PrefKey prefKey = (PrefKey) MessagingPrefKeys.c.a("login/");
        f13107a = prefKey;
        f13108b = (PrefKey) prefKey.a("logged_out_remotely");
    }
}

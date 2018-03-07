package com.facebook.messaging.forcemessenger;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: item_reply */
public class ForceMessengerPrefKeys {
    public static final PrefKey f9723a;
    public static final PrefKey f9724b = ((PrefKey) f9726d.a("new_app_user_internal"));
    public static final PrefKey f9725c = ((PrefKey) f9726d.a("diode_override_toggle"));
    private static final PrefKey f9726d;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.d.a("force_messenger/");
        f9726d = prefKey;
        f9723a = (PrefKey) prefKey.a("check_qe_internal");
    }

    public static ForceMessengerPrefKeys m10161a(InjectorLike injectorLike) {
        return new ForceMessengerPrefKeys();
    }
}

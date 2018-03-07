package com.facebook.registration.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: extra_ref */
public class RegistrationPrefKeys {
    public static final PrefKey f12443a;
    public static final PrefKey f12444b;
    public static final PrefKey f12445c;
    public static final PrefKey f12446d;
    public static final PrefKey f12447e = ((PrefKey) f12445c.a("profile_pic/"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("reg/");
        f12443a = prefKey;
        f12444b = (PrefKey) prefKey.a("reg_instance");
        prefKey = (PrefKey) f12443a.a("new_user_info/");
        f12445c = prefKey;
        f12446d = (PrefKey) prefKey.a("gender/");
    }

    public static PrefKey m13187a(String str) {
        return (PrefKey) f12446d.a(str);
    }

    public static PrefKey m13188b(String str) {
        return (PrefKey) f12447e.a(str);
    }
}

package com.facebook.appinvites.data;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: is_thread_queue_enabled */
public class AppInvitePrefKeys {
    public static final PrefKey f9814a;
    public static final PrefKey f9815b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("app_invites/");
        f9814a = prefKey;
        f9815b = (PrefKey) prefKey.a("install_track/");
    }
}

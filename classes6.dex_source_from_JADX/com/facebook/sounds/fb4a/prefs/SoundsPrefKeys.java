package com.facebook.sounds.fb4a.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: event_email_invitees */
public class SoundsPrefKeys {
    public static final PrefKey f16052a;
    public static final PrefKey f16053b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("sounds/");
        f16052a = prefKey;
        f16053b = (PrefKey) prefKey.a("sounds_preferences/");
    }
}

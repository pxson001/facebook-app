package com.facebook.selfupdate.remotepushtrigger;

import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: PREF_FIRST */
public class RemotePushTriggerPrefs implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f12541a;
    private static final PrefKey f12542b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("remote_push_trigger");
        f12542b = prefKey;
        f12541a = (PrefKey) prefKey.a("last_server_ping_time");
    }

    public final ImmutableSet<PrefKey> m12941a() {
        return ImmutableSet.of(f12541a);
    }
}

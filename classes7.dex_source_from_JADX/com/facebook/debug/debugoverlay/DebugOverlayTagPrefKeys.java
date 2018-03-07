package com.facebook.debug.debugoverlay;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: sync_check_server_response_received */
public class DebugOverlayTagPrefKeys {
    private static final PrefKey f2585a = ((PrefKey) SharedPrefKeys.a.a("debugoverlay/"));

    public static PrefKey m2975a(DebugOverlayTag debugOverlayTag) {
        return (PrefKey) f2585a.a(debugOverlayTag.f2582a);
    }
}

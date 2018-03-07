package com.facebook.runtimepermissions;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: animated_webp_src */
public class RequestPermissionsPrefKeys implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f20402a;
    public static final PrefKey f20403b = ((PrefKey) f20407f.a("camera_never_ask_again_shown"));
    public static final PrefKey f20404c = ((PrefKey) f20407f.a("contacts_never_ask_again_shown"));
    public static final PrefKey f20405d = ((PrefKey) f20407f.a("location_never_ask_again_shown"));
    public static final PrefKey f20406e = ((PrefKey) f20407f.a("storage_never_ask_again_shown"));
    private static final PrefKey f20407f;

    public static RequestPermissionsPrefKeys m19966a(InjectorLike injectorLike) {
        return new RequestPermissionsPrefKeys();
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("permissions/");
        f20407f = prefKey;
        f20402a = (PrefKey) prefKey.a("audio_never_ask_again_shown");
    }

    public final ImmutableSet<PrefKey> m19967a() {
        return ImmutableSet.of(f20407f);
    }
}

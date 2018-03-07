package com.facebook.instantshopping;

import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: Sounds */
public class InstantShoppingPrefKeys implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f23459a;
    public static final PrefKey f23460b;
    public static final PrefKey f23461c = ((PrefKey) f23459a.a("save_nux_seen_count"));
    public static final PrefKey f23462d = ((PrefKey) f23459a.a("has_seen_save_modal"));
    public static final PrefKey f23463e = ((PrefKey) f23459a.a("has_seen_audio_nux"));
    public static final PrefKey f23464f = ((PrefKey) f23459a.a("audio_is_state"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("instant_shopping/");
        f23459a = prefKey;
        f23460b = (PrefKey) prefKey.a("has_seen_checkout_nux");
    }

    public final ImmutableSet<PrefKey> m24785a() {
        return ImmutableSet.of(f23460b, f23461c);
    }
}

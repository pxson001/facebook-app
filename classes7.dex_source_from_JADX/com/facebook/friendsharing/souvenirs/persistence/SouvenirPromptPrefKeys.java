package com.facebook.friendsharing.souvenirs.persistence;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: RESU */
public class SouvenirPromptPrefKeys implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f24085a;
    public static final PrefKey f24086b;

    public static SouvenirPromptPrefKeys m26213a(InjectorLike injectorLike) {
        return new SouvenirPromptPrefKeys();
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("souvenir_prompt/");
        f24085a = prefKey;
        f24086b = (PrefKey) prefKey.a("time_last_souvenir_prompt_dismissed");
    }

    public final ImmutableSet<PrefKey> m26214a() {
        return ImmutableSet.of(f24086b);
    }
}

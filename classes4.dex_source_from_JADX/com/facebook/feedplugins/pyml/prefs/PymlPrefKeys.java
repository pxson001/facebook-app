package com.facebook.feedplugins.pyml.prefs;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: onError MEDIA_ERROR_MALFORMED */
public class PymlPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f6228a;
    private static final PrefKey f6229b;

    public static PymlPrefKeys m6681a(InjectorLike injectorLike) {
        return new PymlPrefKeys();
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("pyml/");
        f6229b = prefKey;
        f6228a = (PrefKey) prefKey.a("pyml_with_large_image_cursor");
    }

    public final ImmutableSet<PrefKey> m6682b() {
        return ImmutableSet.of(f6228a);
    }
}

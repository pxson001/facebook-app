package com.facebook.feed.ui.itemlistfeedunits.neko.prefs;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: Tap to close */
public class NekoPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f22323a;
    private static final PrefKey f22324b;

    public static NekoPrefKeys m24932a(InjectorLike injectorLike) {
        return new NekoPrefKeys();
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("neko/");
        f22324b = prefKey;
        f22323a = (PrefKey) prefKey.a("digital_goods_cursor");
    }

    public final ImmutableSet<PrefKey> m24933b() {
        return ImmutableSet.of(f22323a);
    }
}

package com.facebook.feedplugins.storyset.prefs;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: SHOWN */
public class StorySetPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f23823a;
    private static final PrefKey f23824b;

    public static StorySetPrefKeys m25973a(InjectorLike injectorLike) {
        return new StorySetPrefKeys();
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("storyset/");
        f23824b = prefKey;
        f23823a = (PrefKey) prefKey.a("storyset_item_cursor");
    }

    public final ImmutableSet<PrefKey> m25974b() {
        return ImmutableSet.of(f23823a);
    }
}

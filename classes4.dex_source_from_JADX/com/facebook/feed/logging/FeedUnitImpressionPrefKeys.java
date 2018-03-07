package com.facebook.feed.logging;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: profile_pic */
public class FeedUnitImpressionPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f4119a;
    public static final PrefKey f4120b = ((PrefKey) f4121c.a("sponsored"));
    private static final PrefKey f4121c;

    public static FeedUnitImpressionPrefKeys m4663a(InjectorLike injectorLike) {
        return new FeedUnitImpressionPrefKeys();
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("imp/");
        f4121c = prefKey;
        f4119a = (PrefKey) prefKey.a("viewport");
    }

    public final ImmutableSet<PrefKey> m4664b() {
        return ImmutableSet.of(f4119a, f4120b);
    }
}

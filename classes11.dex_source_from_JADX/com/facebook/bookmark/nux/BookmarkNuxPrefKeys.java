package com.facebook.bookmark.nux;

import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: media_error_io */
public class BookmarkNuxPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f5487a;
    private static final PrefKey f5488b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("bookmarknux/");
        f5488b = prefKey;
        f5487a = (PrefKey) prefKey.a("messenger_nux_seen");
    }

    public final ImmutableSet<PrefKey> m6695b() {
        return ImmutableSet.of(f5487a);
    }
}

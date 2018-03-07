package com.facebook.growth.prefs;

import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.collect.ImmutableSet;

/* compiled from: post_intercept_words_after_number */
public class FriendFinderPrefKeys implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f6093a;
    private static final PrefKey f6094b;
    private static final PrefKey f6095c = ((PrefKey) f6093a.a("persistent_legal_approved/"));

    static {
        PrefKey prefKey = (PrefKey) GrowthPrefKeys.a.a("friendfinder/");
        f6093a = prefKey;
        f6094b = (PrefKey) prefKey.a("legalapproved/");
    }

    public final ImmutableSet<PrefKey> m7891a() {
        return ImmutableSet.of(f6094b);
    }

    public static PrefKey m7890a(String str, FbSharedPreferences fbSharedPreferences) {
        PrefKey prefKey = (PrefKey) f6095c.a(str);
        PrefKey prefKey2 = f6094b;
        if (fbSharedPreferences.a(prefKey2, false)) {
            fbSharedPreferences.edit().putBoolean(prefKey2, false).commit();
            fbSharedPreferences.edit().putBoolean(prefKey, true).commit();
        }
        return prefKey;
    }
}

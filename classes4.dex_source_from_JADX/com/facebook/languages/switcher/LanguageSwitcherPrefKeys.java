package com.facebook.languages.switcher;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: topPushableFriends */
public class LanguageSwitcherPrefKeys {
    public static final PrefKey f911a;
    public static final PrefKey f912b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("locales/");
        f911a = prefKey;
        f912b = (PrefKey) prefKey.a("suggested_locale_list");
    }

    public static LanguageSwitcherPrefKeys m1239a(InjectorLike injectorLike) {
        return new LanguageSwitcherPrefKeys();
    }
}

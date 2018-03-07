package com.facebook.languages.switchercommonex;

import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: timeline_delete_story */
public class LanguageSwitcherCommonExPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f2784a;
    public static final PrefKey f2785b = ((PrefKey) f2788e.m2011a("application_locale"));
    public static final PrefKey f2786c = ((PrefKey) f2788e.m2011a("locale_last_time_synced"));
    public static final PrefKey f2787d = ((PrefKey) f2788e.m2011a("internal_settings/"));
    private static final PrefKey f2788e;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("language_switcher/");
        f2788e = prefKey;
        f2784a = (PrefKey) prefKey.m2011a("account_locale");
    }

    public final ImmutableSet<PrefKey> mo671b() {
        return ImmutableSet.of(f2784a, f2786c);
    }
}

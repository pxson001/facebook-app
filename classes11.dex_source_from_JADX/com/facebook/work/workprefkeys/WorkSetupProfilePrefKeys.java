package com.facebook.work.workprefkeys;

import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: music_preview_impression */
public class WorkSetupProfilePrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f5285a;
    public static final PrefKey f5286b;
    public static final PrefKey f5287c;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("at_work_app/");
        f5285a = prefKey;
        prefKey = (PrefKey) prefKey.a("setup_profile/");
        f5286b = prefKey;
        f5287c = (PrefKey) prefKey.a("is_onboarded/");
    }

    public final ImmutableSet<PrefKey> m6547b() {
        return ImmutableSet.of(f5287c);
    }
}

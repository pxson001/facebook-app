package com.facebook.video.videohome.prefs;

import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: goodwill_small_accent_image */
public class VideoHomePrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f22152a;
    public static final PrefKey f22153b;
    public static final PrefKey f22154c = ((PrefKey) f22152a.m2011a("has_user_entered_video_home_tab"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("videohome/");
        f22152a = prefKey;
        f22153b = (PrefKey) prefKey.m2011a("count_of_user_was_exposed_to_video_home_tab_icon");
    }

    public final ImmutableSet<PrefKey> mo671b() {
        return ImmutableSet.of(f22153b, f22154c);
    }
}

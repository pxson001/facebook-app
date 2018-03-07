package com.facebook.timeline.profilevideo.store;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: mIsTrickyBin */
public class ProfileVideoStorePreferencesKeys {
    public static final PrefKey f9423a;
    private static final PrefKey f9424b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("timeline/profilevideo/store");
        f9424b = prefKey;
        f9423a = (PrefKey) prefKey.a("uploading_profile_video_path");
    }
}

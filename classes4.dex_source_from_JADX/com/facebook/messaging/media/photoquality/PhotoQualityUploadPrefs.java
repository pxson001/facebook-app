package com.facebook.messaging.media.photoquality;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: mActionManifests */
public class PhotoQualityUploadPrefs {
    public static final PrefKey f8770a;
    public static final PrefKey f8771b;
    public static final PrefKey f8772c = ((PrefKey) f8770a.a("photo_quality_for_thread"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("mediaupload/");
        f8770a = prefKey;
        f8771b = (PrefKey) prefKey.a("full_quality_photos");
    }
}

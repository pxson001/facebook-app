package com.facebook.messaging.media.download;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: mExpirationYear */
public class MediaDownloadPrefKeys {
    public static final PrefKey f11535a;
    public static final PrefKey f11536b;
    public static final PrefKey f11537c;
    public static final PrefKey f11538d = ((PrefKey) f11536b.a("auto_photo_download_upsell_shown"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("messages/");
        f11535a = prefKey;
        prefKey = (PrefKey) prefKey.a("photos/");
        f11536b = prefKey;
        f11537c = (PrefKey) prefKey.a("auto_photo_download_enabled");
    }
}

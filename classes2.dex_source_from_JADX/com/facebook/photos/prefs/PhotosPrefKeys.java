package com.facebook.photos.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: onUnbind called with null intent */
public class PhotosPrefKeys {
    public static final PrefKey f11063a;
    public static final PrefKey f11064b;
    public static final PrefKey f11065c = ((PrefKey) f11063a.m2011a("analytics"));
    public static final PrefKey f11066d = ((PrefKey) f11063a.m2011a("SOUVENIR_NUX"));
    public static final PrefKey f11067e = ((PrefKey) f11063a.m2011a("MMP_NUX"));
    public static final PrefKey f11068f = ((PrefKey) SharedPrefKeys.f987a.m2011a("slideshow/entry_point"));
    public static final PrefKey f11069g = ((PrefKey) f11063a.m2011a("hd_upload_nux"));
    public static final PrefKey f11070h = ((PrefKey) f11063a.m2011a("last_video_asset_count_log_time"));
    public static final PrefKey f11071i = ((PrefKey) f11063a.m2011a("last_new_asset_count_log_time"));
    public static final PrefKey f11072j = ((PrefKey) f11063a.m2011a("hi_res_photo_upload_pref"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("photos/");
        f11063a = prefKey;
        f11064b = (PrefKey) prefKey.m2011a("simplepicker_last_open_time");
    }
}

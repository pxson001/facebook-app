package com.facebook.platform.webdialogs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: getFavoriteFriends */
public class PlatformWebDialogsPrefKeys {
    public static final PrefKey f11163a;
    public static final PrefKey f11164b;
    public static final PrefKey f11165c;
    public static final PrefKey f11166d = ((PrefKey) f11164b.a("disable_refresh"));
    public static final PrefKey f11167e;
    public static final PrefKey f11168f;
    public static final PrefKey f11169g = ((PrefKey) f11167e.a("url_map_file_name"));
    public static final PrefKey f11170h;
    public static final PrefKey f11171i;
    public static final PrefKey f11172j = ((PrefKey) f11170h.a("last_update_timestamp"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.c.a("platform_webdialogs/");
        f11163a = prefKey;
        prefKey = (PrefKey) prefKey.a("internal_settings/");
        f11164b = prefKey;
        f11165c = (PrefKey) prefKey.a("reset_per_action");
        prefKey = (PrefKey) f11163a.a("cache_settings/");
        f11167e = prefKey;
        f11168f = (PrefKey) prefKey.a("read_write_failure_count");
        prefKey = (PrefKey) f11163a.a("manifest/");
        f11170h = prefKey;
        f11171i = (PrefKey) prefKey.a("file_name");
    }
}

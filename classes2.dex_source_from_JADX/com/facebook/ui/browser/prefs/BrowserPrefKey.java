package com.facebook.ui.browser.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: post_url_data */
public class BrowserPrefKey {
    public static final PrefKey f9364a = ((PrefKey) SharedPrefKeys.f987a.m2011a("browser/disabled"));
    public static final PrefKey f9365b = ((PrefKey) SharedPrefKeys.f987a.m2011a("browser/seen_blues_clues_nux"));
    public static final PrefKey f9366c = ((PrefKey) SharedPrefKeys.f987a.m2011a("browser/first_seen_blues_clues_nux"));
    public static final PrefKey f9367d = ((PrefKey) SharedPrefKeys.f987a.m2011a("browser/last_mobile_sso_time"));
    public static final PrefKey f9368e;
    public static final PrefKey f9369f;
    public static final PrefKey f9370g = ((PrefKey) f9368e.m2011a("always_prefetch/"));
    public static final PrefKey f9371h = ((PrefKey) f9368e.m2011a("saved_text_zoom_level"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f989c.m2011a("browser/");
        f9368e = prefKey;
        f9369f = (PrefKey) prefKey.m2011a("last_clear_data_date/");
    }
}

package com.facebook.pages.adminedpages.service;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: error_domain */
public class AdminedPagesOperationConstants {
    public static final PrefKey f12805a;
    public static final PrefKey f12806b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("admined_pages/");
        f12805a = prefKey;
        f12806b = (PrefKey) prefKey.a("last_db_update_time");
    }
}

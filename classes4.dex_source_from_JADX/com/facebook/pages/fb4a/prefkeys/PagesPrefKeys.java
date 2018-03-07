package com.facebook.pages.fb4a.prefkeys;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: reminder_request_date */
public class PagesPrefKeys {
    public static final PrefKey f3491a;
    public static final PrefKey f3492b;
    public static final PrefKey f3493c;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("page_identity/");
        f3491a = prefKey;
        prefKey = (PrefKey) prefKey.a("nux/");
        f3492b = prefKey;
        f3493c = (PrefKey) prefKey.a("activity_feed");
    }
}

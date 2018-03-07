package com.facebook.search.common.errors.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: event_user_block */
public class SearchErrorPrefKeys {
    public static final PrefKey f15854a;
    private static final PrefKey f15855b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.d.a("search_error/");
        f15855b = prefKey;
        f15854a = (PrefKey) prefKey.a("toast_errors");
    }
}

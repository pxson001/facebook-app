package com.facebook.contacts.util;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: quantity */
public class ContactsPrefKeys {
    public static final PrefKey f3931a;
    public static final PrefKey f3932b;
    public static final PrefKey f3933c = ((PrefKey) f3931a.a("has_contacts_fetch_succeeded_at_least_once"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("contacts_sync/");
        f3931a = prefKey;
        f3932b = (PrefKey) prefKey.a("has_contacts_fetch_run_at_least_once");
    }
}

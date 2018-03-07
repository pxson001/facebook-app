package com.facebook.contactlogs.prefs;

import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: photo_order */
public class ContactLogsPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f8116a;
    public static final PrefKey f8117b = ((PrefKey) f8116a.a("last_upload_attempt_timestamp"));
    public static final PrefKey f8118c;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("contactlogs/");
        f8116a = prefKey;
        f8118c = (PrefKey) prefKey.a("upload_enabled/");
    }

    public final ImmutableSet<PrefKey> m11678b() {
        return ImmutableSet.of(f8117b);
    }
}

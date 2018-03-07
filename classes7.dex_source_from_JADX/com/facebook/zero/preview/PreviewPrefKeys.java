package com.facebook.zero.preview;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: z-m-api.facebook.com */
public class PreviewPrefKeys {
    public static final PrefKey f165a;
    public static final PrefKey f166b;
    public static final PrefKey f167c;
    public static final PrefKey f168d = ((PrefKey) f166b.a("friends_megaphone_dismissed"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("preview/");
        f165a = prefKey;
        prefKey = (PrefKey) prefKey.a("clearable/");
        f166b = prefKey;
        f167c = (PrefKey) prefKey.a("notifications_megaphone_dismissed");
    }
}

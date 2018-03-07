package com.facebook.messaging.emoji;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: time_elapsed_since_manual_refresh */
public class EmojiPrefKeys {
    public static final PrefKey f2913a;
    public static final PrefKey f2914b;
    public static final PrefKey f2915c;
    public static final PrefKey f2916d = ((PrefKey) f2914b.m2011a("page"));
    public static final PrefKey f2917e = ((PrefKey) f2913a.m2011a("has_seen_emoji_color_nux"));
    public static final PrefKey f2918f = ((PrefKey) f2913a.m2011a("force_emoji_color_nux"));
    public static final PrefKey f2919g = ((PrefKey) f2913a.m2011a("has_seen_full_screen_emoji_nux"));
    public static final PrefKey f2920h = ((PrefKey) f2913a.m2011a("force_full_screen_emoji_nux"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("emojis/");
        f2913a = prefKey;
        prefKey = (PrefKey) prefKey.m2011a("popup/");
        f2914b = prefKey;
        f2915c = (PrefKey) prefKey.m2011a("tab_id");
    }
}

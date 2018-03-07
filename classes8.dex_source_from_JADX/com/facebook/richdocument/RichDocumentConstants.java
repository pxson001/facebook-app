package com.facebook.richdocument;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: profile_pic_width */
public class RichDocumentConstants {
    public static final PrefKey f5037a;
    public static final PrefKey f5038b = ((PrefKey) f5047k.a("last_article_info"));
    public static final PrefKey f5039c = ((PrefKey) f5047k.a("last_article_open_time"));
    public static final PrefKey f5040d = ((PrefKey) f5047k.a("snap_max_velocity"));
    public static final PrefKey f5041e = ((PrefKey) f5047k.a("snap_high_velocity"));
    public static final PrefKey f5042f = ((PrefKey) f5047k.a("snap_high_range"));
    public static final PrefKey f5043g = ((PrefKey) f5047k.a("snap_low_velocity"));
    public static final PrefKey f5044h = ((PrefKey) f5047k.a("snap_low_range"));
    public static final PrefKey f5045i = ((PrefKey) f5047k.a("frame_rate_logging"));
    public static final PrefKey f5046j = ((PrefKey) f5047k.a("frame_rate_logging_only_drops"));
    private static final PrefKey f5047k;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.c.a("/ia_sample");
        f5047k = prefKey;
        f5037a = (PrefKey) prefKey.a("bookmark");
    }
}

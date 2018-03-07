package com.facebook.video.videohome.prefetching;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: showsVerticalScrollIndicator */
public class VideoHomePrefetchPrefKeys {
    public static final PrefKey f3281a;
    public static final PrefKey f3282b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.c.a("video_home_prefetch");
        f3281a = prefKey;
        f3282b = (PrefKey) prefKey.a("video_home_prefetch_interval");
    }
}

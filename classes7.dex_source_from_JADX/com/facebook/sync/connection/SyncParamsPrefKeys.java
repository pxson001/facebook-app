package com.facebook.sync.connection;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: feedback/VIDEO_COMMENT_NUX */
public class SyncParamsPrefKeys {
    public static final PrefKey f14498a;
    public static final PrefKey f14499b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("sync_params/");
        f14498a = prefKey;
        f14499b = (PrefKey) prefKey.a("image_dimensions/");
    }

    public static PrefKey m18393a(Integer num) {
        return (PrefKey) ((PrefKey) f14499b.a("width/")).a(num.toString());
    }

    public static PrefKey m18394b(Integer num) {
        return (PrefKey) ((PrefKey) f14499b.a("height/")).a(num.toString());
    }
}

package com.facebook.backstage;

import com.facebook.backstage.media.Decoding.PhotoSpec;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.rebound.SpringConfig;

/* compiled from: segment_transcode_status */
public abstract class StacksConstants {
    public static final SpringConfig f4251a = SpringConfig.a(40.0d, 7.0d);
    public static final PhotoSpec f4252b = new PhotoSpec(720, 1280, 85);
    public static final PhotoSpec f4253c = new PhotoSpec(2340, 4160, 96);
    public static final PrefKey f4254d;
    public static final PrefKey f4255e;
    public static final PrefKey f4256f = ((PrefKey) f4254d.a("lockscreen_cam_is_open"));
    public static final PrefKey f4257g = ((PrefKey) f4254d.a("since_last_import_query"));
    public static final PrefKey f4258h = ((PrefKey) f4254d.a("since_last_activity_query"));
    public static final PrefKey f4259i = ((PrefKey) f4256f.a("nub_x"));
    public static final PrefKey f4260j = ((PrefKey) f4256f.a("nub_y"));
    public static final PrefKey f4261k = ((PrefKey) f4256f.a("always_show"));
    public static final PrefKey f4262l = ((PrefKey) f4254d.a("nux_should_be_shown"));
    public static final PrefKey f4263m = ((PrefKey) f4254d.a("tooltip_should_be_shown"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.e.a("backstage");
        f4254d = prefKey;
        f4255e = (PrefKey) prefKey.a("last_import_timestamp");
    }
}

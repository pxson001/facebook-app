package com.facebook.common.quickcam.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: promo_data= */
public class QuickCamPrefKeys {
    public static final PrefKey f6120a;
    public static final PrefKey f6121b;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("quickcam/");
        f6120a = prefKey;
        f6121b = (PrefKey) prefKey.a("quickcam_camera_direction");
    }
}

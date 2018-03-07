package com.facebook.camera.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: all_users */
public class CameraPrefKeys {
    public static final PrefKey f10971a;
    public static final PrefKey f10972b;
    public static final PrefKey f10973c = ((PrefKey) f10971a.a("camera_facing_id"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("camera/");
        f10971a = prefKey;
        f10972b = (PrefKey) prefKey.a("camera_flash_mode");
    }
}

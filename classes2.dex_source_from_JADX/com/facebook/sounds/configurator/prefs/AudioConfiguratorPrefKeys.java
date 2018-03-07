package com.facebook.sounds.configurator.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: reaction_android_share_trigger */
public class AudioConfiguratorPrefKeys {
    public static final PrefKey f8137a;
    public static final PrefKey f8138b;
    public static final PrefKey f8139c = ((PrefKey) f8137a.m2011a("custom_sound_levels/"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("audio_configurator/");
        f8137a = prefKey;
        f8138b = (PrefKey) prefKey.m2011a("audio_setting_preferences/");
    }
}

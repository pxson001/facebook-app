package com.facebook.config.background.impl;

import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: enable_starve */
public class ConfigPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f13103a = ((PrefKey) SharedPrefKeys.d.a("configuration_last_fetch_time_attempt_ms"));
    public static final PrefKey f13104b = ((PrefKey) SharedPrefKeys.d.a("configuration_last_fetch_time_success_ms"));
    public static final PrefKey f13105c = ((PrefKey) SharedPrefKeys.d.a("component_last_attempt/"));
    public static final PrefKey f13106d = ((PrefKey) SharedPrefKeys.d.a("sync_component_last_attempt/"));

    public final ImmutableSet<PrefKey> m13926b() {
        return ImmutableSet.of(f13103a, f13104b, f13105c, f13106d);
    }
}

package com.facebook.mqttlite;

import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: foreground_version_code */
public class MqttPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f23399a = ((PrefKey) SharedPrefKeys.f989c.m2011a("mqtt/mqtt_connect_hash"));
    public static final PrefKey f23400b = ((PrefKey) f23402d.m2011a("config_server"));
    public static final PrefKey f23401c = ((PrefKey) f23402d.m2011a("fbns_enabled"));
    private static final PrefKey f23402d = ((PrefKey) SharedPrefKeys.f990d.m2011a("mqtt/"));

    public final ImmutableSet<PrefKey> mo671b() {
        return ImmutableSet.of(f23399a);
    }
}

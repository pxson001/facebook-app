package com.facebook.placetips.presence;

import com.facebook.placetips.bootstrap.PresenceDescription;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.objects.ObjectPrefKey;
import com.google.common.collect.ImmutableSet;

/* compiled from: saved2.db */
public class PlaceTipsPresencePrefs implements IHavePrivacyCriticalKeysToClear {
    static final ObjectPrefKey<PresenceDescription> f3903a = ObjectPrefKey.a(PlaceTipsSettingsPrefs.a, "current_presence", PresenceDescription.class);

    public final ImmutableSet<PrefKey> m3875b() {
        return ImmutableSet.of(f3903a.a);
    }
}

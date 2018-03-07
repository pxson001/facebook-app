package com.facebook.feedplugins.placetips;

import com.facebook.common.typedkey.TypedKey;
import com.facebook.inject.InjectorLike;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: max_age_ms */
public class PlaceTipsPostComposeNuxPrefs implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f14951a;
    public static final PrefKey f14952b;
    public final FbSharedPreferences f14953c;

    public static PlaceTipsPostComposeNuxPrefs m21389b(InjectorLike injectorLike) {
        return new PlaceTipsPostComposeNuxPrefs(FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    static {
        TypedKey typedKey = PlaceTipsSettingsPrefs.f14954a;
        f14951a = typedKey;
        f14952b = (PrefKey) typedKey.m2011a("post_compose_nux_seen");
    }

    @Inject
    public PlaceTipsPostComposeNuxPrefs(FbSharedPreferences fbSharedPreferences) {
        this.f14953c = fbSharedPreferences;
    }

    public final ImmutableSet<PrefKey> mo1206a() {
        return ImmutableSet.of(f14952b);
    }

    public final boolean m21391b() {
        return this.f14953c.mo286a(f14952b, false);
    }
}

package com.facebook.feedplugins.momentsupsell.prefs;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: in */
public class MomentsUpsellPrefs implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f20305a;
    public static final PrefKey f20306b;
    public static final PrefKey f20307c = ((PrefKey) f20305a.m2011a("last_impression_time"));
    private static ImmutableSet<PrefKey> f20308d = ImmutableSet.of(f20306b, f20307c);
    public Clock f20309e;
    public FbSharedPreferences f20310f;

    public static MomentsUpsellPrefs m27967b(InjectorLike injectorLike) {
        return new MomentsUpsellPrefs(SystemClockMethodAutoProvider.m1498a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("moments_upsell_prefs/");
        f20305a = prefKey;
        f20306b = (PrefKey) prefKey.m2011a("impression_count");
    }

    @Inject
    public MomentsUpsellPrefs(Clock clock, FbSharedPreferences fbSharedPreferences) {
        this.f20309e = clock;
        this.f20310f = fbSharedPreferences;
    }

    public final ImmutableSet<PrefKey> mo1206a() {
        return f20308d;
    }

    public final int m27969d() {
        return this.f20310f.mo276a(f20306b, 0);
    }
}

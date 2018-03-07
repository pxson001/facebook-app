package com.facebook.places.checkin.composerflows;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;

/* compiled from: see_page_ads_and_promotions */
public class PlacesFlowsStore {
    private FbSharedPreferences f3536a;
    private Clock f3537b;
    private PrefKey f3538c;
    private PrefKey f3539d;

    public static PlacesFlowsStore m3462b(InjectorLike injectorLike) {
        return new PlacesFlowsStore((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PlacesFlowsStore(FbSharedPreferences fbSharedPreferences, Clock clock) {
        this.f3536a = fbSharedPreferences;
        this.f3537b = clock;
    }

    public final void m3465a(PrefKey prefKey, PrefKey prefKey2) {
        this.f3538c = prefKey;
        this.f3539d = prefKey2;
    }

    public final void m3464a() {
        this.f3536a.edit().a(this.f3538c, 0).commit();
    }

    public final void m3466b() {
        this.f3536a.edit().a(this.f3538c, m3463d() + 1).a(this.f3539d, this.f3537b.a()).commit();
    }

    private int m3463d() {
        return this.f3536a.a(this.f3538c, 0);
    }

    public final boolean m3467c() {
        if (this.f3537b.a() - this.f3536a.a(this.f3539d, 0) >= 43200000 && m3463d() < 3) {
            return true;
        }
        return false;
    }
}

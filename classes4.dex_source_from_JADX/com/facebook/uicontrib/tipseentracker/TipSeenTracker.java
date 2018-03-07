package com.facebook.uicontrib.tipseentracker;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: render_height */
public class TipSeenTracker {
    private final FbSharedPreferences f3474a;
    public int f3475b = 1;
    private PrefKey f3476c;

    public static TipSeenTracker m3732b(InjectorLike injectorLike) {
        return new TipSeenTracker((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public TipSeenTracker(FbSharedPreferences fbSharedPreferences) {
        this.f3474a = fbSharedPreferences;
    }

    public final void m3734a(PrefKey prefKey) {
        Preconditions.checkNotNull(prefKey);
        this.f3476c = prefKey;
    }

    public final void m3733a() {
        Preconditions.checkNotNull(this.f3476c, "prefKey was not set!");
        this.f3474a.edit().a(this.f3476c, this.f3474a.a(this.f3476c, 0) + 1).commit();
    }

    public static TipSeenTracker m3731a(InjectorLike injectorLike) {
        return m3732b(injectorLike);
    }

    public final void m3735b() {
        Preconditions.checkNotNull(this.f3476c, "prefKey was not set!");
        this.f3474a.edit().a(this.f3476c, this.f3475b).commit();
    }

    public final boolean m3736c() {
        Preconditions.checkNotNull(this.f3476c, "prefKey was not set!");
        if (this.f3475b > this.f3474a.a(this.f3476c, 0)) {
            return true;
        }
        return false;
    }
}

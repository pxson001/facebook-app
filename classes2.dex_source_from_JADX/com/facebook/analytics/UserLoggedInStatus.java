package com.facebook.analytics;

import com.facebook.analytics.prefs.AnalyticsPrefKeys;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: tag_ids */
public class UserLoggedInStatus implements Provider<TriState> {
    private final FbSharedPreferences f3332a;

    public /* synthetic */ Object get() {
        return m5542a();
    }

    public static UserLoggedInStatus m5541b(InjectorLike injectorLike) {
        return new UserLoggedInStatus(FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    @Inject
    public UserLoggedInStatus(FbSharedPreferences fbSharedPreferences) {
        this.f3332a = fbSharedPreferences;
    }

    public final TriState m5542a() {
        if (this.f3332a.mo284a()) {
            return TriState.valueOf(this.f3332a.mo286a(AnalyticsPrefKeys.f4985g, false));
        }
        return TriState.UNSET;
    }

    public final void m5543a(boolean z) {
        this.f3332a.edit().putBoolean(AnalyticsPrefKeys.f4985g, z).commit();
    }

    public final void m5544b() {
        this.f3332a.edit().mo1271a(AnalyticsPrefKeys.f4985g).commit();
    }

    public static UserLoggedInStatus m5540a(InjectorLike injectorLike) {
        return m5541b(injectorLike);
    }
}

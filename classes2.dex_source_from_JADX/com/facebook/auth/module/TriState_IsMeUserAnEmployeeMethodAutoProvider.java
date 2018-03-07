package com.facebook.auth.module;

import com.facebook.common.util.TriState;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: request_duration_ms */
public class TriState_IsMeUserAnEmployeeMethodAutoProvider extends AbstractProvider<TriState> {
    public static TriState m11944b(InjectorLike injectorLike) {
        return LoggedInUserModule.m2888a(IdBasedProvider.m1811a(injectorLike, 3595), (FbSharedPreferences) FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    public Object get() {
        return LoggedInUserModule.m2888a(IdBasedProvider.m1811a(this, 3595), (FbSharedPreferences) FbSharedPreferencesImpl.m1826a((InjectorLike) this));
    }

    public static TriState m11943a(InjectorLike injectorLike) {
        return m11944b(injectorLike);
    }
}

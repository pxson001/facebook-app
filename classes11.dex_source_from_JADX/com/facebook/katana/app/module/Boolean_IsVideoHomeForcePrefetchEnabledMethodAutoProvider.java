package com.facebook.katana.app.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: User is zero-rated so not fetching attachment */
public class Boolean_IsVideoHomeForcePrefetchEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return MainProcessModule.f((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}

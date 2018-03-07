package com.facebook.katana.app.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: Use Proxy */
public class Boolean_IsVideoHomePrefetchToastEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return MainProcessModule.g((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}

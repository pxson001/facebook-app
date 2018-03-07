package com.facebook.katana.app.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: phoneid_sync_interval */
public class Boolean_IsAlwaysPlayVideoUnmutedEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return MainProcessModule.c((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}

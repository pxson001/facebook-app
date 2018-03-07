package com.facebook.katana.app.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: User canceled log in. */
public class Boolean_IsVideoHomePlayVideoUnmutedEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return MainProcessModule.d((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}

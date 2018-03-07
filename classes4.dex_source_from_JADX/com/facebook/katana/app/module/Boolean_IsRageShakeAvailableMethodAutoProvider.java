package com.facebook.katana.app.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: voice_reply */
public class Boolean_IsRageShakeAvailableMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return MainProcessModule.b((FbSharedPreferences) FbSharedPreferencesImpl.a(this), IdBasedProvider.a(this, 640), IdBasedProvider.a(this, 642));
    }
}

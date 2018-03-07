package com.facebook.katana.app.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: VIDEO_ITEM */
public class Boolean_IsCommercialBreakDebugToastsEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return MainProcessModule.h((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}

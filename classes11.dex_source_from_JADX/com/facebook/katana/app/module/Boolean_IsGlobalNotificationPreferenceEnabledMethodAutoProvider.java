package com.facebook.katana.app.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: VIDEO_AUTOPLAY */
public class Boolean_IsGlobalNotificationPreferenceEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return MainProcessModule.a((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}

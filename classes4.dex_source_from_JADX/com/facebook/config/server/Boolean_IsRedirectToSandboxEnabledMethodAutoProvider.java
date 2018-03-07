package com.facebook.config.server;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: hugePictureUrl */
public class Boolean_IsRedirectToSandboxEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return ServerConfigModule.a((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}

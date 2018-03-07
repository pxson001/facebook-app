package com.facebook.debug.viewserver;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: voicemail_download */
public class Boolean_IsViewServerEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return ViewServerModule.a((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}

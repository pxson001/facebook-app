package com.facebook.http.common;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: voip_voicemail_audio */
public class Boolean_IsArtilleryTracingEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return FbHttpModule.c((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}

package com.facebook.messaging.login;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: enable_download */
public class Boolean_IsLoggedOutRemotelyMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return MessagingLoginModule.m13927a((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}

package com.facebook.messaging.chatheads.prefs;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: is_video_call */
public class Boolean_DefaultIsChatHeadsEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return ChatHeadsPrefsModule.m18911a((FbSharedPreferences) FbSharedPreferencesImpl.a(this), IdBasedProvider.a(this, 4132));
    }
}

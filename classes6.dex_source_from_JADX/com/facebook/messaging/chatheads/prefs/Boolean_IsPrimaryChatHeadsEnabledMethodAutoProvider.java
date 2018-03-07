package com.facebook.messaging.chatheads.prefs;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: is_sticker_post */
public class Boolean_IsPrimaryChatHeadsEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return ChatHeadsPrefsModule.m18913b((FbSharedPreferences) FbSharedPreferencesImpl.a(this), IdBasedProvider.a(this, 4128));
    }
}

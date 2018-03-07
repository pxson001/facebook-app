package com.facebook.messaging.chatheads.prefs;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: is_vault */
public class Boolean_IsChatHeadDebugShadingEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m18903b(InjectorLike injectorLike) {
        return ChatHeadsPrefsModule.m18910a((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    public Object get() {
        return ChatHeadsPrefsModule.m18910a((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}

package com.facebook.work.config;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: com.facebook.fragment.EXIT_ANIM */
public class String_WorkCommunityNameMethodAutoProvider extends AbstractProvider<String> {
    public static String m10622b(InjectorLike injectorLike) {
        return WorkConfigModule.a((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    public Object get() {
        return WorkConfigModule.a((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }

    public static String m10621a(InjectorLike injectorLike) {
        return m10622b(injectorLike);
    }
}

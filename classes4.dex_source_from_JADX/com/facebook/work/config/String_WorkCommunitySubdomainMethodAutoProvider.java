package com.facebook.work.config;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: touch_exploration_enabled */
public class String_WorkCommunitySubdomainMethodAutoProvider extends AbstractProvider<String> {
    public static String m1197b(InjectorLike injectorLike) {
        return WorkConfigModule.m1200c((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    public Object get() {
        return WorkConfigModule.m1200c((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}

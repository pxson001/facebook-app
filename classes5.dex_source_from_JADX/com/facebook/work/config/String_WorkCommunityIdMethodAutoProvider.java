package com.facebook.work.config;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: com.facebook.fragment.FRAGMENT_ACTION */
public class String_WorkCommunityIdMethodAutoProvider extends AbstractProvider<String> {
    public static String m10620a(InjectorLike injectorLike) {
        return WorkConfigModule.b((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    public Object get() {
        return WorkConfigModule.b((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}

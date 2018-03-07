package com.facebook.katana.app.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: prefetchAdminedPages */
public class Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m4865b(InjectorLike injectorLike) {
        return MainProcessModule.b((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    public Object get() {
        return MainProcessModule.b((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }

    public static Boolean m4864a(InjectorLike injectorLike) {
        return m4865b(injectorLike);
    }
}

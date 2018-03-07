package com.facebook.katana.app.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: ip_address */
public class String_VideoLoggingLevelMethodAutoProvider extends AbstractProvider<String> {
    public static String m27128a(InjectorLike injectorLike) {
        return MainProcessModule.m4797e(FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    public Object get() {
        return MainProcessModule.m4797e(FbSharedPreferencesImpl.m1826a((InjectorLike) this));
    }
}

package com.facebook.feed.analytics.vpvlogging;

import com.facebook.feed.analytics.vpvlogging.debugger.VpvLoggingDebugger;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: promotionId */
public class VpvLoggingDebuggerMethodAutoProvider extends AbstractProvider<VpvLoggingDebugger> {
    public static VpvLoggingDebugger m4624b(InjectorLike injectorLike) {
        return VpvLoggingModule.m4625a((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 5821), IdBasedLazy.a(injectorLike, 1294));
    }

    public Object get() {
        return VpvLoggingModule.m4625a((FbSharedPreferences) FbSharedPreferencesImpl.a(this), IdBasedLazy.a(this, 5821), IdBasedLazy.a(this, 1294));
    }
}

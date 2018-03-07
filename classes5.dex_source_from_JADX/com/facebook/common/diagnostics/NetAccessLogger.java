package com.facebook.common.diagnostics;

import android.net.Uri;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import javax.inject.Inject;

/* compiled from: store_id */
public class NetAccessLogger {
    public static final PrefKey f2521a = ((PrefKey) SharedPrefKeys.c.a("fb_log_net_access"));
    public final FbSharedPreferences f2522b;

    public static NetAccessLogger m3643b(InjectorLike injectorLike) {
        return new NetAccessLogger((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public NetAccessLogger(FbSharedPreferences fbSharedPreferences) {
        this.f2522b = fbSharedPreferences;
    }

    public final void m3644a(String str) {
        boolean z = false;
        if (this.f2522b.a()) {
            z = this.f2522b.a(f2521a, false);
        }
        if (z) {
            String scheme = Uri.parse(str).getScheme();
            if (!"http".equals(scheme)) {
                "https".equals(scheme);
            }
        }
    }

    public static NetAccessLogger m3642a(InjectorLike injectorLike) {
        return m3643b(injectorLike);
    }
}

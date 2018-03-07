package com.facebook.fbreact.autoupdater;

import android.content.Context;
import com.facebook.crudolib.prefs.LightSharedPreferencesFactory;
import com.facebook.crudolib.prefs.LightSharedPreferencesFactory.Builder;

/* compiled from: fadeDuration */
public final class OverTheAirBundleInfo {
    private final LightSharedPreferencesFactory f7251a;

    public OverTheAirBundleInfo(Context context) {
        this.f7251a = new Builder(context).a();
    }

    private void m8465b() {
        this.f7251a.a("overtheair_prefs").b().a("activated").a("next").c();
    }

    public final int m8466a() {
        int i = 0;
        try {
            i = this.f7251a.a("overtheair_prefs").a("activated", 0);
        } catch (RuntimeException e) {
            m8465b();
        }
        return i;
    }
}

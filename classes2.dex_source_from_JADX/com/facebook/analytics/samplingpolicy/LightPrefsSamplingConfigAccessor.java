package com.facebook.analytics.samplingpolicy;

import com.facebook.crudolib.prefs.LightSharedPreferencesImpl;
import java.util.Set;

/* compiled from: used_count */
class LightPrefsSamplingConfigAccessor extends SamplingConfigAccessor {
    private final LightSharedPreferencesImpl f1496a;

    LightPrefsSamplingConfigAccessor(LightSharedPreferencesImpl lightSharedPreferencesImpl) {
        this.f1496a = lightSharedPreferencesImpl;
    }

    protected final Set<String> mo403a(String str, Set<String> set) {
        return this.f1496a.m2645a(str, (Set) set);
    }

    protected final int mo401a(String str, int i) {
        return this.f1496a.m2641a(str, i);
    }

    protected final String mo402a(String str, String str2) {
        return this.f1496a.m2643a(str, str2);
    }
}

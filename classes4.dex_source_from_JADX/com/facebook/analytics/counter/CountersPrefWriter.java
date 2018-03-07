package com.facebook.analytics.counter;

import com.facebook.common.time.Clock;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Provider;

/* compiled from: pa_type */
public class CountersPrefWriter {
    private final FbSharedPreferences f5570a;
    private final String f5571b;
    private final CountersPrefKeyUtil f5572c;
    private final Clock f5573d;
    private final Provider<Long> f5574e;

    public CountersPrefWriter(FbSharedPreferences fbSharedPreferences, String str, CountersPrefKeyUtil countersPrefKeyUtil, Clock clock, Provider<Long> provider) {
        this.f5570a = fbSharedPreferences;
        this.f5572c = countersPrefKeyUtil;
        this.f5571b = str;
        this.f5573d = clock;
        this.f5574e = provider;
    }

    private PrefKey m5991b(String str) {
        return this.f5572c.a(this.f5571b, str);
    }

    private PrefKey m5992c(String str) {
        return this.f5572c.b(this.f5571b, str);
    }

    public final boolean m5994a(String str) {
        return this.f5570a.a() && this.f5573d.a() - this.f5570a.a(m5991b(str), 0) > ((Long) this.f5574e.get()).longValue() && !this.f5570a.a(m5992c(str));
    }

    public final void m5993a(String str, String str2) {
        this.f5570a.edit().a(m5992c(str), str2).a(m5991b(str), this.f5573d.a()).commit();
    }
}

package com.facebook.analytics.counter;

import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map.Entry;

/* compiled from: hasPendingUpdates */
public class CountersPrefReader {
    private final FbSharedPreferences f10900a;
    private final CountersPrefKeyUtil f10901b;

    public CountersPrefReader(FbSharedPreferences fbSharedPreferences, CountersPrefKeyUtil countersPrefKeyUtil) {
        this.f10900a = fbSharedPreferences;
        this.f10901b = countersPrefKeyUtil;
    }

    public final synchronized ImmutableMap<String, ImmutableMap<String, Object>> m11326a() {
        ImmutableMap<String, ImmutableMap<String, Object>> b;
        Object obj = null;
        synchronized (this) {
            Builder builder = ImmutableMap.builder();
            Editor edit = this.f10900a.edit();
            Builder builder2 = null;
            for (Entry entry : this.f10900a.e(CountersPrefKeyUtil.a).entrySet()) {
                PrefKey prefKey = (PrefKey) entry.getKey();
                if (CountersPrefKeyUtil.b(prefKey)) {
                    String[] a = CountersPrefKeyUtil.a(prefKey);
                    if (a.length > 2) {
                        String str = a[0];
                        Object obj2 = a[1];
                        if (!str.equals(obj)) {
                            if (!(obj == null || builder2 == null)) {
                                builder.b(obj, builder2.b());
                            }
                            builder2 = ImmutableMap.builder();
                            obj = str;
                        }
                        builder2.b(obj2, entry.getValue());
                        edit.a(prefKey);
                    }
                }
                obj = obj;
                builder2 = builder2;
            }
            if (!(obj == null || builder2 == null)) {
                builder.b(obj, builder2.b());
            }
            edit.commit();
            b = builder.b();
        }
        return b;
    }
}

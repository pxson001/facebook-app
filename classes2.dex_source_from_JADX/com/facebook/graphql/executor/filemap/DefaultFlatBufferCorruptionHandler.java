package com.facebook.graphql.executor.filemap;

import com.facebook.inject.Assisted;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;

/* compiled from: maximum size must not be negative */
public class DefaultFlatBufferCorruptionHandler {
    private static final Class<?> f14814a = DefaultFlatBufferCorruptionHandler.class;
    public final FbSharedPreferences f14815b;
    public final PrefKey f14816c;

    @Inject
    public DefaultFlatBufferCorruptionHandler(FbSharedPreferences fbSharedPreferences, @Assisted PrefKey prefKey) {
        this.f14815b = fbSharedPreferences;
        this.f14816c = prefKey;
    }

    public final void m21221a() {
        this.f14816c.m2012a();
        this.f14815b.edit().putBoolean(this.f14816c, true).commit();
    }

    public final void m21222c() {
        this.f14815b.edit().putBoolean(this.f14816c, false).commit();
    }
}

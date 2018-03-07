package com.facebook.prefs.shared.objects;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.objects.FbSharedObjectPreferences.Editor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: maximized */
public class FbSharedObjectPreferencesImpl {
    private final FbSharedPreferences f14835a;
    public final ObjectMapper f14836b;

    public static FbSharedObjectPreferencesImpl m21242b(InjectorLike injectorLike) {
        return new FbSharedObjectPreferencesImpl(FbSharedPreferencesImpl.m1826a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    @Inject
    public FbSharedObjectPreferencesImpl(FbSharedPreferences fbSharedPreferences, ObjectMapper objectMapper) {
        this.f14835a = fbSharedPreferences;
        this.f14836b = objectMapper;
    }

    @Nullable
    public final <T> T m21244a(ObjectPrefKey<T> objectPrefKey) {
        T t = null;
        String a = this.f14835a.mo278a(objectPrefKey.m21402a(), null);
        if (a != null) {
            try {
                t = this.f14836b.m6657a(a, objectPrefKey.m21403b());
            } catch (Throwable e) {
                throw Throwables.propagate(e);
            }
        }
        return t;
    }

    public final Editor m21243a() {
        return new EditorImpl(this, this.f14835a.edit());
    }
}

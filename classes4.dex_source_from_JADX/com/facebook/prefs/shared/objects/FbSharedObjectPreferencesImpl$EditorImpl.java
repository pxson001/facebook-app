package com.facebook.prefs.shared.objects;

import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.google.common.base.Throwables;
import javax.annotation.Nullable;

/* compiled from: refetch_analytics_tag */
class FbSharedObjectPreferencesImpl$EditorImpl implements FbSharedObjectPreferences$Editor {
    final /* synthetic */ FbSharedObjectPreferencesImpl f3539a;
    private final Editor f3540b;

    FbSharedObjectPreferencesImpl$EditorImpl(FbSharedObjectPreferencesImpl fbSharedObjectPreferencesImpl, Editor editor) {
        this.f3539a = fbSharedObjectPreferencesImpl;
        this.f3540b = editor;
    }

    public final <T> FbSharedObjectPreferences$Editor mo283a(ObjectPrefKey<T> objectPrefKey, @Nullable T t) {
        if (t == null) {
            this.f3540b.a(objectPrefKey.a());
        } else {
            try {
                this.f3540b.a(objectPrefKey.a(), this.f3539a.b.a(t));
            } catch (Throwable e) {
                throw Throwables.propagate(e);
            }
        }
        return this;
    }

    public final void mo284a() {
        this.f3540b.commit();
    }
}

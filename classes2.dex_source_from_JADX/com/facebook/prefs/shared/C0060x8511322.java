package com.facebook.prefs.shared;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.prefs.shared.FbSharedPreferencesCache.OnChangesListener;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class C0060x8511322 implements MultiBindIndexedProvider<OnChangesListener>, Provider<Set<OnChangesListener>> {
    private final InjectorLike f1032a;

    public C0060x8511322(InjectorLike injectorLike) {
        this.f1032a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1032a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 0;
    }

    public final Object provide(Injector injector, int i) {
        throw new IllegalArgumentException("Invalid binding index");
    }
}

package com.facebook.prefs.shared;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class C0411x84623665 implements MultiBindIndexedProvider<PrefKey>, Provider<Set<PrefKey>> {
    private final InjectorLike f8569a;

    public C0411x84623665(InjectorLike injectorLike) {
        this.f8569a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8569a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 0;
    }

    public final Object provide(Injector injector, int i) {
        throw new IllegalArgumentException("Invalid binding index");
    }
}

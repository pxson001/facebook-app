package com.facebook.bookmark.model;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: recommended_radius */
public final class STATICDI_MULTIBIND_PROVIDER$OptionalBookmarksGroup implements MultiBindIndexedProvider<OptionalBookmarksGroup>, Provider<Set<OptionalBookmarksGroup>> {
    private final InjectorLike f5674a;

    private STATICDI_MULTIBIND_PROVIDER$OptionalBookmarksGroup(InjectorLike injectorLike) {
        this.f5674a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f5674a.getScopeAwareInjector(), this);
    }

    public static Set<OptionalBookmarksGroup> m5893a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$OptionalBookmarksGroup(injectorLike));
    }

    public final int size() {
        return 0;
    }

    public final Object provide(Injector injector, int i) {
        throw new IllegalArgumentException("Invalid binding index");
    }
}

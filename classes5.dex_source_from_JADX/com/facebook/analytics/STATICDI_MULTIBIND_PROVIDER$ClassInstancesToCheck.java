package com.facebook.analytics;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: transaction_status_display */
public final class STATICDI_MULTIBIND_PROVIDER$ClassInstancesToCheck implements MultiBindIndexedProvider<ClassInstancesToCheck>, Provider<Set<ClassInstancesToCheck>> {
    private final InjectorLike f1874a;

    public STATICDI_MULTIBIND_PROVIDER$ClassInstancesToCheck(InjectorLike injectorLike) {
        this.f1874a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1874a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 0;
    }

    public final Object provide(Injector injector, int i) {
        throw new IllegalArgumentException("Invalid binding index");
    }
}

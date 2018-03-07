package com.facebook.debug.dumpsys;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: transaction_status_display */
public final class STATICDI_MULTIBIND_PROVIDER$DumpsysHandler implements MultiBindIndexedProvider<DumpsysHandler>, Provider<Set<DumpsysHandler>> {
    private final InjectorLike f11780a;

    public STATICDI_MULTIBIND_PROVIDER$DumpsysHandler(InjectorLike injectorLike) {
        this.f11780a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f11780a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 0;
    }

    public final Object provide(Injector injector, int i) {
        throw new IllegalArgumentException("Invalid binding index");
    }
}

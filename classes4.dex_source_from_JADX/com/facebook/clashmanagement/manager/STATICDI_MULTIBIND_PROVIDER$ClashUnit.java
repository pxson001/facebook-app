package com.facebook.clashmanagement.manager;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$ClashUnit implements MultiBindIndexedProvider<ClashUnit>, Provider<Set<ClashUnit>> {
    private final InjectorLike f9915a;

    public STATICDI_MULTIBIND_PROVIDER$ClashUnit(InjectorLike injectorLike) {
        this.f9915a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f9915a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new ClashUnitBase(ClashManager.m10297a((InjectorLike) injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

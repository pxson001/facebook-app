package com.facebook.quickpromotion.customrender;

import com.facebook.contacts.pna.qps.PnaCustomRenderEntry;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: unknown relative layout param =  */
public final class STATICDI_MULTIBIND_PROVIDER$CustomRenderEntry implements MultiBindIndexedProvider<CustomRenderEntry>, Provider<Set<CustomRenderEntry>> {
    private final InjectorLike f4614a;

    public STATICDI_MULTIBIND_PROVIDER$CustomRenderEntry(InjectorLike injectorLike) {
        this.f4614a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f4614a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new PnaCustomRenderEntry();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

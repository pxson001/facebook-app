package com.facebook.localstats;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.loom.module.LocalStatsListenerForLoom;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$LocalStatsValuesListener implements MultiBindIndexedProvider<LocalStatsValuesListener>, Provider<Set<LocalStatsValuesListener>> {
    private final InjectorLike f8759a;

    private STATICDI_MULTIBIND_PROVIDER$LocalStatsValuesListener(InjectorLike injectorLike) {
        this.f8759a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8759a.getScopeAwareInjector(), this);
    }

    public static Set<LocalStatsValuesListener> m13610a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$LocalStatsValuesListener(injectorLike));
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new LocalStatsListenerForLoom();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

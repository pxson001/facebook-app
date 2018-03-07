package com.facebook.abtest.qe.bootstrap.registry;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.placetips.pulsarcore.PulsarFeatureController;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$QuickExperimentCacheUpdateListener implements MultiBindIndexedProvider<QuickExperimentCacheUpdateListener>, Provider<Set<QuickExperimentCacheUpdateListener>> {
    private final InjectorLike f1828a;

    public STATICDI_MULTIBIND_PROVIDER$QuickExperimentCacheUpdateListener(InjectorLike injectorLike) {
        this.f1828a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1828a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return PulsarFeatureController.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

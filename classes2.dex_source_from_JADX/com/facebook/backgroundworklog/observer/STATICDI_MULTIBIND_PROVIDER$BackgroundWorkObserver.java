package com.facebook.backgroundworklog.observer;

import com.facebook.backgroundworklog.performanceobserver.PerformanceBackgroundWorkObserver;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$BackgroundWorkObserver implements MultiBindIndexedProvider<BackgroundWorkObserver>, Provider<Set<BackgroundWorkObserver>> {
    private final InjectorLike f882a;

    public STATICDI_MULTIBIND_PROVIDER$BackgroundWorkObserver(InjectorLike injectorLike) {
        this.f882a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f882a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return PerformanceBackgroundWorkObserver.m2659a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

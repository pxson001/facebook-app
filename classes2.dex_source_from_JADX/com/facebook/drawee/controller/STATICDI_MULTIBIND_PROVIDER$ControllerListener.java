package com.facebook.drawee.controller;

import com.facebook.drawee.instrumentation.PerfLoggingListener;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$ControllerListener implements MultiBindIndexedProvider<ControllerListener>, Provider<Set<ControllerListener>> {
    private final InjectorLike f13227a;

    public STATICDI_MULTIBIND_PROVIDER$ControllerListener(InjectorLike injectorLike) {
        this.f13227a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f13227a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return PerfLoggingListener.m20778a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

package com.facebook.debug.activitytracer;

import com.facebook.debug.activitytracer.ActivityTracer.Listener;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$ActivityTracer_Listener implements MultiBindIndexedProvider<Listener>, Provider<Set<Listener>> {
    private final InjectorLike f1101a;

    public STATICDI_MULTIBIND_PROVIDER$ActivityTracer_Listener(InjectorLike injectorLike) {
        this.f1101a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1101a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 0;
    }

    public final Object provide(Injector injector, int i) {
        throw new IllegalArgumentException("Invalid binding index");
    }
}

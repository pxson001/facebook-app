package com.facebook.common.touchlistener;

import com.facebook.analytics.eventlisteners.InteractionEventListenerDispatcher;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$FbTouchEventActivityListener implements MultiBindIndexedProvider<FbTouchEventActivityListener>, Provider<Set<FbTouchEventActivityListener>> {
    private final InjectorLike f3751a;

    public STATICDI_MULTIBIND_PROVIDER$FbTouchEventActivityListener(InjectorLike injectorLike) {
        this.f3751a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f3751a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return InteractionEventListenerDispatcher.m6205a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

package com.facebook.config.server;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$UserAgentComponent implements MultiBindIndexedProvider<UserAgentComponent>, Provider<Set<UserAgentComponent>> {
    private final InjectorLike f5561a;

    public STATICDI_MULTIBIND_PROVIDER$UserAgentComponent(InjectorLike injectorLike) {
        this.f5561a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f5561a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 0;
    }

    public final Object provide(Injector injector, int i) {
        throw new IllegalArgumentException("Invalid binding index");
    }
}

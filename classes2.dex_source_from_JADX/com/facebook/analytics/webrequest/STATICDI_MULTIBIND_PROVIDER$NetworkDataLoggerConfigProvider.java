package com.facebook.analytics.webrequest;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.util.logging.FB4ADataLoggerConfigProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$NetworkDataLoggerConfigProvider implements MultiBindIndexedProvider<NetworkDataLoggerConfigProvider>, Provider<Set<NetworkDataLoggerConfigProvider>> {
    private final InjectorLike f12046a;

    public STATICDI_MULTIBIND_PROVIDER$NetworkDataLoggerConfigProvider(InjectorLike injectorLike) {
        this.f12046a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f12046a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return FB4ADataLoggerConfigProvider.m24637a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

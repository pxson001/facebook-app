package com.facebook.quicklog;

import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.loom.module.QPLVisitorForLoom;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.quicklog.module.QPLVisitorForCTScanMethodAutoProvider;
import com.facebook.trace.PerfDebugTracer;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$QuickEventListener implements MultiBindIndexedProvider<QuickEventListener>, Provider<Set<QuickEventListener>> {
    private final InjectorLike f1559a;

    private STATICDI_MULTIBIND_PROVIDER$QuickEventListener(InjectorLike injectorLike) {
        this.f1559a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1559a.getScopeAwareInjector(), this);
    }

    public static Set<QuickEventListener> m3057a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$QuickEventListener(injectorLike));
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                QPLVisitorForLoom qPLVisitorForLoom = new QPLVisitorForLoom();
                qPLVisitorForLoom.f1582b = IdBasedSingletonScopeProvider.m1810b(injector, 476);
                return qPLVisitorForLoom;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return QPLVisitorForCTScanMethodAutoProvider.m3192a(injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return PerfDebugTracer.m3203a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

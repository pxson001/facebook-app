package com.facebook.analytics.tagging;

import com.facebook.analytics.NavigationToastProvider;
import com.facebook.http.common.NetworkOnModuleChangedListener;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.performancelogger.PerfLoggerNavigationEventListener;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$NavigationEventListener implements MultiBindIndexedProvider<NavigationEventListener>, Provider<Set<NavigationEventListener>> {
    private final InjectorLike f3337a;

    public STATICDI_MULTIBIND_PROVIDER$NavigationEventListener(InjectorLike injectorLike) {
        this.f3337a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f3337a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return NavigationToastProvider.m13034a(injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return NetworkOnModuleChangedListener.m13038a(injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return PerfLoggerNavigationEventListener.m13041a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

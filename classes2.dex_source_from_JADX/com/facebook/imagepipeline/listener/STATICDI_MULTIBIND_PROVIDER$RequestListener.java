package com.facebook.imagepipeline.listener;

import com.facebook.http.push.C0467x1d8d6909;
import com.facebook.imagepipeline.instrumentation.RequestPerfLoggingListener;
import com.facebook.imagepipeline.module.RequestLoggingListenerMethodAutoProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.photos.base.C0465xb30f5de8;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$RequestListener implements MultiBindIndexedProvider<RequestListener>, Provider<Set<RequestListener>> {
    private final InjectorLike f10772a;

    private STATICDI_MULTIBIND_PROVIDER$RequestListener(InjectorLike injectorLike) {
        this.f10772a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10772a.getScopeAwareInjector(), this);
    }

    public static Set<RequestListener> m16017a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$RequestListener(injectorLike));
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return RequestPerfLoggingListener.m16373a((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return RequestLoggingListenerMethodAutoProvider.m16392a(injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return C0465xb30f5de8.m16405a(injector);
            case 3:
                return C0467x1d8d6909.m16433a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

package com.facebook.imagepipeline.internal;

import com.facebook.http.push.C0467x1d8d6909;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.photos.base.C0465xb30f5de8;
import com.facebook.photos.base.analytics.efficiency.PhotosEvictionLogger;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$FbImageFetchListener implements MultiBindIndexedProvider<FbImageFetchListener>, Provider<Set<FbImageFetchListener>> {
    private final InjectorLike f10763a;

    private STATICDI_MULTIBIND_PROVIDER$FbImageFetchListener(InjectorLike injectorLike) {
        this.f10763a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10763a.getScopeAwareInjector(), this);
    }

    public static Set<FbImageFetchListener> m16005a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$FbImageFetchListener(injectorLike));
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return C0465xb30f5de8.m16405a(injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return C0467x1d8d6909.m16433a(injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return PhotosEvictionLogger.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

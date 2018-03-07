package com.facebook.common.flightrecorder;

import com.facebook.common.network.FbNetworkManager;
import com.facebook.http.common.HttpFlightRecorderRequestSupplier;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$FbHttpNetworkCustomDataSupplier implements MultiBindIndexedProvider<FbHttpNetworkCustomDataSupplier>, Provider<Set<FbHttpNetworkCustomDataSupplier>> {
    private final InjectorLike f2264a;

    public STATICDI_MULTIBIND_PROVIDER$FbHttpNetworkCustomDataSupplier(InjectorLike injectorLike) {
        this.f2264a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f2264a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return FbNetworkManager.m3811a((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return HttpFlightRecorderRequestSupplier.m17818a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

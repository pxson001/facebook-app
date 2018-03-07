package com.facebook.common.uri;

import com.facebook.directinstall.DirectInstallIntentListener;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.intent.thirdparty.intentlistener.ThirdPartyIntentListener;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$UriIntentListener implements MultiBindIndexedProvider<UriIntentListener>, Provider<Set<UriIntentListener>> {
    private final InjectorLike f4858a;

    public STATICDI_MULTIBIND_PROVIDER$UriIntentListener(InjectorLike injectorLike) {
        this.f4858a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f4858a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new DirectInstallIntentListener(IdBasedSingletonScopeProvider.m1809a(injector, 5501));
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return ThirdPartyIntentListener.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

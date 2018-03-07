package com.facebook.content;

import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.dialtone.DialtoneAwareInternalIntentHandler;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProviderLazy;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.zero.ZeroAwareInternalIntentHandler;
import com.facebook.zero.common.intent.STATICDI_MULTIBIND_PROVIDER$InternalIntentBlacklistItem;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$InternalIntentHandler implements MultiBindIndexedProvider<InternalIntentHandler>, Provider<Set<InternalIntentHandler>> {
    private final InjectorLike f2449a;

    public STATICDI_MULTIBIND_PROVIDER$InternalIntentHandler(InjectorLike injectorLike) {
        this.f2449a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f2449a.getScopeAwareInjector(), this);
    }

    public static Lazy<Set<InternalIntentHandler>> m4653a(InjectorLike injectorLike) {
        return ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$InternalIntentHandler(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new DialtoneAwareInternalIntentHandler(DialtoneControllerImpl.m8272a((InjectorLike) injector), DefaultSecureContextHelper.m4636a((InjectorLike) injector));
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new ZeroAwareInternalIntentHandler(IdBasedProvider.m1811a(injector, 4034), new MultiBinderSet(injector.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$InternalIntentBlacklistItem(injector)), FbErrorReporterImpl.m2317a((InjectorLike) injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

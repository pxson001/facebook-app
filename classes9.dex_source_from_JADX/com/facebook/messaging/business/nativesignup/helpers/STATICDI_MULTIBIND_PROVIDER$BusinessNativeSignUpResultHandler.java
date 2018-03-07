package com.facebook.messaging.business.nativesignup.helpers;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.business.ride.helper.RideNativeSignUpResultHandler;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: recommended_radius */
public final class STATICDI_MULTIBIND_PROVIDER$BusinessNativeSignUpResultHandler implements MultiBindIndexedProvider<BusinessNativeSignUpResultHandler>, Provider<Set<BusinessNativeSignUpResultHandler>> {
    private final InjectorLike f8869a;

    public STATICDI_MULTIBIND_PROVIDER$BusinessNativeSignUpResultHandler(InjectorLike injectorLike) {
        this.f8869a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8869a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return DefaultNativeSignUpResultHandler.m9146b((InjectorLike) injector);
            case 1:
                return RideNativeSignUpResultHandler.m9718b((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

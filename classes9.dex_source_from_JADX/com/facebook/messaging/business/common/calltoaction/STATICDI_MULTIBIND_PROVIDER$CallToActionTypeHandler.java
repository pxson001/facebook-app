package com.facebook.messaging.business.common.calltoaction;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.business.ride.helper.RideMutationHelper;
import com.facebook.messaging.business.ride.view.RideCallToActionHandler;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: recommended_radius */
public final class STATICDI_MULTIBIND_PROVIDER$CallToActionTypeHandler implements MultiBindIndexedProvider<CallToActionTypeHandler>, Provider<Set<CallToActionTypeHandler>> {
    private final InjectorLike f8733a;

    public STATICDI_MULTIBIND_PROVIDER$CallToActionTypeHandler(InjectorLike injectorLike) {
        this.f8733a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8733a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return CTAPostbackActionHandler.m8920b(injector);
            case 1:
                return new RideCallToActionHandler(RideMutationHelper.m9712b((InjectorLike) injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

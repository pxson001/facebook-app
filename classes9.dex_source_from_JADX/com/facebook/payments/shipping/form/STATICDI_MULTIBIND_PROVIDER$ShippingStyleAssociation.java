package com.facebook.payments.shipping.form;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.payment.method.input.shipping.MessengerCommerceShippingStyleAssociation;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: recommended_radius */
public final class STATICDI_MULTIBIND_PROVIDER$ShippingStyleAssociation implements MultiBindIndexedProvider<ShippingStyleAssociation>, Provider<Set<ShippingStyleAssociation>> {
    private final InjectorLike f18912a;

    public STATICDI_MULTIBIND_PROVIDER$ShippingStyleAssociation(InjectorLike injectorLike) {
        this.f18912a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f18912a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new MessengerCommerceShippingStyleAssociation(IdBasedLazy.a(injector, 8058), IdBasedLazy.a(injector, 8055), IdBasedLazy.a(injector, 8056), IdBasedLazy.a(injector, 8059));
            case 1:
                return new SimpleShippingStyleAssociation(IdBasedLazy.a(injector, 9215), IdBasedLazy.a(injector, 9212), IdBasedLazy.a(injector, 9229), IdBasedLazy.a(injector, 9230));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

package com.facebook.payments.checkout;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.payment.value.input.checkout.MCheckoutStyleAssociation;
import com.facebook.messaging.payment.value.input.checkout.MessengerCommerceCheckoutStyleAssociation;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: recommended_radius */
public final class STATICDI_MULTIBIND_PROVIDER$CheckoutStyleAssociation implements MultiBindIndexedProvider<CheckoutStyleAssociation>, Provider<Set<CheckoutStyleAssociation>> {
    private final InjectorLike f18481a;

    public STATICDI_MULTIBIND_PROVIDER$CheckoutStyleAssociation(InjectorLike injectorLike) {
        this.f18481a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f18481a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new MCheckoutStyleAssociation(IdBasedLazy.a(injector, 9115), IdBasedLazy.a(injector, 9116), IdBasedLazy.a(injector, 9118), IdBasedLazy.a(injector, 8248), IdBasedLazy.a(injector, 8244), IdBasedLazy.a(injector, 8245), IdBasedLazy.a(injector, 9127), IdBasedLazy.a(injector, 9126), IdBasedLazy.a(injector, 8247), IdBasedLazy.a(injector, 8243));
            case 1:
                return MessengerCommerceCheckoutStyleAssociation.m15958b(injector);
            case 2:
                return SimpleCheckoutStyleAssociation.m18498b(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

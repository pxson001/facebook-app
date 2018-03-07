package com.facebook.payments.paymentmethods.cardform;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.payment.method.input.MessengerPayAddCardFormStyleAssociation;
import com.facebook.messaging.payment.method.input.MessengerPayEditCardFormStyleAssociation;
import com.facebook.messaging.payment.method.input.cvv.MessengerPayRequireCvvFormStyleAssociation;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: unknown relative layout param =  */
public final class STATICDI_MULTIBIND_PROVIDER$CardFormStyleAssociation implements MultiBindIndexedProvider<CardFormStyleAssociation>, Provider<Set<CardFormStyleAssociation>> {
    private final InjectorLike f1869a;

    public STATICDI_MULTIBIND_PROVIDER$CardFormStyleAssociation(InjectorLike injectorLike) {
        this.f1869a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1869a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new MessengerPayAddCardFormStyleAssociation(IdBasedLazy.a(injector, 8045), IdBasedLazy.a(injector, 8041), IdBasedLazy.a(injector, 8042), IdBasedLazy.a(injector, 8046), IdBasedLazy.a(injector, 8043));
            case 1:
                return MessengerPayEditCardFormStyleAssociation.b(injector);
            case 2:
                return MessengerPayRequireCvvFormStyleAssociation.b(injector);
            case 3:
                return SimpleCardFormStyleAssociation.m2087b(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

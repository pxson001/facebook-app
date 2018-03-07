package com.facebook.payments.confirmation;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.payment.value.input.pagescommerce.PagesCommerceConfirmationStyleAssociation;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: recommended_radius */
public final class STATICDI_MULTIBIND_PROVIDER$ConfirmationStyleAssociation implements MultiBindIndexedProvider<ConfirmationStyleAssociation>, Provider<Set<ConfirmationStyleAssociation>> {
    private final InjectorLike f18627a;

    public STATICDI_MULTIBIND_PROVIDER$ConfirmationStyleAssociation(InjectorLike injectorLike) {
        this.f18627a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f18627a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new PagesCommerceConfirmationStyleAssociation(IdBasedLazy.a(injector, 8261), IdBasedLazy.a(injector, 9132), IdBasedLazy.a(injector, 9133), IdBasedLazy.a(injector, 9134));
            case 1:
                return new SimpleConfirmationStyleAssociation(IdBasedLazy.a(injector, 9136), IdBasedLazy.a(injector, 9132), IdBasedLazy.a(injector, 9133), IdBasedLazy.a(injector, 9134));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

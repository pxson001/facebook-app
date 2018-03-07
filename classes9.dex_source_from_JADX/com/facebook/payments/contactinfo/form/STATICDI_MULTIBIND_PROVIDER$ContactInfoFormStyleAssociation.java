package com.facebook.payments.contactinfo.form;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: recommended_radius */
public final class STATICDI_MULTIBIND_PROVIDER$ContactInfoFormStyleAssociation implements MultiBindIndexedProvider<ContactInfoFormStyleAssociation>, Provider<Set<ContactInfoFormStyleAssociation>> {
    private final InjectorLike f18676a;

    public STATICDI_MULTIBIND_PROVIDER$ContactInfoFormStyleAssociation(InjectorLike injectorLike) {
        this.f18676a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f18676a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new EmailContactInfoFormStyleAssociation(IdBasedLazy.a(injector, 9138), IdBasedLazy.a(injector, 9147));
            case 1:
                return new SimpleContactInfoFormStyleAssociation(IdBasedLazy.a(injector, 9141), IdBasedLazy.a(injector, 9147));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

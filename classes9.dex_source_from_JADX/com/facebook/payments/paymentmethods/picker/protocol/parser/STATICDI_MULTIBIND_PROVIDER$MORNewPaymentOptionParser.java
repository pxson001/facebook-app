package com.facebook.payments.paymentmethods.picker.protocol.parser;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: recommended_radius */
public final class STATICDI_MULTIBIND_PROVIDER$MORNewPaymentOptionParser implements MultiBindIndexedProvider<MORNewPaymentOptionParser>, Provider<Set<MORNewPaymentOptionParser>> {
    private final InjectorLike f18878a;

    public STATICDI_MULTIBIND_PROVIDER$MORNewPaymentOptionParser(InjectorLike injectorLike) {
        this.f18878a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f18878a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new MORNewCreditCardOptionParser();
            case 1:
                return new MORNewPayPalOptionParser();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

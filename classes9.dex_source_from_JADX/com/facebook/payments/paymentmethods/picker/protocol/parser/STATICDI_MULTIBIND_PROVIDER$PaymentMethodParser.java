package com.facebook.payments.paymentmethods.picker.protocol.parser;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: recommended_radius */
public final class STATICDI_MULTIBIND_PROVIDER$PaymentMethodParser implements MultiBindIndexedProvider<PaymentMethodParser>, Provider<Set<PaymentMethodParser>> {
    private final InjectorLike f18880a;

    public STATICDI_MULTIBIND_PROVIDER$PaymentMethodParser(InjectorLike injectorLike) {
        this.f18880a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f18880a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new CreditCardPaymentMethodParser();
            case 1:
                return new PayPalBillingAgreementPaymentMethodParser();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

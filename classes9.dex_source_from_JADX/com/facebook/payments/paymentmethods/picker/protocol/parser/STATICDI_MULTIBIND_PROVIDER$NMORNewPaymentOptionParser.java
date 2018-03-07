package com.facebook.payments.paymentmethods.picker.protocol.parser;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.payment.protocol.cards.parser.NMORNewManualTransferOptionParser;
import com.facebook.messaging.payment.protocol.cards.parser.NMORNewNetBankingOptionParser;
import com.facebook.messaging.payment.protocol.cards.parser.NMORNewPayOverCounterOptionParser;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: recommended_radius */
public final class STATICDI_MULTIBIND_PROVIDER$NMORNewPaymentOptionParser implements MultiBindIndexedProvider<NMORNewPaymentOptionParser>, Provider<Set<NMORNewPaymentOptionParser>> {
    private final InjectorLike f18879a;

    public STATICDI_MULTIBIND_PROVIDER$NMORNewPaymentOptionParser(InjectorLike injectorLike) {
        this.f18879a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f18879a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new NMORNewManualTransferOptionParser();
            case 1:
                return new NMORNewNetBankingOptionParser();
            case 2:
                return new NMORNewPayOverCounterOptionParser();
            case 3:
                return new NMORNewCreditCardOptionParser();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

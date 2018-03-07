package com.facebook.payments.checkout;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.payments.checkout.recyclerview.SimpleCheckoutRowViewHolderFactory;
import com.facebook.payments.checkout.recyclerview.SimpleCheckoutRowsGenerator;
import com.facebook.payments.checkout.recyclerview.SimpleCheckoutSubScreenParamsGenerator;
import com.facebook.payments.checkout.statemachine.SimpleCheckoutStateMachineHandler;
import com.facebook.payments.checkout.statemachine.SimpleCheckoutStateMachineOrganizer;
import javax.inject.Inject;

/* compiled from: card */
public class SimpleCheckoutStyleAssociation extends CheckoutStyleAssociation<SimpleCheckoutDataLoader, SimpleCheckoutDataMutator, SimpleCheckoutOnActivityResultHandler, SimpleCheckoutSubScreenParamsGenerator, SimpleCheckoutRowsGenerator, SimpleCheckoutSender, SimpleCheckoutStateMachineOrganizer, SimpleCheckoutStateMachineHandler, SimpleCheckoutStyleRenderer, SimpleCheckoutRowViewHolderFactory> {
    public static SimpleCheckoutStyleAssociation m18498b(InjectorLike injectorLike) {
        return new SimpleCheckoutStyleAssociation(IdBasedLazy.a(injectorLike, 9115), IdBasedLazy.a(injectorLike, 9116), IdBasedLazy.a(injectorLike, 9118), IdBasedLazy.a(injectorLike, 9125), IdBasedLazy.a(injectorLike, 9124), IdBasedLazy.a(injectorLike, 9119), IdBasedLazy.a(injectorLike, 9127), IdBasedLazy.a(injectorLike, 9126), IdBasedLazy.a(injectorLike, 9121), IdBasedLazy.a(injectorLike, 9123));
    }

    @Inject
    public SimpleCheckoutStyleAssociation(Lazy<SimpleCheckoutDataLoader> lazy, Lazy<SimpleCheckoutDataMutator> lazy2, Lazy<SimpleCheckoutOnActivityResultHandler> lazy3, Lazy<SimpleCheckoutSubScreenParamsGenerator> lazy4, Lazy<SimpleCheckoutRowsGenerator> lazy5, Lazy<SimpleCheckoutSender> lazy6, Lazy<SimpleCheckoutStateMachineOrganizer> lazy7, Lazy<SimpleCheckoutStateMachineHandler> lazy8, Lazy<SimpleCheckoutStyleRenderer> lazy9, Lazy<SimpleCheckoutRowViewHolderFactory> lazy10) {
        super(CheckoutStyle.SIMPLE, lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8, lazy9, lazy10);
    }
}

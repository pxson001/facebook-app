package com.facebook.messaging.payment.value.input.checkout;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.payments.checkout.CheckoutStyle;
import com.facebook.payments.checkout.CheckoutStyleAssociation;
import com.facebook.payments.checkout.SimpleCheckoutOnActivityResultHandler;
import com.facebook.payments.checkout.statemachine.SimpleCheckoutStateMachineHandler;
import com.facebook.payments.checkout.statemachine.SimpleCheckoutStateMachineOrganizer;
import javax.inject.Inject;

/* compiled from: encryption_key */
public class MessengerCommerceCheckoutStyleAssociation extends CheckoutStyleAssociation<MessengerCommerceCheckoutDataLoader, MessengerCommerceCheckoutDataMutator, SimpleCheckoutOnActivityResultHandler, MessengerCommerceCheckoutSubScreenParamsGenerator, MessengerCommerceCheckoutRowsGenerator, MessengerCommerceCheckoutSender, SimpleCheckoutStateMachineOrganizer, SimpleCheckoutStateMachineHandler, MessengerCommerceCheckoutStyleRenderer, MessengerCommerceCheckoutRowViewHolderFactory> {
    public static MessengerCommerceCheckoutStyleAssociation m15958b(InjectorLike injectorLike) {
        return new MessengerCommerceCheckoutStyleAssociation(IdBasedLazy.a(injectorLike, 8249), IdBasedLazy.a(injectorLike, 8250), IdBasedLazy.a(injectorLike, 9118), IdBasedLazy.a(injectorLike, 8256), IdBasedLazy.a(injectorLike, 8252), IdBasedLazy.a(injectorLike, 8253), IdBasedLazy.a(injectorLike, 9127), IdBasedLazy.a(injectorLike, 9126), IdBasedLazy.a(injectorLike, 8255), IdBasedLazy.a(injectorLike, 8251));
    }

    @Inject
    public MessengerCommerceCheckoutStyleAssociation(Lazy<MessengerCommerceCheckoutDataLoader> lazy, Lazy<MessengerCommerceCheckoutDataMutator> lazy2, Lazy<SimpleCheckoutOnActivityResultHandler> lazy3, Lazy<MessengerCommerceCheckoutSubScreenParamsGenerator> lazy4, Lazy<MessengerCommerceCheckoutRowsGenerator> lazy5, Lazy<MessengerCommerceCheckoutSender> lazy6, Lazy<SimpleCheckoutStateMachineOrganizer> lazy7, Lazy<SimpleCheckoutStateMachineHandler> lazy8, Lazy<MessengerCommerceCheckoutStyleRenderer> lazy9, Lazy<MessengerCommerceCheckoutRowViewHolderFactory> lazy10) {
        super(CheckoutStyle.MESSENGER_COMMERCE, lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8, lazy9, lazy10);
    }
}

package com.facebook.messaging.payment.method.input;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.payments.paymentmethods.cardform.CardFormStyle;
import com.facebook.payments.paymentmethods.cardform.CardFormStyleAssociation;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormViewController;
import javax.inject.Inject;

/* compiled from: incoming_transactions_creation_time_index */
public class MessengerPayEditCardFormStyleAssociation extends CardFormStyleAssociation<MessengerPayEditCardFormStyleRenderer, MessengerPayEditCardFormAnalyticsEventSelector, MessengerPayEditCardFormConfigurator, SimpleCardFormViewController, MessengerPayEditCardFormMutator> {
    public static MessengerPayEditCardFormStyleAssociation m13373b(InjectorLike injectorLike) {
        return new MessengerPayEditCardFormStyleAssociation(IdBasedLazy.a(injectorLike, 8051), IdBasedLazy.a(injectorLike, 8047), IdBasedLazy.a(injectorLike, 8048), IdBasedLazy.a(injectorLike, 9156), IdBasedLazy.a(injectorLike, 8049));
    }

    @Inject
    public MessengerPayEditCardFormStyleAssociation(Lazy<MessengerPayEditCardFormStyleRenderer> lazy, Lazy<MessengerPayEditCardFormAnalyticsEventSelector> lazy2, Lazy<MessengerPayEditCardFormConfigurator> lazy3, Lazy<SimpleCardFormViewController> lazy4, Lazy<MessengerPayEditCardFormMutator> lazy5) {
        super(CardFormStyle.MESSENGER_PAY_EDIT, lazy, lazy2, lazy3, lazy4, lazy5);
    }
}

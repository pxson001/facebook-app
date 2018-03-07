package com.facebook.messaging.payment.method.input.cvv;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.payments.paymentmethods.cardform.CardFormStyle;
import com.facebook.payments.paymentmethods.cardform.CardFormStyleAssociation;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormAnalyticsEventSelector;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormStyleRenderer;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormViewController;
import javax.inject.Inject;

/* compiled from: include_message_info */
public class MessengerPayRequireCvvFormStyleAssociation extends CardFormStyleAssociation<SimpleCardFormStyleRenderer, SimpleCardFormAnalyticsEventSelector, MessengerPayRequireCvvFormConfigurator, SimpleCardFormViewController, MessengerPayRequireCvvFormMutator> {
    public static MessengerPayRequireCvvFormStyleAssociation m13390b(InjectorLike injectorLike) {
        return new MessengerPayRequireCvvFormStyleAssociation(IdBasedLazy.a(injectorLike, 9155), IdBasedLazy.a(injectorLike, 9150), IdBasedLazy.a(injectorLike, 8052), IdBasedLazy.a(injectorLike, 9156), IdBasedLazy.a(injectorLike, 8053));
    }

    @Inject
    public MessengerPayRequireCvvFormStyleAssociation(Lazy<SimpleCardFormStyleRenderer> lazy, Lazy<SimpleCardFormAnalyticsEventSelector> lazy2, Lazy<MessengerPayRequireCvvFormConfigurator> lazy3, Lazy<SimpleCardFormViewController> lazy4, Lazy<MessengerPayRequireCvvFormMutator> lazy5) {
        super(CardFormStyle.MESSENGER_PAY_REQUIRE_CVV, lazy, lazy2, lazy3, lazy4, lazy5);
    }
}

package com.facebook.messaging.payment.method.input;

import com.facebook.inject.Lazy;
import com.facebook.payments.paymentmethods.cardform.CardFormStyle;
import com.facebook.payments.paymentmethods.cardform.CardFormStyleAssociation;
import javax.inject.Inject;

/* compiled from: initEncode failed */
public class MessengerPayAddCardFormStyleAssociation extends CardFormStyleAssociation<MessengerPayAddCardFormStyleRenderer, MessengerPayAddCardFormAnalyticsEventSelector, MessengerPayAddCardFormConfigurator, MessengerPayAddCardFormViewController, MessengerPayAddCardFormMutator> {
    @Inject
    public MessengerPayAddCardFormStyleAssociation(Lazy<MessengerPayAddCardFormStyleRenderer> lazy, Lazy<MessengerPayAddCardFormAnalyticsEventSelector> lazy2, Lazy<MessengerPayAddCardFormConfigurator> lazy3, Lazy<MessengerPayAddCardFormViewController> lazy4, Lazy<MessengerPayAddCardFormMutator> lazy5) {
        super(CardFormStyle.MESSENGER_PAY_ADD, lazy, lazy2, lazy3, lazy4, lazy5);
    }
}

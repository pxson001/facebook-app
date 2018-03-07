package com.facebook.messaging.payment.method.input.shipping;

import com.facebook.inject.Lazy;
import com.facebook.payments.shipping.form.ShippingStyleAssociation;
import com.facebook.payments.shipping.model.ShippingStyle;
import javax.inject.Inject;

/* compiled from: in_tc */
public class MessengerCommerceShippingStyleAssociation extends ShippingStyleAssociation<MessengerCommerceShippingStyleRenderer, MessengerCommerceShippingAddressMutator, MessengerCommerceShippingStateInputValidator, MessengerCommerceShippingZipInputValidator> {
    @Inject
    public MessengerCommerceShippingStyleAssociation(Lazy<MessengerCommerceShippingStyleRenderer> lazy, Lazy<MessengerCommerceShippingAddressMutator> lazy2, Lazy<MessengerCommerceShippingStateInputValidator> lazy3, Lazy<MessengerCommerceShippingZipInputValidator> lazy4) {
        super(ShippingStyle.MESSENGER_COMMERCE, lazy, lazy2, lazy3, lazy4);
    }
}

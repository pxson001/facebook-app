package com.facebook.payments.shipping.form;

import com.facebook.inject.Lazy;
import com.facebook.payments.shipping.model.ShippingStyle;
import com.facebook.payments.shipping.validation.SimpleShippingStateInputValidator;
import com.facebook.payments.shipping.validation.SimpleShippingZipInputValidator;
import javax.inject.Inject;

/* compiled from: backstage_selfstack_open */
public class SimpleShippingStyleAssociation extends ShippingStyleAssociation<SimpleShippingStyleRenderer, SimpleShippingAddressMutator, SimpleShippingStateInputValidator, SimpleShippingZipInputValidator> {
    @Inject
    public SimpleShippingStyleAssociation(Lazy<SimpleShippingStyleRenderer> lazy, Lazy<SimpleShippingAddressMutator> lazy2, Lazy<SimpleShippingStateInputValidator> lazy3, Lazy<SimpleShippingZipInputValidator> lazy4) {
        super(ShippingStyle.SIMPLE, lazy, lazy2, lazy3, lazy4);
    }
}

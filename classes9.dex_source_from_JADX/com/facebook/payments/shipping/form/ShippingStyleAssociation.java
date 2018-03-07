package com.facebook.payments.shipping.form;

import com.facebook.inject.Lazy;
import com.facebook.payments.shipping.model.ShippingStyle;
import com.facebook.payments.shipping.validation.ShippingStateInputValidator;
import com.facebook.payments.shipping.validation.ShippingZipInputValidator;
import com.google.common.base.Preconditions;

/* compiled from: inbox/# */
public class ShippingStyleAssociation<STYLE_RENDERER extends ShippingStyleRenderer, MUTATOR extends ShippingAddressMutator, STATE_INPUT_VALIDATOR extends ShippingStateInputValidator, ZIP_INPUT_VALIDATOR extends ShippingZipInputValidator> {
    public final ShippingStyle f13099a;
    public final Lazy<STYLE_RENDERER> f13100b;
    public final Lazy<MUTATOR> f13101c;
    public final Lazy<STATE_INPUT_VALIDATOR> f13102d;
    public final Lazy<ZIP_INPUT_VALIDATOR> f13103e;

    public ShippingStyleAssociation(ShippingStyle shippingStyle, Lazy<STYLE_RENDERER> lazy, Lazy<MUTATOR> lazy2, Lazy<STATE_INPUT_VALIDATOR> lazy3, Lazy<ZIP_INPUT_VALIDATOR> lazy4) {
        this.f13099a = (ShippingStyle) Preconditions.checkNotNull(shippingStyle);
        this.f13100b = lazy;
        this.f13101c = lazy2;
        this.f13102d = lazy3;
        this.f13103e = lazy4;
    }
}

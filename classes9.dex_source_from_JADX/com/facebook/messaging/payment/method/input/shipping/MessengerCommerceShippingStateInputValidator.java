package com.facebook.messaging.payment.method.input.shipping;

import android.content.res.Resources;
import com.facebook.common.locale.Country;
import com.facebook.payments.paymentmethods.cardform.validation.InputValidatorParams;
import com.facebook.payments.shipping.validation.SimpleShippingStateInputValidator;
import javax.inject.Inject;

/* compiled from: incall_count */
public class MessengerCommerceShippingStateInputValidator extends SimpleShippingStateInputValidator {
    private Country f13098a;

    @Inject
    public MessengerCommerceShippingStateInputValidator(Resources resources) {
        super(resources);
    }

    public final boolean mo515a(InputValidatorParams inputValidatorParams) {
        if (Country.a.equals(this.f13098a)) {
            return super.mo515a(inputValidatorParams);
        }
        return true;
    }

    public final void mo514a(Country country) {
        this.f13098a = country;
    }

    public final int mo513a() {
        if (Country.a.equals(this.f13098a)) {
            return super.mo513a();
        }
        return Integer.MAX_VALUE;
    }
}

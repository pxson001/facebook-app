package com.facebook.messaging.payment.method.input.shipping;

import android.content.res.Resources;
import com.facebook.common.locale.Country;
import com.facebook.payments.paymentmethods.cardform.validation.BillingZipInputValidator;
import com.facebook.payments.paymentmethods.cardform.validation.InputValidatorParams;
import com.facebook.payments.shipping.validation.SimpleShippingZipInputValidator;
import javax.inject.Inject;

/* compiled from: imp_private_message_selection */
public class MessengerCommerceShippingZipInputValidator extends SimpleShippingZipInputValidator {
    private Country f13109a;

    @Inject
    public MessengerCommerceShippingZipInputValidator(Resources resources, BillingZipInputValidator billingZipInputValidator) {
        super(resources, billingZipInputValidator);
    }

    public final boolean mo519a(InputValidatorParams inputValidatorParams) {
        if (Country.a.equals(this.f13109a)) {
            return super.mo519a(inputValidatorParams);
        }
        return true;
    }

    public final void mo518a(Country country) {
        this.f13109a = country;
    }

    public final int mo517a() {
        if (Country.a.equals(this.f13109a)) {
            return super.mo517a();
        }
        return Integer.MAX_VALUE;
    }
}

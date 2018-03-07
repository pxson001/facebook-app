package com.facebook.payments.shipping.validation;

import android.content.res.Resources;
import com.facebook.common.locale.Country;
import com.facebook.payments.paymentmethods.cardform.validation.BillingZipInputValidator;
import com.facebook.payments.paymentmethods.cardform.validation.InputValidatorParams;
import com.facebook.payments.paymentmethods.cardform.validation.TextInputValidator;
import javax.inject.Inject;

/* compiled from: impression_list */
public class SimpleShippingZipInputValidator implements TextInputValidator {
    private Resources f13107a;
    private BillingZipInputValidator f13108b;

    @Inject
    public SimpleShippingZipInputValidator(Resources resources, BillingZipInputValidator billingZipInputValidator) {
        this.f13107a = resources;
        this.f13108b = billingZipInputValidator;
    }

    public boolean mo519a(InputValidatorParams inputValidatorParams) {
        return this.f13108b.a(inputValidatorParams);
    }

    public final String m13425b(InputValidatorParams inputValidatorParams) {
        return this.f13107a.getString(2131240113);
    }

    public int mo517a() {
        return 5;
    }

    public void mo518a(Country country) {
    }
}

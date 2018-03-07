package com.facebook.adspayments.validation;

import com.facebook.adspayments.PaymentsQeAccessor;
import javax.inject.Inject;

/* compiled from: UPLOAD_FAILED */
public class BillingZipInputValidator extends InputValidatorCallbackHandler {
    public final PaymentsQeAccessor f23726a;

    @Inject
    public BillingZipInputValidator(PaymentsQeAccessor paymentsQeAccessor) {
        this.f23726a = paymentsQeAccessor;
    }
}

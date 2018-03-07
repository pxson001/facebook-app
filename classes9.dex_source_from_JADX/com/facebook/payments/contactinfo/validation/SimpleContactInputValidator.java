package com.facebook.payments.contactinfo.validation;

import com.facebook.common.util.StringUtil;
import com.facebook.payments.paymentmethods.cardform.validation.InputValidatorParams;
import com.facebook.payments.paymentmethods.cardform.validation.TextInputValidator;

/* compiled from: boosted_product_mobile */
public class SimpleContactInputValidator implements TextInputValidator {
    public final boolean m18716a(InputValidatorParams inputValidatorParams) {
        return !StringUtil.a(inputValidatorParams.a());
    }

    public final String m18717b(InputValidatorParams inputValidatorParams) {
        return null;
    }
}

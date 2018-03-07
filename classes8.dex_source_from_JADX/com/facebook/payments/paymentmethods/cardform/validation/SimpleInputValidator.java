package com.facebook.payments.paymentmethods.cardform.validation;

import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;

/* compiled from: supported_roles */
public class SimpleInputValidator implements TextInputValidator {
    public static SimpleInputValidator m2142a(InjectorLike injectorLike) {
        return new SimpleInputValidator();
    }

    public final boolean mo91a(InputValidatorParams inputValidatorParams) {
        return !StringUtil.a(inputValidatorParams.mo93a());
    }

    public final String mo92b(InputValidatorParams inputValidatorParams) {
        return null;
    }
}

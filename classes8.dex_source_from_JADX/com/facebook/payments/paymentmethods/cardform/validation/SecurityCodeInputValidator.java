package com.facebook.payments.paymentmethods.cardform.validation;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import javax.inject.Inject;

/* compiled from: supports_screen_resolution_images */
public class SecurityCodeInputValidator implements TextInputValidator {
    private final Resources f1938a;

    public static SecurityCodeInputValidator m2138b(InjectorLike injectorLike) {
        return new SecurityCodeInputValidator(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SecurityCodeInputValidator(Resources resources) {
        this.f1938a = resources;
    }

    public final boolean mo91a(InputValidatorParams inputValidatorParams) {
        SecurityCodeInputValidatorParams securityCodeInputValidatorParams = (SecurityCodeInputValidatorParams) inputValidatorParams;
        String a = securityCodeInputValidatorParams.mo93a();
        if (StringUtil.a(a) || !a.matches("\\d{3,4}")) {
            return false;
        }
        FbPaymentCardType fbPaymentCardType = securityCodeInputValidatorParams.f1940b;
        int length = a.length();
        switch (fbPaymentCardType) {
            case AMEX:
                if (length == 4) {
                    return true;
                }
                return false;
            case UNKNOWN:
                if (length == 4 || length == 3) {
                    return true;
                }
                return false;
            default:
                if (length == 3) {
                    return true;
                }
                return false;
        }
    }

    public static int m2137a(FbPaymentCardType fbPaymentCardType) {
        return fbPaymentCardType == FbPaymentCardType.AMEX ? 4 : 3;
    }

    public final String mo92b(InputValidatorParams inputValidatorParams) {
        return ((SecurityCodeInputValidatorParams) inputValidatorParams).f1940b == FbPaymentCardType.AMEX ? this.f1938a.getString(2131238323) : this.f1938a.getString(2131238322);
    }
}

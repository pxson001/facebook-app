package com.facebook.payments.paymentmethods.cardform.validation;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: surface_source_id */
public class BillingZipInputValidator implements TextInputValidator {
    private Resources f1928a;

    public static BillingZipInputValidator m2124b(InjectorLike injectorLike) {
        return new BillingZipInputValidator(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BillingZipInputValidator(Resources resources) {
        this.f1928a = resources;
    }

    public final boolean mo91a(InputValidatorParams inputValidatorParams) {
        Object a = inputValidatorParams.mo93a();
        if (StringUtil.a(a)) {
            return false;
        }
        return a.matches("\\d{5}");
    }

    public final String mo92b(InputValidatorParams inputValidatorParams) {
        return this.f1928a.getString(2131238324);
    }
}

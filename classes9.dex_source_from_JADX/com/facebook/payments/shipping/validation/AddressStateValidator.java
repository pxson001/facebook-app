package com.facebook.payments.shipping.validation;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.payments.paymentmethods.cardform.validation.InputValidatorParams;
import com.facebook.payments.paymentmethods.cardform.validation.TextInputValidator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: backstage_audience_deselect_all */
public class AddressStateValidator implements TextInputValidator {
    private static final ImmutableList<String> f19057b;
    private Resources f19058a;

    private static AddressStateValidator m19023b(InjectorLike injectorLike) {
        return new AddressStateValidator(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AddressStateValidator(Resources resources) {
        this.f19058a = resources;
    }

    static {
        Builder builder = new Builder();
        builder.c("AL");
        builder.c("AK");
        builder.c("AZ");
        builder.c("AR");
        builder.c("CA");
        builder.c("CO");
        builder.c("CT");
        builder.c("DE");
        builder.c("FL");
        builder.c("GA");
        builder.c("HI");
        builder.c("ID");
        builder.c("IL");
        builder.c("IN");
        builder.c("IA");
        builder.c("KS");
        builder.c("KY");
        builder.c("LA");
        builder.c("ME");
        builder.c("MD");
        builder.c("MA");
        builder.c("MI");
        builder.c("MN");
        builder.c("MS");
        builder.c("MO");
        builder.c("MT");
        builder.c("NE");
        builder.c("NV");
        builder.c("NH");
        builder.c("NJ");
        builder.c("NM");
        builder.c("NY");
        builder.c("NC");
        builder.c("ND");
        builder.c("OH");
        builder.c("OK");
        builder.c("OR");
        builder.c("PA");
        builder.c("RI");
        builder.c("SC");
        builder.c("SD");
        builder.c("TN");
        builder.c("TX");
        builder.c("UT");
        builder.c("VT");
        builder.c("VA");
        builder.c("WA");
        builder.c("WV");
        builder.c("WI");
        builder.c("WY");
        f19057b = builder.b();
    }

    public final boolean m19024a(InputValidatorParams inputValidatorParams) {
        CharSequence a = inputValidatorParams.a();
        if (StringUtil.a(a)) {
            return false;
        }
        return f19057b.contains(a);
    }

    public final String m19025b(InputValidatorParams inputValidatorParams) {
        return this.f19058a.getString(2131240112);
    }
}

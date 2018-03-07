package com.facebook.payments.paymentmethods.cardform;

import android.content.Context;
import android.content.Intent;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.dialog.ConfirmActionParams;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: tagged_user_ids */
public class SimpleCardFormConfigurator {
    private final Context f1871a;

    public static SimpleCardFormConfigurator m2059b(InjectorLike injectorLike) {
        return new SimpleCardFormConfigurator((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public SimpleCardFormConfigurator(Context context) {
        this.f1871a = context;
    }

    public void m2061a(Context context) {
    }

    public String m2060a(CardFormParams cardFormParams) {
        return this.f1871a.getString(2131238320);
    }

    public boolean m2062a(FbPaymentCardType fbPaymentCardType, CardFormParams cardFormParams) {
        switch (fbPaymentCardType) {
            case AMEX:
            case DISCOVER:
            case JCB:
            case MASTER_CARD:
            case VISA:
                return true;
            default:
                return false;
        }
    }

    @Nullable
    public ConfirmActionParams m2063b(CardFormParams cardFormParams) {
        return null;
    }

    @Nullable
    public Intent m2064c(CardFormParams cardFormParams) {
        return null;
    }

    public boolean m2065d(CardFormParams cardFormParams) {
        if (cardFormParams.mo78a().f1775d == null) {
            return false;
        }
        return cardFormParams.mo78a().f1775d.mo101j();
    }

    public boolean m2066e(CardFormParams cardFormParams) {
        return false;
    }

    public boolean m2067f(CardFormParams cardFormParams) {
        return false;
    }

    public boolean m2068g(CardFormParams cardFormParams) {
        return true;
    }

    public boolean m2069h(CardFormParams cardFormParams) {
        return true;
    }

    public boolean m2070i(CardFormParams cardFormParams) {
        return true;
    }
}

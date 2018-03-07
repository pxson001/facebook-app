package com.facebook.messaging.payment.method.input.cvv;

import android.content.Context;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.payments.paymentmethods.cardform.CardFormParams;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormConfigurator;
import javax.inject.Inject;

/* compiled from: incoming_messenger_payments */
public class MessengerPayRequireCvvFormConfigurator extends SimpleCardFormConfigurator {
    @Inject
    public MessengerPayRequireCvvFormConfigurator(Context context) {
        super(context);
    }

    public final void m13384a(Context context) {
        MessengerMaterialThemeUtil.a(context, 2131625175);
    }

    public final boolean m13385e(CardFormParams cardFormParams) {
        return true;
    }

    public final boolean m13386g(CardFormParams cardFormParams) {
        return false;
    }

    public final boolean m13387h(CardFormParams cardFormParams) {
        return true;
    }

    public final boolean m13388i(CardFormParams cardFormParams) {
        return false;
    }
}

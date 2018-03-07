package com.facebook.messaging.payment.method.input;

import android.content.Context;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.payments.paymentmethods.cardform.CardFormParams;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormConfigurator;
import javax.inject.Inject;

/* compiled from: ineligible_recipient_dialog */
public class MessengerPayEditCardFormConfigurator extends SimpleCardFormConfigurator {
    @Inject
    public MessengerPayEditCardFormConfigurator(Context context) {
        super(context);
    }

    public final void m13341a(Context context) {
        MessengerMaterialThemeUtil.a(context, 2131625175);
    }

    public final boolean m13342d(CardFormParams cardFormParams) {
        MessengerPayCardFormParams messengerPayCardFormParams = (MessengerPayCardFormParams) cardFormParams;
        return !messengerPayCardFormParams.f13036i && super.d(cardFormParams) && messengerPayCardFormParams.f13035h;
    }

    public final boolean m13343e(CardFormParams cardFormParams) {
        MessengerPayCardFormParams messengerPayCardFormParams = (MessengerPayCardFormParams) cardFormParams;
        return !messengerPayCardFormParams.f13036i && messengerPayCardFormParams.f13035h;
    }

    public final boolean m13344f(CardFormParams cardFormParams) {
        MessengerPayCardFormParams messengerPayCardFormParams = (MessengerPayCardFormParams) cardFormParams;
        return (messengerPayCardFormParams.f13036i || !messengerPayCardFormParams.f13035h || ((PaymentCard) cardFormParams.a().d).f13210i) ? false : true;
    }

    public final boolean m13345g(CardFormParams cardFormParams) {
        return ((MessengerPayCardFormParams) cardFormParams).f13036i ? false : super.g(cardFormParams);
    }

    public final boolean m13346h(CardFormParams cardFormParams) {
        return ((MessengerPayCardFormParams) cardFormParams).f13036i ? false : super.g(cardFormParams);
    }

    public final boolean m13347i(CardFormParams cardFormParams) {
        return ((MessengerPayCardFormParams) cardFormParams).f13036i ? false : super.g(cardFormParams);
    }
}

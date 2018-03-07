package com.facebook.messaging.payment.method.input;

import android.view.ViewGroup;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.PaymentCardCategory;
import com.facebook.payments.paymentmethods.cardform.CardFormParams;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormConfigurator;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormStyleRenderer;
import com.facebook.payments.ui.PaymentsComponentView;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: incoming_requests_present */
public class MessengerPayEditCardFormStyleRenderer extends SimpleCardFormStyleRenderer {
    private final SimpleCardFormConfigurator f13074a;

    @Inject
    public MessengerPayEditCardFormStyleRenderer(SimpleCardFormConfigurator simpleCardFormConfigurator) {
        this.f13074a = simpleCardFormConfigurator;
    }

    public final PaymentsComponentView m13378a(ViewGroup viewGroup, CardFormParams cardFormParams) {
        MessengerPayCardFormParams messengerPayCardFormParams = (MessengerPayCardFormParams) cardFormParams;
        MessengerPayEditCardFormHeaderView messengerPayEditCardFormHeaderView = new MessengerPayEditCardFormHeaderView(viewGroup.getContext());
        m13376a(messengerPayEditCardFormHeaderView, messengerPayCardFormParams);
        messengerPayEditCardFormHeaderView.m13360a(messengerPayCardFormParams.f13036i);
        return messengerPayEditCardFormHeaderView;
    }

    public final PaymentsComponentView m13379b(ViewGroup viewGroup, CardFormParams cardFormParams) {
        MessengerPayCardFormParams messengerPayCardFormParams = (MessengerPayCardFormParams) cardFormParams;
        PaymentCard paymentCard = (PaymentCard) messengerPayCardFormParams.f13033f.d;
        Preconditions.checkNotNull(paymentCard);
        MessengerPayEditCardFormFooterView messengerPayEditCardFormFooterView = new MessengerPayEditCardFormFooterView(viewGroup.getContext());
        messengerPayEditCardFormFooterView.f13052e = paymentCard;
        m13374a(messengerPayEditCardFormFooterView, messengerPayCardFormParams);
        m13375a(messengerPayEditCardFormFooterView, messengerPayCardFormParams, paymentCard);
        messengerPayEditCardFormFooterView.m13355a(messengerPayCardFormParams.f13036i);
        return messengerPayEditCardFormFooterView;
    }

    private void m13376a(MessengerPayEditCardFormHeaderView messengerPayEditCardFormHeaderView, MessengerPayCardFormParams messengerPayCardFormParams) {
        int i = 8;
        if (m13377a(messengerPayCardFormParams)) {
            messengerPayEditCardFormHeaderView.setVisibilityOfIsPrimaryCardTextView(8);
            return;
        }
        if (messengerPayCardFormParams.f13034g) {
            i = 0;
        }
        messengerPayEditCardFormHeaderView.setVisibilityOfIsPrimaryCardTextView(i);
    }

    private void m13374a(MessengerPayEditCardFormFooterView messengerPayEditCardFormFooterView, MessengerPayCardFormParams messengerPayCardFormParams) {
        if (m13377a(messengerPayCardFormParams)) {
            messengerPayEditCardFormFooterView.setVisibilityOfDeleteCardButton(8);
        }
    }

    private void m13375a(MessengerPayEditCardFormFooterView messengerPayEditCardFormFooterView, MessengerPayCardFormParams messengerPayCardFormParams, PaymentCard paymentCard) {
        if (m13377a(messengerPayCardFormParams)) {
            messengerPayEditCardFormFooterView.setVisibilityOfMakePrimaryButton(8);
        } else if (messengerPayCardFormParams.f13034g || paymentCard.mo522g() != PaymentCardCategory.DEBIT_CARD) {
            messengerPayEditCardFormFooterView.setVisibilityOfMakePrimaryButton(8);
        } else {
            messengerPayEditCardFormFooterView.setVisibilityOfMakePrimaryButton(0);
        }
    }

    private boolean m13377a(MessengerPayCardFormParams messengerPayCardFormParams) {
        return this.f13074a.d(messengerPayCardFormParams) || messengerPayCardFormParams.f13035h;
    }
}

package com.facebook.messaging.payment.method.input;

import com.facebook.payments.paymentmethods.cardform.CardFormParams;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormAnalyticsEventSelector;

/* compiled from: initialData */
public class MessengerPayAddCardFormAnalyticsEventSelector extends SimpleCardFormAnalyticsEventSelector {
    public final String m13309a(CardFormParams cardFormParams) {
        return "p2p_cancel_add_card";
    }

    public final String m13310b(CardFormParams cardFormParams) {
        return "p2p_confirm_card_details";
    }

    public final String m13311c(CardFormParams cardFormParams) {
        return "p2p_add_card_success";
    }

    public final String m13312d(CardFormParams cardFormParams) {
        return "p2p_add_card_fail";
    }

    public final String m13313e(CardFormParams cardFormParams) {
        return "p2p_add_card_save_button_click";
    }

    public final String m13314f(CardFormParams cardFormParams) {
        return "p2p_add_card_done_button_click";
    }
}

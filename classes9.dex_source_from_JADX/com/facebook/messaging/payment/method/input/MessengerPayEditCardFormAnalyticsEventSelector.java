package com.facebook.messaging.payment.method.input;

import com.facebook.payments.paymentmethods.cardform.CardFormParams;
import com.facebook.payments.paymentmethods.cardform.SimpleCardFormAnalyticsEventSelector;

/* compiled from: inf */
public class MessengerPayEditCardFormAnalyticsEventSelector extends SimpleCardFormAnalyticsEventSelector {
    public final String m13337a(CardFormParams cardFormParams) {
        return "p2p_cancel_edit_card";
    }

    public final String m13338b(CardFormParams cardFormParams) {
        return "p2p_edit_card_details";
    }

    public final String m13339c(CardFormParams cardFormParams) {
        return "p2p_edit_card_success";
    }

    public final String m13340d(CardFormParams cardFormParams) {
        return "p2p_edit_card_fail";
    }
}

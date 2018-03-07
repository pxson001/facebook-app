package com.facebook.messaging.payment.cache;

import com.facebook.messaging.payment.model.PaymentCard;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: intent_extra_data */
public class PaymentCardCacheResult {
    public static final PaymentCardCacheResult f12823c = new PaymentCardCacheResult(null, State.CARD_EXISTS_BUT_NOT_IN_CACHE);
    public static final PaymentCardCacheResult f12824d = new PaymentCardCacheResult(null, State.CARD_DOES_NOT_EXIST);
    public final PaymentCard f12825a;
    public final State f12826b;

    /* compiled from: intent_extra_data */
    public enum State {
        CARD_EXISTS_AND_IN_CACHE,
        CARD_DOES_NOT_EXIST,
        CARD_EXISTS_BUT_NOT_IN_CACHE
    }

    public PaymentCardCacheResult(PaymentCard paymentCard, State state) {
        this.f12825a = paymentCard;
        this.f12826b = state;
    }
}

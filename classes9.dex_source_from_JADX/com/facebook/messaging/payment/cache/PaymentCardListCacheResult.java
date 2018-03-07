package com.facebook.messaging.payment.cache;

import com.facebook.messaging.payment.model.PaymentCard;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: intent_data_id */
public class PaymentCardListCacheResult {
    public static final PaymentCardListCacheResult f12827c = new PaymentCardListCacheResult(RegularImmutableList.a, State.CARDS_EXIST_BUT_NOT_ALL_IN_CACHE);
    public static final PaymentCardListCacheResult f12828d = new PaymentCardListCacheResult(RegularImmutableList.a, State.NO_CARDS_EXIST);
    public final ImmutableList<PaymentCard> f12829a;
    public final State f12830b;

    /* compiled from: intent_data_id */
    public enum State {
        CARDS_EXIST_AND_ALL_IN_CACHE,
        NO_CARDS_EXIST,
        CARDS_EXIST_BUT_NOT_ALL_IN_CACHE
    }

    public PaymentCardListCacheResult(ImmutableList<PaymentCard> immutableList, State state) {
        this.f12829a = immutableList;
        this.f12830b = state;
    }
}

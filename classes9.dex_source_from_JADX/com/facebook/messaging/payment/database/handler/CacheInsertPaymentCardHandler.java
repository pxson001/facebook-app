package com.facebook.messaging.payment.database.handler;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.cache.PaymentCardCache;
import com.facebook.messaging.payment.model.PaymentCard;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: insertOrUpdatePaymentRequest */
public class CacheInsertPaymentCardHandler {
    public final PaymentCardCache f12934a;
    public final DbInsertPaymentCardIdsHandler f12935b;

    public static CacheInsertPaymentCardHandler m13223b(InjectorLike injectorLike) {
        return new CacheInsertPaymentCardHandler(PaymentCardCache.m13157a(injectorLike), DbInsertPaymentCardIdsHandler.m13249a(injectorLike));
    }

    @Inject
    public CacheInsertPaymentCardHandler(PaymentCardCache paymentCardCache, DbInsertPaymentCardIdsHandler dbInsertPaymentCardIdsHandler) {
        this.f12934a = paymentCardCache;
        this.f12935b = dbInsertPaymentCardIdsHandler;
    }

    public final void m13225a(PaymentCard paymentCard) {
        this.f12935b.m13254a(paymentCard.f13202a);
        this.f12934a.m13163a(paymentCard);
    }

    public final void m13226a(ImmutableList<PaymentCard> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(Long.valueOf(((PaymentCard) immutableList.get(i)).f13202a));
        }
        this.f12935b.m13253a();
        this.f12935b.m13255a(builder.b());
        this.f12934a.m13164a((ImmutableList) immutableList);
    }

    public static CacheInsertPaymentCardHandler m13222a(InjectorLike injectorLike) {
        return m13223b(injectorLike);
    }

    public final void m13224a() {
        this.f12935b.m13256b();
        this.f12934a.m13169d();
    }
}

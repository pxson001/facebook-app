package com.facebook.messaging.payment.database.handler;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.cache.PaymentCardCache;
import com.facebook.messaging.payment.model.PaymentCard;
import javax.inject.Inject;

/* compiled from: insertOrUpdateIncomingPaymentRequests */
public class CacheInsertTransactionPaymentCardHandler {
    private final PaymentCardCache f12936a;
    private final DbInsertTransactionPaymentCardIdHandler f12937b;

    public static CacheInsertTransactionPaymentCardHandler m13227b(InjectorLike injectorLike) {
        return new CacheInsertTransactionPaymentCardHandler(PaymentCardCache.m13157a(injectorLike), DbInsertTransactionPaymentCardIdHandler.m13271a(injectorLike));
    }

    @Inject
    public CacheInsertTransactionPaymentCardHandler(PaymentCardCache paymentCardCache, DbInsertTransactionPaymentCardIdHandler dbInsertTransactionPaymentCardIdHandler) {
        this.f12936a = paymentCardCache;
        this.f12937b = dbInsertTransactionPaymentCardIdHandler;
    }

    public final void m13228a(long j, PaymentCard paymentCard) {
        this.f12937b.m13273a(j, paymentCard.f13202a);
        this.f12936a.m13167b(paymentCard);
    }
}

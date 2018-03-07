package com.facebook.messaging.payment.database.handler;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.cache.PaymentCardCache;
import javax.inject.Inject;

/* compiled from: insertOrUpdatePaymentTransaction */
public class CacheFetchTransactionPaymentCardHandler {
    public final PaymentCardCache f12932a;
    public final DbFetchTransactionPaymentCardIdHandler f12933b;

    public static CacheFetchTransactionPaymentCardHandler m13221b(InjectorLike injectorLike) {
        return new CacheFetchTransactionPaymentCardHandler(PaymentCardCache.m13157a(injectorLike), DbFetchTransactionPaymentCardIdHandler.m13246a(injectorLike));
    }

    @Inject
    public CacheFetchTransactionPaymentCardHandler(PaymentCardCache paymentCardCache, DbFetchTransactionPaymentCardIdHandler dbFetchTransactionPaymentCardIdHandler) {
        this.f12932a = paymentCardCache;
        this.f12933b = dbFetchTransactionPaymentCardIdHandler;
    }
}

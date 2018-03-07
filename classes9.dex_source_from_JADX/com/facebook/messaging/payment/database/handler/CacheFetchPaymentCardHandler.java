package com.facebook.messaging.payment.database.handler;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.cache.PaymentCardCache;
import javax.inject.Inject;

/* compiled from: insertOrUpdateTransactionInRecentAll */
public class CacheFetchPaymentCardHandler {
    public final PaymentCardCache f12930a;
    public final DbFetchPaymentCardIdsHandler f12931b;

    public static CacheFetchPaymentCardHandler m13220b(InjectorLike injectorLike) {
        return new CacheFetchPaymentCardHandler(PaymentCardCache.m13157a(injectorLike), DbFetchPaymentCardIdsHandler.m13230a(injectorLike));
    }

    @Inject
    public CacheFetchPaymentCardHandler(PaymentCardCache paymentCardCache, DbFetchPaymentCardIdsHandler dbFetchPaymentCardIdsHandler) {
        this.f12930a = paymentCardCache;
        this.f12931b = dbFetchPaymentCardIdsHandler;
    }
}

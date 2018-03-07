package com.facebook.messaging.payment.thread;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: feed_id */
public class CompositeDetailsPaymentBubbleViewController extends AbstractCompositePaymentBubbleViewController<PaymentBubbleDetailsView> {
    private final Lazy<RequestDetailsPaymentBubbleViewController> f14947a;
    private final Lazy<TransactionDetailsPaymentBubbleViewController> f14948b;

    public static CompositeDetailsPaymentBubbleViewController m15342b(InjectorLike injectorLike) {
        return new CompositeDetailsPaymentBubbleViewController(IdBasedLazy.a(injectorLike, 8186), IdBasedLazy.a(injectorLike, 8193));
    }

    @Inject
    public CompositeDetailsPaymentBubbleViewController(Lazy<RequestDetailsPaymentBubbleViewController> lazy, Lazy<TransactionDetailsPaymentBubbleViewController> lazy2) {
        this.f14947a = lazy;
        this.f14948b = lazy2;
    }

    protected final PaymentBubbleViewController mo604b(PaymentViewParams paymentViewParams) {
        switch (paymentViewParams.f15020a) {
            case PAYMENT_REQUEST:
                return (PaymentBubbleViewController) this.f14947a.get();
            case PAYMENT_TRANSACTION:
                return (PaymentBubbleViewController) this.f14948b.get();
            default:
                throw new IllegalStateException("Unknown messenger entity type found: " + paymentViewParams.f15020a);
        }
    }
}

package com.facebook.messaging.payment.thread;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: feed_diode */
public class CompositeHeaderPaymentBubbleViewController extends AbstractCompositePaymentBubbleViewController<PaymentBubbleHeaderView> {
    private final Lazy<RequestHeaderPaymentBubbleViewController> f14953a;
    private final Lazy<TransactionHeaderPaymentBubbleViewController> f14954b;

    public static CompositeHeaderPaymentBubbleViewController m15346b(InjectorLike injectorLike) {
        return new CompositeHeaderPaymentBubbleViewController(IdBasedLazy.a(injectorLike, 8188), IdBasedLazy.a(injectorLike, 8195));
    }

    @Inject
    public CompositeHeaderPaymentBubbleViewController(Lazy<RequestHeaderPaymentBubbleViewController> lazy, Lazy<TransactionHeaderPaymentBubbleViewController> lazy2) {
        this.f14953a = lazy;
        this.f14954b = lazy2;
    }

    protected final PaymentBubbleViewController mo604b(PaymentViewParams paymentViewParams) {
        switch (paymentViewParams.f15020a) {
            case PAYMENT_REQUEST:
                return (PaymentBubbleViewController) this.f14953a.get();
            case PAYMENT_TRANSACTION:
                return (PaymentBubbleViewController) this.f14954b.get();
            default:
                throw new IllegalStateException("Unknown messenger entity type found: " + paymentViewParams.f15020a);
        }
    }
}

package com.facebook.messaging.payment.thread;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: fb_qt-faststart_jni */
public class CompositeSupplementaryPaymentBubbleViewController extends AbstractCompositePaymentBubbleViewController<PaymentBubbleSupplementaryView> {
    private final Lazy<DefaultPaymentBubbleViewController> f14962a;
    private final Lazy<TransactionSupplementaryPaymentBubbleViewController> f14963b;

    public static CompositeSupplementaryPaymentBubbleViewController m15352b(InjectorLike injectorLike) {
        return new CompositeSupplementaryPaymentBubbleViewController(IdBasedLazy.a(injectorLike, 8182), IdBasedLazy.a(injectorLike, 8198));
    }

    @Inject
    public CompositeSupplementaryPaymentBubbleViewController(Lazy<DefaultPaymentBubbleViewController> lazy, Lazy<TransactionSupplementaryPaymentBubbleViewController> lazy2) {
        this.f14962a = lazy;
        this.f14963b = lazy2;
    }

    protected final PaymentBubbleViewController mo604b(PaymentViewParams paymentViewParams) {
        switch (paymentViewParams.f15020a) {
            case PAYMENT_REQUEST:
                return (PaymentBubbleViewController) this.f14962a.get();
            case PAYMENT_TRANSACTION:
                return (PaymentBubbleViewController) this.f14963b.get();
            default:
                throw new IllegalStateException("Unknown messenger entity type found: " + paymentViewParams.f15020a);
        }
    }
}

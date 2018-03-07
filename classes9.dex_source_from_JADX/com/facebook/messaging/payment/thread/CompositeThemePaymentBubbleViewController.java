package com.facebook.messaging.payment.thread;

import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: fb_id */
public class CompositeThemePaymentBubbleViewController extends AbstractCompositePaymentBubbleViewController<PaymentBubbleThemeView> {
    private final Lazy<RequestThemePaymentBubbleViewController> f14965a;
    private final Lazy<TransactionThemePaymentBubbleViewController> f14966b;

    @Inject
    public CompositeThemePaymentBubbleViewController(Lazy<RequestThemePaymentBubbleViewController> lazy, Lazy<TransactionThemePaymentBubbleViewController> lazy2) {
        this.f14965a = lazy;
        this.f14966b = lazy2;
    }

    protected final PaymentBubbleViewController mo604b(PaymentViewParams paymentViewParams) {
        switch (paymentViewParams.f15020a) {
            case PAYMENT_REQUEST:
                return (PaymentBubbleViewController) this.f14965a.get();
            case PAYMENT_TRANSACTION:
                return (PaymentBubbleViewController) this.f14966b.get();
            default:
                throw new IllegalStateException("Unknown messenger entity type found: " + paymentViewParams.f15020a);
        }
    }
}

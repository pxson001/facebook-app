package com.facebook.messaging.payment.thread;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: fblink */
public class CompositeRecipientNamePaymentBubbleViewController extends AbstractCompositePaymentBubbleViewController<PaymentBubbleRecipientNameView> {
    private final Lazy<RequestRecipientNamePaymentBubbleViewController> f14959a;
    private final Lazy<TransactionRecipientNamePaymentBubbleViewController> f14960b;

    public static CompositeRecipientNamePaymentBubbleViewController m15350b(InjectorLike injectorLike) {
        return new CompositeRecipientNamePaymentBubbleViewController(IdBasedLazy.a(injectorLike, 8190), IdBasedLazy.a(injectorLike, 8197));
    }

    @Inject
    public CompositeRecipientNamePaymentBubbleViewController(Lazy<RequestRecipientNamePaymentBubbleViewController> lazy, Lazy<TransactionRecipientNamePaymentBubbleViewController> lazy2) {
        this.f14959a = lazy;
        this.f14960b = lazy2;
    }

    protected final PaymentBubbleViewController mo604b(PaymentViewParams paymentViewParams) {
        switch (paymentViewParams.f15020a) {
            case PAYMENT_REQUEST:
                return (PaymentBubbleViewController) this.f14959a.get();
            case PAYMENT_TRANSACTION:
                return (PaymentBubbleViewController) this.f14960b.get();
            default:
                throw new IllegalStateException("Unknown messenger entity type found: " + paymentViewParams.f15020a);
        }
    }
}

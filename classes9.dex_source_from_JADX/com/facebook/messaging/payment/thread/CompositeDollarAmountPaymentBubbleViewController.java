package com.facebook.messaging.payment.thread;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: feed_diode_enabled */
public class CompositeDollarAmountPaymentBubbleViewController extends AbstractCompositePaymentBubbleViewController<CustomLinearLayout> {
    private final Lazy<RequestDollarAmountPaymentBubbleViewController> f14950a;
    private final Lazy<TransactionDollarAmountPaymentBubbleViewController> f14951b;

    public static CompositeDollarAmountPaymentBubbleViewController m15344b(InjectorLike injectorLike) {
        return new CompositeDollarAmountPaymentBubbleViewController(IdBasedLazy.a(injectorLike, 8187), IdBasedLazy.a(injectorLike, 8194));
    }

    @Inject
    public CompositeDollarAmountPaymentBubbleViewController(Lazy<RequestDollarAmountPaymentBubbleViewController> lazy, Lazy<TransactionDollarAmountPaymentBubbleViewController> lazy2) {
        this.f14950a = lazy;
        this.f14951b = lazy2;
    }

    protected final PaymentBubbleViewController mo604b(PaymentViewParams paymentViewParams) {
        switch (paymentViewParams.f15020a) {
            case PAYMENT_REQUEST:
                return (PaymentBubbleViewController) this.f14950a.get();
            case PAYMENT_TRANSACTION:
                return (PaymentBubbleViewController) this.f14951b.get();
            default:
                throw new IllegalStateException("Unknown messenger entity type found: " + paymentViewParams.f15020a);
        }
    }
}

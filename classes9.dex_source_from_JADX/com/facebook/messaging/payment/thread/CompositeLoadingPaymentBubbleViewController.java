package com.facebook.messaging.payment.thread;

import android.view.View;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: fbui_adoption_enabled */
public class CompositeLoadingPaymentBubbleViewController extends AbstractCompositePaymentBubbleViewController<View> {
    private final Lazy<RequestLoadingPaymentBubbleViewController> f14956a;
    private final Lazy<TransactionLoadingPaymentBubbleViewController> f14957b;

    public static CompositeLoadingPaymentBubbleViewController m15348b(InjectorLike injectorLike) {
        return new CompositeLoadingPaymentBubbleViewController(IdBasedLazy.a(injectorLike, 8189), IdBasedLazy.a(injectorLike, 8196));
    }

    @Inject
    public CompositeLoadingPaymentBubbleViewController(Lazy<RequestLoadingPaymentBubbleViewController> lazy, Lazy<TransactionLoadingPaymentBubbleViewController> lazy2) {
        this.f14956a = lazy;
        this.f14957b = lazy2;
    }

    protected final PaymentBubbleViewController mo604b(PaymentViewParams paymentViewParams) {
        switch (paymentViewParams.f15020a) {
            case PAYMENT_REQUEST:
                return (PaymentBubbleViewController) this.f14956a.get();
            case PAYMENT_TRANSACTION:
                return (PaymentBubbleViewController) this.f14957b.get();
            default:
                throw new IllegalStateException("Unknown messenger entity type found: " + paymentViewParams.f15020a);
        }
    }
}

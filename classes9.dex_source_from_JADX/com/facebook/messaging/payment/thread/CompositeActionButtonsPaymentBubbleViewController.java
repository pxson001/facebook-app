package com.facebook.messaging.payment.thread;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.payment.thread.PaymentBubbleActionButtonsView.Listener;
import javax.inject.Inject;

/* compiled from: feeds_switcher_load_topics_failed */
public class CompositeActionButtonsPaymentBubbleViewController extends AbstractCompositePaymentBubbleViewController<PaymentBubbleActionButtonsView> {
    private final Lazy<RequestActionButtonsPaymentBubbleViewController> f14944a;
    private final Lazy<TransactionActionButtonsPaymentBubbleViewController> f14945b;

    /* compiled from: feeds_switcher_load_topics_failed */
    final class C17191 implements Listener {
        final /* synthetic */ PaymentView.Listener f14942a;

        C17191(PaymentView.Listener listener) {
            this.f14942a = listener;
        }

        public final void mo602a() {
            this.f14942a.m15384a();
        }

        public final void mo603b() {
        }
    }

    public static CompositeActionButtonsPaymentBubbleViewController m15340b(InjectorLike injectorLike) {
        return new CompositeActionButtonsPaymentBubbleViewController(IdBasedLazy.a(injectorLike, 8185), IdBasedLazy.a(injectorLike, 8192));
    }

    @Inject
    public CompositeActionButtonsPaymentBubbleViewController(Lazy<RequestActionButtonsPaymentBubbleViewController> lazy, Lazy<TransactionActionButtonsPaymentBubbleViewController> lazy2) {
        this.f14944a = lazy;
        this.f14945b = lazy2;
    }

    protected final PaymentBubbleViewController mo604b(PaymentViewParams paymentViewParams) {
        switch (paymentViewParams.f15020a) {
            case PAYMENT_REQUEST:
                return (PaymentBubbleViewController) this.f14944a.get();
            case PAYMENT_TRANSACTION:
                return (PaymentBubbleViewController) this.f14945b.get();
            default:
                throw new IllegalStateException("Unknown messenger entity type found: " + paymentViewParams.f15020a);
        }
    }

    protected static void m15339a(PaymentBubbleActionButtonsView paymentBubbleActionButtonsView, PaymentView.Listener listener) {
        paymentBubbleActionButtonsView.setPrimaryActionText(2131240583);
        paymentBubbleActionButtonsView.setPrimaryActionVisibility(0);
        paymentBubbleActionButtonsView.setSecondaryActionVisibility(8);
        paymentBubbleActionButtonsView.setBackgroundResource(2130842242);
        paymentBubbleActionButtonsView.setListener(new C17191(listener));
    }
}

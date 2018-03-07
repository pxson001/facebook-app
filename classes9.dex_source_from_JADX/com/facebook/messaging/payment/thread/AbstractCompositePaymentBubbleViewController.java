package com.facebook.messaging.payment.thread;

import android.view.View;
import com.facebook.messaging.payment.thread.PaymentView.Listener;

/* compiled from: female */
public abstract class AbstractCompositePaymentBubbleViewController<VIEW extends View> implements PaymentBubbleViewController<VIEW> {
    protected abstract PaymentBubbleViewController mo604b(PaymentViewParams paymentViewParams);

    public final void mo600a(VIEW view, PaymentViewParams paymentViewParams, Listener listener) {
        mo604b(paymentViewParams).mo600a(view, paymentViewParams, listener);
    }

    public final boolean mo601a(PaymentViewParams paymentViewParams) {
        return mo604b(paymentViewParams).mo601a(paymentViewParams);
    }
}

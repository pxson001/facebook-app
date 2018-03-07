package com.facebook.messaging.payment.thread;

import android.view.View;
import com.facebook.messaging.payment.thread.PaymentView.Listener;

/* compiled from: fetchAllforSync */
public interface PaymentBubbleViewController<VIEW extends View> {
    void mo600a(VIEW view, PaymentViewParams paymentViewParams, Listener listener);

    boolean mo601a(PaymentViewParams paymentViewParams);
}

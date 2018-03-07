package com.facebook.messaging.payment.thread;

import android.view.View;
import com.facebook.messaging.payment.thread.PaymentView.Listener;
import com.facebook.messaging.payment.util.PaymentRequestUtil;

/* compiled from: failed_fetch_more_messages */
public class RequestThemePaymentBubbleViewController implements PaymentBubbleViewController<PaymentBubbleThemeView> {
    public final void mo600a(View view, PaymentViewParams paymentViewParams, Listener listener) {
        ((PaymentBubbleThemeView) view).m15378a(paymentViewParams.f15023d.ly_());
    }

    public final boolean mo601a(PaymentViewParams paymentViewParams) {
        return paymentViewParams.f15023d != null && PaymentRequestUtil.g(paymentViewParams.f15023d);
    }
}

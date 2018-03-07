package com.facebook.messaging.payment.thread;

import android.view.View;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.thread.PaymentView.Listener;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;

/* compiled from: failed to load mms %s */
public class TransactionThemePaymentBubbleViewController implements PaymentBubbleViewController<PaymentBubbleThemeView> {
    public final void mo600a(View view, PaymentViewParams paymentViewParams, Listener listener) {
        ((PaymentBubbleThemeView) view).m15378a(paymentViewParams.f15022c.f15115c.f13239l.m13951b());
    }

    public final boolean mo601a(PaymentViewParams paymentViewParams) {
        PaymentTransaction paymentTransaction = paymentViewParams.f15022c.f15115c;
        return paymentTransaction != null && PaymentTransactionUtil.m15524f(paymentTransaction);
    }
}

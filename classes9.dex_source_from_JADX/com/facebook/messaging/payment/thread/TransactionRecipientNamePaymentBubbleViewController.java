package com.facebook.messaging.payment.thread;

import android.content.res.Resources;
import android.view.View;
import com.facebook.messaging.payment.thread.PaymentView.Listener;
import javax.inject.Inject;

/* compiled from: failed to save mms photo */
public class TransactionRecipientNamePaymentBubbleViewController implements PaymentBubbleViewController<PaymentBubbleRecipientNameView> {
    private final Resources f15061a;

    public final void mo600a(View view, PaymentViewParams paymentViewParams, Listener listener) {
        ((PaymentBubbleRecipientNameView) view).setRecipientNameText(this.f15061a.getString(2131240509, new Object[]{paymentViewParams.f15025f.get()}));
    }

    @Inject
    public TransactionRecipientNamePaymentBubbleViewController(Resources resources) {
        this.f15061a = resources;
    }

    public final boolean mo601a(PaymentViewParams paymentViewParams) {
        return paymentViewParams.f15021b.b.b() && paymentViewParams.f15025f.isPresent();
    }
}

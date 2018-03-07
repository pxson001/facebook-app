package com.facebook.messaging.payment.thread;

import android.content.res.Resources;
import android.view.View;
import com.facebook.messaging.payment.thread.PaymentView.Listener;
import javax.inject.Inject;

/* compiled from: failed_fetch_more_messages_communication */
public class RequestRecipientNamePaymentBubbleViewController implements PaymentBubbleViewController<PaymentBubbleRecipientNameView> {
    private final Resources f15046a;

    public final void mo600a(View view, PaymentViewParams paymentViewParams, Listener listener) {
        ((PaymentBubbleRecipientNameView) view).setRecipientNameText(this.f15046a.getString(2131240510, new Object[]{paymentViewParams.f15025f.get()}));
    }

    @Inject
    public RequestRecipientNamePaymentBubbleViewController(Resources resources) {
        this.f15046a = resources;
    }

    public final boolean mo601a(PaymentViewParams paymentViewParams) {
        return paymentViewParams.f15021b.b.b() && paymentViewParams.f15025f.isPresent();
    }
}

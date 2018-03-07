package com.facebook.messaging.payment.thread;

import android.content.res.Resources;
import android.view.View;
import com.facebook.messaging.payment.thread.PaymentView.Listener;
import com.facebook.messaging.payment.util.PaymentRequestUtil;
import com.facebook.user.model.User;
import javax.inject.Inject;

/* compiled from: failed_fetch_more_threads_communication */
public class RequestHeaderPaymentBubbleViewController implements PaymentBubbleViewController<PaymentBubbleHeaderView> {
    private final Resources f15044a;
    private final PaymentRequestUtil f15045b;

    public final void mo600a(View view, PaymentViewParams paymentViewParams, Listener listener) {
        boolean z;
        String string;
        PaymentBubbleHeaderView paymentBubbleHeaderView = (PaymentBubbleHeaderView) view;
        PaymentRequestUtil paymentRequestUtil = this.f15045b;
        String valueOf = String.valueOf(paymentViewParams.f15021b.C.b);
        if (paymentRequestUtil.b.get() == null) {
            z = false;
        } else {
            z = ((User) paymentRequestUtil.b.get()).a.equals(valueOf);
        }
        if (z) {
            string = this.f15044a.getString(2131240579);
        } else {
            string = this.f15044a.getString(2131240580, new Object[]{paymentViewParams.f15024e});
        }
        paymentBubbleHeaderView.setText(string);
    }

    @Inject
    public RequestHeaderPaymentBubbleViewController(Resources resources, PaymentRequestUtil paymentRequestUtil) {
        this.f15044a = resources;
        this.f15045b = paymentRequestUtil;
    }

    public final boolean mo601a(PaymentViewParams paymentViewParams) {
        return true;
    }
}

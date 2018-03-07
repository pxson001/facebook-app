package com.facebook.messaging.payment.thread;

import android.content.res.Resources;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.TransferStatus;
import com.facebook.messaging.payment.thread.PaymentView.Listener;
import javax.inject.Inject;

/* compiled from: failed white list */
public class TransactionHeaderPaymentBubbleViewController implements PaymentBubbleViewController<PaymentBubbleHeaderView> {
    private final Resources f15060a;

    public final void mo600a(View view, PaymentViewParams paymentViewParams, Listener listener) {
        ((PaymentBubbleHeaderView) view).setText(this.f15060a.getString(2131240508, new Object[]{paymentViewParams.f15024e}));
    }

    @Inject
    public TransactionHeaderPaymentBubbleViewController(Resources resources) {
        this.f15060a = resources;
    }

    public final boolean mo601a(PaymentViewParams paymentViewParams) {
        PaymentTransaction paymentTransaction = paymentViewParams.f15022c.f15115c;
        return (paymentTransaction == null || paymentTransaction.f13234g != TransferStatus.R_PENDING_NUX || StringUtil.a(paymentViewParams.f15024e)) ? false : true;
    }
}

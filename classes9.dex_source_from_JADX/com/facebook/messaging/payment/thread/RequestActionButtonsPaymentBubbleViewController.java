package com.facebook.messaging.payment.thread;

import android.view.View;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.thread.PaymentView.Listener;
import com.facebook.messaging.payment.util.PaymentRequestUtil;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: failed_fetch_thread_list */
public class RequestActionButtonsPaymentBubbleViewController implements PaymentBubbleViewController<PaymentBubbleActionButtonsView> {
    private final PaymentRequestUtil f15036a;

    public final void mo600a(View view, PaymentViewParams paymentViewParams, final Listener listener) {
        PaymentBubbleActionButtonsView paymentBubbleActionButtonsView = (PaymentBubbleActionButtonsView) view;
        PaymentRequestModel paymentRequestModel = paymentViewParams.f15023d;
        Preconditions.checkNotNull(paymentRequestModel);
        if (PaymentRequestUtil.f(paymentRequestModel)) {
            CompositeActionButtonsPaymentBubbleViewController.m15339a(paymentBubbleActionButtonsView, listener);
        } else if (this.f15036a.a(paymentRequestModel)) {
            paymentBubbleActionButtonsView.setPrimaryActionText(2131240581);
            paymentBubbleActionButtonsView.setSecondaryActionText(2131240582);
            paymentBubbleActionButtonsView.setPrimaryActionVisibility(0);
            paymentBubbleActionButtonsView.setSecondaryActionVisibility(0);
            paymentBubbleActionButtonsView.setBackgroundResource(2130842242);
            paymentBubbleActionButtonsView.setListener(new PaymentBubbleActionButtonsView.Listener(this) {
                final /* synthetic */ RequestActionButtonsPaymentBubbleViewController f15035b;

                public final void mo602a() {
                    listener.m15388e();
                }

                public final void mo603b() {
                    listener.m15389f();
                }
            });
        }
    }

    @Inject
    public RequestActionButtonsPaymentBubbleViewController(PaymentRequestUtil paymentRequestUtil) {
        this.f15036a = paymentRequestUtil;
    }

    public final boolean mo601a(PaymentViewParams paymentViewParams) {
        PaymentRequestModel paymentRequestModel = paymentViewParams.f15023d;
        if (paymentRequestModel == null) {
            return false;
        }
        boolean f = PaymentRequestUtil.f(paymentRequestModel);
        boolean a = this.f15036a.a(paymentRequestModel);
        if (f || a) {
            return true;
        }
        return false;
    }
}

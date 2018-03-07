package com.facebook.messaging.payment.thread;

import android.view.View;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.TransferStatus;
import com.facebook.messaging.payment.thread.PaymentBubbleActionButtonsView.Listener;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import com.google.common.base.Preconditions;

/* compiled from: failed_fetch_messages_communication */
public class TransactionActionButtonsPaymentBubbleViewController implements PaymentBubbleViewController<PaymentBubbleActionButtonsView> {
    private static final Class<?> f15051a = TransactionActionButtonsPaymentBubbleViewController.class;

    /* compiled from: failed_fetch_messages_communication */
    public final class C17351 implements Listener {
        final /* synthetic */ PaymentView.Listener f15047a;

        public C17351(PaymentView.Listener listener) {
            this.f15047a = listener;
        }

        public final void mo602a() {
            this.f15047a.m15387d();
        }

        public final void mo603b() {
        }
    }

    /* compiled from: failed_fetch_messages_communication */
    public final class C17362 implements Listener {
        final /* synthetic */ PaymentView.Listener f15048a;

        public C17362(PaymentView.Listener listener) {
            this.f15048a = listener;
        }

        public final void mo602a() {
            this.f15048a.m15385b();
        }

        public final void mo603b() {
        }
    }

    /* compiled from: failed_fetch_messages_communication */
    public final class C17373 implements Listener {
        final /* synthetic */ PaymentView.Listener f15049a;

        public C17373(PaymentView.Listener listener) {
            this.f15049a = listener;
        }

        public final void mo602a() {
            this.f15049a.m15386c();
        }

        public final void mo603b() {
        }
    }

    public final void mo600a(View view, PaymentViewParams paymentViewParams, PaymentView.Listener listener) {
        PaymentBubbleActionButtonsView paymentBubbleActionButtonsView = (PaymentBubbleActionButtonsView) view;
        PaymentTransaction paymentTransaction = paymentViewParams.f15022c.f15115c;
        Preconditions.checkNotNull(paymentTransaction);
        if (PaymentTransactionUtil.m15523e(paymentTransaction)) {
            CompositeActionButtonsPaymentBubbleViewController.m15339a(paymentBubbleActionButtonsView, listener);
            return;
        }
        switch (paymentTransaction.f13234g) {
            case R_PENDING_VERIFICATION:
            case S_PENDING_VERIFICATION:
                paymentBubbleActionButtonsView.setPrimaryActionText(2131240440);
                paymentBubbleActionButtonsView.setBackgroundResource(2130842240);
                paymentBubbleActionButtonsView.setListener(new C17351(listener));
                paymentBubbleActionButtonsView.setPrimaryActionVisibility(0);
                paymentBubbleActionButtonsView.setSecondaryActionVisibility(8);
                return;
            case R_PENDING_NUX:
                paymentBubbleActionButtonsView.setPrimaryActionText(2131240401);
                paymentBubbleActionButtonsView.setBackgroundResource(2130842240);
                paymentBubbleActionButtonsView.setListener(new C17362(listener));
                paymentBubbleActionButtonsView.setPrimaryActionVisibility(0);
                paymentBubbleActionButtonsView.setSecondaryActionVisibility(8);
                return;
            case R_PENDING_PUSH_FAIL:
            case R_PENDING_PUSH_FAIL_CARD_EXPIRED:
                paymentBubbleActionButtonsView.setPrimaryActionText(2131240407);
                paymentBubbleActionButtonsView.setBackgroundResource(2130842240);
                paymentBubbleActionButtonsView.setListener(new C17373(listener));
                paymentBubbleActionButtonsView.setPrimaryActionVisibility(0);
                paymentBubbleActionButtonsView.setSecondaryActionVisibility(8);
                return;
            default:
                TransferStatus transferStatus = paymentTransaction.f13234g;
                return;
        }
    }

    public final boolean mo601a(PaymentViewParams paymentViewParams) {
        PaymentTransaction paymentTransaction = paymentViewParams.f15022c.f15115c;
        if (paymentTransaction == null) {
            return false;
        }
        boolean e = PaymentTransactionUtil.m15523e(paymentTransaction);
        if (TransactionSupplementaryPaymentBubbleViewController.m15446a(paymentTransaction.f13234g) || e) {
            return true;
        }
        return false;
    }
}

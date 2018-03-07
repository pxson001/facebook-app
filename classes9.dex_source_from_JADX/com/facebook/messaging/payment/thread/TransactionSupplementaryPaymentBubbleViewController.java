package com.facebook.messaging.payment.thread;

import android.view.View;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.TransferStatus;
import com.facebook.messaging.payment.thread.PaymentView.Listener;
import com.google.common.base.Preconditions;

/* compiled from: failed to read turn config. partial data will be returned */
public class TransactionSupplementaryPaymentBubbleViewController implements PaymentBubbleViewController<PaymentBubbleSupplementaryView> {
    private static final Class<?> f15063a = TransactionSupplementaryPaymentBubbleViewController.class;

    public final void mo600a(View view, PaymentViewParams paymentViewParams, Listener listener) {
        PaymentBubbleSupplementaryView paymentBubbleSupplementaryView = (PaymentBubbleSupplementaryView) view;
        PaymentTransaction paymentTransaction = paymentViewParams.f15022c.f15115c;
        Preconditions.checkNotNull(paymentTransaction);
        TransferStatus transferStatus = paymentTransaction.f13234g;
        switch (transferStatus) {
            case R_PENDING_VERIFICATION:
            case S_PENDING_VERIFICATION:
                paymentBubbleSupplementaryView.setDrawableText(transferStatus == TransferStatus.R_PENDING_VERIFICATION ? 2131240438 : 2131240439);
                paymentBubbleSupplementaryView.setMessageTextVisibility(8);
                paymentBubbleSupplementaryView.setDrawableTextVisibility(0);
                return;
            case R_PENDING_NUX:
                paymentBubbleSupplementaryView.setMessageText(2131240399);
                paymentBubbleSupplementaryView.setDrawableText(2131240400);
                paymentBubbleSupplementaryView.setMessageTextVisibility(0);
                paymentBubbleSupplementaryView.setDrawableTextVisibility(0);
                return;
            case R_PENDING_PUSH_FAIL:
            case R_PENDING_PUSH_FAIL_CARD_EXPIRED:
                paymentBubbleSupplementaryView.setMessageText(2131240406);
                paymentBubbleSupplementaryView.setMessageTextVisibility(0);
                paymentBubbleSupplementaryView.setDrawableTextVisibility(8);
                return;
            default:
                return;
        }
    }

    public final boolean mo601a(PaymentViewParams paymentViewParams) {
        PaymentTransaction paymentTransaction = paymentViewParams.f15022c.f15115c;
        return (paymentViewParams.f15021b.B == null || paymentTransaction == null || !m15446a(paymentTransaction.f13234g)) ? false : true;
    }

    public static boolean m15446a(TransferStatus transferStatus) {
        return transferStatus == TransferStatus.R_PENDING_VERIFICATION || transferStatus == TransferStatus.R_PENDING_NUX || transferStatus == TransferStatus.R_PENDING_PUSH_FAIL || transferStatus == TransferStatus.R_PENDING_PUSH_FAIL_CARD_EXPIRED || transferStatus == TransferStatus.S_PENDING_VERIFICATION;
    }
}

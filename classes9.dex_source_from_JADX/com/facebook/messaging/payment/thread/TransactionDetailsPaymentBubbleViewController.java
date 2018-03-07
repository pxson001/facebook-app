package com.facebook.messaging.payment.thread;

import android.content.res.Resources;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.TransferStatus;
import com.facebook.messaging.payment.thread.PaymentView.Listener;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: failed_fetch_messages */
public class TransactionDetailsPaymentBubbleViewController implements PaymentBubbleViewController<PaymentBubbleDetailsView> {
    private static final Class<?> f15053a = TransactionDetailsPaymentBubbleViewController.class;
    private final Resources f15054b;
    private final PaymentTransactionUtil f15055c;

    public final void mo600a(View view, PaymentViewParams paymentViewParams, Listener listener) {
        PaymentBubbleDetailsView paymentBubbleDetailsView = (PaymentBubbleDetailsView) view;
        PaymentTransaction paymentTransaction = paymentViewParams.f15022c.f15115c;
        paymentBubbleDetailsView.setMemoText(paymentTransaction.f13239l.m13950a());
        paymentBubbleDetailsView.setStatusText(m15435a(paymentTransaction));
    }

    @Inject
    public TransactionDetailsPaymentBubbleViewController(Resources resources, PaymentTransactionUtil paymentTransactionUtil) {
        this.f15054b = resources;
        this.f15055c = paymentTransactionUtil;
    }

    public final boolean mo601a(PaymentViewParams paymentViewParams) {
        PaymentTransaction paymentTransaction = paymentViewParams.f15022c.f15115c;
        if (paymentViewParams.f15021b.B == null || paymentTransaction == null) {
            return false;
        }
        boolean z;
        if (StringUtil.c(paymentTransaction.f13239l.m13950a())) {
            z = false;
        } else {
            z = true;
        }
        boolean z2;
        if (StringUtil.a(m15435a(paymentTransaction))) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z || r3) {
            return true;
        }
        return false;
    }

    @Nullable
    private String m15435a(PaymentTransaction paymentTransaction) {
        String b;
        switch (paymentTransaction.f13234g) {
            case S_CANCELED:
            case S_CANCELED_SENDER_RISK:
            case S_CANCELED_RECIPIENT_RISK:
            case S_CANCELED_DECLINED:
            case S_CANCELED_EXPIRED:
            case S_CANCELED_SAME_CARD:
            case S_CANCELED_CUSTOMER_SERVICE:
            case S_CANCELED_CHARGEBACK:
            case S_CANCELED_SYSTEM_FAIL:
            case R_CANCELED:
            case R_CANCELED_SENDER_RISK:
            case R_CANCELED_RECIPIENT_RISK:
            case R_CANCELED_DECLINED:
            case R_CANCELED_EXPIRED:
            case R_CANCELED_SAME_CARD:
            case R_CANCELED_CUSTOMER_SERVICE:
            case R_CANCELED_CHARGEBACK:
            case R_CANCELED_SYSTEM_FAIL:
                b = this.f15055c.m15526b(paymentTransaction.f13236i);
                return this.f15054b.getString(2131240521, new Object[]{b});
            case S_SENT:
                b = this.f15055c.m15526b(paymentTransaction.f13233f);
                return this.f15054b.getString(2131240519, new Object[]{b});
            case R_COMPLETED:
            case S_COMPLETED:
                b = this.f15055c.m15526b(paymentTransaction.f13235h);
                return this.f15054b.getString(2131240520, new Object[]{b});
            case S_PENDING:
            case S_PENDING_MANUAL_REVIEW:
            case S_PENDING_VERIFICATION_PROCESSING:
            case R_PENDING:
            case R_PENDING_VERIFICATION_PROCESSING:
            case R_PENDING_MANUAL_REVIEW:
            case R_PENDING_PROCESSING:
                return this.f15054b.getString(2131240518);
            case R_PENDING_VERIFICATION:
            case R_PENDING_NUX:
            case R_PENDING_PUSH_FAIL:
            case R_PENDING_PUSH_FAIL_CARD_EXPIRED:
            case S_PENDING_VERIFICATION:
                return null;
            default:
                TransferStatus transferStatus = paymentTransaction.f13234g;
                return null;
        }
    }
}

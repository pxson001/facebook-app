package com.facebook.messaging.payment.prefs.receipts.footer;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.debug.log.BLog;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.prefs.receipts.animation.ReceiptAnimationController;
import com.facebook.messaging.payment.utils.PaymentViewUtil;
import com.facebook.payments.ui.FloatingLabelTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: getValueDescriptor */
public class ReceiptSentTimeViewController {
    private static ReceiptSentTimeViewController f14124f;
    private static final Object f14125g = new Object();
    private final ReceiptAnimationController f14126a;
    private final PaymentViewUtil f14127b;
    public final int[] f14128c = new int[2];
    private PaymentTransaction f14129d;
    public FloatingLabelTextView f14130e;

    private static ReceiptSentTimeViewController m14594b(InjectorLike injectorLike) {
        return new ReceiptSentTimeViewController(ReceiptAnimationController.m14526a(injectorLike), PaymentViewUtil.m15542b(injectorLike));
    }

    @Inject
    public ReceiptSentTimeViewController(ReceiptAnimationController receiptAnimationController, PaymentViewUtil paymentViewUtil) {
        this.f14126a = receiptAnimationController;
        this.f14127b = paymentViewUtil;
    }

    public static ReceiptSentTimeViewController m14593a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReceiptSentTimeViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14125g) {
                ReceiptSentTimeViewController receiptSentTimeViewController;
                if (a2 != null) {
                    receiptSentTimeViewController = (ReceiptSentTimeViewController) a2.a(f14125g);
                } else {
                    receiptSentTimeViewController = f14124f;
                }
                if (receiptSentTimeViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14594b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14125g, b3);
                        } else {
                            f14124f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = receiptSentTimeViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m14599a(PaymentTransaction paymentTransaction) {
        this.f14129d = paymentTransaction;
        m14595c();
    }

    private void m14595c() {
        switch (this.f14129d.f13234g) {
            case R_PENDING:
            case R_PENDING_VERIFICATION:
            case R_PENDING_VERIFICATION_PROCESSING:
            case R_PENDING_MANUAL_REVIEW:
            case R_PENDING_NUX:
            case R_PENDING_PROCESSING:
            case R_PENDING_PUSH_FAIL:
            case R_PENDING_PUSH_FAIL_CARD_EXPIRED:
                m14598f();
                return;
            case R_CANCELED:
            case R_CANCELED_SENDER_RISK:
            case R_CANCELED_RECIPIENT_RISK:
            case R_CANCELED_DECLINED:
            case R_CANCELED_EXPIRED:
            case R_CANCELED_SAME_CARD:
            case R_CANCELED_CUSTOMER_SERVICE:
            case R_CANCELED_CHARGEBACK:
            case R_CANCELED_SYSTEM_FAIL:
                this.f14127b.m15545a(this.f14130e, 2131240342, Long.parseLong(this.f14129d.f13236i) * 1000);
                return;
            case R_COMPLETED:
                m14596d();
                return;
            case S_PENDING:
            case S_PENDING_VERIFICATION:
            case S_PENDING_MANUAL_REVIEW:
            case S_PENDING_VERIFICATION_PROCESSING:
                m14598f();
                return;
            case S_CANCELED:
            case S_CANCELED_SENDER_RISK:
            case S_CANCELED_RECIPIENT_RISK:
            case S_CANCELED_DECLINED:
            case S_CANCELED_EXPIRED:
            case S_CANCELED_SAME_CARD:
            case S_CANCELED_CUSTOMER_SERVICE:
            case S_CANCELED_CHARGEBACK:
            case S_CANCELED_SYSTEM_FAIL:
            case S_SENT:
                m14597e();
                return;
            case S_COMPLETED:
                if (ReceiptFooterViewController.m14575a(this.f14129d)) {
                    m14597e();
                    return;
                } else {
                    m14596d();
                    return;
                }
            default:
                BLog.a("ReceiptStatusViewController", "We should not see this unknown transfer status %s", new Object[]{this.f14129d.f13234g});
                m14598f();
                return;
        }
    }

    private void m14596d() {
        this.f14127b.m15545a(this.f14130e, 2131240340, Long.parseLong(this.f14129d.f13235h) * 1000);
    }

    private void m14597e() {
        this.f14127b.m15545a(this.f14130e, 2131240339, Long.parseLong(this.f14129d.f13233f) * 1000);
    }

    private void m14598f() {
        this.f14130e.setVisibility(8);
    }
}

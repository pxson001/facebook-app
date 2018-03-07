package com.facebook.messaging.payment.prefs.receipts.footer;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.prefs.receipts.animation.ReceiptAnimationController;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import com.facebook.messaging.payment.utils.PaymentViewUtil;
import com.facebook.payments.ui.FloatingLabelTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: getToken */
public class ReceiptSupplementaryTimeViewController {
    private static ReceiptSupplementaryTimeViewController f14132f;
    private static final Object f14133g = new Object();
    private final ReceiptAnimationController f14134a;
    private final PaymentViewUtil f14135b;
    private PaymentTransaction f14136c;
    private boolean f14137d;
    public FloatingLabelTextView f14138e;

    private static ReceiptSupplementaryTimeViewController m14602b(InjectorLike injectorLike) {
        return new ReceiptSupplementaryTimeViewController(ReceiptAnimationController.m14526a(injectorLike), PaymentViewUtil.m15542b(injectorLike));
    }

    @Inject
    public ReceiptSupplementaryTimeViewController(ReceiptAnimationController receiptAnimationController, PaymentViewUtil paymentViewUtil) {
        this.f14134a = receiptAnimationController;
        this.f14135b = paymentViewUtil;
    }

    public final void m14605a(PaymentTransaction paymentTransaction, boolean z) {
        this.f14136c = paymentTransaction;
        this.f14137d = z;
        m14601a();
    }

    public static ReceiptSupplementaryTimeViewController m14600a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReceiptSupplementaryTimeViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14133g) {
                ReceiptSupplementaryTimeViewController receiptSupplementaryTimeViewController;
                if (a2 != null) {
                    receiptSupplementaryTimeViewController = (ReceiptSupplementaryTimeViewController) a2.a(f14133g);
                } else {
                    receiptSupplementaryTimeViewController = f14132f;
                }
                if (receiptSupplementaryTimeViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14602b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14133g, b3);
                        } else {
                            f14132f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = receiptSupplementaryTimeViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m14601a() {
        switch (this.f14136c.f13234g) {
            case S_CANCELED_RECIPIENT_RISK:
            case S_CANCELED_DECLINED:
            case S_CANCELED_EXPIRED:
            case S_CANCELED_SAME_CARD:
                this.f14135b.m15545a(this.f14138e, PaymentTransactionUtil.m15521a(this.f14136c) ? 2131240343 : 2131240341, 1000 * Long.parseLong(this.f14136c.f13236i));
                m14603b();
                return;
            case S_CANCELED:
            case S_CANCELED_SENDER_RISK:
            case S_CANCELED_CUSTOMER_SERVICE:
            case S_CANCELED_CHARGEBACK:
            case S_CANCELED_SYSTEM_FAIL:
                this.f14135b.m15545a(this.f14138e, 2131240342, Long.parseLong(this.f14136c.f13236i) * 1000);
                m14603b();
                return;
            case S_COMPLETED:
                if (ReceiptFooterViewController.m14575a(this.f14136c)) {
                    this.f14135b.m15545a(this.f14138e, 2131240340, Long.parseLong(this.f14136c.f13235h) * 1000);
                    m14603b();
                    return;
                }
                m14604c();
                return;
            default:
                m14604c();
                return;
        }
    }

    private void m14603b() {
        if (this.f14137d) {
            ReceiptAnimationController.m14527a(this.f14138e, 0);
        }
    }

    private void m14604c() {
        this.f14138e.setVisibility(8);
    }
}

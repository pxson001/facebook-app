package com.facebook.messaging.payment.prefs.receipts.footer;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ErrorCodeUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.prefs.receipts.ReceiptCardFetcher;
import com.facebook.messaging.payment.prefs.receipts.ReceiptCardFetcher.ReceiptCardFetcherListener;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import com.facebook.payments.ui.FloatingLabelTextView;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: get_location_task_key */
public class ReceiptPaymentMethodViewController {
    private static ReceiptPaymentMethodViewController f14110g;
    private static final Object f14111h = new Object();
    private final PaymentTransactionUtil f14112a;
    public final ReceiptCardFetcher f14113b;
    private final Clock f14114c;
    public FloatingLabelTextView f14115d;
    public BetterTextView f14116e;
    private PaymentTransaction f14117f;

    /* compiled from: get_location_task_key */
    class C16061 implements ReceiptCardFetcherListener {
        final /* synthetic */ ReceiptPaymentMethodViewController f14108a;

        C16061(ReceiptPaymentMethodViewController receiptPaymentMethodViewController) {
            this.f14108a = receiptPaymentMethodViewController;
        }

        public final void mo550a(Throwable th) {
            ReceiptPaymentMethodViewController receiptPaymentMethodViewController = this.f14108a;
            receiptPaymentMethodViewController.f14115d.b();
            if (ErrorCodeUtil.a(th) == ErrorCode.CONNECTION_FAILURE) {
                receiptPaymentMethodViewController.f14115d.setText(2131240488);
            } else {
                receiptPaymentMethodViewController.f14115d.setText(2131240489);
            }
        }

        public final void mo549a(@Nullable PaymentCard paymentCard) {
            ReceiptPaymentMethodViewController.m14585a(this.f14108a, paymentCard);
        }
    }

    private static ReceiptPaymentMethodViewController m14586b(InjectorLike injectorLike) {
        return new ReceiptPaymentMethodViewController(PaymentTransactionUtil.m15519a(injectorLike), ReceiptCardFetcher.m14511b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ReceiptPaymentMethodViewController(PaymentTransactionUtil paymentTransactionUtil, ReceiptCardFetcher receiptCardFetcher, Clock clock) {
        this.f14112a = paymentTransactionUtil;
        this.f14113b = receiptCardFetcher;
        this.f14114c = clock;
    }

    public static ReceiptPaymentMethodViewController m14584a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReceiptPaymentMethodViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14111h) {
                ReceiptPaymentMethodViewController receiptPaymentMethodViewController;
                if (a2 != null) {
                    receiptPaymentMethodViewController = (ReceiptPaymentMethodViewController) a2.a(f14111h);
                } else {
                    receiptPaymentMethodViewController = f14110g;
                }
                if (receiptPaymentMethodViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14586b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14111h, b3);
                        } else {
                            f14110g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = receiptPaymentMethodViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m14590a(PaymentTransaction paymentTransaction) {
        this.f14117f = paymentTransaction;
        m14587b();
    }

    private void m14587b() {
        switch (this.f14117f.f13234g) {
            case R_PENDING:
            case R_PENDING_VERIFICATION:
            case R_PENDING_VERIFICATION_PROCESSING:
            case R_PENDING_MANUAL_REVIEW:
            case R_CANCELED:
            case R_CANCELED_SENDER_RISK:
            case R_CANCELED_RECIPIENT_RISK:
            case R_CANCELED_DECLINED:
            case R_CANCELED_EXPIRED:
            case R_CANCELED_SAME_CARD:
            case R_CANCELED_CUSTOMER_SERVICE:
            case R_CANCELED_CHARGEBACK:
            case R_CANCELED_SYSTEM_FAIL:
            case R_PENDING_NUX:
            case R_PENDING_PROCESSING:
            case R_PENDING_PUSH_FAIL:
            case R_PENDING_PUSH_FAIL_CARD_EXPIRED:
                this.f14116e.setVisibility(8);
                return;
            case R_COMPLETED:
                if (m14589d()) {
                    this.f14116e.setText(2131240348);
                    this.f14116e.setVisibility(4);
                } else {
                    this.f14116e.setVisibility(8);
                }
                m14588c();
                return;
            case S_PENDING:
            case S_CANCELED:
            case S_CANCELED_RECIPIENT_RISK:
            case S_CANCELED_DECLINED:
            case S_CANCELED_EXPIRED:
            case S_CANCELED_SAME_CARD:
            case S_CANCELED_CUSTOMER_SERVICE:
            case S_CANCELED_CHARGEBACK:
            case S_COMPLETED:
            case S_SENT:
                this.f14116e.setVisibility(8);
                if (PaymentTransactionUtil.m15521a(this.f14117f)) {
                    this.f14115d.setHint(2131240379);
                    this.f14115d.setText(2131240380);
                    this.f14115d.setVisibility(0);
                    return;
                }
                m14588c();
                return;
            case S_PENDING_VERIFICATION:
            case S_PENDING_VERIFICATION_PROCESSING:
            case S_PENDING_MANUAL_REVIEW:
            case S_CANCELED_SENDER_RISK:
            case S_CANCELED_SYSTEM_FAIL:
                this.f14116e.setVisibility(8);
                return;
            default:
                BLog.a("ReceiptPaymentMethodViewController", "We should not see this unknown transfer status %s", new Object[]{this.f14117f.f13234g});
                this.f14116e.setVisibility(8);
                return;
        }
    }

    private void m14588c() {
        this.f14115d.setVisibility(0);
        this.f14115d.a();
        this.f14115d.setHint(this.f14112a.m15527c(this.f14117f) ? 2131240347 : 2131240345);
        this.f14113b.f14010e = new C16061(this);
        this.f14113b.m14513a(this.f14117f.f13229b);
    }

    public static void m14585a(@Nullable ReceiptPaymentMethodViewController receiptPaymentMethodViewController, PaymentCard paymentCard) {
        receiptPaymentMethodViewController.f14115d.b();
        if (paymentCard == null) {
            receiptPaymentMethodViewController.f14115d.setVisibility(8);
            receiptPaymentMethodViewController.f14116e.setVisibility(8);
            return;
        }
        if (receiptPaymentMethodViewController.f14112a.m15527c(receiptPaymentMethodViewController.f14117f) && receiptPaymentMethodViewController.m14589d()) {
            receiptPaymentMethodViewController.f14116e.setVisibility(0);
        }
        receiptPaymentMethodViewController.f14115d.setText(StringFormatUtil.formatStrLocaleSafe("%s •%s", paymentCard.f13207f, paymentCard.m13503e()));
    }

    private boolean m14589d() {
        return (this.f14114c.a() / 1000) - Long.parseLong(this.f14117f.f13235h) <= 1209600;
    }
}

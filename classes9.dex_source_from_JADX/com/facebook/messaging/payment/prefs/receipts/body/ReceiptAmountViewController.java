package com.facebook.messaging.payment.prefs.receipts.body;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLPeerToPeerPaymentRequestStatus;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.TransferStatus;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.prefs.receipts.animation.ReceiptAnimationController;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.messaging.payment.utils.PaymentTextUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: got exception decoding bitmap  */
public class ReceiptAmountViewController {
    private static ReceiptAmountViewController f14033f;
    private static final Object f14034g = new Object();
    private final PaymentTextUtils f14035a;
    private final PaymentCurrencyUtil f14036b;
    private final ReceiptAnimationController f14037c;
    public final int[] f14038d = new int[2];
    public DollarIconEditText f14039e;

    /* compiled from: got exception decoding bitmap  */
    /* synthetic */ class C15971 {
        static final /* synthetic */ int[] f14032b = new int[GraphQLPeerToPeerPaymentRequestStatus.values().length];

        static {
            try {
                f14032b[GraphQLPeerToPeerPaymentRequestStatus.TRANSFER_COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            f14031a = new int[TransferStatus.values().length];
            try {
                f14031a[TransferStatus.R_COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14031a[TransferStatus.S_COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f14031a[TransferStatus.S_SENT.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private static ReceiptAmountViewController m14533b(InjectorLike injectorLike) {
        return new ReceiptAmountViewController(PaymentTextUtils.m15538b(injectorLike), PaymentCurrencyUtil.m13192a(injectorLike), ReceiptAnimationController.m14526a(injectorLike));
    }

    @Inject
    public ReceiptAmountViewController(PaymentTextUtils paymentTextUtils, PaymentCurrencyUtil paymentCurrencyUtil, ReceiptAnimationController receiptAnimationController) {
        this.f14035a = paymentTextUtils;
        this.f14036b = paymentCurrencyUtil;
        this.f14037c = receiptAnimationController;
    }

    public static ReceiptAmountViewController m14529a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReceiptAmountViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14034g) {
                ReceiptAmountViewController receiptAmountViewController;
                if (a2 != null) {
                    receiptAmountViewController = (ReceiptAmountViewController) a2.a(f14034g);
                } else {
                    receiptAmountViewController = f14033f;
                }
                if (receiptAmountViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14533b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14034g, b3);
                        } else {
                            f14033f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = receiptAmountViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m14534a(Object obj) {
        if (obj instanceof PaymentTransaction) {
            m14531a((PaymentTransaction) obj);
        } else if (obj instanceof PaymentRequestModel) {
            m14532a((PaymentRequestModel) obj);
        }
    }

    private void m14531a(PaymentTransaction paymentTransaction) {
        switch (paymentTransaction.f13234g) {
            case R_COMPLETED:
            case S_COMPLETED:
            case S_SENT:
                this.f14039e.m15481a();
                break;
            default:
                this.f14039e.m15483b();
                break;
        }
        m14530a(paymentTransaction.f13237j.m13469d(), paymentTransaction.f13237j.m13467b());
    }

    private void m14532a(PaymentRequestModel paymentRequestModel) {
        switch (C15971.f14032b[paymentRequestModel.lx_().ordinal()]) {
            case 1:
                this.f14039e.m15481a();
                break;
            default:
                this.f14039e.m15483b();
                break;
        }
        m14530a(paymentRequestModel.m13811b().m13703a(), paymentRequestModel.m13811b().m13707b());
    }

    private void m14530a(int i, String str) {
        String a = this.f14036b.m13199a(CurrencyFormatType.NO_CURRENCY_SYMBOL_OR_EMPTY_DECIMALS, i, str);
        this.f14039e.setTextSize(0, (float) this.f14035a.m15540a(a));
        this.f14039e.m15482a(str, a);
    }
}

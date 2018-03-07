package com.facebook.messaging.payment.prefs.receipts.footer;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.payments.util.PaymentsTextViewLinkHelper;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: goldfish */
public class ReceiptDisclaimerViewController {
    private static ReceiptDisclaimerViewController f14073e;
    private static final Object f14074f = new Object();
    public final Resources f14075a;
    public final PaymentsTextViewLinkHelper f14076b;
    public BetterTextView f14077c;
    public PaymentTransaction f14078d;

    private static ReceiptDisclaimerViewController m14555b(InjectorLike injectorLike) {
        return new ReceiptDisclaimerViewController(ResourcesMethodAutoProvider.a(injectorLike), PaymentsTextViewLinkHelper.b(injectorLike));
    }

    @Inject
    public ReceiptDisclaimerViewController(Resources resources, PaymentsTextViewLinkHelper paymentsTextViewLinkHelper) {
        this.f14075a = resources;
        this.f14076b = paymentsTextViewLinkHelper;
    }

    public final void m14556a(PaymentTransaction paymentTransaction) {
        this.f14078d = paymentTransaction;
        if (this.f14078d.f13240m == null) {
            this.f14077c.setVisibility(8);
            return;
        }
        this.f14076b.a(2131240382, "[[report_link]]", this.f14075a.getString(2131240383), this.f14077c, "https://m.facebook.com/help/contact/828169843971429");
        this.f14077c.setVisibility(0);
    }

    public static ReceiptDisclaimerViewController m14554a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReceiptDisclaimerViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14074f) {
                ReceiptDisclaimerViewController receiptDisclaimerViewController;
                if (a2 != null) {
                    receiptDisclaimerViewController = (ReceiptDisclaimerViewController) a2.a(f14074f);
                } else {
                    receiptDisclaimerViewController = f14073e;
                }
                if (receiptDisclaimerViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14555b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14074f, b3);
                        } else {
                            f14073e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = receiptDisclaimerViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

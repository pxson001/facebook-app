package com.facebook.messaging.payment.prefs.receipts.body;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.prefs.receipts.ReceiptFragment;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.text.BetterButton;
import javax.inject.Inject;

@ContextScoped
/* compiled from: google_place_id */
public class ReceiptBodyViewController {
    private static ReceiptBodyViewController f14040c;
    private static final Object f14041d = new Object();
    private final ReceiptAmountViewController f14042a;
    private final ReceiptStatusViewController f14043b;

    private static ReceiptBodyViewController m14536b(InjectorLike injectorLike) {
        return new ReceiptBodyViewController(ReceiptAmountViewController.m14529a(injectorLike), ReceiptStatusViewController.m14539a(injectorLike));
    }

    @Inject
    public ReceiptBodyViewController(ReceiptAmountViewController receiptAmountViewController, ReceiptStatusViewController receiptStatusViewController) {
        this.f14042a = receiptAmountViewController;
        this.f14043b = receiptStatusViewController;
    }

    public final void m14538a(DollarIconEditText dollarIconEditText, FbTextView fbTextView, FbTextView fbTextView2, FbTextView fbTextView3, BetterButton betterButton, FbTextView fbTextView4, BetterButton betterButton2) {
        this.f14042a.f14039e = dollarIconEditText;
        this.f14043b.m14548a(fbTextView, fbTextView2, fbTextView3, betterButton, fbTextView4, betterButton2);
    }

    public static ReceiptBodyViewController m14535a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReceiptBodyViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14041d) {
                ReceiptBodyViewController receiptBodyViewController;
                if (a2 != null) {
                    receiptBodyViewController = (ReceiptBodyViewController) a2.a(f14041d);
                } else {
                    receiptBodyViewController = f14040c;
                }
                if (receiptBodyViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14536b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14041d, b3);
                        } else {
                            f14040c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = receiptBodyViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m14537a(PaymentTransaction paymentTransaction, ReceiptFragment receiptFragment, boolean z) {
        this.f14042a.m14534a((Object) paymentTransaction);
        this.f14043b.m14547a(paymentTransaction, receiptFragment, z);
    }
}

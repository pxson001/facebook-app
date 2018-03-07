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
import com.facebook.payments.ui.SingleItemInfoView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: get_brazil_address_details */
public class ReceiptPlatformItemInfoViewController {
    private static ReceiptPlatformItemInfoViewController f14118d;
    private static final Object f14119e = new Object();
    public final Resources f14120a;
    public SingleItemInfoView f14121b;
    public PaymentTransaction f14122c;

    private static ReceiptPlatformItemInfoViewController m14592b(InjectorLike injectorLike) {
        return new ReceiptPlatformItemInfoViewController(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ReceiptPlatformItemInfoViewController(Resources resources) {
        this.f14120a = resources;
    }

    public static ReceiptPlatformItemInfoViewController m14591a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReceiptPlatformItemInfoViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14119e) {
                ReceiptPlatformItemInfoViewController receiptPlatformItemInfoViewController;
                if (a2 != null) {
                    receiptPlatformItemInfoViewController = (ReceiptPlatformItemInfoViewController) a2.a(f14119e);
                } else {
                    receiptPlatformItemInfoViewController = f14118d;
                }
                if (receiptPlatformItemInfoViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14592b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14119e, b3);
                        } else {
                            f14118d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = receiptPlatformItemInfoViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

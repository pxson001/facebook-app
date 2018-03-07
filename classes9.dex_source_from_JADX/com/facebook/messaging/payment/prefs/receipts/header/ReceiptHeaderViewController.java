package com.facebook.messaging.payment.prefs.receipts.header;

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
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import javax.inject.Inject;

@ContextScoped
/* compiled from: getRequesterIdForRequest */
public class ReceiptHeaderViewController {
    private static ReceiptHeaderViewController f14141f;
    private static final Object f14142g = new Object();
    private final PaymentTransactionUtil f14143a;
    public ReceiptHeaderView f14144b;
    private PaymentTransaction f14145c;
    private String f14146d;
    private String f14147e;

    private static ReceiptHeaderViewController m14615b(InjectorLike injectorLike) {
        return new ReceiptHeaderViewController(ResourcesMethodAutoProvider.a(injectorLike), PaymentTransactionUtil.m15519a(injectorLike));
    }

    @Inject
    public ReceiptHeaderViewController(Resources resources, PaymentTransactionUtil paymentTransactionUtil) {
        this.f14143a = paymentTransactionUtil;
        this.f14146d = resources.getString(2131240334);
        this.f14147e = resources.getString(2131240333);
    }

    public final void m14618a(ReceiptHeaderView receiptHeaderView) {
        this.f14144b = receiptHeaderView;
    }

    public final void m14617a(PaymentTransaction paymentTransaction) {
        this.f14145c = paymentTransaction;
        if (this.f14143a.m15527c(this.f14145c)) {
            m14614a();
        } else {
            m14616b();
        }
    }

    public static ReceiptHeaderViewController m14613a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReceiptHeaderViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14142g) {
                ReceiptHeaderViewController receiptHeaderViewController;
                if (a2 != null) {
                    receiptHeaderViewController = (ReceiptHeaderViewController) a2.a(f14142g);
                } else {
                    receiptHeaderViewController = f14141f;
                }
                if (receiptHeaderViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14615b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14142g, b3);
                        } else {
                            f14141f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = receiptHeaderViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m14614a() {
        ReceiptHeaderView receiptHeaderView = this.f14144b;
        ReceiptHeaderViewParamsBuilder newBuilder = ReceiptHeaderViewParams.newBuilder();
        newBuilder.f14152a = this.f14145c.f13231d;
        newBuilder = newBuilder;
        newBuilder.f14153b = this.f14145c.f13231d.mo527c();
        newBuilder = newBuilder;
        newBuilder.f14154c = this.f14146d;
        newBuilder = newBuilder;
        newBuilder.f14155d = true;
        receiptHeaderView.setReceiptHeaderViewParams(newBuilder.m14627e());
    }

    private void m14616b() {
        ReceiptHeaderView receiptHeaderView = this.f14144b;
        ReceiptHeaderViewParamsBuilder newBuilder = ReceiptHeaderViewParams.newBuilder();
        newBuilder.f14152a = this.f14145c.f13232e;
        newBuilder = newBuilder;
        newBuilder.f14153b = this.f14145c.f13232e.mo527c();
        newBuilder = newBuilder;
        newBuilder.f14154c = this.f14147e;
        newBuilder = newBuilder;
        newBuilder.f14155d = true;
        receiptHeaderView.setReceiptHeaderViewParams(newBuilder.m14627e());
    }
}

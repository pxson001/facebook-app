package com.facebook.messaging.payment.prefs.receipts.footer;

import android.content.Context;
import android.support.v4.util.Pair;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.google.common.collect.ImmutableList;

@ContextScoped
/* compiled from: glUniform1f */
public class ReceiptFooterInfoViewController {
    private static ReceiptFooterInfoViewController f14088b;
    private static final Object f14089c = new Object();
    public ReceiptFooterInfoView f14090a;

    private static ReceiptFooterInfoViewController m14564a() {
        return new ReceiptFooterInfoViewController();
    }

    public final void m14567a(ReceiptFooterInfoView receiptFooterInfoView) {
        this.f14090a = receiptFooterInfoView;
    }

    public final void m14568a(Object obj) {
        if (obj instanceof PaymentTransaction) {
            m14566a((PaymentTransaction) obj);
        } else if (obj instanceof PaymentRequestModel) {
            PaymentRequestModel paymentRequestModel = (PaymentRequestModel) obj;
            ImmutableList of = ImmutableList.of(Pair.a(Integer.valueOf(2131240375), "https://m.facebook.com/payments_terms"), Pair.a(Integer.valueOf(2131240374), "https://m.facebook.com/help/messenger-app/750020781733477"));
            ReceiptFooterInfoView receiptFooterInfoView = this.f14090a;
            ReceiptFooterInfoViewParamsBuilder newBuilder = ReceiptFooterInfoViewParams.newBuilder();
            newBuilder.f14093a = paymentRequestModel.lw_();
            newBuilder = newBuilder;
            newBuilder.f14094b = of;
            receiptFooterInfoView.setViewParams(newBuilder.m14573c());
        }
    }

    private void m14566a(PaymentTransaction paymentTransaction) {
        Object obj;
        switch (paymentTransaction.f13234g) {
            case R_PENDING_VERIFICATION:
            case S_PENDING_VERIFICATION:
                obj = "https://m.facebook.com/help/messenger-app/369959656515129";
                break;
            default:
                obj = "https://m.facebook.com/help/messenger-app/750020781733477";
                break;
        }
        ImmutableList of = ImmutableList.of(Pair.a(Integer.valueOf(2131240375), "https://m.facebook.com/payments_terms"), Pair.a(Integer.valueOf(2131240374), obj));
        ReceiptFooterInfoView receiptFooterInfoView = this.f14090a;
        ReceiptFooterInfoViewParamsBuilder newBuilder = ReceiptFooterInfoViewParams.newBuilder();
        newBuilder.f14093a = paymentTransaction.f13229b;
        newBuilder = newBuilder;
        newBuilder.f14094b = of;
        receiptFooterInfoView.setViewParams(newBuilder.m14573c());
    }

    public static ReceiptFooterInfoViewController m14565a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReceiptFooterInfoViewController a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f14089c) {
                ReceiptFooterInfoViewController receiptFooterInfoViewController;
                if (a3 != null) {
                    receiptFooterInfoViewController = (ReceiptFooterInfoViewController) a3.a(f14089c);
                } else {
                    receiptFooterInfoViewController = f14088b;
                }
                if (receiptFooterInfoViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m14564a();
                        if (a3 != null) {
                            a3.a(f14089c, a2);
                        } else {
                            f14088b = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = receiptFooterInfoViewController;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

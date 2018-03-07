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
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PlatformItemModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PlatformItemModel.PhotosModel;
import com.facebook.payments.ui.FloatingLabelTextView;
import com.facebook.payments.ui.SingleItemInfoView;
import com.facebook.payments.ui.SingleItemInfoViewParams;
import com.facebook.payments.ui.SingleItemInfoViewParamsBuilder;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: get_resumable_upload_session */
public class ReceiptFooterViewController {
    private static ReceiptFooterViewController f14095h;
    private static final Object f14096i = new Object();
    private final ReceiptPlatformItemInfoViewController f14097a;
    private final ReceiptMemoViewController f14098b;
    public final ReceiptPaymentMethodViewController f14099c;
    private final ReceiptDisclaimerViewController f14100d;
    private final ReceiptSentTimeViewController f14101e;
    private final ReceiptSupplementaryTimeViewController f14102f;
    private final ReceiptFooterInfoViewController f14103g;

    private static ReceiptFooterViewController m14576b(InjectorLike injectorLike) {
        return new ReceiptFooterViewController(ReceiptPlatformItemInfoViewController.m14591a(injectorLike), ReceiptMemoViewController.m14579a(injectorLike), ReceiptPaymentMethodViewController.m14584a(injectorLike), ReceiptDisclaimerViewController.m14554a(injectorLike), ReceiptSentTimeViewController.m14593a(injectorLike), ReceiptSupplementaryTimeViewController.m14600a(injectorLike), ReceiptFooterInfoViewController.m14565a(injectorLike));
    }

    @Inject
    public ReceiptFooterViewController(ReceiptPlatformItemInfoViewController receiptPlatformItemInfoViewController, ReceiptMemoViewController receiptMemoViewController, ReceiptPaymentMethodViewController receiptPaymentMethodViewController, ReceiptDisclaimerViewController receiptDisclaimerViewController, ReceiptSentTimeViewController receiptSentTimeViewController, ReceiptSupplementaryTimeViewController receiptSupplementaryTimeViewController, ReceiptFooterInfoViewController receiptFooterInfoViewController) {
        this.f14097a = receiptPlatformItemInfoViewController;
        this.f14098b = receiptMemoViewController;
        this.f14099c = receiptPaymentMethodViewController;
        this.f14100d = receiptDisclaimerViewController;
        this.f14101e = receiptSentTimeViewController;
        this.f14102f = receiptSupplementaryTimeViewController;
        this.f14103g = receiptFooterInfoViewController;
    }

    public static ReceiptFooterViewController m14574a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReceiptFooterViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14096i) {
                ReceiptFooterViewController receiptFooterViewController;
                if (a2 != null) {
                    receiptFooterViewController = (ReceiptFooterViewController) a2.a(f14096i);
                } else {
                    receiptFooterViewController = f14095h;
                }
                if (receiptFooterViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14576b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14096i, b3);
                        } else {
                            f14095h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = receiptFooterViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m14578a(FloatingLabelTextView floatingLabelTextView, BetterTextView betterTextView, BetterTextView betterTextView2, FloatingLabelTextView floatingLabelTextView2, FloatingLabelTextView floatingLabelTextView3, SingleItemInfoView singleItemInfoView, FloatingLabelTextView floatingLabelTextView4, ReceiptFooterInfoView receiptFooterInfoView) {
        this.f14097a.f14121b = singleItemInfoView;
        this.f14098b.f14107b = floatingLabelTextView4;
        this.f14100d.f14077c = betterTextView2;
        ReceiptPaymentMethodViewController receiptPaymentMethodViewController = this.f14099c;
        receiptPaymentMethodViewController.f14115d = floatingLabelTextView;
        receiptPaymentMethodViewController.f14116e = betterTextView;
        this.f14101e.f14130e = floatingLabelTextView2;
        this.f14102f.f14138e = floatingLabelTextView3;
        this.f14103g.f14090a = receiptFooterInfoView;
    }

    static boolean m14575a(PaymentTransaction paymentTransaction) {
        return Long.parseLong(paymentTransaction.f13235h) - Long.parseLong(paymentTransaction.f13233f) > 1200;
    }

    public final void m14577a(PaymentTransaction paymentTransaction, boolean z) {
        ReceiptPlatformItemInfoViewController receiptPlatformItemInfoViewController = this.f14097a;
        receiptPlatformItemInfoViewController.f14122c = paymentTransaction;
        if (receiptPlatformItemInfoViewController.f14122c.f13240m == null) {
            receiptPlatformItemInfoViewController.f14121b.setVisibility(8);
        } else {
            PlatformItemModel platformItemModel = receiptPlatformItemInfoViewController.f14122c.f13240m;
            SingleItemInfoViewParamsBuilder newBuilder = SingleItemInfoViewParams.newBuilder();
            newBuilder.c = platformItemModel.m13902d();
            newBuilder = newBuilder;
            newBuilder.d = platformItemModel.m13900b();
            newBuilder = newBuilder;
            if (!platformItemModel.lF_().isEmpty()) {
                newBuilder.a = ((PhotosModel) platformItemModel.lF_().get(0)).m13894a().m13888a();
                newBuilder.b = receiptPlatformItemInfoViewController.f14120a.getDimension(2131429256);
            }
            receiptPlatformItemInfoViewController.f14121b.setViewParams(newBuilder.f());
            receiptPlatformItemInfoViewController.f14121b.setVisibility(0);
        }
        this.f14098b.m14581a((Object) paymentTransaction);
        this.f14100d.m14556a(paymentTransaction);
        this.f14099c.m14590a(paymentTransaction);
        this.f14101e.m14599a(paymentTransaction);
        this.f14102f.m14605a(paymentTransaction, z);
        this.f14103g.m14568a((Object) paymentTransaction);
    }
}
